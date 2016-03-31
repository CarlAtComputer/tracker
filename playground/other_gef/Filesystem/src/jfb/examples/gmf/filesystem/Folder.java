/**
 */
package jfb.examples.gmf.filesystem;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jfb.examples.gmf.filesystem.Folder#getName <em>Name</em>}</li>
 *   <li>{@link jfb.examples.gmf.filesystem.Folder#getFolders <em>Folders</em>}</li>
 *   <li>{@link jfb.examples.gmf.filesystem.Folder#getFiles <em>Files</em>}</li>
 * </ul>
 *
 * @see jfb.examples.gmf.filesystem.FilesystemPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jfb.examples.gmf.filesystem.FilesystemPackage#getFolder_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jfb.examples.gmf.filesystem.Folder#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Folders</b></em>' reference list.
	 * The list contents are of type {@link jfb.examples.gmf.filesystem.Folder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Folders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Folders</em>' reference list.
	 * @see jfb.examples.gmf.filesystem.FilesystemPackage#getFolder_Folders()
	 * @model
	 * @generated
	 */
	EList<Folder> getFolders();

	/**
	 * Returns the value of the '<em><b>Files</b></em>' reference list.
	 * The list contents are of type {@link jfb.examples.gmf.filesystem.File}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' reference list.
	 * @see jfb.examples.gmf.filesystem.FilesystemPackage#getFolder_Files()
	 * @model
	 * @generated
	 */
	EList<File> getFiles();

} // Folder
