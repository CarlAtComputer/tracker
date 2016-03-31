/**
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.Color#getColorName <em>Color Name</em>}</li>
 * </ul>
 *
 * @see model.ModelPackage#getColor()
 * @model
 * @generated
 */
public interface Color extends EObject {
	/**
	 * Returns the value of the '<em><b>Color Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Name</em>' attribute.
	 * @see #setColorName(String)
	 * @see model.ModelPackage#getColor_ColorName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getColorName();

	/**
	 * Sets the value of the '{@link model.Color#getColorName <em>Color Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Name</em>' attribute.
	 * @see #getColorName()
	 * @generated
	 */
	void setColorName(String value);

} // Color
