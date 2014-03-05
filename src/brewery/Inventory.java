/**
 */
package brewery;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inventory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link brewery.Inventory#getYeast <em>Yeast</em>}</li>
 * </ul>
 * </p>
 *
 * @see brewery.BreweryPackage#getInventory()
 * @model
 * @generated
 */
public interface Inventory extends EObject {
	/**
	 * Returns the value of the '<em><b>Yeast</b></em>' containment reference list.
	 * The list contents are of type {@link brewery.Yeast}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yeast</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yeast</em>' containment reference list.
	 * @see brewery.BreweryPackage#getInventory_Yeast()
	 * @model containment="true"
	 * @generated
	 */
	EList<Yeast> getYeast();

} // Inventory
