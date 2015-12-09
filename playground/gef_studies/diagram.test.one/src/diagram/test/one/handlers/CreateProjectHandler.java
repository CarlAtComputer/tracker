package diagram.test.one.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import diagram.test.one.Application;
import diagram.test.one.ProjectView;
import diagram.test.one.editors.FileDiagramEditor;
import diagram.test.one.editors.ProjectEditorInput;
import diagram.test.one.model.Project;

public class CreateProjectHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project createdProject = null;

		InputDialog d = new InputDialog(Display.getDefault().getActiveShell(), "New Project", "Project name?", "Project#" + (new Random().nextInt(1000)), null);
		if (d.open() == Dialog.OK) {
			try {
				createdProject = createProject(d.getValue());
			} catch (IOException e) {
				e.printStackTrace();
				MessageDialog.openError(Display.getDefault().getActiveShell(), "New Project", "Error creating project: " + e.getMessage());
			}
		}
		
		refreshProjectVIew();
		
		try {
			openProjectEditor(createdProject);
		} catch (PartInitException e) {
			e.printStackTrace();
			MessageDialog.openError(Display.getDefault().getActiveShell(), "New Project", "Error opening project: " + e.getMessage());
		}
		return null;
	}

	private Project createProject(String name) throws IOException {
		File projectFile = new File(Application.PROJECT_FOLDER_LOCATION + File.separator + name + ".project");
		FileOutputStream fout = new FileOutputStream(projectFile);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		Project project = new Project();
		project.setName(name);
		project.setProjectFile(projectFile);
		oos.writeObject(project);
		fout.close();
		oos.close();
		return project;
	}

	private void refreshProjectVIew() {
		ProjectView view = (ProjectView) getPage().findView(ProjectView.ID);
		
		if (view != null) {
			view.refreshProjects();
		}
	}

	private IWorkbenchPage getPage() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

	private void openProjectEditor(Project project) throws PartInitException {
		getPage().openEditor(createEditorInput(project), FileDiagramEditor.ID);
	}
	
	private IEditorInput createEditorInput(Project project) {
		return new ProjectEditorInput(project);
	}

}
