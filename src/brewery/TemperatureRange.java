/**
 */
package brewery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Temperature Range</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link brewery.TemperatureRange#getUnit <em>Unit</em>}</li>
 * <li>{@link brewery.TemperatureRange#getLow <em>Low</em>}</li>
 * <li>{@link brewery.TemperatureRange#getHigh <em>High</em>}</li>
 * </ul>
 * </p>
 * 
 * @see brewery.BreweryPackage#getTemperatureRange()
 * @model
 * @generated
 */
public interface TemperatureRange extends EObject {
	/**
	 * Returns the value of the '<em><b>High</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>High</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>High</em>' attribute.
	 * @see #setHigh(int)
	 * @see brewery.BreweryPackage#getTemperatureRange_High()
	 * @model
	 * @generated
	 */
	int getHigh();

	/**
	 * Returns the value of the '<em><b>Low</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Low</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Low</em>' attribute.
	 * @see #setLow(int)
	 * @see brewery.BreweryPackage#getTemperatureRange_Low()
	 * @model
	 * @generated
	 */
	int getLow();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute. The literals
	 * are from the enumeration {@link brewery.TemperatureUnit}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see brewery.TemperatureUnit
	 * @see #setUnit(TemperatureUnit)
	 * @see brewery.BreweryPackage#getTemperatureRange_Unit()
	 * @model
	 * @generated
	 */
	TemperatureUnit getUnit();

	/**
	 * Sets the value of the '{@link brewery.TemperatureRange#getHigh
	 * <em>High</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>High</em>' attribute.
	 * @see #getHigh()
	 * @generated
	 */
	void setHigh(int value);

	/**
	 * Sets the value of the '{@link brewery.TemperatureRange#getLow
	 * <em>Low</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Low</em>' attribute.
	 * @see #getLow()
	 * @generated
	 */
	void setLow(int value);

	/**
	 * Sets the value of the '{@link brewery.TemperatureRange#getUnit
	 * <em>Unit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Unit</em>' attribute.
	 * @see brewery.TemperatureUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(TemperatureUnit value);

} // TemperatureRange
