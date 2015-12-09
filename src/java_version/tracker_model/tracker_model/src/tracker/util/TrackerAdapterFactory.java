/**
 */
package tracker.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tracker.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tracker.TrackerPackage
 * @generated
 */
public class TrackerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TrackerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TrackerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrackerSwitch<Adapter> modelSwitch =
		new TrackerSwitch<Adapter>() {
			@Override
			public Adapter caseChronos(Chronos object) {
				return createChronosAdapter();
			}
			@Override
			public Adapter caseTracker(Tracker object) {
				return createTrackerAdapter();
			}
			@Override
			public Adapter caseSnapshooter(Snapshooter object) {
				return createSnapshooterAdapter();
			}
			@Override
			public Adapter caseClerk(Clerk object) {
				return createClerkAdapter();
			}
			@Override
			public Adapter caseDatasource(Datasource object) {
				return createDatasourceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link tracker.Snapshooter <em>Snapshooter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tracker.Snapshooter
	 * @generated
	 */
	public Adapter createSnapshooterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tracker.Chronos <em>Chronos</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tracker.Chronos
	 * @generated
	 */
	public Adapter createChronosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tracker.Clerk <em>Clerk</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tracker.Clerk
	 * @generated
	 */
	public Adapter createClerkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tracker.Tracker <em>Tracker</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tracker.Tracker
	 * @generated
	 */
	public Adapter createTrackerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tracker.Datasource <em>Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tracker.Datasource
	 * @generated
	 */
	public Adapter createDatasourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TrackerAdapterFactory
