/**
 * 
 */
package brewery.ui.monitor;

import brewery.MashSchedule;
import brewery.MashStep;

/**
 * @author nguba
 * 
 */
public interface MashManagerEventListener {
	/**
	 * called when a new setpoint (target temperature) is to be set
	 */
	public void newSetpointEvent(MashStep step);

	/**
	 * called when the schedule has completed
	 */
	public void scheduleCompleteEvent(MashSchedule schedule);

	/**
	 * called when the setpoint of that step has been reached
	 * 
	 * @param step
	 */
	public void setpointReachedEvent(MashStep step);

	/**
	 * fired when a step has completed
	 * 
	 * @param step
	 */
	public void stepCompleteEvent(MashStep step);
}
