package diagram.test.one.graphical;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import diagram.test.one.model.Connection;
import diagram.test.one.model.FileElement;
import diagram.test.one.model.Project;

public class FileEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if (model instanceof FileElement) {
			FileElement file = (FileElement) model;
			part = new FileEditPart();
			part.setModel(file);
		}
		if (model instanceof Project) {
			Project project = (Project) model;
			part = new DirectoryEditPart();
			part.setModel(project);
		}
		if (model instanceof Connection) {
			Connection connection = (Connection) model;
			part = new ConnectionEditPart();
			part.setModel(connection);
		}
		return part;
	}

}
