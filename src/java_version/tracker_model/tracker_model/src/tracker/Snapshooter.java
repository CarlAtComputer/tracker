/**
 */
package tracker;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshooter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tracker.Snapshooter#getDatasources <em>Datasources</em>}</li>
 * </ul>
 *
 * @see tracker.TrackerPackage#getSnapshooter()
 * @model
 * @generated
 */
public interface Snapshooter extends EObject {
	/**
	 * Returns the value of the '<em><b>Datasources</b></em>' reference list.
	 * The list contents are of type {@link tracker.Datasource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datasources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datasources</em>' reference list.
	 * @see tracker.TrackerPackage#getSnapshooter_Datasources()
	 * @model
	 * @generated
	 */
	EList<Datasource> getDatasources();

} // Snapshooter
