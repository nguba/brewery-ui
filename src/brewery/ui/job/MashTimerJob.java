/**
 * 
 */
package brewery.ui.job;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UISynchronize;

import brewery.MashSchedule;
import brewery.MashStep;
import brewery.impl.ArduinoControllerImpl;
import brewery.ui.BreweryEventTopic;
import brewery.ui.monitor.MashManager;
import brewery.ui.monitor.MashManagerEventListener;
import brewery.ui.parts.MashPartCommand;

/**
 * @author nguba_000
 * 
 */
public final class MashTimerJob extends Job implements MashManagerEventListener {
	public static final int DELAY = 1000;
	public static final String NAME = "job/mash/timer";

	@Inject
	private UISynchronize sync;
	private Calendar calendar = Calendar.getInstance();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("KK:mm:ss");
	private Date startDate;
	private MashManager mashManager;
	private boolean shouldRun;
	@Inject
	private Logger logger;
	private ArduinoControllerImpl controller;
	private TimerEventListener listener;
	@Inject
	private IEventBroker broker;

	/**
	 * 
	 * @param mashPart
	 * @param controller
	 * @throws IOException
	 */
	public MashTimerJob(final TimerEventListener listener,
			ArduinoControllerImpl controller) throws IOException {
		super(NAME);
		this.listener = listener;
		this.controller = controller;
		this.mashManager = new MashManager(this);
	}

	/**
	 * @return the startDate
	 */
	public final Date getStartDate() {
		return startDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		sync.asyncExec(new Runnable() {
			@Override
			public void run() {
				calendar.setTimeInMillis(System.currentTimeMillis()
						- startDate.getTime());
				calendar.add(Calendar.HOUR, -1);
				final String format = dateFormat.format(calendar.getTime());
				try {
					controller.sendSensorCommand();
				} catch (final IOException e) {
					shouldRun = false;
					broker.send(BreweryEventTopic.INPUT, e.getMessage());
					e.printStackTrace();
				}
				if (shouldRun) {
					listener.timeUpdatedEvent(format);
					schedule(DELAY);
				}
			}
		});
		return Status.OK_STATUS;
	}

	/**
	 * @param schedule
	 * @throws IOException
	 * 
	 */
	public void start(MashSchedule schedule) throws IOException {
		mashManager.start(schedule);
		shouldRun = true;
		startDate = new Date();
		schedule(DELAY);
	}

	/**
	 * 
	 */
	public void stop() {
		cancel();
	}

	/**
	 * 
	 */
	@Override
	public void newSetpointEvent(MashStep step) {
		logger.info("NEW SETPOINT " + step);
		try {
			controller.sendSetpointCommand(step.getTemperature());
			broker.send(BreweryEventTopic.MASH_SETPOINT_NEW, step);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void scheduleCompleteEvent(MashSchedule schedule) {
		logger.info("SCHEDULE COMPLETE " + schedule);
		try {
			controller.sendSetpointCommand(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		broker.send(BreweryEventTopic.MASH_COMMAND, MashPartCommand.STOP);
		shouldRun = false;
		cancel();
	}

	/**
	 * 
	 */
	@Override
	public void setpointReachedEvent(MashStep step) {
		logger.info("SETPOINT REACHED " + step);
		broker.send(BreweryEventTopic.MASH_SETPOINT_REACHED, step);
	}

	/**
	 * 
	 * @param value
	 */
	public void setCurrentTemp(double value) {
		mashManager.setTemperature(value);
	}

	@Override
	public void stepCompleteEvent(MashStep step) {
		logger.info("STEP COMPLETE " + step);
		broker.send(BreweryEventTopic.MASH_STEP_COMPLETE, step);
	}
}
