package diagram.test.one;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	private static final String DIAGRAM_TEST_ONE_FOLDER = "diagram.test.one.folder";
	private static final String DIAGRAM_TEST_ONE_PROJECT_FOLDER = "diagram.test.one.project.folder";

	public void createInitialLayout(IPageLayout layout) {
		layout.createFolder(DIAGRAM_TEST_ONE_FOLDER, IPageLayout.LEFT, 0.15f, IPageLayout.ID_EDITOR_AREA);
		layout.createFolder(DIAGRAM_TEST_ONE_PROJECT_FOLDER, IPageLayout.TOP, 0.5f, DIAGRAM_TEST_ONE_FOLDER);
	}

}
