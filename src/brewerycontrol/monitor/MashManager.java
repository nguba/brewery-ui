/**
 * 
 */
package brewerycontrol.monitor;

import java.io.IOException;
import java.util.Iterator;

import brewery.MashSchedule;
import brewery.MashStep;

/**
 * Handles the scheduling of mash temperatures according to a given schedule.
 * 
 * @author nguba
 * 
 */
public class MashManager {

	private MashSchedule schedule;
	Iterator<MashStep> iterator;
	MashStep step = null;
	long timer;
	long startTime;
	private MashManagerEventListener listener;

	/**
	 * the listener is mandatory otherwise the state machine won't work
	 * @param listener
	 */
	public MashManager(MashManagerEventListener listener) {
		super();
		this.listener = listener;
	}

	private enum State {
		START, LOAD, COMPLETE, RISE, REST;
	}

	private State state = State.START;

	/**
	 * @return the schedule
	 */
	public MashSchedule getSchedule() {
		return schedule;
	}

	/**
	 * 
	 * @param schedule
	 * @throws IOException
	 */
	public void start(MashSchedule schedule) throws IOException {
		this.schedule = schedule;
		if (schedule == null)
			throw new IOException(
					"Schedule cannot be null, set the schedule first");
		state = State.START;
		iterator = schedule.getSteps().iterator();
	}

	/**
	 * 
	 * @return true if the mash schedule has completed
	 */
	public boolean isComplete() {
		return state == State.COMPLETE;
	}

	public void setTemperature(double temp) {
		long now = System.currentTimeMillis();
		switch (state) {
		case START:
			state = State.LOAD;
			startTime = now;
			break;
		case LOAD:
			timer = now;
			if (iterator.hasNext()) {
				step = iterator.next();
				if (listener != null)
					listener.newSetpointEvent(step);
				state = State.RISE;
			} else {
				state = State.COMPLETE;
			}
			break;
		case RISE:
			if (temp >= step.getTemperature()) {
				step.setRiseTime(now - timer);
				timer = now;
				state = State.REST;
				if (listener != null)
					listener.setpointReachedEvent(step);
			}
			break;
		case COMPLETE:
			step.setRiseTime(now - timer);
			long totalTime = now - startTime;
			schedule.setTotalTime(totalTime);
			if (listener != null)
				listener.scheduleCompleteEvent(schedule);
			break;
		case REST:
			long lapsed = now - timer;
			// System.out.println("lapsed " + lapsed + "/" + step.getPause());
			if (lapsed >= step.getPause()) {
				if(listener != null) {
					listener.stepCompleteEvent(step);
				}
				state = State.LOAD;
			}
			break;
		default:
			break;
		}
	}

}
