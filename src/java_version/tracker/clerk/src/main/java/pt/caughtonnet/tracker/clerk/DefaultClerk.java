package pt.caughtonnet.tracker.clerk;

import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pt.caughtonnet.tracker.api.clerk.Clerk;
import pt.caughtonnet.tracker.api.clerk.Courier;
import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.mailbox.TrackerMailBox;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.clerk.config.DefaultClerkParameters;

/**
 * @author CaughtOnNet
 */

public class DefaultClerk implements Clerk, ConfigurableElement<DefaultClerkParameters> {
	/**
	 * The mailbox
	 */
	private TrackerMailBox mailBox;

	/**
	 * The courier
	 */
	private Courier courier;

	/**
	 * The task timer
	 */
	private Timer clerkTimer;

	/**
	 * Clerk configuration
	 */
	private DefaultClerkParameters configuration;

	/**
	 * Start flag
	 */
	private boolean running;

	/**
	 * Chronos randomizer for the rate deviation
	 */
	protected Random clerkRandom;

	/**
	 * Decomposition infinite task
	 */
	private Thread decompositionInfiniteThread;

	/**
	 * Track queue
	 */
	private Queue<Track> trackQueue;

	/**
	 * Thread executor
	 */
	protected ExecutorService executor;

	/**
	 * The Clerk timer task
	 * 
	 * @author CaughtOnNet
	 */
	private class ClerkTimerTask extends TimerTask {
		public void run() {
			if (running) {
				DefaultClerk.this.runClerkTimeTask();
			}
		}
	}
	
	/**
	 * @author CaughtOnNet
	 *
	 */
	public class CourierTask implements Runnable {
		public void run() {
			if (running) {
				Snapshot snapshot;
				Track toSend = trackQueue.poll();
				if (toSend == null) {
					snapshot = getMailBox().retrieveSnapshot();
					if (snapshot != null && snapshot.isOkFlag()) {
						trackQueue.addAll(snapshot.getTracks());
					}
				}
				if (toSend != null) {
					getCourier().dispatch(toSend);
				}
			}
		}
	}

	/**
	 * Gets the mailBox
	 * 
	 * @return the mailBox
	 */
	public TrackerMailBox getMailBox() {
		return mailBox;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#setMailBox(pt.caughtonnet.tracker.api.mailbox.TrackerMailBox)
	 */
	@Override
	public void setMailBox(TrackerMailBox mailBox) {
		this.mailBox = mailBox;
	}

	/**
	 * Gets the courier
	 * 
	 * @return the courier
	 */
	public Courier getCourier() {
		return courier;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#setCourier(pt.caughtonnet.tracker.api.clerk.Courier)
	 */
	@Override
	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#getConfigurationBean()
	 */
	@Override
	public Class<DefaultClerkParameters> getConfigurationBean() {
		return DefaultClerkParameters.class;
	}

	/**
	 * Gets the configuration
	 * 
	 * @return the configuration
	 */
	public DefaultClerkParameters getConfiguration() {
		return configuration;
	}

	/**
	 * The clerk timer task callback
	 */
	public void runClerkTimeTask() {
		executor.submit(new CourierTask());
		Long deviatedDelay = getDeviatedDelay(getConfiguration().getRate(), getConfiguration().getRateDeviation());
		clerkTimer.schedule(new ClerkTimerTask(), deviatedDelay);
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#setup()
	 */
	@Override
	public void configure(DefaultClerkParameters configuration) {
		this.clerkTimer = new Timer();
		this.configuration = configuration;
		this.clerkRandom = new Random();
		this.trackQueue = new ConcurrentLinkedQueue<Track>();
		this.executor = Executors.newFixedThreadPool(getConfiguration().getParallelProcesses().intValue());
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#start()
	 */
	@Override
	public void start() {
		clerkTimer.schedule(new ClerkTimerTask(), 0);
		this.running = true;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.clerk.Clerk#stop()
	 */
	@Override
	public void stop() {
		clerkTimer.cancel();
		this.running = false;
	}

	/* - - - - - - - - - - - - - - - - - INNER TASKS- - - - - - - - - - - - - - - - - - */
	/* - - - - - - - - - - - - - - - - - HELPER METHODS - - - - - - - - - - - - - - - - - - */

	/**
	 * Gets the delay according to the rate and deviation
	 * 
	 * @param rate the current rate
	 * @param rateDeviation the rate deviation
	 * @return The delay with deviation according to <code>rate</code> and <code>rateDeviation</code>
	 */
	private Long getDeviatedDelay(Double rate, Double rateDeviation) {
		double rand = clerkRandom.nextDouble();
		long value = Double.valueOf(rate - (rateDeviation) + Double.valueOf(2 * rand * rateDeviation).longValue()).longValue();
		return value < 0l ? 0l : value;
	}

}
