/**
 */
package brewery.impl;

import brewery.ArduinoController;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import brewery.BreweryFactory;
import brewery.BreweryPackage;
import brewery.ConsoleCommand;
import brewery.ConsoleReply;
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
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BreweryPackageImpl extends EPackageImpl implements BreweryPackage {
	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link BreweryPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BreweryPackage init() {
		if (isInited) return (BreweryPackage)EPackage.Registry.INSTANCE.getEPackage(BreweryPackage.eNS_URI);

		// Obtain or create and register package
		BreweryPackageImpl theBreweryPackage = (BreweryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BreweryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BreweryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBreweryPackage.createPackageContents();

		// Initialize created meta-data
		theBreweryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBreweryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BreweryPackage.eNS_URI, theBreweryPackage);
		return theBreweryPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yeastEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inventoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temperatureRangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fermenterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mashStepEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mashScheduleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pinEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consoleCommandEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consoleReplyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorReplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arduinoControllerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temperatureUnitEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType commPortIdentifierEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType portInUseExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serialPortEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unsupportedCommOperationExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see brewery.BreweryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BreweryPackageImpl() {
		super(eNS_URI, BreweryFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		yeastEClass = createEClass(YEAST);
		createEAttribute(yeastEClass, YEAST__NAME);
		createEAttribute(yeastEClass, YEAST__FLOCCULATION);
		createEAttribute(yeastEClass, YEAST__ATTENUATION);
		createEAttribute(yeastEClass, YEAST__MANUFACTURER);
		createEReference(yeastEClass, YEAST__RANGE);

		inventoryEClass = createEClass(INVENTORY);
		createEReference(inventoryEClass, INVENTORY__YEAST);

		temperatureRangeEClass = createEClass(TEMPERATURE_RANGE);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__UNIT);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__LOW);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__HIGH);

		fermenterEClass = createEClass(FERMENTER);
		createEAttribute(fermenterEClass, FERMENTER__NAME);
		createEReference(fermenterEClass, FERMENTER__YEAST);
		createEAttribute(fermenterEClass, FERMENTER__CONTENT);
		createEAttribute(fermenterEClass, FERMENTER__STARTED);

		mashStepEClass = createEClass(MASH_STEP);
		createEAttribute(mashStepEClass, MASH_STEP__TEMPERATURE);
		createEAttribute(mashStepEClass, MASH_STEP__PAUSE);
		createEAttribute(mashStepEClass, MASH_STEP__DESCRIPTION);
		createEAttribute(mashStepEClass, MASH_STEP__COMPLETE);
		createEAttribute(mashStepEClass, MASH_STEP__RISE_TIME);

		mashScheduleEClass = createEClass(MASH_SCHEDULE);
		createEReference(mashScheduleEClass, MASH_SCHEDULE__STEPS);
		createEAttribute(mashScheduleEClass, MASH_SCHEDULE__NAME);
		createEAttribute(mashScheduleEClass, MASH_SCHEDULE__TOTAL_TIME);

		sensorEClass = createEClass(SENSOR);
		createEAttribute(sensorEClass, SENSOR__VALUE);
		createEAttribute(sensorEClass, SENSOR__ID);

		pinEClass = createEClass(PIN);
		createEAttribute(pinEClass, PIN__ID);

		consoleCommandEClass = createEClass(CONSOLE_COMMAND);
		createEAttribute(consoleCommandEClass, CONSOLE_COMMAND__NAME);
		createEAttribute(consoleCommandEClass, CONSOLE_COMMAND__VALUE);

		consoleReplyEClass = createEClass(CONSOLE_REPLY);
		createEAttribute(consoleReplyEClass, CONSOLE_REPLY__NAME);

		sensorReplyEClass = createEClass(SENSOR_REPLY);
		createEAttribute(sensorReplyEClass, SENSOR_REPLY__TEMPERATURE);

		arduinoControllerEClass = createEClass(ARDUINO_CONTROLLER);
		createEOperation(arduinoControllerEClass, ARDUINO_CONTROLLER___SCAN);
		createEOperation(arduinoControllerEClass, ARDUINO_CONTROLLER___SELECT__COMMPORTIDENTIFIER);
		createEOperation(arduinoControllerEClass, ARDUINO_CONTROLLER___CONFIGURE__INT_SERIALPORT);

		// Create enums
		temperatureUnitEEnum = createEEnum(TEMPERATURE_UNIT);

		// Create data types
		commPortIdentifierEDataType = createEDataType(COMM_PORT_IDENTIFIER);
		portInUseExceptionEDataType = createEDataType(PORT_IN_USE_EXCEPTION);
		serialPortEDataType = createEDataType(SERIAL_PORT);
		unsupportedCommOperationExceptionEDataType = createEDataType(UNSUPPORTED_COMM_OPERATION_EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BreweryFactory getBreweryFactory() {
		return (BreweryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsoleCommand() {
		return consoleCommandEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConsoleCommand_Name() {
		return (EAttribute)consoleCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConsoleCommand_Value() {
		return (EAttribute)consoleCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsoleReply() {
		return consoleReplyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConsoleReply_Name() {
		return (EAttribute)consoleReplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFermenter() {
		return fermenterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Content() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Name() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Started() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFermenter_Yeast() {
		return (EReference)fermenterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInventory() {
		return inventoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInventory_Yeast() {
		return (EReference)inventoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMashSchedule() {
		return mashScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashSchedule_Name() {
		return (EAttribute)mashScheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMashSchedule_TotalTime() {
		return (EAttribute)mashScheduleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMashSchedule_Steps() {
		return (EReference)mashScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMashStep() {
		return mashStepEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashStep_Complete() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashStep_Description() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashStep_Pause() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashStep_RiseTime() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMashStep_Temperature() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPin() {
		return pinEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPin_Id() {
		return (EAttribute)pinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSensor() {
		return sensorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSensor_Id() {
		return (EAttribute)sensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSensor_Value() {
		return (EAttribute)sensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSensorReply() {
		return sensorReplyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSensorReply_Temperature() {
		return (EAttribute)sensorReplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArduinoController() {
		return arduinoControllerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArduinoController__Scan() {
		return arduinoControllerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArduinoController__Select__CommPortIdentifier() {
		return arduinoControllerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getArduinoController__Configure__int_SerialPort() {
		return arduinoControllerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemperatureRange() {
		return temperatureRangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_High() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_Low() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_Unit() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTemperatureUnit() {
		return temperatureUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCommPortIdentifier() {
		return commPortIdentifierEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPortInUseException() {
		return portInUseExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSerialPort() {
		return serialPortEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUnsupportedCommOperationException() {
		return unsupportedCommOperationExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getYeast() {
		return yeastEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Attenuation() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Flocculation() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Manufacturer() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Name() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getYeast_Range() {
		return (EReference)yeastEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sensorReplyEClass.getESuperTypes().add(this.getConsoleReply());

		// Initialize classes, features, and operations; add parameters
		initEClass(yeastEClass, Yeast.class, "Yeast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getYeast_Name(), ecorePackage.getEString(), "name", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Flocculation(), ecorePackage.getEString(), "flocculation", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Attenuation(), ecorePackage.getEString(), "attenuation", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Manufacturer(), ecorePackage.getEString(), "manufacturer", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getYeast_Range(), this.getTemperatureRange(), null, "range", null, 1, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inventoryEClass, Inventory.class, "Inventory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInventory_Yeast(), this.getYeast(), null, "yeast", null, 0, -1, Inventory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temperatureRangeEClass, TemperatureRange.class, "TemperatureRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemperatureRange_Unit(), this.getTemperatureUnit(), "unit", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemperatureRange_Low(), ecorePackage.getEInt(), "low", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemperatureRange_High(), ecorePackage.getEInt(), "high", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fermenterEClass, Fermenter.class, "Fermenter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFermenter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFermenter_Yeast(), this.getYeast(), null, "yeast", null, 1, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFermenter_Content(), ecorePackage.getEString(), "content", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFermenter_Started(), ecorePackage.getEDate(), "started", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mashStepEClass, MashStep.class, "MashStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMashStep_Temperature(), ecorePackage.getEDouble(), "temperature", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_Pause(), ecorePackage.getELong(), "pause", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_Description(), ecorePackage.getEString(), "description", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_Complete(), ecorePackage.getEBoolean(), "complete", null, 0, 1, MashStep.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_RiseTime(), ecorePackage.getELong(), "riseTime", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mashScheduleEClass, MashSchedule.class, "MashSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMashSchedule_Steps(), this.getMashStep(), null, "steps", null, 0, -1, MashSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashSchedule_Name(), ecorePackage.getEString(), "name", null, 0, 1, MashSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashSchedule_TotalTime(), ecorePackage.getELong(), "totalTime", null, 0, 1, MashSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sensorEClass, Sensor.class, "Sensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensor_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSensor_Id(), ecorePackage.getEString(), "id", null, 0, 1, Sensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pinEClass, Pin.class, "Pin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPin_Id(), ecorePackage.getEString(), "id", null, 0, 1, Pin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consoleCommandEClass, ConsoleCommand.class, "ConsoleCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConsoleCommand_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConsoleCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsoleCommand_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, ConsoleCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consoleReplyEClass, ConsoleReply.class, "ConsoleReply", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConsoleReply_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConsoleReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sensorReplyEClass, SensorReply.class, "SensorReply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSensorReply_Temperature(), ecorePackage.getEDouble(), "temperature", null, 0, 1, SensorReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arduinoControllerEClass, ArduinoController.class, "ArduinoController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getArduinoController__Scan(), this.getCommPortIdentifier(), "scan", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getArduinoController__Select__CommPortIdentifier(), this.getSerialPort(), "select", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCommPortIdentifier(), "portIdentifier", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getPortInUseException());

		op = initEOperation(getArduinoController__Configure__int_SerialPort(), null, "configure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dataRate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSerialPort(), "port", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getUnsupportedCommOperationException());

		// Initialize enums and add enum literals
		initEEnum(temperatureUnitEEnum, TemperatureUnit.class, "TemperatureUnit");
		addEEnumLiteral(temperatureUnitEEnum, TemperatureUnit.CELSIUS);
		addEEnumLiteral(temperatureUnitEEnum, TemperatureUnit.FARENHEIT);

		// Initialize data types
		initEDataType(commPortIdentifierEDataType, CommPortIdentifier.class, "CommPortIdentifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(portInUseExceptionEDataType, PortInUseException.class, "PortInUseException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(serialPortEDataType, SerialPort.class, "SerialPort", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unsupportedCommOperationExceptionEDataType, UnsupportedCommOperationException.class, "UnsupportedCommOperationException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // BreweryPackageImpl
