package tracker.diagram.providers;

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

import tracker.TrackerPackage;
import tracker.diagram.edit.parts.ChronosClerkEditPart;
import tracker.diagram.edit.parts.ChronosEditPart;
import tracker.diagram.edit.parts.ChronosSnapshooterEditPart;
import tracker.diagram.edit.parts.ClerkEditPart;
import tracker.diagram.edit.parts.SnapshooterDatasourcesEditPart;
import tracker.diagram.edit.parts.SnapshooterEditPart;
import tracker.diagram.edit.parts.TrackerEditPart;
import tracker.diagram.part.TrackerDiagramEditorPlugin;

/**
 * @generated
 */
public class TrackerElementTypes {

	/**
	* @generated
	*/
	private TrackerElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			TrackerDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Tracker_1000 = getElementType("tracker_model.diagram.Tracker_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Snapshooter_2001 = getElementType("tracker_model.diagram.Snapshooter_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Chronos_2002 = getElementType("tracker_model.diagram.Chronos_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Clerk_2003 = getElementType("tracker_model.diagram.Clerk_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ChronosClerk_4001 = getElementType("tracker_model.diagram.ChronosClerk_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ChronosSnapshooter_4002 = getElementType(
			"tracker_model.diagram.ChronosSnapshooter_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType SnapshooterDatasources_4003 = getElementType(
			"tracker_model.diagram.SnapshooterDatasources_4003"); //$NON-NLS-1$

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
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Tracker_1000, TrackerPackage.eINSTANCE.getTracker());

			elements.put(Snapshooter_2001, TrackerPackage.eINSTANCE.getSnapshooter());

			elements.put(Chronos_2002, TrackerPackage.eINSTANCE.getChronos());

			elements.put(Clerk_2003, TrackerPackage.eINSTANCE.getClerk());

			elements.put(ChronosClerk_4001, TrackerPackage.eINSTANCE.getChronos_Clerk());

			elements.put(ChronosSnapshooter_4002, TrackerPackage.eINSTANCE.getChronos_Snapshooter());

			elements.put(SnapshooterDatasources_4003, TrackerPackage.eINSTANCE.getSnapshooter_Datasources());
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
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Tracker_1000);
			KNOWN_ELEMENT_TYPES.add(Snapshooter_2001);
			KNOWN_ELEMENT_TYPES.add(Chronos_2002);
			KNOWN_ELEMENT_TYPES.add(Clerk_2003);
			KNOWN_ELEMENT_TYPES.add(ChronosClerk_4001);
			KNOWN_ELEMENT_TYPES.add(ChronosSnapshooter_4002);
			KNOWN_ELEMENT_TYPES.add(SnapshooterDatasources_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case TrackerEditPart.VISUAL_ID:
			return Tracker_1000;
		case SnapshooterEditPart.VISUAL_ID:
			return Snapshooter_2001;
		case ChronosEditPart.VISUAL_ID:
			return Chronos_2002;
		case ClerkEditPart.VISUAL_ID:
			return Clerk_2003;
		case ChronosClerkEditPart.VISUAL_ID:
			return ChronosClerk_4001;
		case ChronosSnapshooterEditPart.VISUAL_ID:
			return ChronosSnapshooter_4002;
		case SnapshooterDatasourcesEditPart.VISUAL_ID:
			return SnapshooterDatasources_4003;
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
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return tracker.diagram.providers.TrackerElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return tracker.diagram.providers.TrackerElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return tracker.diagram.providers.TrackerElementTypes.getElement(elementTypeAdapter);
		}
	};

}
