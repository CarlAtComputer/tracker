package graphical_app.editor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import graphical_app.domain.Clerk;

public class ClerkEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		IFigure figure = new RectangleFigure();
		figure.setBackgroundColor(new Color(null, 200, 200, 200));
		return figure;
	}
	
	@Override
	protected void refreshVisuals() {
		Rectangle bounds = new Rectangle(50, 50, 50, 50);
		getFigure().setBounds(bounds);
		Label label = new Label(((Clerk)getModel()).getName());
		Font widgetFont = new Font(null, "Arial", 6, SWT.NORMAL);
		label.setFont(widgetFont);
		label.setTextAlignment(PositionConstants.CENTER);
		label.setBounds(bounds.crop(IFigure.NO_INSETS));
		getFigure().add(label);
		getFigure().setBackgroundColor(new Color(null, 255, 100, 255));
	}

	@Override
	protected void createEditPolicies() {

	}

}
