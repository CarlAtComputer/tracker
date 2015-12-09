package tracker.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import tracker.diagram.edit.parts.TrackerEditPart;
import tracker.diagram.edit.parts.TrackerEditPartFactory;
import tracker.diagram.part.TrackerVisualIDRegistry;

/**
 * @generated
 */
public class TrackerEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public TrackerEditPartProvider() {
		super(new TrackerEditPartFactory(), TrackerVisualIDRegistry.TYPED_INSTANCE, TrackerEditPart.MODEL_ID);
	}

}
