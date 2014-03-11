/**
 */
package brewery.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import brewery.BreweryFactory;
import brewery.BreweryPackage;
import brewery.Fermenter;
import brewery.Inventory;
import brewery.MashSchedule;
import brewery.MashStep;
import brewery.TemperatureRange;
import brewery.TemperatureUnit;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BreweryPackageImpl extends EPackageImpl implements BreweryPackage {
	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link BreweryPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BreweryPackage init() {
		if (isInited) return (BreweryPackage)EPackage.Registry.INSTANCE.getEPackage(BreweryPackage.eNS_URI);

		// Obtain or create and register package
		BreweryPackageImpl theBreweryPackage = (BreweryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BreweryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BreweryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBreweryPackage.createPackageContents();

		// Initialize created meta-data
		theBreweryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBreweryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BreweryPackage.eNS_URI, theBreweryPackage);
		return theBreweryPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yeastEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inventoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temperatureRangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fermenterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mashStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mashScheduleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temperatureUnitEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see brewery.BreweryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BreweryPackageImpl() {
		super(eNS_URI, BreweryFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		yeastEClass = createEClass(YEAST);
		createEAttribute(yeastEClass, YEAST__NAME);
		createEAttribute(yeastEClass, YEAST__FLOCCULATION);
		createEAttribute(yeastEClass, YEAST__ATTENUATION);
		createEAttribute(yeastEClass, YEAST__MANUFACTURER);
		createEReference(yeastEClass, YEAST__RANGE);

		inventoryEClass = createEClass(INVENTORY);
		createEReference(inventoryEClass, INVENTORY__YEAST);

		temperatureRangeEClass = createEClass(TEMPERATURE_RANGE);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__UNIT);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__LOW);
		createEAttribute(temperatureRangeEClass, TEMPERATURE_RANGE__HIGH);

		fermenterEClass = createEClass(FERMENTER);
		createEAttribute(fermenterEClass, FERMENTER__NAME);
		createEReference(fermenterEClass, FERMENTER__YEAST);
		createEAttribute(fermenterEClass, FERMENTER__CONTENT);
		createEAttribute(fermenterEClass, FERMENTER__STARTED);

		mashStepEClass = createEClass(MASH_STEP);
		createEAttribute(mashStepEClass, MASH_STEP__TEMPERATURE);
		createEAttribute(mashStepEClass, MASH_STEP__PAUSE);
		createEAttribute(mashStepEClass, MASH_STEP__DESCRIPTION);

		mashScheduleEClass = createEClass(MASH_SCHEDULE);
		createEReference(mashScheduleEClass, MASH_SCHEDULE__STEPS);

		// Create enums
		temperatureUnitEEnum = createEEnum(TEMPERATURE_UNIT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BreweryFactory getBreweryFactory() {
		return (BreweryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFermenter() {
		return fermenterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Content() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Name() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFermenter_Started() {
		return (EAttribute)fermenterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMashStep() {
		return mashStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMashStep_Temperature() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMashStep_Pause() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMashStep_Description() {
		return (EAttribute)mashStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMashSchedule() {
		return mashScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMashSchedule_Steps() {
		return (EReference)mashScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFermenter_Yeast() {
		return (EReference)fermenterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInventory() {
		return inventoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInventory_Yeast() {
		return (EReference)inventoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemperatureRange() {
		return temperatureRangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_High() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_Low() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTemperatureRange_Unit() {
		return (EAttribute)temperatureRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTemperatureUnit() {
		return temperatureUnitEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getYeast() {
		return yeastEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Attenuation() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Flocculation() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Manufacturer() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getYeast_Name() {
		return (EAttribute)yeastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getYeast_Range() {
		return (EReference)yeastEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(yeastEClass, Yeast.class, "Yeast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getYeast_Name(), ecorePackage.getEString(), "name", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Flocculation(), ecorePackage.getEString(), "flocculation", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Attenuation(), ecorePackage.getEString(), "attenuation", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getYeast_Manufacturer(), ecorePackage.getEString(), "manufacturer", null, 0, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getYeast_Range(), this.getTemperatureRange(), null, "range", null, 1, 1, Yeast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inventoryEClass, Inventory.class, "Inventory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInventory_Yeast(), this.getYeast(), null, "yeast", null, 0, -1, Inventory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(temperatureRangeEClass, TemperatureRange.class, "TemperatureRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemperatureRange_Unit(), this.getTemperatureUnit(), "unit", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemperatureRange_Low(), ecorePackage.getEInt(), "low", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemperatureRange_High(), ecorePackage.getEInt(), "high", null, 0, 1, TemperatureRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fermenterEClass, Fermenter.class, "Fermenter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFermenter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFermenter_Yeast(), this.getYeast(), null, "yeast", null, 1, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFermenter_Content(), ecorePackage.getEString(), "content", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFermenter_Started(), ecorePackage.getEDate(), "started", null, 0, 1, Fermenter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mashStepEClass, MashStep.class, "MashStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMashStep_Temperature(), ecorePackage.getEInt(), "temperature", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_Pause(), ecorePackage.getEInt(), "pause", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMashStep_Description(), ecorePackage.getEString(), "description", null, 0, 1, MashStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mashScheduleEClass, MashSchedule.class, "MashSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMashSchedule_Steps(), this.getMashStep(), null, "steps", null, 0, -1, MashSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(temperatureUnitEEnum, TemperatureUnit.class, "TemperatureUnit");
		addEEnumLiteral(temperatureUnitEEnum, TemperatureUnit.CELSIUS);
		addEEnumLiteral(temperatureUnitEEnum, TemperatureUnit.FARENHEIT);

		// Create resource
		createResource(eNS_URI);
	}

} // BreweryPackageImpl
