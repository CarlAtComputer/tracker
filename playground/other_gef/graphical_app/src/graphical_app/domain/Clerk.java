package graphical_app.domain;

public class Clerk {
	private String name;
	
	public Clerk(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
