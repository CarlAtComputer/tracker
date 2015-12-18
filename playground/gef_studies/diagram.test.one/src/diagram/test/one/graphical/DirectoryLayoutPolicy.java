package diagram.test.one.graphical;

import java.io.File;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import diagram.test.one.graphical.commands.FileCreateCommand;
import diagram.test.one.graphical.commands.ReboundCommand;

public class DirectoryLayoutPolicy extends XYLayoutEditPolicy {
	
	private EditPart parent;

	public DirectoryLayoutPolicy(EditPart parent) {
		this.parent = parent;
	}
	
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return new FileCreateCommand((File) request.getNewObject(), parent, request.getLocation());
	}

	@Override
	protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
		if (request.getType().equals(RequestConstants.REQ_RESIZE_CHILDREN) || request.getType().equals(RequestConstants.REQ_MOVE_CHILDREN)) {
			return new ReboundCommand((FileEditPart) child, (Rectangle) constraint);
		}

		return super.createChangeConstraintCommand(request, child, constraint);
	}
}
