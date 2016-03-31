package graphical_app.domain;

public class Chronos {
	private String name;
	private Snapshooter snapshooter;
	private Clerk clerk;
	
	public Chronos(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Snapshooter getSnapshooter() {
		return snapshooter;
	}
	
	public void setSnapshooter(Snapshooter snapshooter) {
		this.snapshooter = snapshooter;
	}
	
	public Clerk getClerk() {
		return clerk;
	}
	
	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}
}
