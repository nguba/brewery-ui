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
	private enum State {
		READY, TOKEN, REPLY, COMMAND, COMMAND_ARG;
	}

	private final ConsoleParserEventListener listener;

	private State state = State.READY;

	private final StringBuilder buf = new StringBuilder();

	public ConsoleParser(final ConsoleParserEventListener listener) {
		super();
		this.listener = listener;
	}

	public void parse(final String cmd) {
		// System.out.println(cmd);
		for (int i = 0, len = cmd.length(); i < len; i++) {
			final char c = cmd.charAt(i);

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
					final int indexOf = buf.indexOf(" ", 0);
					if (indexOf >= 0) {
						final String value = buf.substring(indexOf);
						arg = value.trim();
						buf.delete(indexOf, buf.length());
					}
					final String name = buf.toString();
					switch (name) {
					case "sensor":
						final SensorReply reply = BreweryFactory.eINSTANCE
								.createSensorReply();
						reply.setName(name);
						if (arg != null) {
							reply.setTemperature(Double.parseDouble(arg));
						}
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

					final ConsoleCommand command = BreweryFactory.eINSTANCE
							.createConsoleCommand();
					final int indexOf = buf.indexOf(" ", 0);
					if (indexOf >= 0) {
						final String arg = buf.substring(indexOf);
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
