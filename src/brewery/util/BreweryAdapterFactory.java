/**
 */
package brewery.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import brewery.BreweryPackage;
import brewery.Fermenter;
import brewery.Inventory;
import brewery.TemperatureRange;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see brewery.BreweryPackage
 * @generated
 */
public class BreweryAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static BreweryPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BrewerySwitch<Adapter> modelSwitch = new BrewerySwitch<Adapter>() {
		@Override
		public Adapter caseFermenter(Fermenter object) {
			return createFermenterAdapter();
		}

		@Override
		public Adapter caseInventory(Inventory object) {
			return createInventoryAdapter();
		}

		@Override
		public Adapter caseTemperatureRange(TemperatureRange object) {
			return createTemperatureRangeAdapter();
		}

		@Override
		public Adapter caseYeast(Yeast object) {
			return createYeastAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public BreweryAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BreweryPackage.eINSTANCE;
		}
	}

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link brewery.Fermenter
	 * <em>Fermenter</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see brewery.Fermenter
	 * @generated
	 */
	public Adapter createFermenterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link brewery.Inventory
	 * <em>Inventory</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see brewery.Inventory
	 * @generated
	 */
	public Adapter createInventoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link brewery.TemperatureRange <em>Temperature Range</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance
	 * will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see brewery.TemperatureRange
	 * @generated
	 */
	public Adapter createTemperatureRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link brewery.Yeast
	 * <em>Yeast</em>}'. <!-- begin-user-doc --> This default implementation
	 * returns null so that we can easily ignore cases; it's useful to ignore a
	 * case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see brewery.Yeast
	 * @generated
	 */
	public Adapter createYeastAdapter() {
		return null;
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

} // BreweryAdapterFactory
