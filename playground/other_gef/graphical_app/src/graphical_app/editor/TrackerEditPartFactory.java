package graphical_app.editor;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import graphical_app.domain.Chronos;
import graphical_app.domain.Clerk;
import graphical_app.domain.Snapshooter;

public class TrackerEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		
		if (model instanceof Chronos) {
			editPart = new ChronosEditPart();
			editPart.setModel(model);
		} else if (model instanceof Clerk) {
			editPart = new ClerkEditPart();
			editPart.setModel(model);
		} else if (model instanceof Snapshooter) {
			editPart = new SnapshooterEditPart();
			editPart.setModel(model);
		}
		
		return editPart;
	}

}
