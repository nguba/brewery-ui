/**
 */
package brewery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see brewery.BreweryFactory
 * @model kind="package"
 * @generated
 */
public interface BreweryPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link brewery.impl.YeastImpl <em>Yeast</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.YeastImpl
		 * @see brewery.impl.BreweryPackageImpl#getYeast()
		 * @generated
		 */
		EClass YEAST = eINSTANCE.getYeast();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__NAME = eINSTANCE.getYeast_Name();

		/**
		 * The meta object literal for the '<em><b>Flocculation</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__FLOCCULATION = eINSTANCE.getYeast_Flocculation();

		/**
		 * The meta object literal for the '<em><b>Attenuation</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__ATTENUATION = eINSTANCE.getYeast_Attenuation();

		/**
		 * The meta object literal for the '<em><b>Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__MANUFACTURER = eINSTANCE.getYeast_Manufacturer();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference YEAST__RANGE = eINSTANCE.getYeast_Range();

		/**
		 * The meta object literal for the '{@link brewery.impl.InventoryImpl
		 * <em>Inventory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see brewery.impl.InventoryImpl
		 * @see brewery.impl.BreweryPackageImpl#getInventory()
		 * @generated
		 */
		EClass INVENTORY = eINSTANCE.getInventory();

		/**
		 * The meta object literal for the '<em><b>Yeast</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVENTORY__YEAST = eINSTANCE.getInventory_Yeast();

		/**
		 * The meta object literal for the '{@link brewery.impl.TemperatureRangeImpl <em>Temperature Range</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.TemperatureRangeImpl
		 * @see brewery.impl.BreweryPackageImpl#getTemperatureRange()
		 * @generated
		 */
		EClass TEMPERATURE_RANGE = eINSTANCE.getTemperatureRange();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__UNIT = eINSTANCE.getTemperatureRange_Unit();

		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__LOW = eINSTANCE.getTemperatureRange_Low();

		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__HIGH = eINSTANCE.getTemperatureRange_High();

		/**
		 * The meta object literal for the '{@link brewery.impl.FermenterImpl
		 * <em>Fermenter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see brewery.impl.FermenterImpl
		 * @see brewery.impl.BreweryPackageImpl#getFermenter()
		 * @generated
		 */
		EClass FERMENTER = eINSTANCE.getFermenter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__NAME = eINSTANCE.getFermenter_Name();

		/**
		 * The meta object literal for the '<em><b>Yeast</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FERMENTER__YEAST = eINSTANCE.getFermenter_Yeast();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__CONTENT = eINSTANCE.getFermenter_Content();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__STARTED = eINSTANCE.getFermenter_Started();

		/**
		 * The meta object literal for the '{@link brewery.impl.MashStepImpl <em>Mash Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.MashStepImpl
		 * @see brewery.impl.BreweryPackageImpl#getMashStep()
		 * @generated
		 */
		EClass MASH_STEP = eINSTANCE.getMashStep();

		/**
		 * The meta object literal for the '<em><b>Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__TEMPERATURE = eINSTANCE.getMashStep_Temperature();

		/**
		 * The meta object literal for the '<em><b>Pause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__PAUSE = eINSTANCE.getMashStep_Pause();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__DESCRIPTION = eINSTANCE.getMashStep_Description();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__COMPLETE = eINSTANCE.getMashStep_Complete();

		/**
		 * The meta object literal for the '<em><b>Rise Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__RISE_TIME = eINSTANCE.getMashStep_RiseTime();

		/**
		 * The meta object literal for the '{@link brewery.impl.MashScheduleImpl <em>Mash Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.MashScheduleImpl
		 * @see brewery.impl.BreweryPackageImpl#getMashSchedule()
		 * @generated
		 */
		EClass MASH_SCHEDULE = eINSTANCE.getMashSchedule();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASH_SCHEDULE__STEPS = eINSTANCE.getMashSchedule_Steps();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_SCHEDULE__NAME = eINSTANCE.getMashSchedule_Name();

		/**
		 * The meta object literal for the '{@link brewery.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.SensorImpl
		 * @see brewery.impl.BreweryPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__VALUE = eINSTANCE.getSensor_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__ID = eINSTANCE.getSensor_Id();

		/**
		 * The meta object literal for the '{@link brewery.impl.PinImpl <em>Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.PinImpl
		 * @see brewery.impl.BreweryPackageImpl#getPin()
		 * @generated
		 */
		EClass PIN = eINSTANCE.getPin();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIN__ID = eINSTANCE.getPin_Id();

		/**
		 * The meta object literal for the '{@link brewery.impl.ConsoleCommandImpl <em>Console Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.ConsoleCommandImpl
		 * @see brewery.impl.BreweryPackageImpl#getConsoleCommand()
		 * @generated
		 */
		EClass CONSOLE_COMMAND = eINSTANCE.getConsoleCommand();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_COMMAND__NAME = eINSTANCE.getConsoleCommand_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_COMMAND__VALUE = eINSTANCE.getConsoleCommand_Value();

		/**
		 * The meta object literal for the '{@link brewery.impl.ConsoleReplyImpl <em>Console Reply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.ConsoleReplyImpl
		 * @see brewery.impl.BreweryPackageImpl#getConsoleReply()
		 * @generated
		 */
		EClass CONSOLE_REPLY = eINSTANCE.getConsoleReply();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_REPLY__NAME = eINSTANCE.getConsoleReply_Name();

		/**
		 * The meta object literal for the '{@link brewery.impl.SensorReplyImpl <em>Sensor Reply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.SensorReplyImpl
		 * @see brewery.impl.BreweryPackageImpl#getSensorReply()
		 * @generated
		 */
		EClass SENSOR_REPLY = eINSTANCE.getSensorReply();

		/**
		 * The meta object literal for the '<em><b>Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_REPLY__TEMPERATURE = eINSTANCE.getSensorReply_Temperature();

		/**
		 * The meta object literal for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see brewery.TemperatureUnit
		 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
		 * @generated
		 */
		EEnum TEMPERATURE_UNIT = eINSTANCE.getTemperatureUnit();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "brewery";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://brewery/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "brewery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	BreweryPackage eINSTANCE = brewery.impl.BreweryPackageImpl.init();

	/**
	 * The meta object id for the '{@link brewery.impl.YeastImpl <em>Yeast</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.YeastImpl
	 * @see brewery.impl.BreweryPackageImpl#getYeast()
	 * @generated
	 */
	int YEAST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST__NAME = 0;

	/**
	 * The feature id for the '<em><b>Flocculation</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST__FLOCCULATION = 1;

	/**
	 * The feature id for the '<em><b>Attenuation</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST__ATTENUATION = 2;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST__MANUFACTURER = 3;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__RANGE = 4;

	/**
	 * The number of structural features of the '<em>Yeast</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Yeast</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int YEAST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.InventoryImpl <em>Inventory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.InventoryImpl
	 * @see brewery.impl.BreweryPackageImpl#getInventory()
	 * @generated
	 */
	int INVENTORY = 1;

	/**
	 * The feature id for the '<em><b>Yeast</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY__YEAST = 0;

	/**
	 * The number of structural features of the '<em>Inventory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INVENTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Inventory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INVENTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.TemperatureRangeImpl <em>Temperature Range</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see brewery.impl.TemperatureRangeImpl
	 * @see brewery.impl.BreweryPackageImpl#getTemperatureRange()
	 * @generated
	 */
	int TEMPERATURE_RANGE = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__UNIT = 0;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__LOW = 1;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__HIGH = 2;

	/**
	 * The number of structural features of the '<em>Temperature Range</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Temperature Range</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.FermenterImpl <em>Fermenter</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.FermenterImpl
	 * @see brewery.impl.BreweryPackageImpl#getFermenter()
	 * @generated
	 */
	int FERMENTER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Yeast</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER__YEAST = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER__CONTENT = 2;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER__STARTED = 3;

	/**
	 * The number of structural features of the '<em>Fermenter</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Fermenter</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FERMENTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.MashStepImpl <em>Mash Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.MashStepImpl
	 * @see brewery.impl.BreweryPackageImpl#getMashStep()
	 * @generated
	 */
	int MASH_STEP = 4;

	/**
	 * The feature id for the '<em><b>Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__TEMPERATURE = 0;

	/**
	 * The feature id for the '<em><b>Pause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__PAUSE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__COMPLETE = 3;

	/**
	 * The feature id for the '<em><b>Rise Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__RISE_TIME = 4;

	/**
	 * The number of structural features of the '<em>Mash Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mash Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.MashScheduleImpl <em>Mash Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.MashScheduleImpl
	 * @see brewery.impl.BreweryPackageImpl#getMashSchedule()
	 * @generated
	 */
	int MASH_SCHEDULE = 5;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE__STEPS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Mash Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mash Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.SensorImpl
	 * @see brewery.impl.BreweryPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ID = 1;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.PinImpl <em>Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.PinImpl
	 * @see brewery.impl.BreweryPackageImpl#getPin()
	 * @generated
	 */
	int PIN = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN__ID = 0;

	/**
	 * The number of structural features of the '<em>Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.ConsoleCommandImpl <em>Console Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.ConsoleCommandImpl
	 * @see brewery.impl.BreweryPackageImpl#getConsoleCommand()
	 * @generated
	 */
	int CONSOLE_COMMAND = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Console Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Console Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.ConsoleReplyImpl <em>Console Reply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.ConsoleReplyImpl
	 * @see brewery.impl.BreweryPackageImpl#getConsoleReply()
	 * @generated
	 */
	int CONSOLE_REPLY = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Console Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Console Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.SensorReplyImpl <em>Sensor Reply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.SensorReplyImpl
	 * @see brewery.impl.BreweryPackageImpl#getSensorReply()
	 * @generated
	 */
	int SENSOR_REPLY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY__NAME = CONSOLE_REPLY__NAME;

	/**
	 * The feature id for the '<em><b>Temperature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY__TEMPERATURE = CONSOLE_REPLY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sensor Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY_FEATURE_COUNT = CONSOLE_REPLY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Sensor Reply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY_OPERATION_COUNT = CONSOLE_REPLY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see brewery.TemperatureUnit
	 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
	 * @generated
	 */
	int TEMPERATURE_UNIT = 11;

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BreweryFactory getBreweryFactory();

	/**
	 * Returns the meta object for class '{@link brewery.Fermenter <em>Fermenter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fermenter</em>'.
	 * @see brewery.Fermenter
	 * @generated
	 */
	EClass getFermenter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.Fermenter#getContent <em>Content</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see brewery.Fermenter#getContent()
	 * @see #getFermenter()
	 * @generated
	 */
	EAttribute getFermenter_Content();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Fermenter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.Fermenter#getName()
	 * @see #getFermenter()
	 * @generated
	 */
	EAttribute getFermenter_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.Fermenter#getStarted <em>Started</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see brewery.Fermenter#getStarted()
	 * @see #getFermenter()
	 * @generated
	 */
	EAttribute getFermenter_Started();

	/**
	 * Returns the meta object for class '{@link brewery.MashStep <em>Mash Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mash Step</em>'.
	 * @see brewery.MashStep
	 * @generated
	 */
	EClass getMashStep();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#getTemperature <em>Temperature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temperature</em>'.
	 * @see brewery.MashStep#getTemperature()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Temperature();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#getPause <em>Pause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pause</em>'.
	 * @see brewery.MashStep#getPause()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Pause();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see brewery.MashStep#getDescription()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Description();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#isComplete <em>Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see brewery.MashStep#isComplete()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Complete();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#getRiseTime <em>Rise Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rise Time</em>'.
	 * @see brewery.MashStep#getRiseTime()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_RiseTime();

	/**
	 * Returns the meta object for class '{@link brewery.MashSchedule <em>Mash Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mash Schedule</em>'.
	 * @see brewery.MashSchedule
	 * @generated
	 */
	EClass getMashSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link brewery.MashSchedule#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see brewery.MashSchedule#getSteps()
	 * @see #getMashSchedule()
	 * @generated
	 */
	EReference getMashSchedule_Steps();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashSchedule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.MashSchedule#getName()
	 * @see #getMashSchedule()
	 * @generated
	 */
	EAttribute getMashSchedule_Name();

	/**
	 * Returns the meta object for class '{@link brewery.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see brewery.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Sensor#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see brewery.Sensor#getValue()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Value();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Sensor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see brewery.Sensor#getId()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Id();

	/**
	 * Returns the meta object for class '{@link brewery.Pin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pin</em>'.
	 * @see brewery.Pin
	 * @generated
	 */
	EClass getPin();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Pin#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see brewery.Pin#getId()
	 * @see #getPin()
	 * @generated
	 */
	EAttribute getPin_Id();

	/**
	 * Returns the meta object for class '{@link brewery.ConsoleCommand <em>Console Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Command</em>'.
	 * @see brewery.ConsoleCommand
	 * @generated
	 */
	EClass getConsoleCommand();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ConsoleCommand#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.ConsoleCommand#getName()
	 * @see #getConsoleCommand()
	 * @generated
	 */
	EAttribute getConsoleCommand_Name();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ConsoleCommand#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see brewery.ConsoleCommand#getValue()
	 * @see #getConsoleCommand()
	 * @generated
	 */
	EAttribute getConsoleCommand_Value();

	/**
	 * Returns the meta object for class '{@link brewery.ConsoleReply <em>Console Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Reply</em>'.
	 * @see brewery.ConsoleReply
	 * @generated
	 */
	EClass getConsoleReply();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ConsoleReply#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.ConsoleReply#getName()
	 * @see #getConsoleReply()
	 * @generated
	 */
	EAttribute getConsoleReply_Name();

	/**
	 * Returns the meta object for class '{@link brewery.SensorReply <em>Sensor Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Reply</em>'.
	 * @see brewery.SensorReply
	 * @generated
	 */
	EClass getSensorReply();

	/**
	 * Returns the meta object for the attribute '{@link brewery.SensorReply#getTemperature <em>Temperature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temperature</em>'.
	 * @see brewery.SensorReply#getTemperature()
	 * @see #getSensorReply()
	 * @generated
	 */
	EAttribute getSensorReply_Temperature();

	/**
	 * Returns the meta object for the reference '{@link brewery.Fermenter#getYeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Yeast</em>'.
	 * @see brewery.Fermenter#getYeast()
	 * @see #getFermenter()
	 * @generated
	 */
	EReference getFermenter_Yeast();

	/**
	 * Returns the meta object for class '{@link brewery.Inventory <em>Inventory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inventory</em>'.
	 * @see brewery.Inventory
	 * @generated
	 */
	EClass getInventory();

	/**
	 * Returns the meta object for the containment reference list '{@link brewery.Inventory#getYeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Yeast</em>'.
	 * @see brewery.Inventory#getYeast()
	 * @see #getInventory()
	 * @generated
	 */
	EReference getInventory_Yeast();

	/**
	 * Returns the meta object for class '{@link brewery.TemperatureRange
	 * <em>Temperature Range</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Temperature Range</em>'.
	 * @see brewery.TemperatureRange
	 * @generated
	 */
	EClass getTemperatureRange();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.TemperatureRange#getHigh <em>High</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see brewery.TemperatureRange#getHigh()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_High();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.TemperatureRange#getLow <em>Low</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see brewery.TemperatureRange#getLow()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_Low();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.TemperatureRange#getUnit <em>Unit</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see brewery.TemperatureRange#getUnit()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_Unit();

	/**
	 * Returns the meta object for enum '{@link brewery.TemperatureUnit
	 * <em>Temperature Unit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for enum '<em>Temperature Unit</em>'.
	 * @see brewery.TemperatureUnit
	 * @generated
	 */
	EEnum getTemperatureUnit();

	/**
	 * Returns the meta object for class '{@link brewery.Yeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Yeast</em>'.
	 * @see brewery.Yeast
	 * @generated
	 */
	EClass getYeast();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.Yeast#getAttenuation <em>Attenuation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Attenuation</em>'.
	 * @see brewery.Yeast#getAttenuation()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Attenuation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.Yeast#getFlocculation <em>Flocculation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Flocculation</em>'.
	 * @see brewery.Yeast#getFlocculation()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Flocculation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.Yeast#getManufacturer <em>Manufacturer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Manufacturer</em>'.
	 * @see brewery.Yeast#getManufacturer()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Manufacturer();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Yeast#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.Yeast#getName()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Name();

	/**
	 * Returns the meta object for the containment reference '{@link brewery.Yeast#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see brewery.Yeast#getRange()
	 * @see #getYeast()
	 * @generated
	 */
	EReference getYeast_Range();

} // BreweryPackage
