/**
 * 
 */
package brewery.ui;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplicationContext;

import brewery.ArduinoController;
import brewery.BreweryFactory;
import brewery.ConsoleCommand;
import brewery.Inventory;
import brewery.PID;
import brewery.Sensor;
import brewery.SensorReply;
import brewery.ui.monitor.ConsoleParser;
import brewery.ui.monitor.ConsoleParserEventListener;

/**
 * @author nguba_000
 * 
 */
public final class LifecycleManager implements SerialPortEventListener,
		ConsoleParserEventListener {
	private static final String SETTINGS_FILENAME = "brewery-settings.bctl";
	SerialPort serialPort;
	private BufferedReader input;
	private IEventBroker eventBroker;
	private final ConsoleParser parser;

	/**
	 * 
	 */
	public LifecycleManager() {
		BreweryFactory.eINSTANCE.eClass();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("bctl", new XMIResourceFactoryImpl());
		parser = new ConsoleParser();
	}

	/**
	 * 
	 */
	@PreSave
	public void cleanup() {
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
					// from the persistence store
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
		ArduinoController controller = BreweryFactory.eINSTANCE.createArduinoController();
		controller.setEventBroker(eventBroker);
		controller.addListener(this);
		//InjectorFactory.getDefault().addBinding(ArduinoController.class).implementedBy(ArduinoControllerImpl.class);
		context.set(controller.getClass().getCanonicalName(), controller);
	}

	@Override
	public void onCommand(final ConsoleCommand command) {
		System.out.println(command);
	}

	@Override
	public void onSensorReply(final SensorReply reply) {
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

	@Override
	public void onInput(String cmd) {
		eventBroker.send(BreweryEventTopic.INPUT, cmd);
	}

	@Override
	public void onPIDReply(PID pid) {
		eventBroker.send(BreweryEventTopic.PID, pid);
	}
}
