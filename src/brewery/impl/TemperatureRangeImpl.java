/**
 */
package brewery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import brewery.BreweryPackage;
import brewery.TemperatureRange;
import brewery.TemperatureUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Temperature Range</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link brewery.impl.TemperatureRangeImpl#getUnit <em>Unit</em>}</li>
 * <li>{@link brewery.impl.TemperatureRangeImpl#getLow <em>Low</em>}</li>
 * <li>{@link brewery.impl.TemperatureRangeImpl#getHigh <em>High</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TemperatureRangeImpl extends MinimalEObjectImpl.Container
		implements TemperatureRange {
	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final TemperatureUnit UNIT_EDEFAULT = TemperatureUnit.CELSIUS;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected TemperatureUnit unit = UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLow() <em>Low</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected static final int LOW_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLow() <em>Low</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLow()
	 * @generated
	 * @ordered
	 */
	protected int low = LOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getHigh() <em>High</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected static final int HIGH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHigh() <em>High</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHigh()
	 * @generated
	 * @ordered
	 */
	protected int high = HIGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TemperatureRangeImpl() {
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
		case BreweryPackage.TEMPERATURE_RANGE__UNIT:
			return getUnit();
		case BreweryPackage.TEMPERATURE_RANGE__LOW:
			return getLow();
		case BreweryPackage.TEMPERATURE_RANGE__HIGH:
			return getHigh();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case BreweryPackage.TEMPERATURE_RANGE__UNIT:
			return unit != UNIT_EDEFAULT;
		case BreweryPackage.TEMPERATURE_RANGE__LOW:
			return low != LOW_EDEFAULT;
		case BreweryPackage.TEMPERATURE_RANGE__HIGH:
			return high != HIGH_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BreweryPackage.TEMPERATURE_RANGE__UNIT:
			setUnit((TemperatureUnit) newValue);
			return;
		case BreweryPackage.TEMPERATURE_RANGE__LOW:
			setLow((Integer) newValue);
			return;
		case BreweryPackage.TEMPERATURE_RANGE__HIGH:
			setHigh((Integer) newValue);
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
		return BreweryPackage.Literals.TEMPERATURE_RANGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case BreweryPackage.TEMPERATURE_RANGE__UNIT:
			setUnit(UNIT_EDEFAULT);
			return;
		case BreweryPackage.TEMPERATURE_RANGE__LOW:
			setLow(LOW_EDEFAULT);
			return;
		case BreweryPackage.TEMPERATURE_RANGE__HIGH:
			setHigh(HIGH_EDEFAULT);
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
	public int getHigh() {
		return high;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getLow() {
		return low;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TemperatureUnit getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setHigh(int newHigh) {
		final int oldHigh = high;
		high = newHigh;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.TEMPERATURE_RANGE__HIGH, oldHigh, high));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLow(int newLow) {
		final int oldLow = low;
		low = newLow;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.TEMPERATURE_RANGE__LOW, oldLow, low));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setUnit(TemperatureUnit newUnit) {
		final TemperatureUnit oldUnit = unit;
		unit = newUnit == null ? UNIT_EDEFAULT : newUnit;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					BreweryPackage.TEMPERATURE_RANGE__UNIT, oldUnit, unit));
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
		result.append(" (unit: ");
		result.append(unit);
		result.append(", low: ");
		result.append(low);
		result.append(", high: ");
		result.append(high);
		result.append(')');
		return result.toString();
	}

} // TemperatureRangeImpl
