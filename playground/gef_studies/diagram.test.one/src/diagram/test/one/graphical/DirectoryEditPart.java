package diagram.test.one.graphical;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import diagram.test.one.graphical.commands.FileCreateCommand;
import diagram.test.one.graphical.commands.ReboundCommand;
import diagram.test.one.model.FileElement;
import diagram.test.one.model.Project;

public class DirectoryEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		Figure layer = new Figure();
	    layer.setLayoutManager(new XYLayout());
	    layer.setBorder(new LineBorder(1));
	    return layer;
	}
	
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return new FileCreateCommand((File) request.getNewObject(), (EditPart) DirectoryEditPart.this, request.getLocation());
			}
			
			@Override
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
				if (request.getType().equals(RequestConstants.REQ_RESIZE_CHILDREN)) {
					return new ReboundCommand((FileEditPart)child, (Rectangle) constraint);
				}
				
				if (request.getType().equals(RequestConstants.REQ_MOVE_CHILDREN)) {
					return new ReboundCommand((FileEditPart)child, (Rectangle) constraint);
				}
				return super.createChangeConstraintCommand(request, child, constraint);
			}
			
		});
	}
	
	@Override
	protected List getModelChildren() {
		List<FileElement> children = getProjectModel().getFiles();
		return children == null ? new ArrayList<FileElement>() : children;
	}

	public Project getProjectModel() {
		return (Project) getModel();
	}
	
	
}
