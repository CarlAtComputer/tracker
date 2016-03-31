package jfb.examples.gmf.filesystem.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FolderFoldersItemSemanticEditPolicy extends FilesystemBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public FolderFoldersItemSemanticEditPolicy() {
		super(FilesystemElementTypes.FolderFolders_4001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
