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

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import org.eclipse.gef.examples.shapes.model.Shape;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;
import org.eclipse.gef.examples.shapes.model.commands.ShapeDeleteCommand;

/**
 * This edit policy enables the removal of a Shapes instance from its container.
 * 
 * @see ShapeEditPart#createEditPolicies()
 * @see ShapeTreeEditPart#createEditPolicies()
 * @author Elias Volanakis
 */
class ShapeComponentEditPolicy extends ComponentEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(
	 * org.eclipse.gef.requests.GroupRequest)
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object parent = getHost().getParent().getModel();
		Object child = getHost().getModel();
		if (parent instanceof ShapesDiagram && child instanceof Shape) {
			return new ShapeDeleteCommand((ShapesDiagram) parent, (Shape) child);
		}
		return super.createDeleteCommand(deleteRequest);
	}
}