package jfb.examples.gmf.filesystem.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import jfb.examples.gmf.filesystem.diagram.edit.parts.FileEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FileNameEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FilesystemEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderFilesEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderFoldersEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderNameEditPart;
import jfb.examples.gmf.filesystem.diagram.part.FilesystemDiagramEditorPlugin;
import jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemParserProvider;

/**
 * @generated
 */
public class FilesystemNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		FilesystemDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		FilesystemDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof FilesystemNavigatorItem && !isOwnView(((FilesystemNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof FilesystemNavigatorGroup) {
			FilesystemNavigatorGroup group = (FilesystemNavigatorGroup) element;
			return FilesystemDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem navigatorItem = (FilesystemNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http:///jfb/examples/gmf/filesystem.ecore?Filesystem", //$NON-NLS-1$
					FilesystemElementTypes.Filesystem_1000);
		case FolderEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///jfb/examples/gmf/filesystem.ecore?Folder", //$NON-NLS-1$
					FilesystemElementTypes.Folder_2001);
		case FileEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http:///jfb/examples/gmf/filesystem.ecore?File", //$NON-NLS-1$
					FilesystemElementTypes.File_2002);
		case FolderFoldersEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http:///jfb/examples/gmf/filesystem.ecore?Folder?folders", //$NON-NLS-1$
					FilesystemElementTypes.FolderFolders_4001);
		case FolderFilesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http:///jfb/examples/gmf/filesystem.ecore?Folder?files", //$NON-NLS-1$
					FilesystemElementTypes.FolderFiles_4002);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = FilesystemDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && FilesystemElementTypes.isKnownElementType(elementType)) {
			image = FilesystemElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof FilesystemNavigatorGroup) {
			FilesystemNavigatorGroup group = (FilesystemNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem navigatorItem = (FilesystemNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000Text(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_2001Text(view);
		case FileEditPart.VISUAL_ID:
			return getFile_2002Text(view);
		case FolderFoldersEditPart.VISUAL_ID:
			return getFolderFolders_4001Text(view);
		case FolderFilesEditPart.VISUAL_ID:
			return getFolderFiles_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getFilesystem_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getFolder_2001Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(FilesystemElementTypes.Folder_2001,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry.getType(FolderNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFile_2002Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(FilesystemElementTypes.File_2002,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry.getType(FileNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getFolderFolders_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getFolderFiles_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return FilesystemEditPart.MODEL_ID.equals(FilesystemVisualIDRegistry.getModelID(view));
	}

}
