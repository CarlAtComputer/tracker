package diagram.test.one;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import diagram.test.one.editors.FileDiagramEditor;

public class View extends ViewPart {
	public static final String ID = "diagram.test.one.view";

	private TreeViewer viewer;

	class ViewContentProvider implements ITreeContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ((File) inputElement).listFiles();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((File) parentElement).listFiles();
		}

		@Override
		public Object getParent(Object element) {
			return ((File) element).getParentFile();
		}

		@Override
		public boolean hasChildren(Object element) {
			return ((File) element).isDirectory();
		}

	}

	class ViewLabelProvider extends LabelProvider {
		public String getText(Object obj) {
			return ((File) obj).getName();
		}

		public Image getImage(Object obj) {
			ISharedImages imgs = PlatformUI.getWorkbench().getSharedImages();
			return ((File) obj).isDirectory() ? imgs.getImage(ISharedImages.IMG_OBJ_FOLDER)
					: imgs.getImage(ISharedImages.IMG_OBJ_FILE);
		}

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(new File(System.getProperty("user.home")));
		viewer.addDoubleClickListener((e) -> {
			selected((File) ((IStructuredSelection) e.getSelection()).getFirstElement());
		});

		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		Transfer[] transferTypes = new Transfer[] { FileTransfer.getInstance() };
		DragSourceListener listener = new DragSourceListener() {
			
			@Override
			public void dragStart(DragSourceEvent event) {
				ITreeSelection selection = viewer.getStructuredSelection();
				File firstElement = (File) selection.getFirstElement();
				event.data = new String[] { firstElement.getAbsolutePath() };
			}
			
			@Override
			public void dragSetData(DragSourceEvent event) {
				ITreeSelection selection = viewer.getStructuredSelection();
				File firstElement = (File) selection.getFirstElement();
				
				if (FileTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = new String[] { firstElement.getAbsolutePath() };
				}
			}
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				
			}
		};
		viewer.addDragSupport(operations, transferTypes, listener);
		
	}

	private void selected(File file) {
		try {
			if (file.isDirectory()) {
				getSite().getPage().openEditor(createEditorInput(file), FileDiagramEditor.ID);
			}
		} catch (PartInitException e) {
			MessageDialog.openError(getSite().getShell(), "ERROR", e.getMessage());
		}

	}

	private IEditorInput createEditorInput(File file) {
		return new FileEditorInput(file);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}