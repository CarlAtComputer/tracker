package model.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import model.diagram.edit.parts.DiagramEditPart;
import model.diagram.part.ModelDiagramEditorPlugin;

/**
 * @generated
 */
public class ModelElementTypes {

	/**
	* @generated
	*/
	private ModelElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map/*[org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement]*/ elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			ModelDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/ KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Diagram_1000 = getElementType("graphical.diagram.Diagram_1000"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap/*[org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement]*/();
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet/*[org.eclipse.gmf.runtime.emf.type.core.IElementType]*/();
			KNOWN_ELEMENT_TYPES.add(Diagram_1000);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case DiagramEditPart.VISUAL_ID:
			return Diagram_1000;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/

		public boolean isKnownElementType(IElementType elementType) {
			return model.diagram.providers.ModelElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/

		public IElementType getElementTypeForVisualId(int visualID) {
			return model.diagram.providers.ModelElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return model.diagram.providers.ModelElementTypes.getElement(elementTypeAdapter);
		}
	};

}
