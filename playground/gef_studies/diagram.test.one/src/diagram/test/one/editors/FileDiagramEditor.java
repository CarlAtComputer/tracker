package diagram.test.one.editors;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IEditorPart;

import diagram.test.one.graphical.FileEditPartFactory;
import diagram.test.one.model.Project;

public class FileDiagramEditor extends GraphicalEditorWithFlyoutPalette {

	public static final String ID = "diagram.test.one.editors.FileDiagramEditor";

	public FileDiagramEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}

	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setRootEditPart(new ScalableRootEditPart());
		getGraphicalViewer().setEditPartFactory(new FileEditPartFactory());
		setDropListener();
	}

	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		setPartName(getEditorInput().getName() + " diagram");
		setTitleImage(getEditorInput().getImageDescriptor().createImage());
		adaptInput();
	}

	private void adaptInput() {
		getGraphicalViewer().setContents(getEditorInput().getAdapter(Project.class));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			saveProject(getEditorInput().getAdapter(Project.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getCommandStack().markSaveLocation();
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		return null;
	}
	
	private void setDropListener() {
		Transfer transfer = FileTransfer.getInstance();
		getGraphicalViewer().addDropTargetListener(new AbstractTransferDropTargetListener(getGraphicalViewer(), transfer) {
			protected void updateTargetRequest() {
				CreateRequest request = (CreateRequest) getTargetRequest();
				request.setLocation(getDropLocation());
			}
			
			@Override
			protected Request createTargetRequest() {
				CreateRequest request = new CreateRequest();
				request.setFactory(new CreationFactory() {
					@Override
					public Object getObjectType() {
						return File.class;
					}
					
					@Override
					public Object getNewObject() {
						File file = new File(((String[]) getCurrentEvent().data)[0]);
						return file;
					}
				});
				return request;
//				return super.createTargetRequest();
			}
			
			@Override
			public boolean isEnabled(DropTargetEvent event) {
				return super.isEnabled(event);
			}
		});
	}
	
	private Project saveProject(Project project) throws IOException {
		File projectFile = project.getProjectFile();
		FileOutputStream fout = new FileOutputStream(projectFile);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(project);
		fout.close();
		oos.close();
		return project;
	}


}
