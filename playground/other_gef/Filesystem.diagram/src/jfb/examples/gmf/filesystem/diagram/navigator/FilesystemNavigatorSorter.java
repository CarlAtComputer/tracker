package jfb.examples.gmf.filesystem.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry;

/**
 * @generated
 */
public class FilesystemNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4004;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem item = (FilesystemNavigatorItem) element;
			return FilesystemVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
