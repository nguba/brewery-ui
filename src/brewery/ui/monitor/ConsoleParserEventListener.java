/**
 * 
 */
package brewery.ui.monitor;

import brewery.ConsoleCommand;
import brewery.PID;
import brewery.SensorReply;

/**
 * @author nguba
 * 
 */
public interface ConsoleParserEventListener {

	void onCommand(ConsoleCommand command);

	/**
	 * called when a reply from a sensor is detected
	 * 
	 * @param reply
	 */
	void onSensorReply(SensorReply reply);

	/**
	 * called when new input is parsed. useful for debugging.
	 * 
	 * @param cmd
	 */
	void onInput(String cmd);

	/**
	 * called when the PID settings of the heating element are requested
	 * 
	 * @param pid
	 */
	void onPIDReply(PID pid);

}
