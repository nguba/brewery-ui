/**
 */
package brewery;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see brewery.BreweryPackage
 * @generated
 */
public interface BreweryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	BreweryFactory eINSTANCE = brewery.impl.BreweryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Console Command</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Console Command</em>'.
	 * @generated
	 */
	ConsoleCommand createConsoleCommand();

	/**
	 * Returns a new object of class '<em>Fermenter</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Fermenter</em>'.
	 * @generated
	 */
	Fermenter createFermenter();

	/**
	 * Returns a new object of class '<em>Inventory</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inventory</em>'.
	 * @generated
	 */
	Inventory createInventory();

	/**
	 * Returns a new object of class '<em>Mash Schedule</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mash Schedule</em>'.
	 * @generated
	 */
	MashSchedule createMashSchedule();

	/**
	 * Returns a new object of class '<em>Mash Step</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Mash Step</em>'.
	 * @generated
	 */
	MashStep createMashStep();

	/**
	 * Returns a new object of class '<em>Pin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pin</em>'.
	 * @generated
	 */
	Pin createPin();

	/**
	 * Returns a new object of class '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sensor</em>'.
	 * @generated
	 */
	Sensor createSensor();

	/**
	 * Returns a new object of class '<em>Sensor Reply</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sensor Reply</em>'.
	 * @generated
	 */
	SensorReply createSensorReply();

	/**
	 * Returns a new object of class '<em>Arduino Controller</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arduino Controller</em>'.
	 * @generated
	 */
	ArduinoController createArduinoController();

	/**
	 * Returns a new object of class '<em>Temperature Range</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Temperature Range</em>'.
	 * @generated
	 */
	TemperatureRange createTemperatureRange();

	/**
	 * Returns a new object of class '<em>Yeast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Yeast</em>'.
	 * @generated
	 */
	Yeast createYeast();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BreweryPackage getBreweryPackage();

} // BreweryFactory
