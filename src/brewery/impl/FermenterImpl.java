/**
 */
package brewery.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import brewery.BreweryPackage;
import brewery.Fermenter;
import brewery.Yeast;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Fermenter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link brewery.impl.FermenterImpl#getName <em>Name</em>}</li>
 *   <li>{@link brewery.impl.FermenterImpl#getYeast <em>Yeast</em>}</li>
 *   <li>{@link brewery.impl.FermenterImpl#getContent <em>Content</em>}</li>
 *   <li>{@link brewery.impl.FermenterImpl#getStarted <em>Started</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FermenterImpl extends MinimalEObjectImpl.Container implements
		Fermenter {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getYeast() <em>Yeast</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getYeast()
	 * @generated
	 * @ordered
	 */
	protected Yeast yeast;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected static final Date STARTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected Date started = STARTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FermenterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Yeast basicGetYeast() {
		return yeast;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BreweryPackage.FERMENTER__NAME:
				return getName();
			case BreweryPackage.FERMENTER__YEAST:
				if (resolve) return getYeast();
				return basicGetYeast();
			case BreweryPackage.FERMENTER__CONTENT:
				return getContent();
			case BreweryPackage.FERMENTER__STARTED:
				return getStarted();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BreweryPackage.FERMENTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BreweryPackage.FERMENTER__YEAST:
				return yeast != null;
			case BreweryPackage.FERMENTER__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case BreweryPackage.FERMENTER__STARTED:
				return STARTED_EDEFAULT == null ? started != null : !STARTED_EDEFAULT.equals(started);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BreweryPackage.FERMENTER__NAME:
				setName((String)newValue);
				return;
			case BreweryPackage.FERMENTER__YEAST:
				setYeast((Yeast)newValue);
				return;
			case BreweryPackage.FERMENTER__CONTENT:
				setContent((String)newValue);
				return;
			case BreweryPackage.FERMENTER__STARTED:
				setStarted((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BreweryPackage.Literals.FERMENTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BreweryPackage.FERMENTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BreweryPackage.FERMENTER__YEAST:
				setYeast((Yeast)null);
				return;
			case BreweryPackage.FERMENTER__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case BreweryPackage.FERMENTER__STARTED:
				setStarted(STARTED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getStarted() {
		return started;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Yeast getYeast() {
		if (yeast != null && yeast.eIsProxy()) {
			InternalEObject oldYeast = (InternalEObject)yeast;
			yeast = (Yeast)eResolveProxy(oldYeast);
			if (yeast != oldYeast) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BreweryPackage.FERMENTER__YEAST, oldYeast, yeast));
			}
		}
		return yeast;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BreweryPackage.FERMENTER__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BreweryPackage.FERMENTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStarted(Date newStarted) {
		Date oldStarted = started;
		started = newStarted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BreweryPackage.FERMENTER__STARTED, oldStarted, started));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYeast(Yeast newYeast) {
		Yeast oldYeast = yeast;
		yeast = newYeast;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BreweryPackage.FERMENTER__YEAST, oldYeast, yeast));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", content: ");
		result.append(content);
		result.append(", started: ");
		result.append(started);
		result.append(')');
		return result.toString();
	}

} // FermenterImpl
