/**
 */
package brewery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
		 * The meta object literal for the '{@link brewery.impl.MashStepImpl
		 * <em>Mash Step</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see brewery.impl.MashStepImpl
		 * @see brewery.impl.BreweryPackageImpl#getMashStep()
		 * @generated
		 */
		EClass MASH_STEP = eINSTANCE.getMashStep();

		/**
		 * The meta object literal for the '<em><b>Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__TEMPERATURE = eINSTANCE.getMashStep_Temperature();

		/**
		 * The meta object literal for the '<em><b>Pause</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__PAUSE = eINSTANCE.getMashStep_Pause();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__DESCRIPTION = eINSTANCE.getMashStep_Description();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__COMPLETE = eINSTANCE.getMashStep_Complete();

		/**
		 * The meta object literal for the '<em><b>Rise Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_STEP__RISE_TIME = eINSTANCE.getMashStep_RiseTime();

		/**
		 * The meta object literal for the '{@link brewery.impl.MashScheduleImpl <em>Mash Schedule</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.MashScheduleImpl
		 * @see brewery.impl.BreweryPackageImpl#getMashSchedule()
		 * @generated
		 */
		EClass MASH_SCHEDULE = eINSTANCE.getMashSchedule();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASH_SCHEDULE__STEPS = eINSTANCE.getMashSchedule_Steps();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_SCHEDULE__NAME = eINSTANCE.getMashSchedule_Name();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASH_SCHEDULE__TOTAL_TIME = eINSTANCE.getMashSchedule_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Complete</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MASH_SCHEDULE___COMPLETE__MASHSTEP = eINSTANCE.getMashSchedule__Complete__MashStep();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MASH_SCHEDULE___NEXT = eINSTANCE.getMashSchedule__Next();

		/**
		 * The meta object literal for the '<em><b>Has Next</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MASH_SCHEDULE___HAS_NEXT = eINSTANCE.getMashSchedule__HasNext();

		/**
		 * The meta object literal for the '{@link brewery.impl.SensorImpl
		 * <em>Sensor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see brewery.impl.SensorImpl
		 * @see brewery.impl.BreweryPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__VALUE = eINSTANCE.getSensor_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR__ID = eINSTANCE.getSensor_Id();

		/**
		 * The meta object literal for the '{@link brewery.impl.PinImpl <em>Pin</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.PinImpl
		 * @see brewery.impl.BreweryPackageImpl#getPin()
		 * @generated
		 */
		EClass PIN = eINSTANCE.getPin();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PIN__ID = eINSTANCE.getPin_Id();

		/**
		 * The meta object literal for the '{@link brewery.impl.ConsoleCommandImpl <em>Console Command</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.ConsoleCommandImpl
		 * @see brewery.impl.BreweryPackageImpl#getConsoleCommand()
		 * @generated
		 */
		EClass CONSOLE_COMMAND = eINSTANCE.getConsoleCommand();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_COMMAND__NAME = eINSTANCE.getConsoleCommand_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_COMMAND__VALUE = eINSTANCE.getConsoleCommand_Value();

		/**
		 * The meta object literal for the '{@link brewery.impl.ConsoleReplyImpl <em>Console Reply</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see brewery.impl.ConsoleReplyImpl
		 * @see brewery.impl.BreweryPackageImpl#getConsoleReply()
		 * @generated
		 */
		EClass CONSOLE_REPLY = eINSTANCE.getConsoleReply();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSOLE_REPLY__NAME = eINSTANCE.getConsoleReply_Name();

		/**
		 * The meta object literal for the '{@link brewery.impl.SensorReplyImpl <em>Sensor Reply</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see brewery.impl.SensorReplyImpl
		 * @see brewery.impl.BreweryPackageImpl#getSensorReply()
		 * @generated
		 */
		EClass SENSOR_REPLY = eINSTANCE.getSensorReply();

		/**
		 * The meta object literal for the '<em><b>Temperature</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_REPLY__TEMPERATURE = eINSTANCE.getSensorReply_Temperature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_REPLY__ID = eINSTANCE.getSensorReply_Id();

		/**
		 * The meta object literal for the '{@link brewery.impl.ArduinoControllerImpl <em>Arduino Controller</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.ArduinoControllerImpl
		 * @see brewery.impl.BreweryPackageImpl#getArduinoController()
		 * @generated
		 */
		EClass ARDUINO_CONTROLLER = eINSTANCE.getArduinoController();

		/**
		 * The meta object literal for the '<em><b>Writer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARDUINO_CONTROLLER__WRITER = eINSTANCE.getArduinoController_Writer();

		/**
		 * The meta object literal for the '<em><b>Reader</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARDUINO_CONTROLLER__READER = eINSTANCE.getArduinoController_Reader();

		/**
		 * The meta object literal for the '<em><b>Current Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARDUINO_CONTROLLER__CURRENT_PORT = eINSTANCE.getArduinoController_CurrentPort();

		/**
		 * The meta object literal for the '<em><b>Scan</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SCAN = eINSTANCE.getArduinoController__Scan();

		/**
		 * The meta object literal for the '<em><b>Configure</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___CONFIGURE__INT_SERIALPORT = eINSTANCE.getArduinoController__Configure__int_SerialPort();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___START__STRING = eINSTANCE.getArduinoController__Start__String();

		/**
		 * The meta object literal for the '<em><b>Send Sensor Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_SENSOR_COMMAND = eINSTANCE.getArduinoController__SendSensorCommand();

		/**
		 * The meta object literal for the '<em><b>Send Setpoint Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_SETPOINT_COMMAND__DOUBLE = eINSTANCE.getArduinoController__SendSetpointCommand__double();

		/**
		 * The meta object literal for the '<em><b>Send Sensor PCommand</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_SENSOR_PCOMMAND__INT = eINSTANCE.getArduinoController__SendSensorPCommand__int();

		/**
		 * The meta object literal for the '<em><b>Send Sensor ICommand</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_SENSOR_ICOMMAND__INT = eINSTANCE.getArduinoController__SendSensorICommand__int();

		/**
		 * The meta object literal for the '<em><b>Send Sensor DCommand</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_SENSOR_DCOMMAND__INT = eINSTANCE.getArduinoController__SendSensorDCommand__int();

		/**
		 * The meta object literal for the '<em><b>Add Listener</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___ADD_LISTENER__CONSOLEPARSEREVENTLISTENER = eINSTANCE.getArduinoController__AddListener__ConsoleParserEventListener();

		/**
		 * The meta object literal for the '<em><b>Set Event Broker</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SET_EVENT_BROKER__IEVENTBROKER = eINSTANCE.getArduinoController__SetEventBroker__IEventBroker();

		/**
		 * The meta object literal for the '<em><b>Send PID Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_PID_COMMAND = eINSTANCE.getArduinoController__SendPIDCommand();

		/**
		 * The meta object literal for the '<em><b>Send Tune Command</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ARDUINO_CONTROLLER___SEND_TUNE_COMMAND__INT_INT_INT = eINSTANCE.getArduinoController__SendTuneCommand__int_int_int();

		/**
		 * The meta object literal for the '{@link gnu.io.SerialPortEventListener <em>Serial Port Event Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gnu.io.SerialPortEventListener
		 * @see brewery.impl.BreweryPackageImpl#getSerialPortEventListener()
		 * @generated
		 */
		EClass SERIAL_PORT_EVENT_LISTENER = eINSTANCE.getSerialPortEventListener();

		/**
		 * The meta object literal for the '{@link brewery.ui.monitor.ConsoleParserEventListener <em>Console Parser Event Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.ui.monitor.ConsoleParserEventListener
		 * @see brewery.impl.BreweryPackageImpl#getConsoleParserEventListener()
		 * @generated
		 */
		EClass CONSOLE_PARSER_EVENT_LISTENER = eINSTANCE.getConsoleParserEventListener();

		/**
		 * The meta object literal for the '{@link brewery.impl.PIDImpl <em>PID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.PIDImpl
		 * @see brewery.impl.BreweryPackageImpl#getPID()
		 * @generated
		 */
		EClass PID = eINSTANCE.getPID();

		/**
		 * The meta object literal for the '<em><b>P</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PID__P = eINSTANCE.getPID_P();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PID__I = eINSTANCE.getPID_I();

		/**
		 * The meta object literal for the '<em><b>D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PID__D = eINSTANCE.getPID_D();

		/**
		 * The meta object literal for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see brewery.TemperatureUnit
		 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
		 * @generated
		 */
		EEnum TEMPERATURE_UNIT = eINSTANCE.getTemperatureUnit();

		/**
		 * The meta object literal for the '{@link brewery.Command <em>Command</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.Command
		 * @see brewery.impl.BreweryPackageImpl#getCommand()
		 * @generated
		 */
		EEnum COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em>Comm Port Identifier</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gnu.io.CommPortIdentifier
		 * @see brewery.impl.BreweryPackageImpl#getCommPortIdentifier()
		 * @generated
		 */
		EDataType COMM_PORT_IDENTIFIER = eINSTANCE.getCommPortIdentifier();

		/**
		 * The meta object literal for the '<em>Port In Use Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gnu.io.PortInUseException
		 * @see brewery.impl.BreweryPackageImpl#getPortInUseException()
		 * @generated
		 */
		EDataType PORT_IN_USE_EXCEPTION = eINSTANCE.getPortInUseException();

		/**
		 * The meta object literal for the '<em>Serial Port</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gnu.io.SerialPort
		 * @see brewery.impl.BreweryPackageImpl#getSerialPort()
		 * @generated
		 */
		EDataType SERIAL_PORT = eINSTANCE.getSerialPort();

		/**
		 * The meta object literal for the '<em>Unsupported Comm Operation Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gnu.io.UnsupportedCommOperationException
		 * @see brewery.impl.BreweryPackageImpl#getUnsupportedCommOperationException()
		 * @generated
		 */
		EDataType UNSUPPORTED_COMM_OPERATION_EXCEPTION = eINSTANCE.getUnsupportedCommOperationException();

		/**
		 * The meta object literal for the '<em>IO Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.IOException
		 * @see brewery.impl.BreweryPackageImpl#getIOException()
		 * @generated
		 */
		EDataType IO_EXCEPTION = eINSTANCE.getIOException();

		/**
		 * The meta object literal for the '<em>Writer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.BufferedWriter
		 * @see brewery.impl.BreweryPackageImpl#getWriter()
		 * @generated
		 */
		EDataType WRITER = eINSTANCE.getWriter();

		/**
		 * The meta object literal for the '<em>Reader</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.BufferedReader
		 * @see brewery.impl.BreweryPackageImpl#getReader()
		 * @generated
		 */
		EDataType READER = eINSTANCE.getReader();

		/**
		 * The meta object literal for the '<em>String Builder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.StringBuilder
		 * @see brewery.impl.BreweryPackageImpl#getStringBuilder()
		 * @generated
		 */
		EDataType STRING_BUILDER = eINSTANCE.getStringBuilder();

		/**
		 * The meta object literal for the '<em>IEvent Broker</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.e4.core.services.events.IEventBroker
		 * @see brewery.impl.BreweryPackageImpl#getIEventBroker()
		 * @generated
		 */
		EDataType IEVENT_BROKER = eINSTANCE.getIEventBroker();

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.MashStepImpl
	 * @see brewery.impl.BreweryPackageImpl#getMashStep()
	 * @generated
	 */
	int MASH_STEP = 4;

	/**
	 * The feature id for the '<em><b>Temperature</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__TEMPERATURE = 0;

	/**
	 * The feature id for the '<em><b>Pause</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__PAUSE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Complete</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__COMPLETE = 3;

	/**
	 * The feature id for the '<em><b>Rise Time</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP__RISE_TIME = 4;

	/**
	 * The number of structural features of the '<em>Mash Step</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mash Step</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.MashScheduleImpl
	 * <em>Mash Schedule</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see brewery.impl.MashScheduleImpl
	 * @see brewery.impl.BreweryPackageImpl#getMashSchedule()
	 * @generated
	 */
	int MASH_SCHEDULE = 5;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE__STEPS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE__TOTAL_TIME = 2;

	/**
	 * The number of structural features of the '<em>Mash Schedule</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Complete</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE___COMPLETE__MASHSTEP = 0;

	/**
	 * The operation id for the '<em>Next</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE___NEXT = 1;

	/**
	 * The operation id for the '<em>Has Next</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE___HAS_NEXT = 2;

	/**
	 * The number of operations of the '<em>Mash Schedule</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASH_SCHEDULE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link brewery.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.SensorImpl
	 * @see brewery.impl.BreweryPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR__ID = 1;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Sensor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.PinImpl <em>Pin</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see brewery.impl.PinImpl
	 * @see brewery.impl.BreweryPackageImpl#getPin()
	 * @generated
	 */
	int PIN = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PIN__ID = 0;

	/**
	 * The number of structural features of the '<em>Pin</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PIN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Pin</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.ConsoleCommandImpl <em>Console Command</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see brewery.impl.ConsoleCommandImpl
	 * @see brewery.impl.BreweryPackageImpl#getConsoleCommand()
	 * @generated
	 */
	int CONSOLE_COMMAND = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Console Command</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Console Command</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSOLE_COMMAND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.ConsoleReplyImpl
	 * <em>Console Reply</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see brewery.impl.ConsoleReplyImpl
	 * @see brewery.impl.BreweryPackageImpl#getConsoleReply()
	 * @generated
	 */
	int CONSOLE_REPLY = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Console Reply</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Console Reply</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSOLE_REPLY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.SensorReplyImpl
	 * <em>Sensor Reply</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see brewery.impl.SensorReplyImpl
	 * @see brewery.impl.BreweryPackageImpl#getSensorReply()
	 * @generated
	 */
	int SENSOR_REPLY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY__NAME = CONSOLE_REPLY__NAME;

	/**
	 * The feature id for the '<em><b>Temperature</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY__TEMPERATURE = CONSOLE_REPLY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY__ID = CONSOLE_REPLY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sensor Reply</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY_FEATURE_COUNT = CONSOLE_REPLY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sensor Reply</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_REPLY_OPERATION_COUNT = CONSOLE_REPLY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gnu.io.SerialPortEventListener <em>Serial Port Event Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gnu.io.SerialPortEventListener
	 * @see brewery.impl.BreweryPackageImpl#getSerialPortEventListener()
	 * @generated
	 */
	int SERIAL_PORT_EVENT_LISTENER = 12;

	/**
	 * The number of structural features of the '<em>Serial Port Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIAL_PORT_EVENT_LISTENER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Serial Port Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.ArduinoControllerImpl <em>Arduino Controller</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.ArduinoControllerImpl
	 * @see brewery.impl.BreweryPackageImpl#getArduinoController()
	 * @generated
	 */
	int ARDUINO_CONTROLLER = 11;

	/**
	 * The feature id for the '<em><b>Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER__WRITER = SERIAL_PORT_EVENT_LISTENER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER__READER = SERIAL_PORT_EVENT_LISTENER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER__CURRENT_PORT = SERIAL_PORT_EVENT_LISTENER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Arduino Controller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER_FEATURE_COUNT = SERIAL_PORT_EVENT_LISTENER_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Scan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SCAN = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Configure</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___CONFIGURE__INT_SERIALPORT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___START__STRING = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Send Sensor Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_SENSOR_COMMAND = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Send Setpoint Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_SETPOINT_COMMAND__DOUBLE = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Send Sensor PCommand</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_SENSOR_PCOMMAND__INT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Send Sensor ICommand</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_SENSOR_ICOMMAND__INT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Send Sensor DCommand</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_SENSOR_DCOMMAND__INT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Add Listener</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___ADD_LISTENER__CONSOLEPARSEREVENTLISTENER = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Set Event Broker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SET_EVENT_BROKER__IEVENTBROKER = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Send PID Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_PID_COMMAND = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Send Tune Command</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER___SEND_TUNE_COMMAND__INT_INT_INT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Arduino Controller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARDUINO_CONTROLLER_OPERATION_COUNT = SERIAL_PORT_EVENT_LISTENER_OPERATION_COUNT + 12;

	/**
	 * The meta object id for the '{@link brewery.ui.monitor.ConsoleParserEventListener <em>Console Parser Event Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.ui.monitor.ConsoleParserEventListener
	 * @see brewery.impl.BreweryPackageImpl#getConsoleParserEventListener()
	 * @generated
	 */
	int CONSOLE_PARSER_EVENT_LISTENER = 13;

	/**
	 * The number of structural features of the '<em>Console Parser Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_PARSER_EVENT_LISTENER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Console Parser Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSOLE_PARSER_EVENT_LISTENER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.PIDImpl <em>PID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.PIDImpl
	 * @see brewery.impl.BreweryPackageImpl#getPID()
	 * @generated
	 */
	int PID = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID__NAME = CONSOLE_REPLY__NAME;

	/**
	 * The feature id for the '<em><b>P</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID__P = CONSOLE_REPLY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID__I = CONSOLE_REPLY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID__D = CONSOLE_REPLY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>PID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_FEATURE_COUNT = CONSOLE_REPLY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>PID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PID_OPERATION_COUNT = CONSOLE_REPLY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see brewery.TemperatureUnit
	 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
	 * @generated
	 */
	int TEMPERATURE_UNIT = 15;

	/**
	 * The meta object id for the '{@link brewery.Command <em>Command</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.Command
	 * @see brewery.impl.BreweryPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 16;

	/**
	 * The meta object id for the '<em>Comm Port Identifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gnu.io.CommPortIdentifier
	 * @see brewery.impl.BreweryPackageImpl#getCommPortIdentifier()
	 * @generated
	 */
	int COMM_PORT_IDENTIFIER = 17;

	/**
	 * The meta object id for the '<em>Port In Use Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gnu.io.PortInUseException
	 * @see brewery.impl.BreweryPackageImpl#getPortInUseException()
	 * @generated
	 */
	int PORT_IN_USE_EXCEPTION = 18;

	/**
	 * The meta object id for the '<em>Serial Port</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gnu.io.SerialPort
	 * @see brewery.impl.BreweryPackageImpl#getSerialPort()
	 * @generated
	 */
	int SERIAL_PORT = 19;

	/**
	 * The meta object id for the '<em>Unsupported Comm Operation Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gnu.io.UnsupportedCommOperationException
	 * @see brewery.impl.BreweryPackageImpl#getUnsupportedCommOperationException()
	 * @generated
	 */
	int UNSUPPORTED_COMM_OPERATION_EXCEPTION = 20;

	/**
	 * The meta object id for the '<em>IO Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.IOException
	 * @see brewery.impl.BreweryPackageImpl#getIOException()
	 * @generated
	 */
	int IO_EXCEPTION = 21;

	/**
	 * The meta object id for the '<em>Writer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.BufferedWriter
	 * @see brewery.impl.BreweryPackageImpl#getWriter()
	 * @generated
	 */
	int WRITER = 22;

	/**
	 * The meta object id for the '<em>Reader</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.BufferedReader
	 * @see brewery.impl.BreweryPackageImpl#getReader()
	 * @generated
	 */
	int READER = 23;

	/**
	 * The meta object id for the '<em>String Builder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.StringBuilder
	 * @see brewery.impl.BreweryPackageImpl#getStringBuilder()
	 * @generated
	 */
	int STRING_BUILDER = 24;

	/**
	 * The meta object id for the '<em>IEvent Broker</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.e4.core.services.events.IEventBroker
	 * @see brewery.impl.BreweryPackageImpl#getIEventBroker()
	 * @generated
	 */
	int IEVENT_BROKER = 25;

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BreweryFactory getBreweryFactory();

	/**
	 * Returns the meta object for class '{@link brewery.ConsoleCommand <em>Console Command</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Command</em>'.
	 * @see brewery.ConsoleCommand
	 * @generated
	 */
	EClass getConsoleCommand();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.ConsoleCommand#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.ConsoleCommand#getName()
	 * @see #getConsoleCommand()
	 * @generated
	 */
	EAttribute getConsoleCommand_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.ConsoleCommand#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see brewery.ConsoleCommand#getValue()
	 * @see #getConsoleCommand()
	 * @generated
	 */
	EAttribute getConsoleCommand_Value();

	/**
	 * Returns the meta object for class '{@link brewery.ConsoleReply <em>Console Reply</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Reply</em>'.
	 * @see brewery.ConsoleReply
	 * @generated
	 */
	EClass getConsoleReply();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ConsoleReply#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.ConsoleReply#getName()
	 * @see #getConsoleReply()
	 * @generated
	 */
	EAttribute getConsoleReply_Name();

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
	 * Returns the meta object for class '{@link brewery.MashSchedule <em>Mash Schedule</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mash Schedule</em>'.
	 * @see brewery.MashSchedule
	 * @generated
	 */
	EClass getMashSchedule();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashSchedule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.MashSchedule#getName()
	 * @see #getMashSchedule()
	 * @generated
	 */
	EAttribute getMashSchedule_Name();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashSchedule#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see brewery.MashSchedule#getTotalTime()
	 * @see #getMashSchedule()
	 * @generated
	 */
	EAttribute getMashSchedule_TotalTime();

	/**
	 * Returns the meta object for the '{@link brewery.MashSchedule#complete(brewery.MashStep) <em>Complete</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complete</em>' operation.
	 * @see brewery.MashSchedule#complete(brewery.MashStep)
	 * @generated
	 */
	EOperation getMashSchedule__Complete__MashStep();

	/**
	 * Returns the meta object for the '{@link brewery.MashSchedule#next() <em>Next</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Next</em>' operation.
	 * @see brewery.MashSchedule#next()
	 * @generated
	 */
	EOperation getMashSchedule__Next();

	/**
	 * Returns the meta object for the '{@link brewery.MashSchedule#hasNext() <em>Has Next</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Next</em>' operation.
	 * @see brewery.MashSchedule#hasNext()
	 * @generated
	 */
	EOperation getMashSchedule__HasNext();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link brewery.MashSchedule#getSteps <em>Steps</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Steps</em>'.
	 * @see brewery.MashSchedule#getSteps()
	 * @see #getMashSchedule()
	 * @generated
	 */
	EReference getMashSchedule_Steps();

	/**
	 * Returns the meta object for class '{@link brewery.MashStep <em>Mash Step</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mash Step</em>'.
	 * @see brewery.MashStep
	 * @generated
	 */
	EClass getMashStep();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.MashStep#isComplete <em>Complete</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Complete</em>'.
	 * @see brewery.MashStep#isComplete()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Complete();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.MashStep#getDescription <em>Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see brewery.MashStep#getDescription()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Description();

	/**
	 * Returns the meta object for the attribute '{@link brewery.MashStep#getPause <em>Pause</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pause</em>'.
	 * @see brewery.MashStep#getPause()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Pause();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.MashStep#getRiseTime <em>Rise Time</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Rise Time</em>'.
	 * @see brewery.MashStep#getRiseTime()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_RiseTime();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.MashStep#getTemperature <em>Temperature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Temperature</em>'.
	 * @see brewery.MashStep#getTemperature()
	 * @see #getMashStep()
	 * @generated
	 */
	EAttribute getMashStep_Temperature();

	/**
	 * Returns the meta object for class '{@link brewery.Pin <em>Pin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pin</em>'.
	 * @see brewery.Pin
	 * @generated
	 */
	EClass getPin();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Pin#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see brewery.Pin#getId()
	 * @see #getPin()
	 * @generated
	 */
	EAttribute getPin_Id();

	/**
	 * Returns the meta object for class '{@link brewery.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see brewery.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Sensor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see brewery.Sensor#getId()
	 * @see #getSensor()
	 * @generated
	 */
	EAttribute getSensor_Id();

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
	 * Returns the meta object for class '{@link brewery.SensorReply <em>Sensor Reply</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Reply</em>'.
	 * @see brewery.SensorReply
	 * @generated
	 */
	EClass getSensorReply();

	/**
	 * Returns the meta object for the attribute '
	 * {@link brewery.SensorReply#getTemperature <em>Temperature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Temperature</em>'.
	 * @see brewery.SensorReply#getTemperature()
	 * @see #getSensorReply()
	 * @generated
	 */
	EAttribute getSensorReply_Temperature();

	/**
	 * Returns the meta object for the attribute '{@link brewery.SensorReply#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see brewery.SensorReply#getId()
	 * @see #getSensorReply()
	 * @generated
	 */
	EAttribute getSensorReply_Id();

	/**
	 * Returns the meta object for class '{@link brewery.ArduinoController <em>Arduino Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arduino Controller</em>'.
	 * @see brewery.ArduinoController
	 * @generated
	 */
	EClass getArduinoController();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ArduinoController#getWriter <em>Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writer</em>'.
	 * @see brewery.ArduinoController#getWriter()
	 * @see #getArduinoController()
	 * @generated
	 */
	EAttribute getArduinoController_Writer();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ArduinoController#getReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reader</em>'.
	 * @see brewery.ArduinoController#getReader()
	 * @see #getArduinoController()
	 * @generated
	 */
	EAttribute getArduinoController_Reader();

	/**
	 * Returns the meta object for the attribute '{@link brewery.ArduinoController#getCurrentPort <em>Current Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Port</em>'.
	 * @see brewery.ArduinoController#getCurrentPort()
	 * @see #getArduinoController()
	 * @generated
	 */
	EAttribute getArduinoController_CurrentPort();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#scan() <em>Scan</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Scan</em>' operation.
	 * @see brewery.ArduinoController#scan()
	 * @generated
	 */
	EOperation getArduinoController__Scan();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#configure(int, gnu.io.SerialPort) <em>Configure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure</em>' operation.
	 * @see brewery.ArduinoController#configure(int, gnu.io.SerialPort)
	 * @generated
	 */
	EOperation getArduinoController__Configure__int_SerialPort();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#start(java.lang.String) <em>Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Start</em>' operation.
	 * @see brewery.ArduinoController#start(java.lang.String)
	 * @generated
	 */
	EOperation getArduinoController__Start__String();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendSensorCommand() <em>Send Sensor Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Sensor Command</em>' operation.
	 * @see brewery.ArduinoController#sendSensorCommand()
	 * @generated
	 */
	EOperation getArduinoController__SendSensorCommand();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendSetpointCommand(double) <em>Send Setpoint Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Setpoint Command</em>' operation.
	 * @see brewery.ArduinoController#sendSetpointCommand(double)
	 * @generated
	 */
	EOperation getArduinoController__SendSetpointCommand__double();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendSensorPCommand(int) <em>Send Sensor PCommand</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Sensor PCommand</em>' operation.
	 * @see brewery.ArduinoController#sendSensorPCommand(int)
	 * @generated
	 */
	EOperation getArduinoController__SendSensorPCommand__int();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendSensorICommand(int) <em>Send Sensor ICommand</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Sensor ICommand</em>' operation.
	 * @see brewery.ArduinoController#sendSensorICommand(int)
	 * @generated
	 */
	EOperation getArduinoController__SendSensorICommand__int();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendSensorDCommand(int) <em>Send Sensor DCommand</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Sensor DCommand</em>' operation.
	 * @see brewery.ArduinoController#sendSensorDCommand(int)
	 * @generated
	 */
	EOperation getArduinoController__SendSensorDCommand__int();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#addListener(brewery.ui.monitor.ConsoleParserEventListener) <em>Add Listener</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Listener</em>' operation.
	 * @see brewery.ArduinoController#addListener(brewery.ui.monitor.ConsoleParserEventListener)
	 * @generated
	 */
	EOperation getArduinoController__AddListener__ConsoleParserEventListener();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#setEventBroker(org.eclipse.e4.core.services.events.IEventBroker) <em>Set Event Broker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Event Broker</em>' operation.
	 * @see brewery.ArduinoController#setEventBroker(org.eclipse.e4.core.services.events.IEventBroker)
	 * @generated
	 */
	EOperation getArduinoController__SetEventBroker__IEventBroker();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendPIDCommand() <em>Send PID Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send PID Command</em>' operation.
	 * @see brewery.ArduinoController#sendPIDCommand()
	 * @generated
	 */
	EOperation getArduinoController__SendPIDCommand();

	/**
	 * Returns the meta object for the '{@link brewery.ArduinoController#sendTuneCommand(int, int, int) <em>Send Tune Command</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Tune Command</em>' operation.
	 * @see brewery.ArduinoController#sendTuneCommand(int, int, int)
	 * @generated
	 */
	EOperation getArduinoController__SendTuneCommand__int_int_int();

	/**
	 * Returns the meta object for class '{@link gnu.io.SerialPortEventListener <em>Serial Port Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serial Port Event Listener</em>'.
	 * @see gnu.io.SerialPortEventListener
	 * @model instanceClass="gnu.io.SerialPortEventListener"
	 * @generated
	 */
	EClass getSerialPortEventListener();

	/**
	 * Returns the meta object for class '{@link brewery.ui.monitor.ConsoleParserEventListener <em>Console Parser Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Console Parser Event Listener</em>'.
	 * @see brewery.ui.monitor.ConsoleParserEventListener
	 * @model instanceClass="brewery.ui.monitor.ConsoleParserEventListener"
	 * @generated
	 */
	EClass getConsoleParserEventListener();

	/**
	 * Returns the meta object for class '{@link brewery.PID <em>PID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PID</em>'.
	 * @see brewery.PID
	 * @generated
	 */
	EClass getPID();

	/**
	 * Returns the meta object for the attribute '{@link brewery.PID#getP <em>P</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>P</em>'.
	 * @see brewery.PID#getP()
	 * @see #getPID()
	 * @generated
	 */
	EAttribute getPID_P();

	/**
	 * Returns the meta object for the attribute '{@link brewery.PID#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see brewery.PID#getI()
	 * @see #getPID()
	 * @generated
	 */
	EAttribute getPID_I();

	/**
	 * Returns the meta object for the attribute '{@link brewery.PID#getD <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>D</em>'.
	 * @see brewery.PID#getD()
	 * @see #getPID()
	 * @generated
	 */
	EAttribute getPID_D();

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
	 * Returns the meta object for enum '{@link brewery.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command</em>'.
	 * @see brewery.Command
	 * @generated
	 */
	EEnum getCommand();

	/**
	 * Returns the meta object for data type '{@link gnu.io.CommPortIdentifier <em>Comm Port Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Comm Port Identifier</em>'.
	 * @see gnu.io.CommPortIdentifier
	 * @model instanceClass="gnu.io.CommPortIdentifier"
	 * @generated
	 */
	EDataType getCommPortIdentifier();

	/**
	 * Returns the meta object for data type '{@link gnu.io.PortInUseException <em>Port In Use Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Port In Use Exception</em>'.
	 * @see gnu.io.PortInUseException
	 * @model instanceClass="gnu.io.PortInUseException"
	 * @generated
	 */
	EDataType getPortInUseException();

	/**
	 * Returns the meta object for data type '{@link gnu.io.SerialPort <em>Serial Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Serial Port</em>'.
	 * @see gnu.io.SerialPort
	 * @model instanceClass="gnu.io.SerialPort"
	 * @generated
	 */
	EDataType getSerialPort();

	/**
	 * Returns the meta object for data type '{@link gnu.io.UnsupportedCommOperationException <em>Unsupported Comm Operation Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unsupported Comm Operation Exception</em>'.
	 * @see gnu.io.UnsupportedCommOperationException
	 * @model instanceClass="gnu.io.UnsupportedCommOperationException"
	 * @generated
	 */
	EDataType getUnsupportedCommOperationException();

	/**
	 * Returns the meta object for data type '{@link java.io.IOException <em>IO Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IO Exception</em>'.
	 * @see java.io.IOException
	 * @model instanceClass="java.io.IOException"
	 * @generated
	 */
	EDataType getIOException();

	/**
	 * Returns the meta object for data type '{@link java.io.BufferedWriter <em>Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Writer</em>'.
	 * @see java.io.BufferedWriter
	 * @model instanceClass="java.io.BufferedWriter" serializeable="false"
	 * @generated
	 */
	EDataType getWriter();

	/**
	 * Returns the meta object for data type '{@link java.io.BufferedReader <em>Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reader</em>'.
	 * @see java.io.BufferedReader
	 * @model instanceClass="java.io.BufferedReader" serializeable="false"
	 * @generated
	 */
	EDataType getReader();

	/**
	 * Returns the meta object for data type '{@link java.lang.StringBuilder <em>String Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Builder</em>'.
	 * @see java.lang.StringBuilder
	 * @model instanceClass="java.lang.StringBuilder"
	 * @generated
	 */
	EDataType getStringBuilder();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.e4.core.services.events.IEventBroker <em>IEvent Broker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IEvent Broker</em>'.
	 * @see org.eclipse.e4.core.services.events.IEventBroker
	 * @model instanceClass="org.eclipse.e4.core.services.events.IEventBroker"
	 * @generated
	 */
	EDataType getIEventBroker();

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
