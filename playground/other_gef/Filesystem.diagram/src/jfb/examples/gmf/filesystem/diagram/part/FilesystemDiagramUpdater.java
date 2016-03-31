package jfb.examples.gmf.filesystem.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import jfb.examples.gmf.filesystem.File;
import jfb.examples.gmf.filesystem.Filesystem;
import jfb.examples.gmf.filesystem.FilesystemPackage;
import jfb.examples.gmf.filesystem.Folder;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FileEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FilesystemEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderFilesEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderFoldersEditPart;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FilesystemDiagramUpdater {

	/**
	* @generated
	*/
	public static List<FilesystemNodeDescriptor> getSemanticChildren(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<FilesystemNodeDescriptor> getFilesystem_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Filesystem modelElement = (Filesystem) view.getElement();
		LinkedList<FilesystemNodeDescriptor> result = new LinkedList<FilesystemNodeDescriptor>();
		for (Iterator<?> it = modelElement.getFolders().iterator(); it.hasNext();) {
			Folder childElement = (Folder) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FolderEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getFiles().iterator(); it.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == FileEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<FilesystemLinkDescriptor> getContainedLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000ContainedLinks(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_2001ContainedLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_2002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<FilesystemLinkDescriptor> getIncomingLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FolderEditPart.VISUAL_ID:
			return getFolder_2001IncomingLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_2002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<FilesystemLinkDescriptor> getOutgoingLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FolderEditPart.VISUAL_ID:
			return getFolder_2001OutgoingLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_2002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFilesystem_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_2001ContainedLinks(View view) {
		Folder modelElement = (Folder) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Folder_Folders_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Folder_Files_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_2001IncomingLinks(View view) {
		Folder modelElement = (Folder) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Folder_Folders_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_2002IncomingLinks(View view) {
		File modelElement = (File) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Folder_Files_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_2001OutgoingLinks(View view) {
		Folder modelElement = (Folder) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Folder_Folders_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Folder_Files_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_2002OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<FilesystemLinkDescriptor> getIncomingFeatureModelFacetLinks_Folder_Folders_4001(
			Folder target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FilesystemPackage.eINSTANCE.getFolder_Folders()) {
				result.add(new FilesystemLinkDescriptor(setting.getEObject(), target,
						FilesystemElementTypes.FolderFolders_4001, FolderFoldersEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<FilesystemLinkDescriptor> getIncomingFeatureModelFacetLinks_Folder_Files_4002(File target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == FilesystemPackage.eINSTANCE.getFolder_Files()) {
				result.add(new FilesystemLinkDescriptor(setting.getEObject(), target,
						FilesystemElementTypes.FolderFiles_4002, FolderFilesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<FilesystemLinkDescriptor> getOutgoingFeatureModelFacetLinks_Folder_Folders_4001(
			Folder source) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		for (Iterator<?> destinations = source.getFolders().iterator(); destinations.hasNext();) {
			Folder destination = (Folder) destinations.next();
			result.add(new FilesystemLinkDescriptor(source, destination, FilesystemElementTypes.FolderFolders_4001,
					FolderFoldersEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<FilesystemLinkDescriptor> getOutgoingFeatureModelFacetLinks_Folder_Files_4002(
			Folder source) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		for (Iterator<?> destinations = source.getFiles().iterator(); destinations.hasNext();) {
			File destination = (File) destinations.next();
			result.add(new FilesystemLinkDescriptor(source, destination, FilesystemElementTypes.FolderFiles_4002,
					FolderFilesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<FilesystemNodeDescriptor> getSemanticChildren(View view) {
			return FilesystemDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<FilesystemLinkDescriptor> getContainedLinks(View view) {
			return FilesystemDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<FilesystemLinkDescriptor> getIncomingLinks(View view) {
			return FilesystemDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<FilesystemLinkDescriptor> getOutgoingLinks(View view) {
			return FilesystemDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
