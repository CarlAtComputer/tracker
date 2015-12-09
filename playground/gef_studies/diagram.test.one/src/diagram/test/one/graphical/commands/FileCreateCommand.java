package diagram.test.one.graphical.commands;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import diagram.test.one.model.Connection;
import diagram.test.one.model.FileElement;
import diagram.test.one.model.Project;

public class FileCreateCommand extends Command {

	private File file;
	private Point location;
	private EditPart parent;

	public FileCreateCommand(File file, EditPart parent, Point location) {
		this.file = file;
		this.parent = parent;
		this.location = location;
	}

	@Override
	public void execute() {
		Project project = getProject();
		FileElement fileElement = new FileElement();
		fileElement.setName(file.getName());
		fileElement.setX(location.x);
		fileElement.setY(location.y);
		fileElement.setWidth(-1);
		fileElement.setHeight(-1);
		fileElement.setElementFile(file);
		fileElement.setProject(project);
		project.getFiles().add(fileElement);
		addConnections(fileElement);
		refreshAllEditParts(parent);
	}

	private void addConnections(FileElement fileElem) {
		List<FileElement> others = getProject().getFiles();

		for (FileElement other : others) {
			if (!other.equals(fileElem)) {
				Connection conn = new Connection();
				if (other.getElementFile().equals(file.getParentFile())) {
					conn.setSource(fileElem);
					conn.setDestination(other);
					fileElem.getSourceConnections().add(conn);
					other.getTargetConnections().add(conn);
				}
			}
		}
	}

	private void refreshAllEditParts(EditPart part) {
		part.refresh();
		List children = part.getChildren();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			EditPart child = (EditPart) iter.next();
			refreshAllEditParts(child);
		}
	}

	private Project getProject() {
		return (Project) parent.getModel();
	}

}
