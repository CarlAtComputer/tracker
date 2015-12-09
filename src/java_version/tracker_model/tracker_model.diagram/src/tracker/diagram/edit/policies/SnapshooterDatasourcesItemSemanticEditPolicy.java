package tracker.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import tracker.diagram.providers.TrackerElementTypes;

/**
 * @generated
 */
public class SnapshooterDatasourcesItemSemanticEditPolicy extends TrackerBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public SnapshooterDatasourcesItemSemanticEditPolicy() {
		super(TrackerElementTypes.SnapshooterDatasources_4003);
	}

	/**
	* @generated
	*/
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
