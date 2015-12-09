package diagram.test.one.editors;

import java.io.File;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import diagram.test.one.model.Project;

public class ProjectEditorInput implements IEditorInput {

	private Project project;

	public ProjectEditorInput(Project project) {
		this.project = project;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter.isAssignableFrom(Project.class)) return (T) project;
		if (adapter.isAssignableFrom(File.class)) return (T) project.getProjectFile();
		return null;
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_FILE);
	}

	@Override
	public String getName() {
		return project.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return project.getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProjectEditorInput) {
			ProjectEditorInput other = (ProjectEditorInput) obj;
			return other.getAdapter(Project.class).equals(getAdapter(Project.class));
		}
		
		return false;
	}

}
