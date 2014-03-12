/**
 */
package brewery.impl;

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
 * 
 * @generated
 */
public class BreweryFactoryImpl extends EFactoryImpl implements BreweryFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BreweryPackage getPackage() {
		return BreweryPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static BreweryFactory init() {
		try {
			final BreweryFactory theBreweryFactory = (BreweryFactory) EPackage.Registry.INSTANCE
					.getEFactory(BreweryPackage.eNS_URI);
			if (theBreweryFactory != null) {
				return theBreweryFactory;
			}
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BreweryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public BreweryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTemperatureUnitToString(final EDataType eDataType,
			final Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(final EDataType eDataType,
			final Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case BreweryPackage.TEMPERATURE_UNIT:
			return convertTemperatureUnitToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
		case BreweryPackage.YEAST:
			return createYeast();
		case BreweryPackage.INVENTORY:
			return createInventory();
		case BreweryPackage.TEMPERATURE_RANGE:
			return createTemperatureRange();
		case BreweryPackage.FERMENTER:
			return createFermenter();
		case BreweryPackage.MASH_STEP:
			return createMashStep();
		case BreweryPackage.MASH_SCHEDULE:
			return createMashSchedule();
		case BreweryPackage.SENSOR:
			return createSensor();
		case BreweryPackage.PIN:
			return createPin();
		case BreweryPackage.CONSOLE_COMMAND:
			return createConsoleCommand();
		case BreweryPackage.SENSOR_REPLY:
			return createSensorReply();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ConsoleCommand createConsoleCommand() {
		final ConsoleCommandImpl consoleCommand = new ConsoleCommandImpl();
		return consoleCommand;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Fermenter createFermenter() {
		final FermenterImpl fermenter = new FermenterImpl();
		return fermenter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(final EDataType eDataType,
			final String initialValue) {
		switch (eDataType.getClassifierID()) {
		case BreweryPackage.TEMPERATURE_UNIT:
			return createTemperatureUnitFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Inventory createInventory() {
		final InventoryImpl inventory = new InventoryImpl();
		return inventory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MashSchedule createMashSchedule() {
		final MashScheduleImpl mashSchedule = new MashScheduleImpl();
		return mashSchedule;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public MashStep createMashStep() {
		final MashStepImpl mashStep = new MashStepImpl();
		return mashStep;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Pin createPin() {
		final PinImpl pin = new PinImpl();
		return pin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Sensor createSensor() {
		final SensorImpl sensor = new SensorImpl();
		return sensor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public SensorReply createSensorReply() {
		final SensorReplyImpl sensorReply = new SensorReplyImpl();
		return sensorReply;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TemperatureRange createTemperatureRange() {
		final TemperatureRangeImpl temperatureRange = new TemperatureRangeImpl();
		return temperatureRange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemperatureUnit createTemperatureUnitFromString(
			final EDataType eDataType, final String initialValue) {
		final TemperatureUnit result = TemperatureUnit.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue
					+ "' is not a valid enumerator of '" + eDataType.getName()
					+ "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Yeast createYeast() {
		final YeastImpl yeast = new YeastImpl();
		return yeast;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public BreweryPackage getBreweryPackage() {
		return (BreweryPackage) getEPackage();
	}

} // BreweryFactoryImpl
