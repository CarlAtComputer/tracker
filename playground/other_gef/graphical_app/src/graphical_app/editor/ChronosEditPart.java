package graphical_app.editor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import graphical_app.domain.Chronos;

public class ChronosEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		//Create FreeformLayer figure as layout base for other
		// graphical elements
		Figure f = new FreeformLayer();
		f.setBorder(new MarginBorder(1));
		//Create a layout for the graphical screen
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 7;
		gridLayout.horizontalSpacing = 20;
		gridLayout.verticalSpacing = 20;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		f.setLayoutManager(gridLayout);
		return f;
	}

	@Override
	protected List getModelChildren(){
		return Arrays.asList(((Chronos)getModel()).getSnapshooter(), ((Chronos)getModel()).getClerk());
	}

	@Override
	protected void createEditPolicies() {

	}

}
