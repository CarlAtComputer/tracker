/**
 */
package tracker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chronos</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tracker.Chronos#getSnapshooter <em>Snapshooter</em>}</li>
 *   <li>{@link tracker.Chronos#getClerk <em>Clerk</em>}</li>
 * </ul>
 *
 * @see tracker.TrackerPackage#getChronos()
 * @model
 * @generated
 */
public interface Chronos extends EObject {
	/**
	 * Returns the value of the '<em><b>Snapshooter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshooter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshooter</em>' reference.
	 * @see #setSnapshooter(Snapshooter)
	 * @see tracker.TrackerPackage#getChronos_Snapshooter()
	 * @model required="true"
	 * @generated
	 */
	Snapshooter getSnapshooter();

	/**
	 * Sets the value of the '{@link tracker.Chronos#getSnapshooter <em>Snapshooter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshooter</em>' reference.
	 * @see #getSnapshooter()
	 * @generated
	 */
	void setSnapshooter(Snapshooter value);

	/**
	 * Returns the value of the '<em><b>Clerk</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clerk</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clerk</em>' reference.
	 * @see #setClerk(Clerk)
	 * @see tracker.TrackerPackage#getChronos_Clerk()
	 * @model required="true"
	 * @generated
	 */
	Clerk getClerk();

	/**
	 * Sets the value of the '{@link tracker.Chronos#getClerk <em>Clerk</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clerk</em>' reference.
	 * @see #getClerk()
	 * @generated
	 */
	void setClerk(Clerk value);

} // Chronos
