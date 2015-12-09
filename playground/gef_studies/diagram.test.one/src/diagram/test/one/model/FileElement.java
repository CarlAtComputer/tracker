package diagram.test.one.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileElement extends VisualElement implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private File elementFile;
	transient private Project project;
	private List<Connection> targetConnections;
	private List<Connection> sourceConnections;
	
	public FileElement() {
		targetConnections = new ArrayList<Connection>();
		sourceConnections = new ArrayList<Connection>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getElementFile() {
		return elementFile;
	}

	public void setElementFile(File elementFile) {
		this.elementFile = elementFile;
	}

	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public List<Connection> getTargetConnections() {
		return targetConnections;
	}

	public List<Connection> getSourceConnections() {
		return sourceConnections;
	}

}
