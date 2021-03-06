package tracker.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import tracker.diagram.providers.TrackerElementTypes;

/**
 * @generated
 */
public class ChronosSnapshooterItemSemanticEditPolicy extends TrackerBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ChronosSnapshooterItemSemanticEditPolicy() {
		super(TrackerElementTypes.ChronosSnapshooter_4002);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
