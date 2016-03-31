/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package graphical_app.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
public class OpenHandler {

	@Execute
	public void execute(Shell shell, MApplication application, EModelService service, EPartService partService){
		FileDialog dialog = new FileDialog(shell);
		String path = dialog.open();
		
		
		MPartStack stack = (MPartStack) service.find("tracker_graphical_editor.partstack.right", application);
		MPart part = partService.createPart("graphical_app_explorer.part.asd.template");
		
		part.getTransientData().put("items", new String[]{"test", "test2"});
		stack.getChildren().add(part);
		part = partService.showPart(part, PartState.VISIBLE);
		
		
	}
}
