/**
 */
package tracker.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tracker.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrackerFactoryImpl extends EFactoryImpl implements TrackerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TrackerFactory init() {
		try {
			TrackerFactory theTrackerFactory = (TrackerFactory)EPackage.Registry.INSTANCE.getEFactory(TrackerPackage.eNS_URI);
			if (theTrackerFactory != null) {
				return theTrackerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TrackerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TrackerPackage.CHRONOS: return createChronos();
			case TrackerPackage.TRACKER: return createTracker();
			case TrackerPackage.SNAPSHOOTER: return createSnapshooter();
			case TrackerPackage.CLERK: return createClerk();
			case TrackerPackage.DATASOURCE: return createDatasource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshooter createSnapshooter() {
		SnapshooterImpl snapshooter = new SnapshooterImpl();
		return snapshooter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chronos createChronos() {
		ChronosImpl chronos = new ChronosImpl();
		return chronos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clerk createClerk() {
		ClerkImpl clerk = new ClerkImpl();
		return clerk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tracker createTracker() {
		TrackerImpl tracker = new TrackerImpl();
		return tracker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Datasource createDatasource() {
		DatasourceImpl datasource = new DatasourceImpl();
		return datasource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackerPackage getTrackerPackage() {
		return (TrackerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TrackerPackage getPackage() {
		return TrackerPackage.eINSTANCE;
	}

} //TrackerFactoryImpl
