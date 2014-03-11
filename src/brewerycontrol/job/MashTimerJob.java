/**
 * 
 */
package brewerycontrol.job;

import gnu.io.CommPort;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.custom.CLabel;

/**
 * @author nguba_000
 * 
 */
public final class MashTimerJob extends Job {
	public static final int DELAY = 1000;
	public static final String NAME = "job/mash/timer";
	
	private final UISynchronize sync;
	private final CommPort serialPort;
	private final Calendar calendar;
	private final CLabel label;
	private final SimpleDateFormat dateFormat;
	private Date startDate;

	/**
	 * @param name
	 */
	public MashTimerJob(UISynchronize sync, CommPort serialPort,
			Calendar calendar, CLabel label) {
		super(NAME);
		this.sync = sync;
		this.serialPort = serialPort;
		this.calendar = calendar;
		this.label = label;
		dateFormat = new SimpleDateFormat("KK:mm:ss");
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
				try {
					serialPort.setOutputBufferSize(1024);
					serialPort.getOutputStream().write("[sensor]".getBytes());
					serialPort.getOutputStream().flush();
				} catch (final IOException e) {
					e.printStackTrace();
				}
				calendar.setTimeInMillis(System.currentTimeMillis()
						- startDate.getTime());
				calendar.add(Calendar.HOUR, -1);
				final String format = dateFormat.format(calendar.getTime());
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
	public void start() {
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
}
