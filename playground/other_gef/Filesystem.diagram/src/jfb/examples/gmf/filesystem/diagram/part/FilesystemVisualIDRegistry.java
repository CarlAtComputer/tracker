package jfb.examples.gmf.filesystem.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import jfb.examples.gmf.filesystem.Filesystem;
import jfb.examples.gmf.filesystem.FilesystemPackage;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FileEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FileNameEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FilesystemEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FilesystemVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "Filesystem.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FilesystemEditPart.MODEL_ID.equals(view.getType())) {
				return FilesystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.getVisualID(view.getType());
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
				FilesystemDiagramEditorPlugin.getInstance()
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
		if (FilesystemPackage.eINSTANCE.getFilesystem().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Filesystem) domainElement)) {
			return FilesystemEditPart.VISUAL_ID;
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
		String containerModelID = jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry
				.getModelID(containerView);
		if (!FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FilesystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case FilesystemEditPart.VISUAL_ID:
			if (FilesystemPackage.eINSTANCE.getFolder().isSuperTypeOf(domainElement.eClass())) {
				return FolderEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFile().isSuperTypeOf(domainElement.eClass())) {
				return FileEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry
				.getModelID(containerView);
		if (!FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FilesystemEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case FilesystemEditPart.VISUAL_ID:
			if (FolderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FileEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FolderEditPart.VISUAL_ID:
			if (FolderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FileEditPart.VISUAL_ID:
			if (FileNameEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(Filesystem element) {
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
		case FilesystemEditPart.VISUAL_ID:
			return false;
		case FolderEditPart.VISUAL_ID:
		case FileEditPart.VISUAL_ID:
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
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.checkNodeVisualID(containerView,
					domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
