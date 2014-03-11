/**
 * 
 */
package brewerycontrol.monitor;

import brewery.BreweryFactory;
import brewery.ConsoleCommand;
import brewery.SensorReply;

/**
 * @author nguba
 * 
 */
public final class ConsoleParser {
	private ConsoleParserEventListener listener;

	public ConsoleParser(ConsoleParserEventListener listener) {
		super();
		this.listener = listener;
	}

	private enum State {
		READY, TOKEN, REPLY, COMMAND, COMMAND_ARG;
	}

	private State state = State.READY;
	private StringBuilder buf = new StringBuilder();

	public void parse(String cmd) {
		//System.out.println(cmd);
		for (int i = 0, len = cmd.length(); i < len; i++) {
			char c = cmd.charAt(i);
		
			switch (state) {
			case READY:
				if (c == '[') {
					state = State.TOKEN;
				}
				break;
			case TOKEN:
				if (c == '@') {
					state = State.REPLY;
				} else {
					buf.append(c);
					state = State.COMMAND;
				}
				break;
			case REPLY:
				if (c == ']') {
					state = State.READY;
					String arg = null;
					int indexOf = buf.indexOf(" ", 0);
					if(indexOf >= 0) {
						String value = buf.substring(indexOf);
						arg = value.trim();
						buf.delete(indexOf, buf.length());
					}
					String name = buf.toString();
					switch(name) {
					case "sensor":
						SensorReply reply = BreweryFactory.eINSTANCE.createSensorReply();
						reply.setName(name);
						if(arg != null)
						reply.setTemperature(Double.parseDouble(arg));
						listener.onSensorReply(reply);
						break;
					}
					buf.delete(0, buf.length());
				} else {
					buf.append(c);
				}
				break;
			case COMMAND:
				if (c == ']') {
					state = State.READY;
					
					ConsoleCommand command = BreweryFactory.eINSTANCE
							.createConsoleCommand();
					int indexOf = buf.indexOf(" ", 0);
					if(indexOf >= 0) {
						String arg = buf.substring(indexOf);
						command.setValue(arg.trim());
						buf.delete(indexOf, buf.length());
					}
					command.setName(buf.toString());
					buf.delete(0, buf.length());
					listener.onCommand(command);
				} else {
					buf.append(c);
				}
				break;
			default:
				System.out.println(c);
			}
		}
	}

}
