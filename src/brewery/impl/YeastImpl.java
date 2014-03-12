/**
 */
package brewery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import brewery.BreweryPackage;
import brewery.TemperatureRange;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Yeast</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link brewery.impl.YeastImpl#getName <em>Name</em>}</li>
 * <li>{@link brewery.impl.YeastImpl#getFlocculation <em>Flocculation</em>}</li>
 * <li>{@link brewery.impl.YeastImpl#getAttenuation <em>Attenuation</em>}</li>
 * <li>{@link brewery.impl.YeastImpl#getManufacturer <em>Manufacturer</em>}</li>
 * <li>{@link brewery.impl.YeastImpl#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class YeastImpl extends MinimalEObjectImpl.Container implements Yeast {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFlocculation()
	 * <em>Flocculation</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFlocculation()
	 * @generated
	 * @ordered
	 */
	protected static final String FLOCCULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFlocculation() <em>Flocculation</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFlocculation()
	 * @generated
	 * @ordered
	 */
	protected String flocculation = FLOCCULATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttenuation() <em>Attenuation</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttenuation()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTENUATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttenuation() <em>Attenuation</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttenuation()
	 * @generated
	 * @ordered
	 */
	protected String attenuation = ATTENUATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getManufacturer()
	 * <em>Manufacturer</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected static final String MANUFACTURER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManufacturer() <em>Manufacturer</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected String manufacturer = MANUFACTURER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected TemperatureRange range;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected YeastImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetRange(final TemperatureRange newRange,
			NotificationChain msgs) {
		final TemperatureRange oldRange = range;
		range = newRange;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BreweryPackage.YEAST__RANGE, oldRange,
					newRange);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve,
			final boolean coreType) {
		switch (featureID) {
		case BreweryPackage.YEAST__NAME:
			return getName();
		case BreweryPackage.YEAST__FLOCCULATION:
			return getFlocculation();
		case BreweryPackage.YEAST__ATTENUATION:
			return getAttenuation();
		case BreweryPackage.YEAST__MANUFACTURER:
			return getManufacturer();
		case BreweryPackage.YEAST__RANGE:
			return getRange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(final InternalEObject otherEnd,
			final int featureID, final NotificationChain msgs) {
		switch (featureID) {
		case BreweryPackage.YEAST__RANGE:
			return basicSetRange(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
		case BreweryPackage.YEAST__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case BreweryPackage.YEAST__FLOCCULATION:
			return FLOCCULATION_EDEFAULT == null ? flocculation != null
					: !FLOCCULATION_EDEFAULT.equals(flocculation);
		case BreweryPackage.YEAST__ATTENUATION:
			return ATTENUATION_EDEFAULT == null ? attenuation != null
					: !ATTENUATION_EDEFAULT.equals(attenuation);
		case BreweryPackage.YEAST__MANUFACTURER:
			return MANUFACTURER_EDEFAULT == null ? manufacturer != null
					: !MANUFACTURER_EDEFAULT.equals(manufacturer);
		case BreweryPackage.YEAST__RANGE:
			return range != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
		case BreweryPackage.YEAST__NAME:
			setName((String) newValue);
			return;
		case BreweryPackage.YEAST__FLOCCULATION:
			setFlocculation((String) newValue);
			return;
		case BreweryPackage.YEAST__ATTENUATION:
			setAttenuation((String) newValue);
			return;
		case BreweryPackage.YEAST__MANUFACTURER:
			setManufacturer((String) newValue);
			return;
		case BreweryPackage.YEAST__RANGE:
			setRange((TemperatureRange) newValue);
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
		return BreweryPackage.Literals.YEAST;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(final int featureID) {
		switch (featureID) {
		case BreweryPackage.YEAST__NAME:
			setName(NAME_EDEFAULT);
			return;
		case BreweryPackage.YEAST__FLOCCULATION:
			setFlocculation(FLOCCULATION_EDEFAULT);
			return;
		case BreweryPackage.YEAST__ATTENUATION:
			setAttenuation(ATTENUATION_EDEFAULT);
			return;
		case BreweryPackage.YEAST__MANUFACTURER:
			setManufacturer(MANUFACTURER_EDEFAULT);
			return;
		case BreweryPackage.YEAST__RANGE:
			setRange((TemperatureRange) null);
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
	public String getAttenuation() {
		return attenuation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getFlocculation() {
		return flocculation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TemperatureRange getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAttenuation(final String newAttenuation) {
		final String oldAttenuation = attenuation;
		attenuation = newAttenuation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.YEAST__ATTENUATION, oldAttenuation,
					attenuation));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFlocculation(final String newFlocculation) {
		final String oldFlocculation = flocculation;
		flocculation = newFlocculation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.YEAST__FLOCCULATION, oldFlocculation,
					flocculation));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setManufacturer(final String newManufacturer) {
		final String oldManufacturer = manufacturer;
		manufacturer = newManufacturer;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.YEAST__MANUFACTURER, oldManufacturer,
					manufacturer));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(final String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.YEAST__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setRange(final TemperatureRange newRange) {
		if (newRange != range) {
			NotificationChain msgs = null;
			if (range != null) {
				msgs = ((InternalEObject) range).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BreweryPackage.YEAST__RANGE,
						null, msgs);
			}
			if (newRange != null) {
				msgs = ((InternalEObject) newRange).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BreweryPackage.YEAST__RANGE,
						null, msgs);
			}
			msgs = basicSetRange(newRange, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.YEAST__RANGE, newRange, newRange));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", flocculation: ");
		result.append(flocculation);
		result.append(", attenuation: ");
		result.append(attenuation);
		result.append(", manufacturer: ");
		result.append(manufacturer);
		result.append(')');
		return result.toString();
	}

} // YeastImpl
