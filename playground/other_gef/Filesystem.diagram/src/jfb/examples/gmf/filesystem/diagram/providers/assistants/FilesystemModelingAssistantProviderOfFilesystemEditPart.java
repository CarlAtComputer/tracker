package jfb.examples.gmf.filesystem.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;
import jfb.examples.gmf.filesystem.diagram.providers.FilesystemModelingAssistantProvider;

/**
 * @generated
 */
public class FilesystemModelingAssistantProviderOfFilesystemEditPart extends FilesystemModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(FilesystemElementTypes.Folder_2001);
		types.add(FilesystemElementTypes.File_2002);
		return types;
	}

}
