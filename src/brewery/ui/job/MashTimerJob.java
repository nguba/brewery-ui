/**
 * 
 */
package brewery.ui.job;

import gnu.io.CommPort;

import java.io.IOException;
import java.io.OutputStream;
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
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TableItem;

import brewery.MashSchedule;
import brewery.MashStep;
import brewery.ui.BreweryEventTopic;
import brewery.ui.monitor.MashManager;
import brewery.ui.monitor.MashManagerEventListener;
import brewery.ui.parts.MashPart;
import brewery.ui.parts.MashPartCommand;

/**
 * @author nguba_000
 * 
 */
public final class MashTimerJob extends Job implements MashManagerEventListener {
	public static final int DELAY = 1000;
	public static final String NAME = "job/mash/timer";

	@Inject
	private final UISynchronize sync;
	private final CommPort serialPort;
	private final Calendar calendar;
	private final CLabel label;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("KK:mm:ss");
	private Date startDate;
	private MashManager mashManager;
	private boolean shouldRun;
	private IEventBroker broker;
	private Logger logger;
	private CheckboxTableViewer scheduleTable;
	private ProgressBar progressBar;

	/**
	 * 
	 * @param mashPart
	 * @throws IOException
	 */
	public MashTimerJob(final MashPart mashPart) throws IOException {
		super(NAME);
		this.mashManager = new MashManager(this);
		sync = mashPart.getSync();
		serialPort = mashPart.getSerialPort();
		serialPort.setOutputBufferSize(1024);
		outputStream = serialPort.getOutputStream();
		calendar = mashPart.getCalendar();
		label = mashPart.getTimerLabel();
		broker = mashPart.getBroker();
		logger = mashPart.getLogger();
		scheduleTable = mashPart.getMashScheduleTable();
		progressBar = mashPart.getProgressBar();
	}

	/**
	 * @return the startDate
	 */
	public final Date getStartDate() {
		return startDate;
	}

	private OutputStream outputStream;

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
				// TODO refactor this into it's own job so we can decouple this
				try {
					outputStream.write("[sensor]".getBytes());
					outputStream.flush();
				} catch (final IOException e) {
					e.printStackTrace();
				}
				if (label.isDisposed() == false && shouldRun) {
					label.setText(format);
					schedule(DELAY);
				}
			}
		});
		return Status.OK_STATUS;
	}

	int steps = 0; 
	
	/**
	 * @param schedule
	 * 
	 */
	public void start(MashSchedule schedule) {
		try {
			mashManager.start(schedule); 
			progressBar.setMaximum(schedule.getSteps().size() * 2);
			shouldRun = true;
			startDate = new Date();
			schedule(DELAY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void stop() {
		label.setText("00:00:00");
		cancel();
	}

	@Override
	public void newSetpointEvent(MashStep step) {
		logger.info("SETPOINT " + step);
		//progressBar.setSelection(itemIndex + 1);
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[setpoint ");
		stringBuilder.append(new Double(step.getTemperature()));
		stringBuilder.append("]");
		try {
			outputStream.write(stringBuilder.toString().getBytes());
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void scheduleCompleteEvent(MashSchedule schedule) {
		logger.info("COMPLETE " + schedule);
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[setpoint ");
		stringBuilder.append(0);
		stringBuilder.append("]");
		try {
			outputStream.write(stringBuilder.toString().getBytes());
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		broker.send(BreweryEventTopic.MASH_COMMAND, MashPartCommand.STOP);
		shouldRun = false;
		cancel();
	}

	@Override
	public void setpointReachedEvent(MashStep step) {
		logger.info("SETPOINT REACHED " + step);
		progressBar.setSelection(++steps);
	}

	public void setCurrentTemp(double value) {
		mashManager.setTemperature(value);
	}

	int itemIndex = 0;

	@Override
	public void stepCompleteEvent(MashStep step) {
		logger.info("STEP COMPLETE " + step);
		progressBar.setSelection(++steps);
		TableItem item = scheduleTable.getTable().getItem(itemIndex);
		item.setChecked(true);
		itemIndex++;
	}
}
