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
import pt.caughtonnet.tracker.api.chronos.ChronosMode;
import pt.caughtonnet.tracker.api.model.Snapshot;
import pt.caughtonnet.tracker.api.snapshooter.Snapshooter;
import pt.caughtonnet.tracker.impl.model.DefaultSnapshot;

/**
 * The default chronos
 * 
 * @author CaughtOnNet
 */
public class DefaultChronos implements Chronos {
	
	class ChronosTask extends TimerTask {
		public void run() {
			DefaultChronos chronos = DefaultChronos.this;
			chronos.runChronosTask();
		}
	}
	
	class ChronosSnapshotTask implements Callable<Snapshot> {
		public Snapshot call() throws Exception {
			return DefaultChronos.this.runChronosSnapshotTask();
		}
	} 
	
	/* - - - - - - - - - - - - - - - - *-*-* STATICS *-*-* - - - - - - - - - - - - - - - - -  */

	/**
	 * The default chronos default rate
	 */
	public static final long DEFAULT_CHRONOS_RATE = 1000l;
	
	/**
	 * The default chronos mode
	 */
	public static final ChronosMode DEFAULT_CHRONOS_MODE = ChronosMode.LIVE;
	
	/**
	 * The default chronos rate deviation
	 */
	public static final long DEFAULT_CHRONOS_RATE_DEVIATION = 0l;
	
	/**
	 * The default chronos parallel process number
	 */
	public static final int DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER = 20;
	
	
	/* - - - - - - - - - - - - - - - - *-*-* PARAMETERS *-*-* - - - - - - - - - - - - - - - - -  */
	
	/**
	 * The rate of snapshots for this chronos
	 */
	private long rate;
	
	/**
	 * The chronos snapshooting mode
	 */
	private ChronosMode chronosMode;
	
	/**
	 * The start date with which the snapshots will be asked (not used if mode is ChronosMode.LIVE)
	 */
	private Date startDate;
	
	/**
	 * Maximum rate deviation
	 */
	private long maxRateDeviation;
	
	/**
	 * Number of parallel process allowed
	 */
	private int parallelProcessNumber;
	
	/**
	 * The the chronos snapshooter
	 */
	private Snapshooter chronosSnapshooter;
	
	/* - - - - - - - - - - - - - - - - - - INTERNALS - - - - - - - - - - - - - - - - - -  */
	
	/**
	 * The date for the incremental snapshooting process
	 */
	protected Date currentDate;

	/**
	 * The chronos timer to control the rate of snapshots
	 */
	protected Timer chronosTimer;

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


	/* - - - - - - - - - - - - - - - - *-*-* CONSTRUCTORS *-*-* - - - - - - - - - - - - - - - - - -  */
	
	/**
	 *  The default chronos, will set the defautls
	 */
	public DefaultChronos() {
		setChronosDefaults();
	}
	
	
	/* - - - - - - - - - - - - - - - - *-*-* METHODS *-*-* - - - - - - - - - - - - - - - - - -  */
	
	/* - - - - - - - - - - - - - - - - - GETTERS-SETTERS- - - - - - - - - - - - - - - - - -  */

