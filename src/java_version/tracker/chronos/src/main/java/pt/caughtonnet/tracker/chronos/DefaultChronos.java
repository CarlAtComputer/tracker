package pt.caughtonnet.tracker.chronos;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import pt.caughtonnet.tracker.api.chronos.Chronos;
import pt.caughtonnet.tracker.api.exception.chronos.ChronosException;
import pt.caughtonnet.tracker.api.exception.snapshooter.SnapshooterException;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.chronos.config.DefaultChronosParameters;
import pt.caughtonnet.tracker.impl.model.DefaultSnapshot;

/**
 * The default chronos
 * 
 * @author CaughtOnNet
 */
public class DefaultChronos implements Chronos<DefaultChronosParameters> {

	class ChronosTask extends TimerTask {
		public void run() {
			DefaultChronos.this.runChronosTimeTask();
		}
	}

	class ChronosSnapshotTask implements Callable<Snapshot> {
		public Snapshot call() throws Exception {
			return DefaultChronos.this.runChronosSnapshotTask();
		}
	}

	class ChronosClerkTask extends TimerTask {
		public void run() {
			DefaultChronos.this.runClerkTimeTask();
		}
	}

	/* - - - - - - - - - - - - - - - - *-*-* STATICS *-*-* - - - - - - - - - - - - - - - - - */

	/**
	 * The default chronos default rate
	 */
	public static final long DEFAULT_CHRONOS_RATE = 1000l;

	/**
	 * The default chronos rate deviation
	 */
	public static final long DEFAULT_CHRONOS_RATE_DEVIATION = 0l;

	/**
	 * The default chronos parallel process number
	 */
	public static final int DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER = 20;

	/* - - - - - - - - - - - - - - - - *-*-* PARAMETERS *-*-* - - - - - - - - - - - - - - - - - */

	/**
	 * Chronos parameters
	 */
	private DefaultChronosParameters configuration;
	
	/**
	 * The the chronos snapshooter
	 */
	private Snapshooter chronosSnapshooter;

	/* - - - - - - - - - - - - - - - - - - INTERNALS - - - - - - - - - - - - - - - - - - */

	/**
	 * The date for the incremental snapshooting process
	 */
	protected Date currentDate;

	/**
	 * The chronos timer to control the rate of snapshots
	 */
	protected Timer chronosTimer;

	/**
	 * The clerk timer to control the rate of expeditions
	 */
	protected Timer clerkTimer;

	/**
	 * Chronos randomizer for the rate deviation
	 */
	protected Random chronosRandom;

	/**
	 * Thread executor
	 */
	protected ExecutorService executor;

	/**
	 * Current ordered snapshot tasks
	 */
	protected Map<Date, Future<Snapshot>> currentTasks;

	/* - - - - - - - - - - - - - - - - *-*-* CONSTRUCTORS *-*-* - - - - - - - - - - - - - - - - - - */

	/**
	 * The default chronos, will set the defautls
	 */
	public DefaultChronos() {
		setChronosDefaults();
	}

	/* - - - - - - - - - - - - - - - - *-*-* METHODS *-*-* - - - - - - - - - - - - - - - - - - */

	/* - - - - - - - - - - - - - - - - - GETTERS-SETTERS- - - - - - - - - - - - - - - - - - */
	
	/**
	 * Gets the configuration
	 * @return the configuration
	 */
	public DefaultChronosParameters getConfiguration() {
		return configuration;
	}
	
