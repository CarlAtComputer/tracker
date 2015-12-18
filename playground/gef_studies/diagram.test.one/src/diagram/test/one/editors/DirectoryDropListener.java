/**
 * 
 */
package diagram.test.one.editors;

import java.io.File;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;

/**
 * @author baia
 *
 */
public class DirectoryDropListener extends AbstractTransferDropTargetListener {

	public DirectoryDropListener(EditPartViewer viewer, Transfer xfer) {
		super(viewer, xfer);
	}

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
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		return super.isEnabled(event);
	}

}
