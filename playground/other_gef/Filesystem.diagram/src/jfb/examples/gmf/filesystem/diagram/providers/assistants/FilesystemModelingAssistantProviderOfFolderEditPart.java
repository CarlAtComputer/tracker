package jfb.examples.gmf.filesystem.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import jfb.examples.gmf.filesystem.diagram.edit.parts.FileEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderEditPart;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemModelingAssistantProvider;

/**
 * @generated
 */
public class FilesystemModelingAssistantProviderOfFolderEditPart extends FilesystemModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((FolderEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(FolderEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(FilesystemElementTypes.FolderFolders_4001);
		types.add(FilesystemElementTypes.FolderFiles_4002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((FolderEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(FolderEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof FolderEditPart) {
			types.add(FilesystemElementTypes.FolderFolders_4001);
		}
		if (targetEditPart instanceof FileEditPart) {
			types.add(FilesystemElementTypes.FolderFiles_4002);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((FolderEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(FolderEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == FilesystemElementTypes.FolderFolders_4001) {
			types.add(FilesystemElementTypes.Folder_2001);
		} else if (relationshipType == FilesystemElementTypes.FolderFiles_4002) {
			types.add(FilesystemElementTypes.File_2002);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((FolderEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(FolderEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(FilesystemElementTypes.FolderFolders_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((FolderEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(FolderEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == FilesystemElementTypes.FolderFolders_4001) {
			types.add(FilesystemElementTypes.Folder_2001);
		}
		return types;
	}

}
