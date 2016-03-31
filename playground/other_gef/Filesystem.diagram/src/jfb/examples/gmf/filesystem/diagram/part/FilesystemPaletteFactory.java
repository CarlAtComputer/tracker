
package jfb.examples.gmf.filesystem.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import jfb.examples.gmf.filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FilesystemPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createFilesystem1Group());
	}

	/**
	* Creates "filesystem" palette tool group
	* @generated
	*/
	private PaletteContainer createFilesystem1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Filesystem1Group_title);
		paletteContainer.setId("createFilesystem1Group"); //$NON-NLS-1$
		paletteContainer.add(createFile1CreationTool());
		paletteContainer.add(createFolder2CreationTool());
		paletteContainer.add(createFolderFolders3CreationTool());
		paletteContainer.add(createFolderFiles4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createFile1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.File1CreationTool_title,
				Messages.File1CreationTool_desc, Collections.singletonList(FilesystemElementTypes.File_2002));
		entry.setId("createFile1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes.getImageDescriptor(FilesystemElementTypes.File_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFolder2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Folder2CreationTool_title,
				Messages.Folder2CreationTool_desc, Collections.singletonList(FilesystemElementTypes.Folder_2001));
		entry.setId("createFolder2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes.getImageDescriptor(FilesystemElementTypes.Folder_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFolderFolders3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.FolderFolders3CreationTool_title,
				Messages.FolderFolders3CreationTool_desc,
				Collections.singletonList(FilesystemElementTypes.FolderFolders_4001));
		entry.setId("createFolderFolders3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes.getImageDescriptor(FilesystemElementTypes.FolderFolders_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createFolderFiles4CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.FolderFiles4CreationTool_title,
				Messages.FolderFiles4CreationTool_desc,
				Collections.singletonList(FilesystemElementTypes.FolderFiles_4002));
		entry.setId("createFolderFiles4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes.getImageDescriptor(FilesystemElementTypes.FolderFiles_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
