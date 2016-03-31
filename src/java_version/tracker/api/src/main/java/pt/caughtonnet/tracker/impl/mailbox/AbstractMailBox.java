package pt.caughtonnet.tracker.impl.mailbox;

import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;

public abstract class AbstractMailBox implements TrackerMailBox {

	protected int capacity;

	protected boolean setup;
	
	/**
	 * Gets the capacity
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#setCapacity(int)
	 */
	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.mailbox.TrackerMailBox#setup()
	 */
	@Override
	public void setup() {
		setupMailBox();
		setup = true;
	}
	
	@Override
	public boolean isSetup() {
		return this.setup;
	}
	
	protected abstract void setupMailBox();
}
