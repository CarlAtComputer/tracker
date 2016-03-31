package graphical_app.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;

public class TrackerGraphicalEditorContent extends GraphicalEditor {

	public TrackerGraphicalEditorContent() {
		setEditDomain(new DefaultEditDomain(this));
	}
    
	@Override
	protected void initializeGraphicalViewer() {
		getGraphicalViewer().setContents(MagicHelper.constructSampleDiagram());
	}
	
	@Override
	protected void configureGraphicalViewer() {
        super.configureGraphicalViewer();
        //getGraphicalViewer().setEditPartFactory(new MyGraphicalEditpartFactory());
    }

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

}
