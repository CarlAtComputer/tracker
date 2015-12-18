package diagram.test.one.model;

import java.io.Serializable;

public class Connection implements Serializable {
	private static final long serialVersionUID = 4329992060589541520L;
	
	private FileElement source;
	private FileElement destination;

	public FileElement getDestination() {
		return destination;
	}

	public FileElement getSource() {
		return source;
	}

	public void setDestination(FileElement destination) {
		this.destination = destination;
	}

	public void setSource(FileElement source) {
		this.source = source;
	}
}
