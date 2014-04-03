/**
 * 
 */
package brewery.ui;

/**
 * @author nguba_000
 * 
 */
public final class BreweryEventTopic {

	public static final String MASH_COMMAND = "mash/command";
	public static final String MASH_SCHEDULE = "mash/schedule";
	public static final String SENSOR = "sensor";
	public static final String MASH_STATUS = "mash/status";
	public static final String INPUT = "input";
	public static final String MASH_SETPOINT_REACHED = "mash/setpoint/reached";
	public static final String MASH_SETPOINT_NEW = "mash/setpoint/new";
	public static final String MASH_STEP_COMPLETE = "mash/setp/complete";
	public static final String PID = "pid";
	public static final String MASH_STEP_MODIFIED = "mash/step/mofified";

	/**
	 * 
	 */
	private BreweryEventTopic() {
	}

}
