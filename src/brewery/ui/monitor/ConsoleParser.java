/**
 * 
 */
package brewery.ui.monitor;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import brewery.BreweryFactory;
import brewery.ConsoleCommand;
import brewery.PID;
import brewery.SensorReply;

/**
 * @author nguba
 * 
 */
public final class ConsoleParser {
	private enum State {
		READY, TOKEN, REPLY, COMMAND;
	}

	private List<ConsoleParserEventListener> listeners = new LinkedList<>();

	private State state = State.READY;

	private final StringBuilder buf = new StringBuilder();

	/**
	 * 
	 */
	public ConsoleParser() {
		super();
	}

	public void parse(final String cmd) {
		for (ConsoleParserEventListener listener : listeners)
			listener.onInput(cmd);
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
							StringTokenizer t = new StringTokenizer(arg);
							if(t.countTokens() == 2) {
							reply.setId(t.nextToken());
							reply.setTemperature(Double.parseDouble(t.nextToken()));
							}
							else {
								System.err.println("Wrong sensor token count: " + cmd);
							}
						}
						for (ConsoleParserEventListener listener : listeners)
							listener.onSensorReply(reply);
						break;
					case "pid":
						if(arg != null) {
							StringTokenizer t = new StringTokenizer(arg);
							if(t.countTokens() == 3) {
								double kP = Double.parseDouble(t.nextToken());
								double kI = Double.parseDouble(t.nextToken());
								double kD = Double.parseDouble(t.nextToken());
								final PID pid = BreweryFactory.eINSTANCE.createPID();
								pid.setP((int) kP);
								pid.setI((int) kI);
								pid.setD((int) kD);
								
								for (ConsoleParserEventListener listener : listeners)
									listener.onPIDReply(pid);
							}
							else {
								System.err.println("Wrong sensor token count: " + cmd);
							}
						}
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
					for (ConsoleParserEventListener listener : listeners)
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

	public void addListener(ConsoleParserEventListener listener) {
		if(listeners != null) {
			listeners.add(listener);
		}
	}

}
