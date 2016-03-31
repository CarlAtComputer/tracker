package graphical_app.editor;

import javax.annotation.PostConstruct;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import graphical_app.domain.Chronos;
import graphical_app.domain.Clerk;
import graphical_app.domain.Snapshooter;

public class TrackerGraphicalEditor {
	public static final String ID = "GEFTutorial.view";
	private GraphicalViewer viewer = new PaletteViewer();
	private RootEditPart rootEditPart = new ScalableFreeformRootEditPart();
	private EditPartFactory editPartFactory = new TrackerEditPartFactory();
	private Chronos model;

	@PostConstruct
	public void createComposite(Composite parent) {
		model = new Chronos("Chronos");
		model.setClerk(new Clerk("Clerk"));
		model.setSnapshooter(new Snapshooter("Snapshooter"));
		viewer.setRootEditPart(rootEditPart);
		viewer.setEditPartFactory(editPartFactory);
		viewer.setContents(model);
		viewer.createControl(parent);
		viewer.getControl().setBackground(new Color(null, 255, 255, 255));
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
