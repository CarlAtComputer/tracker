package diagram.test.one.graphical;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import diagram.test.one.model.FileElement;
import diagram.test.one.model.Project;

@SuppressWarnings("rawtypes")
public class DirectoryEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		Figure layer = new Figure();
	    layer.setLayoutManager(new XYLayout());
	    return layer;
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DirectoryLayoutPolicy(this));
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
