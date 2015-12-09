package tracker.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import tracker.Tracker;
import tracker.TrackerPackage;
import tracker.diagram.edit.parts.ChronosEditPart;
import tracker.diagram.edit.parts.ClerkEditPart;
import tracker.diagram.edit.parts.SnapshooterEditPart;
import tracker.diagram.edit.parts.TrackerEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class TrackerVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "tracker_model.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (TrackerEditPart.MODEL_ID.equals(view.getType())) {
				return TrackerEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return tracker.diagram.part.TrackerVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				TrackerDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (TrackerPackage.eINSTANCE.getTracker().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Tracker) domainElement)) {
			return TrackerEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = tracker.diagram.part.TrackerVisualIDRegistry.getModelID(containerView);
		if (!TrackerEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (TrackerEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = tracker.diagram.part.TrackerVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = TrackerEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case TrackerEditPart.VISUAL_ID:
			if (TrackerPackage.eINSTANCE.getSnapshooter().isSuperTypeOf(domainElement.eClass())) {
				return SnapshooterEditPart.VISUAL_ID;
			}
			if (TrackerPackage.eINSTANCE.getChronos().isSuperTypeOf(domainElement.eClass())) {
				return ChronosEditPart.VISUAL_ID;
			}
			if (TrackerPackage.eINSTANCE.getClerk().isSuperTypeOf(domainElement.eClass())) {
				return ClerkEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = tracker.diagram.part.TrackerVisualIDRegistry.getModelID(containerView);
		if (!TrackerEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (TrackerEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = tracker.diagram.part.TrackerVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = TrackerEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case TrackerEditPart.VISUAL_ID:
			if (SnapshooterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChronosEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClerkEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Tracker element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case TrackerEditPart.VISUAL_ID:
			return false;
		case SnapshooterEditPart.VISUAL_ID:
		case ChronosEditPart.VISUAL_ID:
		case ClerkEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return tracker.diagram.part.TrackerVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return tracker.diagram.part.TrackerVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return tracker.diagram.part.TrackerVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return tracker.diagram.part.TrackerVisualIDRegistry.checkNodeVisualID(containerView, domainElement,
					candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return tracker.diagram.part.TrackerVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return tracker.diagram.part.TrackerVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
