package tracker.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import tracker.diagram.edit.commands.ChronosCreateCommand;
import tracker.diagram.edit.commands.ClerkCreateCommand;
import tracker.diagram.edit.commands.SnapshooterCreateCommand;
import tracker.diagram.providers.TrackerElementTypes;

/**
 * @generated
 */
public class TrackerItemSemanticEditPolicy extends TrackerBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public TrackerItemSemanticEditPolicy() {
		super(TrackerElementTypes.Tracker_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (TrackerElementTypes.Snapshooter_2001 == req.getElementType()) {
			return getGEFWrapper(new SnapshooterCreateCommand(req));
		}
		if (TrackerElementTypes.Chronos_2002 == req.getElementType()) {
			return getGEFWrapper(new ChronosCreateCommand(req));
		}
		if (TrackerElementTypes.Clerk_2003 == req.getElementType()) {
			return getGEFWrapper(new ClerkCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
