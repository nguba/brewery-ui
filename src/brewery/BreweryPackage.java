/**
 */
package brewery;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see brewery.BreweryFactory
 * @model kind="package"
 * @generated
 */
public interface BreweryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "brewery";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://brewery/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "brewery";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BreweryPackage eINSTANCE = brewery.impl.BreweryPackageImpl.init();

	/**
	 * The meta object id for the '{@link brewery.impl.YeastImpl <em>Yeast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.YeastImpl
	 * @see brewery.impl.BreweryPackageImpl#getYeast()
	 * @generated
	 */
	int YEAST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__NAME = 0;

	/**
	 * The feature id for the '<em><b>Flocculation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__FLOCCULATION = 1;

	/**
	 * The feature id for the '<em><b>Attenuation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__ATTENUATION = 2;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__MANUFACTURER = 3;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST__RANGE = 4;

	/**
	 * The number of structural features of the '<em>Yeast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Yeast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.InventoryImpl <em>Inventory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.InventoryImpl
	 * @see brewery.impl.BreweryPackageImpl#getInventory()
	 * @generated
	 */
	int INVENTORY = 1;

	/**
	 * The feature id for the '<em><b>Yeast</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY__YEAST = 0;

	/**
	 * The number of structural features of the '<em>Inventory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Inventory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.TemperatureRangeImpl <em>Temperature Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.TemperatureRangeImpl
	 * @see brewery.impl.BreweryPackageImpl#getTemperatureRange()
	 * @generated
	 */
	int TEMPERATURE_RANGE = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__UNIT = 0;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__LOW = 1;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE__HIGH = 2;

	/**
	 * The number of structural features of the '<em>Temperature Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Temperature Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPERATURE_RANGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.impl.FermenterImpl <em>Fermenter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.impl.FermenterImpl
	 * @see brewery.impl.BreweryPackageImpl#getFermenter()
	 * @generated
	 */
	int FERMENTER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Yeast</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER__YEAST = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER__CONTENT = 2;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER__STARTED = 3;

	/**
	 * The number of structural features of the '<em>Fermenter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Fermenter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FERMENTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see brewery.TemperatureUnit
	 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
	 * @generated
	 */
	int TEMPERATURE_UNIT = 4;


	/**
	 * Returns the meta object for class '{@link brewery.Yeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Yeast</em>'.
	 * @see brewery.Yeast
	 * @generated
	 */
	EClass getYeast();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Yeast#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see brewery.Yeast#getName()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Name();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Yeast#getFlocculation <em>Flocculation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flocculation</em>'.
	 * @see brewery.Yeast#getFlocculation()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Flocculation();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Yeast#getAttenuation <em>Attenuation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attenuation</em>'.
	 * @see brewery.Yeast#getAttenuation()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Attenuation();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Yeast#getManufacturer <em>Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manufacturer</em>'.
	 * @see brewery.Yeast#getManufacturer()
	 * @see #getYeast()
	 * @generated
	 */
	EAttribute getYeast_Manufacturer();

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

	/**
	 * Returns the meta object for class '{@link brewery.Inventory <em>Inventory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inventory</em>'.
	 * @see brewery.Inventory
	 * @generated
	 */
	EClass getInventory();

	/**
	 * Returns the meta object for the containment reference list '{@link brewery.Inventory#getYeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Yeast</em>'.
	 * @see brewery.Inventory#getYeast()
	 * @see #getInventory()
	 * @generated
	 */
	EReference getInventory_Yeast();

	/**
	 * Returns the meta object for class '{@link brewery.TemperatureRange <em>Temperature Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temperature Range</em>'.
	 * @see brewery.TemperatureRange
	 * @generated
	 */
	EClass getTemperatureRange();

	/**
	 * Returns the meta object for the attribute '{@link brewery.TemperatureRange#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see brewery.TemperatureRange#getUnit()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_Unit();

	/**
	 * Returns the meta object for the attribute '{@link brewery.TemperatureRange#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see brewery.TemperatureRange#getLow()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_Low();

	/**
	 * Returns the meta object for the attribute '{@link brewery.TemperatureRange#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see brewery.TemperatureRange#getHigh()
	 * @see #getTemperatureRange()
	 * @generated
	 */
	EAttribute getTemperatureRange_High();

	/**
	 * Returns the meta object for class '{@link brewery.Fermenter <em>Fermenter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fermenter</em>'.
	 * @see brewery.Fermenter
	 * @generated
	 */
	EClass getFermenter();

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
	 * Returns the meta object for the reference '{@link brewery.Fermenter#getYeast <em>Yeast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Yeast</em>'.
	 * @see brewery.Fermenter#getYeast()
	 * @see #getFermenter()
	 * @generated
	 */
	EReference getFermenter_Yeast();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Fermenter#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see brewery.Fermenter#getContent()
	 * @see #getFermenter()
	 * @generated
	 */
	EAttribute getFermenter_Content();

	/**
	 * Returns the meta object for the attribute '{@link brewery.Fermenter#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see brewery.Fermenter#getStarted()
	 * @see #getFermenter()
	 * @generated
	 */
	EAttribute getFermenter_Started();

	/**
	 * Returns the meta object for enum '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Temperature Unit</em>'.
	 * @see brewery.TemperatureUnit
	 * @generated
	 */
	EEnum getTemperatureUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BreweryFactory getBreweryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link brewery.impl.YeastImpl <em>Yeast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.YeastImpl
		 * @see brewery.impl.BreweryPackageImpl#getYeast()
		 * @generated
		 */
		EClass YEAST = eINSTANCE.getYeast();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__NAME = eINSTANCE.getYeast_Name();

		/**
		 * The meta object literal for the '<em><b>Flocculation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__FLOCCULATION = eINSTANCE.getYeast_Flocculation();

		/**
		 * The meta object literal for the '<em><b>Attenuation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__ATTENUATION = eINSTANCE.getYeast_Attenuation();

		/**
		 * The meta object literal for the '<em><b>Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAST__MANUFACTURER = eINSTANCE.getYeast_Manufacturer();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference YEAST__RANGE = eINSTANCE.getYeast_Range();

		/**
		 * The meta object literal for the '{@link brewery.impl.InventoryImpl <em>Inventory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.InventoryImpl
		 * @see brewery.impl.BreweryPackageImpl#getInventory()
		 * @generated
		 */
		EClass INVENTORY = eINSTANCE.getInventory();

		/**
		 * The meta object literal for the '<em><b>Yeast</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVENTORY__YEAST = eINSTANCE.getInventory_Yeast();

		/**
		 * The meta object literal for the '{@link brewery.impl.TemperatureRangeImpl <em>Temperature Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.TemperatureRangeImpl
		 * @see brewery.impl.BreweryPackageImpl#getTemperatureRange()
		 * @generated
		 */
		EClass TEMPERATURE_RANGE = eINSTANCE.getTemperatureRange();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__UNIT = eINSTANCE.getTemperatureRange_Unit();

		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__LOW = eINSTANCE.getTemperatureRange_Low();

		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPERATURE_RANGE__HIGH = eINSTANCE.getTemperatureRange_High();

		/**
		 * The meta object literal for the '{@link brewery.impl.FermenterImpl <em>Fermenter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.impl.FermenterImpl
		 * @see brewery.impl.BreweryPackageImpl#getFermenter()
		 * @generated
		 */
		EClass FERMENTER = eINSTANCE.getFermenter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__NAME = eINSTANCE.getFermenter_Name();

		/**
		 * The meta object literal for the '<em><b>Yeast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FERMENTER__YEAST = eINSTANCE.getFermenter_Yeast();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__CONTENT = eINSTANCE.getFermenter_Content();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FERMENTER__STARTED = eINSTANCE.getFermenter_Started();

		/**
		 * The meta object literal for the '{@link brewery.TemperatureUnit <em>Temperature Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see brewery.TemperatureUnit
		 * @see brewery.impl.BreweryPackageImpl#getTemperatureUnit()
		 * @generated
		 */
		EEnum TEMPERATURE_UNIT = eINSTANCE.getTemperatureUnit();

	}

} //BreweryPackage
