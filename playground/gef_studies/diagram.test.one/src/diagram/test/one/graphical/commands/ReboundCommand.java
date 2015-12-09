package diagram.test.one.graphical.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import diagram.test.one.graphical.FileEditPart;
import diagram.test.one.model.FileElement;

public class ReboundCommand extends Command {
	
	private FileEditPart filePart;
	private Rectangle oldBounds;
	private Rectangle newBounds;

	public ReboundCommand(FileEditPart filePart, Rectangle newBounds) {
		this.filePart = filePart;
		this.oldBounds = filePart.getFigure().getBounds().getCopy(); 
		this.newBounds = newBounds;
	}

	@Override
	public void execute() {
		redo();
	}

	@Override
	public void undo() {
		filePart.getFigure().setBounds(oldBounds);
		FileElement file = (FileElement) filePart.getModel();
		file.setX(oldBounds.x);
		file.setY(oldBounds.y);
		file.setHeight(oldBounds.height);
		file.setWidth(oldBounds.width);
	}
	
	@Override
	public void redo() {
		filePart.getFigure().setBounds(newBounds);
		FileElement file = (FileElement) filePart.getModel();
		file.setX(newBounds.x);
		file.setY(newBounds.y);
		file.setHeight(newBounds.height);
		file.setWidth(newBounds.width);
	}
}
