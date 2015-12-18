package diagram.test.one.graphical;

import java.util.List;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Panel;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import diagram.test.one.model.FileElement;

public class FileEditPart extends AbstractGraphicalEditPart implements NodeEditPart {

	private Label label;
	private IFigure imgF;
	private Panel container;

	@Override
	protected IFigure createFigure() {
		Figure f = new Figure();
        f.setOpaque(true);
	    f.setBorder(new LineBorder(1));
	    XYLayout layout = new XYLayout();
        f.setLayoutManager(layout);
        container = new Panel();
        container.setLayoutManager(new GridLayout(2, false));
        Image img = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		imgF = new ImageFigure(img);
		container.add(imgF);
        label = new Label();
        label.setLabelAlignment(Label.LEFT);
        container.add(label);
		f.add(container);
        return f;
	}
	
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		FileElement model = getFileModel();
		label.setText(model.getName());
		Image img = model.getElementFile().isDirectory() ? PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER) : PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		
		container.remove(imgF);
		
		imgF = new ImageFigure(img);
		container.add(imgF, 0);
		
		if (model.getWidth() == -1 || model.getHeight() == -1) {
			Rectangle newBounds = label.getTextBounds().expand(20, 5);
			model.setWidth(newBounds.width);
			model.setHeight(newBounds.height);
		}
		
		Rectangle rect = new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight());
		container.setSize(model.getWidth(), model.getHeight());
		getFigure().setBounds(rect);
		if (model.getElementFile().isDirectory()) {
			getFigure().setBackgroundColor(new Color(null, 255, 0, 0));
			getFigure().setForegroundColor(new Color(null, 0, 0, 0));
		} else {
			getFigure().setBackgroundColor(new Color(null, 0, 0, 255));
			getFigure().setForegroundColor(new Color(null, 255, 255, 255));
		}
	}

	@Override
	protected void createEditPolicies() {
	}

	public FileElement getFileModel() {
		return (FileElement) getModel();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}

	private ConnectionAnchor getConnectionAnchor() {
		return new ChopboxAnchor(figure);
	}
	
	@Override
	protected List getModelSourceConnections() {
		return getFileModel().getSourceConnections();
	}
	
	@Override
	protected List getModelTargetConnections() {
		return getFileModel().getTargetConnections();
	}
}
