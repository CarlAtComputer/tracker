/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
ï¿½* All rights reserved. This program and the accompanying materials
ï¿½* are made available under the terms of the Eclipse Public License v1.0
ï¿½* which accompanies this distribution, and is available at
ï¿½* http://www.eclipse.org/legal/epl-v10.html
ï¿½*
ï¿½* Contributors:
ï¿½*ï¿½ï¿½ï¿½ï¿½Elias Volanakis - initial API and implementation
ï¿½*******************************************************************************/
package org.eclipse.gef.examples.shapes.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import org.eclipse.gef.examples.shapes.model.Shape;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;

/**
 * Factory that maps model elements to TreeEditParts. TreeEditParts are used in
 * the outline view of the ShapesEditor.
 * 
 * @author Elias Volanakis
 */
public class ShapesTreeEditPartFactory implements EditPartFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 * java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof Shape) {
			return new ShapeTreeEditPart((Shape) model);
		}
		if (model instanceof ShapesDiagram) {
			return new DiagramTreeEditPart((ShapesDiagram) model);
		}
		return null; // will not show an entry for the corresponding model
						// instance
	}

}
