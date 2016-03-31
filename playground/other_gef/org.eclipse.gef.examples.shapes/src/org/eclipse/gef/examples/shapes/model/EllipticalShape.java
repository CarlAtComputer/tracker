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
package org.eclipse.gef.examples.shapes.model;

import org.eclipse.swt.graphics.Image;

/**
 * An elliptical shape.
 * 
 * @author Elias Volanakis
 */
public class EllipticalShape extends Shape {

	/** A 16x16 pictogram of an elliptical shape. */
	private static final Image ELLIPSE_ICON = createImage("icons/ellipse16.gif");

	private static final long serialVersionUID = 1;

	public Image getIcon() {
		return ELLIPSE_ICON;
	}

	public String toString() {
		return "Ellipse " + hashCode();
	}
}
