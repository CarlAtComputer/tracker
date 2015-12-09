/**
 */
package tracker.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tracker.Chronos;
import tracker.Clerk;
import tracker.Snapshooter;
import tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chronos</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tracker.impl.ChronosImpl#getSnapshooter <em>Snapshooter</em>}</li>
 *   <li>{@link tracker.impl.ChronosImpl#getClerk <em>Clerk</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChronosImpl extends MinimalEObjectImpl.Container implements Chronos {
	/**
	 * The cached value of the '{@link #getSnapshooter() <em>Snapshooter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshooter()
	 * @generated
	 * @ordered
	 */
	protected Snapshooter snapshooter;

	/**
	 * The cached value of the '{@link #getClerk() <em>Clerk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClerk()
	 * @generated
	 * @ordered
	 */
	protected Clerk clerk;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChronosImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.CHRONOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshooter getSnapshooter() {
		if (snapshooter != null && snapshooter.eIsProxy()) {
			InternalEObject oldSnapshooter = (InternalEObject)snapshooter;
			snapshooter = (Snapshooter)eResolveProxy(oldSnapshooter);
			if (snapshooter != oldSnapshooter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.CHRONOS__SNAPSHOOTER, oldSnapshooter, snapshooter));
			}
		}
		return snapshooter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshooter basicGetSnapshooter() {
		return snapshooter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshooter(Snapshooter newSnapshooter) {
		Snapshooter oldSnapshooter = snapshooter;
		snapshooter = newSnapshooter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.CHRONOS__SNAPSHOOTER, oldSnapshooter, snapshooter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clerk getClerk() {
		if (clerk != null && clerk.eIsProxy()) {
			InternalEObject oldClerk = (InternalEObject)clerk;
			clerk = (Clerk)eResolveProxy(oldClerk);
			if (clerk != oldClerk) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrackerPackage.CHRONOS__CLERK, oldClerk, clerk));
			}
		}
		return clerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clerk basicGetClerk() {
		return clerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClerk(Clerk newClerk) {
		Clerk oldClerk = clerk;
		clerk = newClerk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackerPackage.CHRONOS__CLERK, oldClerk, clerk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.CHRONOS__SNAPSHOOTER:
				if (resolve) return getSnapshooter();
				return basicGetSnapshooter();
			case TrackerPackage.CHRONOS__CLERK:
				if (resolve) return getClerk();
				return basicGetClerk();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.CHRONOS__SNAPSHOOTER:
				setSnapshooter((Snapshooter)newValue);
				return;
			case TrackerPackage.CHRONOS__CLERK:
				setClerk((Clerk)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackerPackage.CHRONOS__SNAPSHOOTER:
				setSnapshooter((Snapshooter)null);
				return;
			case TrackerPackage.CHRONOS__CLERK:
				setClerk((Clerk)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackerPackage.CHRONOS__SNAPSHOOTER:
				return snapshooter != null;
			case TrackerPackage.CHRONOS__CLERK:
				return clerk != null;
		}
		return super.eIsSet(featureID);
	}

} //ChronosImpl
