/**
 * 
 */
package brewerycontrol.monitor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import brewery.ConsoleCommand;
import brewery.ConsoleReply;
import brewery.PID;
import brewery.SensorReply;
import brewery.ui.monitor.ConsoleParser;
import brewery.ui.monitor.ConsoleParserEventListener;

/**
 * @author nguba
 * 
 */
public class ConsoleParserTest implements ConsoleParserEventListener {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	ConsoleParser parser;

	ConsoleCommand cmdResult;

	ConsoleReply reply;

	@Override
	public void onCommand(final ConsoleCommand command) {
		cmdResult = command;
		System.out.println(command);
	}

	@Override
	public void onSensorReply(final SensorReply reply) {
		this.reply = reply;
		System.out.println(reply);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ConsoleParser();
		parser.addListener(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCommandNoArgs() {
		final String cmd = "[sensor]";
		parser.parse(cmd);
		Assert.assertEquals("sensor", cmdResult.getName());
	}

	@Test
	public void testCommandWithArgs_NAME_CORRECT() {
		final String cmd = "[setpoint 22.00]";
		parser.parse(cmd);
		Assert.assertEquals("setpoint", cmdResult.getName());
	}

	@Test
	public void testCommandWithArgs_VALUE_CORRECT() {
		final String cmd = "[setpoint 22.00]";
		parser.parse(cmd);
		Assert.assertEquals("22.00", cmdResult.getValue());
	}

	@Test
	public void testParseSuccessiveCommands() {
		final String cmd = "[setpoint 22.00]\n[sensor]";
		parser.parse(cmd);
		Assert.assertNotNull(cmdResult);
	}

	@Test
	public void testParseSuccessiveCommandsAndReply() {
		final String cmd = "[setpoint 22.00]\n[sensor]\n[@sensor ABCD 33.00]";
		parser.parse(cmd);
		Assert.assertNotNull(cmdResult);
		Assert.assertEquals(Double.valueOf("33.00").doubleValue(),
				((SensorReply) reply).getTemperature(), 0);
	}

	@Test
	public void testReply() {
		final String cmd = "[@sensor AEDDE 22.00]";
		parser.parse(cmd);
		Assert.assertEquals(Double.valueOf("22.00").doubleValue(),
				((SensorReply) reply).getTemperature(), 0);
	}

	@Test
	public void testPIDReply() {
		final String cmd = "[@pid 111.00 222.00 333.00]";
		parser.parse(cmd);
		System.out.println(reply);
	}
	@Override
	public void onInput(String cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPIDReply(PID pid) {
		reply = pid;
	}
}
