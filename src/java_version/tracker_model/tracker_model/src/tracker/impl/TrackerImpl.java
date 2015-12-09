/**
 */
package tracker.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import tracker.Chronos;
import tracker.Clerk;
import tracker.Snapshooter;
import tracker.Tracker;
import tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tracker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tracker.impl.TrackerImpl#getChronos <em>Chronos</em>}</li>
 *   <li>{@link tracker.impl.TrackerImpl#getClerk <em>Clerk</em>}</li>
 *   <li>{@link tracker.impl.TrackerImpl#getSnapshooter <em>Snapshooter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrackerImpl extends MinimalEObjectImpl.Container implements Tracker {
	/**
	 * The cached value of the '{@link #getChronos() <em>Chronos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChronos()
	 * @generated
	 * @ordered
	 */
	protected EList<Chronos> chronos;

	/**
	 * The cached value of the '{@link #getClerk() <em>Clerk</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClerk()
	 * @generated
	 * @ordered
	 */
	protected EList<Clerk> clerk;

	/**
	 * The cached value of the '{@link #getSnapshooter() <em>Snapshooter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshooter()
	 * @generated
	 * @ordered
	 */
	protected EList<Snapshooter> snapshooter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.TRACKER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Chronos> getChronos() {
		if (chronos == null) {
			chronos = new EObjectContainmentEList<Chronos>(Chronos.class, this, TrackerPackage.TRACKER__CHRONOS);
		}
		return chronos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Clerk> getClerk() {
		if (clerk == null) {
			clerk = new EObjectContainmentEList<Clerk>(Clerk.class, this, TrackerPackage.TRACKER__CLERK);
		}
		return clerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Snapshooter> getSnapshooter() {
		if (snapshooter == null) {
			snapshooter = new EObjectContainmentEList<Snapshooter>(Snapshooter.class, this, TrackerPackage.TRACKER__SNAPSHOOTER);
		}
		return snapshooter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TrackerPackage.TRACKER__CHRONOS:
				return ((InternalEList<?>)getChronos()).basicRemove(otherEnd, msgs);
			case TrackerPackage.TRACKER__CLERK:
				return ((InternalEList<?>)getClerk()).basicRemove(otherEnd, msgs);
			case TrackerPackage.TRACKER__SNAPSHOOTER:
				return ((InternalEList<?>)getSnapshooter()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.TRACKER__CHRONOS:
				return getChronos();
			case TrackerPackage.TRACKER__CLERK:
				return getClerk();
			case TrackerPackage.TRACKER__SNAPSHOOTER:
				return getSnapshooter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackerPackage.TRACKER__CHRONOS:
				getChronos().clear();
				getChronos().addAll((Collection<? extends Chronos>)newValue);
				return;
			case TrackerPackage.TRACKER__CLERK:
				getClerk().clear();
				getClerk().addAll((Collection<? extends Clerk>)newValue);
				return;
			case TrackerPackage.TRACKER__SNAPSHOOTER:
				getSnapshooter().clear();
				getSnapshooter().addAll((Collection<? extends Snapshooter>)newValue);
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
			case TrackerPackage.TRACKER__CHRONOS:
				getChronos().clear();
				return;
			case TrackerPackage.TRACKER__CLERK:
				getClerk().clear();
				return;
			case TrackerPackage.TRACKER__SNAPSHOOTER:
				getSnapshooter().clear();
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
			case TrackerPackage.TRACKER__CHRONOS:
				return chronos != null && !chronos.isEmpty();
			case TrackerPackage.TRACKER__CLERK:
				return clerk != null && !clerk.isEmpty();
			case TrackerPackage.TRACKER__SNAPSHOOTER:
				return snapshooter != null && !snapshooter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TrackerImpl
