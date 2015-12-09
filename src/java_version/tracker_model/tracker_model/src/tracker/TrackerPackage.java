/**
 */
package tracker;

import org.eclipse.emf.ecore.EClass;
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
 * @see tracker.TrackerFactory
 * @model kind="package"
 * @generated
 */
public interface TrackerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracker";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/tracker";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackerPackage eINSTANCE = tracker.impl.TrackerPackageImpl.init();

	/**
	 * The meta object id for the '{@link tracker.impl.SnapshooterImpl <em>Snapshooter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracker.impl.SnapshooterImpl
	 * @see tracker.impl.TrackerPackageImpl#getSnapshooter()
	 * @generated
	 */
	int SNAPSHOOTER = 2;

	/**
	 * The meta object id for the '{@link tracker.impl.ChronosImpl <em>Chronos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracker.impl.ChronosImpl
	 * @see tracker.impl.TrackerPackageImpl#getChronos()
	 * @generated
	 */
	int CHRONOS = 0;

	/**
	 * The feature id for the '<em><b>Snapshooter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHRONOS__SNAPSHOOTER = 0;

	/**
	 * The feature id for the '<em><b>Clerk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHRONOS__CLERK = 1;

	/**
	 * The number of structural features of the '<em>Chronos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHRONOS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Chronos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHRONOS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tracker.impl.ClerkImpl <em>Clerk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracker.impl.ClerkImpl
	 * @see tracker.impl.TrackerPackageImpl#getClerk()
	 * @generated
	 */
	int CLERK = 3;

	/**
	 * The meta object id for the '{@link tracker.impl.TrackerImpl <em>Tracker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracker.impl.TrackerImpl
	 * @see tracker.impl.TrackerPackageImpl#getTracker()
	 * @generated
	 */
	int TRACKER = 1;

	/**
	 * The feature id for the '<em><b>Chronos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKER__CHRONOS = 0;

	/**
	 * The feature id for the '<em><b>Clerk</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKER__CLERK = 1;

	/**
	 * The feature id for the '<em><b>Snapshooter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKER__SNAPSHOOTER = 2;

	/**
	 * The number of structural features of the '<em>Tracker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Tracker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKER_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Datasources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOOTER__DATASOURCES = 0;

	/**
	 * The number of structural features of the '<em>Snapshooter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOOTER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Snapshooter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOOTER_OPERATION_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Clerk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLERK_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Clerk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLERK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tracker.impl.DatasourceImpl <em>Datasource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracker.impl.DatasourceImpl
	 * @see tracker.impl.TrackerPackageImpl#getDatasource()
	 * @generated
	 */
	int DATASOURCE = 4;

	/**
	 * The number of structural features of the '<em>Datasource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Datasource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATASOURCE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tracker.Snapshooter <em>Snapshooter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshooter</em>'.
	 * @see tracker.Snapshooter
	 * @generated
	 */
	EClass getSnapshooter();

	/**
	 * Returns the meta object for the reference list '{@link tracker.Snapshooter#getDatasources <em>Datasources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Datasources</em>'.
	 * @see tracker.Snapshooter#getDatasources()
	 * @see #getSnapshooter()
	 * @generated
	 */
	EReference getSnapshooter_Datasources();

	/**
	 * Returns the meta object for class '{@link tracker.Chronos <em>Chronos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chronos</em>'.
	 * @see tracker.Chronos
	 * @generated
	 */
	EClass getChronos();

	/**
	 * Returns the meta object for the reference '{@link tracker.Chronos#getSnapshooter <em>Snapshooter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Snapshooter</em>'.
	 * @see tracker.Chronos#getSnapshooter()
	 * @see #getChronos()
	 * @generated
	 */
	EReference getChronos_Snapshooter();

	/**
	 * Returns the meta object for the reference '{@link tracker.Chronos#getClerk <em>Clerk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clerk</em>'.
	 * @see tracker.Chronos#getClerk()
	 * @see #getChronos()
	 * @generated
	 */
	EReference getChronos_Clerk();

	/**
	 * Returns the meta object for class '{@link tracker.Clerk <em>Clerk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clerk</em>'.
	 * @see tracker.Clerk
	 * @generated
	 */
	EClass getClerk();

	/**
	 * Returns the meta object for class '{@link tracker.Tracker <em>Tracker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tracker</em>'.
	 * @see tracker.Tracker
	 * @generated
	 */
	EClass getTracker();

	/**
	 * Returns the meta object for the containment reference list '{@link tracker.Tracker#getChronos <em>Chronos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chronos</em>'.
	 * @see tracker.Tracker#getChronos()
	 * @see #getTracker()
	 * @generated
	 */
	EReference getTracker_Chronos();

	/**
	 * Returns the meta object for the containment reference list '{@link tracker.Tracker#getClerk <em>Clerk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clerk</em>'.
	 * @see tracker.Tracker#getClerk()
	 * @see #getTracker()
	 * @generated
	 */
	EReference getTracker_Clerk();

	/**
	 * Returns the meta object for the containment reference list '{@link tracker.Tracker#getSnapshooter <em>Snapshooter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snapshooter</em>'.
	 * @see tracker.Tracker#getSnapshooter()
	 * @see #getTracker()
	 * @generated
	 */
	EReference getTracker_Snapshooter();

	/**
	 * Returns the meta object for class '{@link tracker.Datasource <em>Datasource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Datasource</em>'.
	 * @see tracker.Datasource
	 * @generated
	 */
	EClass getDatasource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TrackerFactory getTrackerFactory();

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
		 * The meta object literal for the '{@link tracker.impl.SnapshooterImpl <em>Snapshooter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracker.impl.SnapshooterImpl
		 * @see tracker.impl.TrackerPackageImpl#getSnapshooter()
		 * @generated
		 */
		EClass SNAPSHOOTER = eINSTANCE.getSnapshooter();

		/**
		 * The meta object literal for the '<em><b>Datasources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOOTER__DATASOURCES = eINSTANCE.getSnapshooter_Datasources();

		/**
		 * The meta object literal for the '{@link tracker.impl.ChronosImpl <em>Chronos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracker.impl.ChronosImpl
		 * @see tracker.impl.TrackerPackageImpl#getChronos()
		 * @generated
		 */
		EClass CHRONOS = eINSTANCE.getChronos();

		/**
		 * The meta object literal for the '<em><b>Snapshooter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHRONOS__SNAPSHOOTER = eINSTANCE.getChronos_Snapshooter();

		/**
		 * The meta object literal for the '<em><b>Clerk</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHRONOS__CLERK = eINSTANCE.getChronos_Clerk();

		/**
		 * The meta object literal for the '{@link tracker.impl.ClerkImpl <em>Clerk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracker.impl.ClerkImpl
		 * @see tracker.impl.TrackerPackageImpl#getClerk()
		 * @generated
		 */
		EClass CLERK = eINSTANCE.getClerk();

		/**
		 * The meta object literal for the '{@link tracker.impl.TrackerImpl <em>Tracker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracker.impl.TrackerImpl
		 * @see tracker.impl.TrackerPackageImpl#getTracker()
		 * @generated
		 */
		EClass TRACKER = eINSTANCE.getTracker();

		/**
		 * The meta object literal for the '<em><b>Chronos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACKER__CHRONOS = eINSTANCE.getTracker_Chronos();

		/**
		 * The meta object literal for the '<em><b>Clerk</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACKER__CLERK = eINSTANCE.getTracker_Clerk();

		/**
		 * The meta object literal for the '<em><b>Snapshooter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACKER__SNAPSHOOTER = eINSTANCE.getTracker_Snapshooter();

		/**
		 * The meta object literal for the '{@link tracker.impl.DatasourceImpl <em>Datasource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracker.impl.DatasourceImpl
		 * @see tracker.impl.TrackerPackageImpl#getDatasource()
		 * @generated
		 */
		EClass DATASOURCE = eINSTANCE.getDatasource();

	}

} //TrackerPackage
