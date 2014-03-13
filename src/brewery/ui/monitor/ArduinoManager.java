/**
 * 
 */
package brewery.ui.monitor;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

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
import brewery.ConsoleCommand;
import brewery.Inventory;
import brewery.Sensor;
import brewery.SensorReply;
import brewery.ui.BreweryEventTopic;

/**
 * @author nguba_000
 * 
 */
public final class ArduinoManager implements SerialPortEventListener,
		ConsoleParserEventListener {

	private static final String SETTINGS_FILENAME = "brewery-settings.bctl";

	@Inject
	private Logger logger;
	SerialPort serialPort;
	/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { "/dev/cu.usbmodemfd141",
			"/dev/cu.usbmodemfd121", "/dev/cu.usbmodemfa1331", "/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	private BufferedReader input;
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;
	private IEventBroker eventBroker;
	private final ConsoleParser parser;

	/**
	 * 
	 */
	public ArduinoManager() {
		BreweryFactory.eINSTANCE.eClass();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("bctl", new XMIResourceFactoryImpl());
		parser = new ConsoleParser(this);
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
				logger.info("Trying to find board on port: " + portName);
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

	void init() throws Exception {
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
		//context.set(CommPort.class, serialPort);
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
			final IApplicationContext appContext, final IEclipseContext context)
			throws Exception {
		logger.info("Contacting Arduino");
		this.eventBroker = eventBroker;
		

		final ResourceSet resSet = new ResourceSetImpl();
		final URI uri = URI.createURI(SETTINGS_FILENAME);
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
				resource = resSet.createResource(URI
						.createURI(SETTINGS_FILENAME));
				inventory = BreweryFactory.eINSTANCE.createInventory();
			}
			context.set(resource.getClass().getCanonicalName(), resource);
		}
		context.set(inventory.getClass().getCanonicalName(), inventory);
	}

	@Override
	public void onCommand(final ConsoleCommand command) {
		// System.out.println(command);
	}

	@Override
	public void onSensorReply(final SensorReply reply) {
		// System.out.println(reply);
		final Sensor sensor = BreweryFactory.eINSTANCE.createSensor();
		sensor.setValue(reply.getTemperature());
		eventBroker.send(BreweryEventTopic.SENSOR, sensor);
	}

	/**
	 * capture the serial events from the board and broadcast them to any
	 * listening parts or parts that are interested
	 */
	@Override
	public void serialEvent(final SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = null;
				if (input.ready()) {
					inputLine = input.readLine();
					parser.parse(inputLine);
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}
}
