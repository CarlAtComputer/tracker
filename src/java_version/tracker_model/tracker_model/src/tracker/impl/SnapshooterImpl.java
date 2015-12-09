/**
 */
package tracker.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import tracker.Datasource;
import tracker.Snapshooter;
import tracker.TrackerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshooter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tracker.impl.SnapshooterImpl#getDatasources <em>Datasources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SnapshooterImpl extends MinimalEObjectImpl.Container implements Snapshooter {
	/**
	 * The cached value of the '{@link #getDatasources() <em>Datasources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatasources()
	 * @generated
	 * @ordered
	 */
	protected EList<Datasource> datasources;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshooterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackerPackage.Literals.SNAPSHOOTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Datasource> getDatasources() {
		if (datasources == null) {
			datasources = new EObjectResolvingEList<Datasource>(Datasource.class, this, TrackerPackage.SNAPSHOOTER__DATASOURCES);
		}
		return datasources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackerPackage.SNAPSHOOTER__DATASOURCES:
				return getDatasources();
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
			case TrackerPackage.SNAPSHOOTER__DATASOURCES:
				getDatasources().clear();
				getDatasources().addAll((Collection<? extends Datasource>)newValue);
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
			case TrackerPackage.SNAPSHOOTER__DATASOURCES:
				getDatasources().clear();
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
			case TrackerPackage.SNAPSHOOTER__DATASOURCES:
				return datasources != null && !datasources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SnapshooterImpl
