/**
 * 
 */
package brewery.ui.monitor;

import brewery.ConsoleCommand;
import brewery.SensorReply;

/**
 * @author nguba
 * 
 */
public interface ConsoleParserEventListener {

	void onCommand(ConsoleCommand command);

	void onSensorReply(SensorReply reply);

}
