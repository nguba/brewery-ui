/**
 */
package brewery.impl;

import brewery.*;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import brewery.BreweryFactory;
import brewery.BreweryPackage;
import brewery.ConsoleCommand;
import brewery.Fermenter;
import brewery.Inventory;
import brewery.MashSchedule;
import brewery.MashStep;
import brewery.Pin;
import brewery.Sensor;
import brewery.SensorReply;
import brewery.TemperatureRange;
import brewery.TemperatureUnit;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BreweryFactoryImpl extends EFactoryImpl implements BreweryFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BreweryPackage getPackage() {
		return BreweryPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static BreweryFactory init() {
		try {
			BreweryFactory theBreweryFactory = (BreweryFactory)EPackage.Registry.INSTANCE.getEFactory(BreweryPackage.eNS_URI);
			if (theBreweryFactory != null) {
				return theBreweryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BreweryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public BreweryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemperatureUnitToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command createCommandFromString(EDataType eDataType, String initialValue) {
		Command result = Command.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommandToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommPortIdentifier createCommPortIdentifierFromString(EDataType eDataType, String initialValue) {
		return (CommPortIdentifier)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommPortIdentifierToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortInUseException createPortInUseExceptionFromString(EDataType eDataType, String initialValue) {
		return (PortInUseException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortInUseExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerialPort createSerialPortFromString(EDataType eDataType, String initialValue) {
		return (SerialPort)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSerialPortToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnsupportedCommOperationException createUnsupportedCommOperationExceptionFromString(EDataType eDataType, String initialValue) {
		return (UnsupportedCommOperationException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnsupportedCommOperationExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOException createIOExceptionFromString(EDataType eDataType, String initialValue) {
		return (IOException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIOExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringBuilder createStringBuilderFromString(EDataType eDataType, String initialValue) {
		return (StringBuilder)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringBuilderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEventBroker createIEventBrokerFromString(EDataType eDataType, String initialValue) {
		return (IEventBroker)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIEventBrokerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BreweryPackage.TEMPERATURE_UNIT:
				return convertTemperatureUnitToString(eDataType, instanceValue);
			case BreweryPackage.COMMAND:
				return convertCommandToString(eDataType, instanceValue);
			case BreweryPackage.COMM_PORT_IDENTIFIER:
				return convertCommPortIdentifierToString(eDataType, instanceValue);
			case BreweryPackage.PORT_IN_USE_EXCEPTION:
				return convertPortInUseExceptionToString(eDataType, instanceValue);
			case BreweryPackage.SERIAL_PORT:
				return convertSerialPortToString(eDataType, instanceValue);
			case BreweryPackage.UNSUPPORTED_COMM_OPERATION_EXCEPTION:
				return convertUnsupportedCommOperationExceptionToString(eDataType, instanceValue);
			case BreweryPackage.IO_EXCEPTION:
				return convertIOExceptionToString(eDataType, instanceValue);
			case BreweryPackage.STRING_BUILDER:
				return convertStringBuilderToString(eDataType, instanceValue);
			case BreweryPackage.IEVENT_BROKER:
				return convertIEventBrokerToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BreweryPackage.YEAST: return createYeast();
			case BreweryPackage.INVENTORY: return createInventory();
			case BreweryPackage.TEMPERATURE_RANGE: return createTemperatureRange();
			case BreweryPackage.FERMENTER: return createFermenter();
			case BreweryPackage.MASH_STEP: return createMashStep();
			case BreweryPackage.MASH_SCHEDULE: return createMashSchedule();
			case BreweryPackage.SENSOR: return createSensor();
			case BreweryPackage.PIN: return createPin();
			case BreweryPackage.CONSOLE_COMMAND: return createConsoleCommand();
			case BreweryPackage.SENSOR_REPLY: return createSensorReply();
			case BreweryPackage.ARDUINO_CONTROLLER: return createArduinoController();
			case BreweryPackage.PID: return createPID();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsoleCommand createConsoleCommand() {
		ConsoleCommandImpl consoleCommand = new ConsoleCommandImpl();
		return consoleCommand;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fermenter createFermenter() {
		FermenterImpl fermenter = new FermenterImpl();
		return fermenter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BreweryPackage.TEMPERATURE_UNIT:
				return createTemperatureUnitFromString(eDataType, initialValue);
			case BreweryPackage.COMMAND:
				return createCommandFromString(eDataType, initialValue);
			case BreweryPackage.COMM_PORT_IDENTIFIER:
				return createCommPortIdentifierFromString(eDataType, initialValue);
			case BreweryPackage.PORT_IN_USE_EXCEPTION:
				return createPortInUseExceptionFromString(eDataType, initialValue);
			case BreweryPackage.SERIAL_PORT:
				return createSerialPortFromString(eDataType, initialValue);
			case BreweryPackage.UNSUPPORTED_COMM_OPERATION_EXCEPTION:
				return createUnsupportedCommOperationExceptionFromString(eDataType, initialValue);
			case BreweryPackage.IO_EXCEPTION:
				return createIOExceptionFromString(eDataType, initialValue);
			case BreweryPackage.STRING_BUILDER:
				return createStringBuilderFromString(eDataType, initialValue);
			case BreweryPackage.IEVENT_BROKER:
				return createIEventBrokerFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Inventory createInventory() {
		InventoryImpl inventory = new InventoryImpl();
		return inventory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MashSchedule createMashSchedule() {
		MashScheduleImpl mashSchedule = new MashScheduleImpl();
		return mashSchedule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MashStep createMashStep() {
		MashStepImpl mashStep = new MashStepImpl();
		return mashStep;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pin createPin() {
		PinImpl pin = new PinImpl();
		return pin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sensor createSensor() {
		SensorImpl sensor = new SensorImpl();
		return sensor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SensorReply createSensorReply() {
		SensorReplyImpl sensorReply = new SensorReplyImpl();
		return sensorReply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArduinoController createArduinoController() {
		ArduinoControllerImpl arduinoController = new ArduinoControllerImpl();
		return arduinoController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PID createPID() {
		PIDImpl pid = new PIDImpl();
		return pid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TemperatureRange createTemperatureRange() {
		TemperatureRangeImpl temperatureRange = new TemperatureRangeImpl();
		return temperatureRange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TemperatureUnit createTemperatureUnitFromString(
			EDataType eDataType, String initialValue) {
		TemperatureUnit result = TemperatureUnit.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Yeast createYeast() {
		YeastImpl yeast = new YeastImpl();
		return yeast;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BreweryPackage getBreweryPackage() {
		return (BreweryPackage)getEPackage();
	}

} // BreweryFactoryImpl
