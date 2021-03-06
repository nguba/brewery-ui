package brewery.ui.job;

import java.util.Calendar;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import brewery.Sensor;
import brewery.ui.parts.MashPart;

public final class SensorEventHandler extends Job {
	/**
	 * 
	 */
	private final MashPart mashPart;
	private final Sensor sensor;
	private final Calendar calendar = Calendar.getInstance();

	public SensorEventHandler(final MashPart mashPart, final String name,
			final Sensor sensor) {
		super(name);
		this.mashPart = mashPart;
		this.sensor = sensor;
	}

	/**
	 * 
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		mashPart.getSync().asyncExec(new Runnable() {
			/**
			 * 
			 */
			@Override
			public void run() {
				final double value = sensor.getValue();
				mashPart.getGaugeFigure().setValue(value);
				mashPart.getProvider().setCurrentYData(value);
				MashTimerJob timerJob = mashPart.getTimerJob();
				if (timerJob != null)
					timerJob.setCurrentTemp(value);
				calendar.add(Calendar.HOUR, 1);
				final long newValue = calendar.getTimeInMillis() / 1000 / 60;
				mashPart.getProvider().setCurrentXData(newValue);
			}
		});
		return Status.OK_STATUS;
	}
}