	/**
	 * Sets the configuration
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(DefaultChronosParameters configuration) {
		this.configuration = configuration;
	}

	/**
	 * Gets the chronosSnapshooter
	 * 
	 * @return the chronosSnapshooter
	 */
	public Snapshooter getChronosSnapshooter() {
		return chronosSnapshooter;
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setChronosSnapshooter(pt.caughtonnet.tracker.api.snapshooter.Snapshooter)
	 */
	@Override
	public void setChronosSnapshooter(Snapshooter chronosSnapshooter) {
		this.chronosSnapshooter = chronosSnapshooter;
	}

	/* - - - - - - - - - - - - - - - - - PROCESSES - - - - - - - - - - - - - - - - - - */

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#configure(java.util.Map)
	 */
	@Override
	public Class<DefaultChronosParameters> getConfigurationBean() {
		return DefaultChronosParameters.class;
	}
	
	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setup()
	 */
	@Override
	public void setup(DefaultChronosParameters configuration) throws ChronosException {
		try {
			this.configuration = configuration;
			chronosSnapshooter.setup();
		} catch (SnapshooterException e) {
			throw new ChronosException("An error occurred on the snapshooter setup", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#start()
	 */
	@Override
	public void start() {
		currentDate = configuration.getStartDate() == null ? new Date() : configuration.getStartDate();
		chronosTimer.schedule(new ChronosTask(), 0l);
		clerkTimer.schedule(new ChronosClerkTask(), 0l);
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#stop()
	 */
	@Override
	public void stop() {
		chronosTimer.cancel();
		clerkTimer.cancel();
	}

	/*
	 * (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#getCurrentOrderedTasks()
	 */
	@Override
	public Map<Date, Future<Snapshot>> getCurrentOrderedTasks() {
		return this.currentTasks;
	}

	/* - - - - - - - - - - - - - - - - - INTERNAL METHODS - - - - - - - - - - - - - - - - - - */

	/**
	 * Sets the default chronos defaults
	 */
	protected void setChronosDefaults() {
		setConfiguration(new DefaultChronosParameters());
//		getConfiguration().setRate(DEFAULT_CHRONOS_RATE);
//		getConfiguration().setRateDeviation(DEFAULT_CHRONOS_RATE_DEVIATION);
//		getConfiguration().setParallelProcesses(DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER);
//		getConfiguration().setStartDate(Calendar.getInstance().getTime());

		this.chronosTimer = new Timer();
		this.clerkTimer = new Timer();
		this.chronosRandom = new Random();
		this.currentTasks = new HashMap<Date, Future<Snapshot>>();
		this.executor = Executors.newFixedThreadPool(DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER);
	}

	/**
	 * The timer task method for this chronos
	 * 
	 * @see java.util.TimerTask#run()
	 */
	protected void runChronosTimeTask() {
		long deviatedDelay;

		Future<Snapshot> res = executor.submit(new ChronosSnapshotTask());

		recordTask(currentDate, res);

		deviatedDelay = getDeviatedDelay(getConfiguration().getRate(), getConfiguration().getRateDeviation());
		currentDate = new Date(currentDate.getTime() + deviatedDelay);
		chronosTimer.schedule(new ChronosTask(), deviatedDelay);
	}

	/**
	 * The timer task method for this chronos clerk
	 * 
	 * @see java.util.TimerTask#run()
	 */
	protected void runClerkTimeTask() {
		long delay = Double.valueOf(Math.random() * 100).longValue();
		System.out.println("Running clerk" +  delay);
		clerkTimer.schedule(new ChronosClerkTask(), delay);
	}

	/**
	 * Snapshot task
	 * 
	 * @return The snapshot result
	 */
	public Snapshot runChronosSnapshotTask() {
		try {
			return chronosSnapshooter.shoot(currentDate);
		} catch (Exception e) {
			e.printStackTrace();
			return DefaultSnapshot.NOK;
		}
	}

	/**
	 * Records the task invoice
	 * 
	 * @param taskDate task date
	 * @param taskFutureResult task future result
	 */
	protected void recordTask(Date taskDate, Future<Snapshot> taskFutureResult) {
		/* DEBUG STUFF */
		double ratio;
		int done;
		if (!currentTasks.isEmpty()) {
			done = 0;
			for (Entry<Date, Future<Snapshot>> entries : currentTasks.entrySet()) {
				if (entries.getValue().isDone()) {
					done++;
				}
			}
			ratio = (Integer.valueOf(done).doubleValue() / currentTasks.size());
			System.out.println("Rate: " + ((1.0 / (getConfiguration().getRate() / 1000.0)) * ratio) + " processed per second (" + (1.0 / (getConfiguration().getRate() / 1000.0)) + ")");
		}
		currentTasks.put(taskDate, taskFutureResult);
	}

	/* - - - - - - - - - - - - - - - - - HELPER METHODS - - - - - - - - - - - - - - - - - - */

	/**
	 * Gets the delay according to the rate and deviation
	 * 
	 * @param rate the current rate
	 * @param rateDeviation the rate deviation
	 * @return The delay with deviation according to <code>rate</code> and <code>rateDeviation</code>
	 */
	private Long getDeviatedDelay(Double rate, Double rateDeviation) {
		double rand = chronosRandom.nextDouble();
		return Double.valueOf(rate - (2 * rateDeviation) + Double.valueOf(rand * rateDeviation).longValue()).longValue();
	}
}
