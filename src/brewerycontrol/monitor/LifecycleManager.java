/**
 * 
 */
package brewerycontrol.monitor;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

import javax.inject.Inject;
import javax.naming.CommunicationException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplicationContext;

import brewery.BreweryFactory;
import brewery.Inventory;

/**
 * @author nguba_000
 * 
 */
public final class LifecycleManager implements SerialPortEventListener {

	private enum State {
		COMMAND, COMMAND_START, REPLY_START, READY, REPLY, COMMAND_END;
	}

	@Inject
	private Logger logger;
	SerialPort serialPort;
	/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { "/dev/tty.usbmodemfd141", 
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	private BufferedReader input;
	private static final int TIME_OUT = 2000;

	private static final int DATA_RATE = 9600;

	private IEventBroker eventBroker;

	private State state = State.READY;

	private StringBuilder buf;

	private String command;

	/**
	 * 
	 */
	public LifecycleManager() {
		BreweryFactory.eINSTANCE.eClass();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("bctl", new XMIResourceFactoryImpl());
	}

	/**
	 * 
	 */
	@PreSave
	public void cleanup() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * @return
	 * @throws CommunicationException
	 * 
	 */
	private CommPortIdentifier findPort() throws CommunicationException {
		CommPortIdentifier portId = null;
		final Enumeration<?> portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			final CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			for (final String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					logger.info("Found board on port: " + portId.getName());
					break;
				}
			}
		}
		if (portId == null) {
			logger.error("Could not find COM port.");
			throw new CommunicationException("Cannot find port for the board");
		}
		return portId;
	}

	/**
	 * 
	 * @param eventBroker
	 * @param appContext
	 * @param context
	 * @throws Exception
	 */
	@PostContextCreate
	public void initialise(final IEventBroker eventBroker,
			IApplicationContext appContext, IEclipseContext context)
			throws Exception {
		logger.info("Contacting Arduino");
		this.eventBroker = eventBroker;
		final CommPortIdentifier portIdentifier = findPort();
		serialPort = (SerialPort) portIdentifier.open(
				this.getClass().getName(), TIME_OUT);
		serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		input = new BufferedReader(new InputStreamReader(
				serialPort.getInputStream()));
		eventBroker.send("arduino/init", portIdentifier);
		serialPort.addEventListener(this);
		serialPort.notifyOnDataAvailable(true);
		context.set(CommPort.class, serialPort);

		final ResourceSet resSet = new ResourceSetImpl();
		final URI uri = URI.createURI("data.bctl");
		Resource resource = null;
		Inventory inventory = null;
		if (uri.isFile()) {
			final File f = new File(uri.path());
			if (f.exists()) {
				resource = resSet.getResource(uri, true);
				final EObject eObject = resource.getContents().get(0);
				if (eObject != null) {
					inventory = (Inventory) eObject;
				}
				if (eObject == null) {
					// Create a new inventory instance if you cannot load it
					// from the
					// persistence store
					inventory = BreweryFactory.eINSTANCE.createInventory();
				}
			} else {
				resource = resSet.createResource(URI.createURI("data.bctl"));
				inventory = BreweryFactory.eINSTANCE.createInventory();
			}
			context.set(resource.getClass().getCanonicalName(), resource);
		}
		context.set(inventory.getClass().getCanonicalName(), inventory);
	}

	/**
	 * capture the serial events from the board and broadcast them to any
	 * listening parts or parts that are interested
	 */
	@Override
	public void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = null;
				if (input.ready()) {
					inputLine = input.readLine();
					for (int i = 0, length = inputLine.length(); i < length; i++) {
						final char c = inputLine.charAt(i);
						// System.out.println(state);
						switch (state) {
						case READY:
							buf = new StringBuilder();
							if (c == '[') {
								state = State.COMMAND_START;
							}
							break;
						case COMMAND_START:
							if (Character.isWhitespace(c)) {
								state = State.COMMAND;
							} else if (c == ']') {
								state = State.COMMAND_END;
							} else {
								buf.append(c);
							}
							break;
						case COMMAND:
							if (c == ']') {
								System.out.println(buf);
								state = State.READY;
							}
						case COMMAND_END:
							command = buf.toString();
							// System.out.println("COMMAND -> " + buf);
							if (c == '[') {
								state = State.REPLY_START;
							}
							break;
						case REPLY_START:
							if (Character.isWhitespace(c)) {
								state = State.REPLY;
								// discard the actual command word here
								buf = new StringBuilder();
							}
							break;
						case REPLY:
							if (c == ']') {
								// handle the commands here by building custom
								// objects and sending them via the event
								// broker.
								switch (command) {
								case "sensor":
									final int separator = buf.indexOf(" ");
									final Sensor sensor = new Sensor();
									sensor.setId(buf.substring(0, separator));
									final float value = Float.parseFloat(buf
											.substring(separator).trim());
									sensor.setValue(value);
									eventBroker.send("sensor/mash", sensor);
									break;
								}
								state = State.READY;
							} else {
								buf.append(c);
							}
							break;
						default:
							break;
						}
					}
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}
}
