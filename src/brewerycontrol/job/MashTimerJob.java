/**
 * 
 */
package brewerycontrol.job;

import gnu.io.CommPort;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.custom.CLabel;

import brewery.MashStep;
import brewerycontrol.parts.MashPart;

/**
 * @author nguba_000
 * 
 */
public final class MashTimerJob extends Job {
	public static final int DELAY = 1000;
	public static final String NAME = "job/mash/timer";

	@Inject
	private final UISynchronize sync;
	private final CommPort serialPort;
	private final Calendar calendar;
	private final CLabel label;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("KK:mm:ss");
	private Date startDate;
	private CheckboxTableViewer steps;
	private EObjectContainmentEList<MashStep> schedule;
	private double currentTemp;
	private Iterator<MashStep> scheduleIterator;
	private MashStep step;
	
	/**
	 * 
	 * @param mashPart
	 */
	public MashTimerJob(MashPart mashPart) {
		super(NAME);
		this.sync = mashPart.getSync();
		this.serialPort = mashPart.getSerialPort();
		this.calendar = mashPart.getCalendar();
		this.label = mashPart.getTimerLabel();
		steps = mashPart.getMashSteps();
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
	protected IStatus run(IProgressMonitor monitor) {
		sync.asyncExec(new Runnable() {
			@Override
			public void run() {
				// load the next step
				if (scheduleIterator.hasNext() && step.isComplete()) {
					step = scheduleIterator.next();
					System.out.println(step);
				}
				calendar.setTimeInMillis(
						System.currentTimeMillis() - startDate.getTime());
				calendar.add(Calendar.HOUR, -1);
				final String format = dateFormat.format(calendar.getTime());

				try {
					serialPort.setOutputBufferSize(1024);
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("[setpoint ");
					stringBuilder.append(new Double(step.getTemperature()));
					stringBuilder.append("]");
					OutputStream outputStream = serialPort.getOutputStream();
					outputStream.write(stringBuilder.toString().getBytes());
					outputStream.flush();
					outputStream.write("[sensor]".getBytes());
					outputStream.flush();
				} catch (final IOException e) {
					e.printStackTrace();
				}	
				if (label.isDisposed() == false) {
					label.setText(format);
					schedule(DELAY);
				}
			}
		});
		return Status.OK_STATUS;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void start() {
		schedule = (EObjectContainmentEList<MashStep>) steps.getInput();
		scheduleIterator = schedule.iterator();
		// load the first step to begin the mash
		step = scheduleIterator.next();
		startDate = new Date();
		schedule(DELAY);
	}

	/**
	 * 
	 */
	public void stop() {
		label.setText("00:00:00");
		cancel();
	}

	public double getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}
}
