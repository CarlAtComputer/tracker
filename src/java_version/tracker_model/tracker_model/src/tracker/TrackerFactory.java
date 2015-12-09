/**
 */
package tracker;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tracker.TrackerPackage
 * @generated
 */
public interface TrackerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackerFactory eINSTANCE = tracker.impl.TrackerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Snapshooter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshooter</em>'.
	 * @generated
	 */
	Snapshooter createSnapshooter();

	/**
	 * Returns a new object of class '<em>Chronos</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chronos</em>'.
	 * @generated
	 */
	Chronos createChronos();

	/**
	 * Returns a new object of class '<em>Clerk</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clerk</em>'.
	 * @generated
	 */
	Clerk createClerk();

	/**
	 * Returns a new object of class '<em>Tracker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tracker</em>'.
	 * @generated
	 */
	Tracker createTracker();

	/**
	 * Returns a new object of class '<em>Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Datasource</em>'.
	 * @generated
	 */
	Datasource createDatasource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TrackerPackage getTrackerPackage();

} //TrackerFactory
