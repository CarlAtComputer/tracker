/**
 */
package tracker;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tracker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tracker.Tracker#getChronos <em>Chronos</em>}</li>
 *   <li>{@link tracker.Tracker#getClerk <em>Clerk</em>}</li>
 *   <li>{@link tracker.Tracker#getSnapshooter <em>Snapshooter</em>}</li>
 * </ul>
 *
 * @see tracker.TrackerPackage#getTracker()
 * @model
 * @generated
 */
public interface Tracker extends EObject {
	/**
	 * Returns the value of the '<em><b>Chronos</b></em>' containment reference list.
	 * The list contents are of type {@link tracker.Chronos}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chronos</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chronos</em>' containment reference list.
	 * @see tracker.TrackerPackage#getTracker_Chronos()
	 * @model containment="true"
	 * @generated
	 */
	EList<Chronos> getChronos();

	/**
	 * Returns the value of the '<em><b>Clerk</b></em>' containment reference list.
	 * The list contents are of type {@link tracker.Clerk}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clerk</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clerk</em>' containment reference list.
	 * @see tracker.TrackerPackage#getTracker_Clerk()
	 * @model containment="true"
	 * @generated
	 */
	EList<Clerk> getClerk();

	/**
	 * Returns the value of the '<em><b>Snapshooter</b></em>' containment reference list.
	 * The list contents are of type {@link tracker.Snapshooter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshooter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshooter</em>' containment reference list.
	 * @see tracker.TrackerPackage#getTracker_Snapshooter()
	 * @model containment="true"
	 * @generated
	 */
	EList<Snapshooter> getSnapshooter();

} // Tracker
