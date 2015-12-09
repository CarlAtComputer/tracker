package diagram.test.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import diagram.test.one.editors.FileDiagramEditor;
import diagram.test.one.editors.ProjectEditorInput;
import diagram.test.one.model.FileElement;
import diagram.test.one.model.Project;

public class ProjectView extends ViewPart {
	public static final String ID = "diagram.test.one.project.view";
	private TableViewer viewer;

	public class ProjectLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			File file = (File) element;
			if (columnIndex == 0) {
				if (!file.isDirectory() && file.getName().endsWith(".project"))
					return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
			}
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			File file = (File) element;
			if (columnIndex == 0) {
				return file.getName().substring(0, file.getName().lastIndexOf("."));
			}
			return "";
		}
	}

	public class ProjectContentProvider implements IStructuredContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return ((File) inputElement).listFiles();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent);
		viewer.setContentProvider(new ProjectContentProvider());
		viewer.setLabelProvider(new ProjectLabelProvider());
		File file = new File(Application.PROJECT_FOLDER_LOCATION);
		if (!file.exists()) {
			file.mkdirs();
		}
		viewer.setInput(file);
		viewer.addDoubleClickListener((e) -> {
			openProject((File) ((IStructuredSelection) e.getSelection()).getFirstElement());
		});
		getSite().setSelectionProvider(viewer);
	}

	@Override
	public void setFocus() {

	}

	public void refreshProjects() {
		viewer.refresh();
	}

	private void openProject(File projectFile) {
		try {
			openProjectEditor(readProject(projectFile));
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Open Project", "Error opening project: " + e.getMessage());
		}
	}

	private void openProjectEditor(Project project) throws PartInitException {
		if (project.getFiles() == null) project.setFiles(new ArrayList<FileElement>());
		getSite().getPage().openEditor(createEditorInput(project), FileDiagramEditor.ID);
	}
	
	private Project readProject(File projectFile) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(projectFile);
			ois = new ObjectInputStream(fis);
			return (Project) ois.readObject();
		} finally {
			if (fis != null) fis.close();
			if (ois != null) ois.close();
		}
	}
	
	private IEditorInput createEditorInput(Project project) {
		return new ProjectEditorInput(project);
	}

}
