/**
 */
package brewery.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import brewery.BreweryPackage;
import brewery.Inventory;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Inventory</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link brewery.impl.InventoryImpl#getYeast <em>Yeast</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InventoryImpl extends MinimalEObjectImpl.Container implements
		Inventory {
	/**
	 * The cached value of the '{@link #getYeast() <em>Yeast</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getYeast()
	 * @generated
	 * @ordered
	 */
	protected EList<Yeast> yeast;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InventoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BreweryPackage.INVENTORY__YEAST:
			return getYeast();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BreweryPackage.INVENTORY__YEAST:
			return ((InternalEList<?>) getYeast()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BreweryPackage.INVENTORY__YEAST:
			return yeast != null && !yeast.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BreweryPackage.INVENTORY__YEAST:
			getYeast().clear();
			getYeast().addAll((Collection<? extends Yeast>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BreweryPackage.Literals.INVENTORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BreweryPackage.INVENTORY__YEAST:
			getYeast().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<Yeast> getYeast() {
		if (yeast == null) {
			yeast = new EObjectContainmentEList<Yeast>(Yeast.class, this,
					BreweryPackage.INVENTORY__YEAST);
		}
		return yeast;
	}

} // InventoryImpl
