package diagram.test.one.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {
	private static final long serialVersionUID = -8117608765131020429L;
	
	private String name;
	private File projectFile;
	private List<FileElement> files;
	
	public Project() {
		if (files == null) setFiles(new ArrayList<FileElement>());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FileElement> getFiles() {
		return files;
	}

	public void setFiles(List<FileElement> files) {
		this.files = files;
	}
	
	public File getProjectFile() {
		return projectFile;
	}
	
	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Project) {
			Project other = (Project) obj;
			return other.getProjectFile().equals(getProjectFile());
		}
		return false;
	}

}
