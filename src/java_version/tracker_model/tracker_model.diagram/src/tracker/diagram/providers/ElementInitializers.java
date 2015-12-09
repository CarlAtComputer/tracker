package tracker.diagram.providers;

import tracker.diagram.part.TrackerDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = TrackerDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			TrackerDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
