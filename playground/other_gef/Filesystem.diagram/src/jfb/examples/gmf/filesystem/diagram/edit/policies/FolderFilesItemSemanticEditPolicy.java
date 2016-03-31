package jfb.examples.gmf.filesystem.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FolderFilesItemSemanticEditPolicy extends FilesystemBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public FolderFilesItemSemanticEditPolicy() {
		super(FilesystemElementTypes.FolderFiles_4002);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
