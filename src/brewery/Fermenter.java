/**
 */
package brewery;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Fermenter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link brewery.Fermenter#getName <em>Name</em>}</li>
 *   <li>{@link brewery.Fermenter#getYeast <em>Yeast</em>}</li>
 *   <li>{@link brewery.Fermenter#getContent <em>Content</em>}</li>
 *   <li>{@link brewery.Fermenter#getStarted <em>Started</em>}</li>
 * </ul>
 * </p>
 *
 * @see brewery.BreweryPackage#getFermenter()
 * @model
 * @generated
 */
public interface Fermenter extends EObject {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see brewery.BreweryPackage#getFermenter_Content()
	 * @model
	 * @generated
	 */
	String getContent();

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
	 * @see brewery.BreweryPackage#getFermenter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Started</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Started</em>' attribute.
	 * @see #setStarted(Date)
	 * @see brewery.BreweryPackage#getFermenter_Started()
	 * @model
	 * @generated
	 */
	Date getStarted();

	/**
	 * Returns the value of the '<em><b>Yeast</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yeast</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Yeast</em>' reference.
	 * @see #setYeast(Yeast)
	 * @see brewery.BreweryPackage#getFermenter_Yeast()
	 * @model required="true"
	 * @generated
	 */
	Yeast getYeast();

	/**
	 * Sets the value of the '{@link brewery.Fermenter#getContent
	 * <em>Content</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Sets the value of the '{@link brewery.Fermenter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Sets the value of the '{@link brewery.Fermenter#getStarted
	 * <em>Started</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Started</em>' attribute.
	 * @see #getStarted()
	 * @generated
	 */
	void setStarted(Date value);

	/**
	 * Sets the value of the '{@link brewery.Fermenter#getYeast <em>Yeast</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yeast</em>' reference.
	 * @see #getYeast()
	 * @generated
	 */
	void setYeast(Yeast value);

} // Fermenter
