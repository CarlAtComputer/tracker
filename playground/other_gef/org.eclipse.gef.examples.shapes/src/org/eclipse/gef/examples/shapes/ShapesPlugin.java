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
package org.eclipse.gef.examples.shapes;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The plugin class (singleton).
 * <p>
 * This instance can be shared between all extensions in the plugin. Information
 * shared between extensions can be persisted by using the PreferenceStore.
 * </p>
 * 
 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
 * @author Elias Volanakis
 */
public class ShapesPlugin extends AbstractUIPlugin {

	/** Single plugin instance. */
	private static ShapesPlugin singleton;

	/**
	 * Returns the shared plugin instance.
	 */
	public static ShapesPlugin getDefault() {
		return singleton;
	}

	/**
	 * The constructor.
	 */
	public ShapesPlugin() {
		if (singleton == null) {
			singleton = this;
		}
	}

}