	/**
	 * Gets the rate
	 * @return the rate
	 */
	public long getRate() {
		return rate;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setRate(long)
	 */
	@Override
	public void setRate(long rate) {
		this.rate = rate;
	}
	
	/**
	 * Gets the chronosMode
	 * @return the chronosMode
	 */
	public ChronosMode getChronosMode() {
		return chronosMode;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setChronosMode(pt.caughtonnet.tracker.api.chronos.ChronosMode)
	 */
	@Override
	public void setChronosMode(ChronosMode chronosMode) {
		this.chronosMode = chronosMode;
	}
	
	/**
	 * Gets the startDate
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setStartDate(java.util.Date)
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Gets the maxRateDeviation
	 * @return the maxRateDeviation
	 */
	public long getMaxRateDeviation() {
		return maxRateDeviation;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setMaxRateDeviation(long)
	 */
	@Override
	public void setMaxRateDeviation(long maxRateDeviation) {
		this.maxRateDeviation = maxRateDeviation;
	}
	
	/**
	 * Gets the parallelProcessNumber
	 * @return the parallelProcessNumber
	 */
	public int getParallelProcessNumber() {
		return parallelProcessNumber;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setParallelProcessNumber(int)
	 */
	@Override
	public void setParallelProcessNumber(int parallelProcessNumber) {
		this.parallelProcessNumber = parallelProcessNumber;
	}
	
	/**
	 * Gets the chronosSnapshooter
	 * @return the chronosSnapshooter
	 */
	public Snapshooter getChronosSnapshooter() {
		return chronosSnapshooter;
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#setChronosSnapshooter(pt.caughtonnet.tracker.api.snapshooter.Snapshooter)
	 */
	@Override
	public void setChronosSnapshooter(Snapshooter chronosSnapshooter) {
		this.chronosSnapshooter = chronosSnapshooter;
	}
	
	/* - - - - - - - - - - - - - - - - - PROCESSES - - - - - - - - - - - - - - - - - -  */

	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#start()
	 */
	@Override
	public void start() {
		if (ChronosMode.LIVE.equals(getChronosMode())) {
			currentDate = new Date();
		} else {
			currentDate = startDate;	
		}
		chronosTimer.schedule(new ChronosTask(), 0l);
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#stop()
	 */
	@Override
	public void stop() {
		chronosTimer.cancel();
	}
	
	/* (non-Javadoc)
	 * @see pt.caughtonnet.tracker.api.chronos.Chronos#getCurrentOrderedTasks()
	 */
	@Override
	public Map<Date, Future<Snapshot>> getCurrentOrderedTasks() {
		return this.currentTasks;
	}
	
	
	/* - - - - - - - - - - - - - - - - - INTERNAL METHODS - - - - - - - - - - - - - - - - - -  */
	
	/**
	 * Sets the default chronos defaults
	 */
	protected void setChronosDefaults() {
		setRate(DEFAULT_CHRONOS_RATE);
		setChronosMode(DEFAULT_CHRONOS_MODE);
		setMaxRateDeviation(DEFAULT_CHRONOS_RATE_DEVIATION);
		setParallelProcessNumber(DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER);
		setStartDate(Calendar.getInstance().getTime());
		
		this.chronosTimer = new Timer();
		this.chronosRandom = new Random();
		this.currentTasks = new HashMap<Date, Future<Snapshot>>();
		executor = Executors.newFixedThreadPool(DEFAULT_CHRONOS_PARALLEL_PROCESS_NUMBER);
	}
	
	/**
	 * The timer task method for this chronos
	 * @see java.util.TimerTask#run()
	 */
	protected void runChronosTask() {
		long deviatedDelay;
		
		Future<Snapshot> res = executor.submit(new ChronosSnapshotTask());
		
		recordTask(currentDate, res);
		
		deviatedDelay = getDeviatedDelay(getRate(), getMaxRateDeviation());
		currentDate = new Date(currentDate.getTime() + deviatedDelay);
		chronosTimer.schedule(new ChronosTask(), deviatedDelay);
	}
	
	
	/**
	 * Snapshot task
	 * @return The snapshot result
	 */
	public Snapshot runChronosSnapshotTask() {
		try {
			if (ChronosMode.LIVE.equals(getChronosMode())) {
				return chronosSnapshooter.shoot();
			} else {
				return chronosSnapshooter.shoot(currentDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return DefaultSnapshot.NOK;
		}
	}
	
	/**
	 * Records the task invoice
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
			System.out.println("Rate: " + ((1.0 / (getRate() / 1000.0)) * ratio) + " processed per second (" + (1.0 / (getRate() / 1000.0)) + ")");
		}
		/**/
		
		currentTasks.put(taskDate, taskFutureResult);
		
	}
	

	/* - - - - - - - - - - - - - - - - - HELPER METHODS - - - - - - - - - - - - - - - - - -  */
	


	/**
	 * Gets the delay according to the rate and deviation
	 * 
	 * @param rate the current rate
	 * @param rateDeviation the rate deviation
	 * @return The delay with deviation according to <code>rate</code> and <code>rateDeviation</code>
	 */
	private long getDeviatedDelay(long rate, long rateDeviation) {
		double rand = chronosRandom.nextDouble();
		return rate - (2 * rateDeviation) + Double.valueOf(rand * rateDeviation).longValue();
	}
}
