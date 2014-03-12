/**
 */
package brewery;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Yeast</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link brewery.Yeast#getName <em>Name</em>}</li>
 * <li>{@link brewery.Yeast#getFlocculation <em>Flocculation</em>}</li>
 * <li>{@link brewery.Yeast#getAttenuation <em>Attenuation</em>}</li>
 * <li>{@link brewery.Yeast#getManufacturer <em>Manufacturer</em>}</li>
 * <li>{@link brewery.Yeast#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 * 
 * @see brewery.BreweryPackage#getYeast()
 * @model
 * @generated
 */
public interface Yeast extends EObject {
	/**
	 * Returns the value of the '<em><b>Attenuation</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attenuation</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attenuation</em>' attribute.
	 * @see #setAttenuation(String)
	 * @see brewery.BreweryPackage#getYeast_Attenuation()
	 * @model
	 * @generated
	 */
	String getAttenuation();

	/**
	 * Returns the value of the '<em><b>Flocculation</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flocculation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Flocculation</em>' attribute.
	 * @see #setFlocculation(String)
	 * @see brewery.BreweryPackage#getYeast_Flocculation()
	 * @model
	 * @generated
	 */
	String getFlocculation();

	/**
	 * Returns the value of the '<em><b>Manufacturer</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Manufacturer</em>' attribute.
	 * @see #setManufacturer(String)
	 * @see brewery.BreweryPackage#getYeast_Manufacturer()
	 * @model
	 * @generated
	 */
	String getManufacturer();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see brewery.BreweryPackage#getYeast_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(TemperatureRange)
	 * @see brewery.BreweryPackage#getYeast_Range()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TemperatureRange getRange();

	/**
	 * Sets the value of the '{@link brewery.Yeast#getAttenuation
	 * <em>Attenuation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Attenuation</em>' attribute.
	 * @see #getAttenuation()
	 * @generated
	 */
	void setAttenuation(String value);

	/**
	 * Sets the value of the '{@link brewery.Yeast#getFlocculation
	 * <em>Flocculation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Flocculation</em>' attribute.
	 * @see #getFlocculation()
	 * @generated
	 */
	void setFlocculation(String value);

	/**
	 * Sets the value of the '{@link brewery.Yeast#getManufacturer
	 * <em>Manufacturer</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Manufacturer</em>' attribute.
	 * @see #getManufacturer()
	 * @generated
	 */
	void setManufacturer(String value);

	/**
	 * Sets the value of the '{@link brewery.Yeast#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Sets the value of the '{@link brewery.Yeast#getRange <em>Range</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(TemperatureRange value);

} // Yeast
