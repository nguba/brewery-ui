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
import brewery.SensorReply;

/**
 * @author nguba
 *
 */
public class ConsoleParserTest implements ConsoleParserEventListener {

	ConsoleParser parser;
	ConsoleCommand cmdResult;
	ConsoleReply reply;
	
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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ConsoleParser(this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCommandNoArgs() {
		String cmd = "[sensor]";
		parser.parse(cmd);
		Assert.assertEquals("sensor", cmdResult.getName());
	}
	
	@Test
	public void testCommandWithArgs_NAME_CORRECT() {
		String cmd = "[setpoint 22.00]";
		parser.parse(cmd);
		Assert.assertEquals("setpoint", cmdResult.getName());
	}
	
	@Test
	public void testCommandWithArgs_VALUE_CORRECT() {
		String cmd = "[setpoint 22.00]";
		parser.parse(cmd);
		Assert.assertEquals("22.00", cmdResult.getValue());
	}
	
	@Test
	public void testReply() {
		String cmd = "[@sensor 22.00]";
		parser.parse(cmd);
		Assert.assertEquals(Double.valueOf("22.00").doubleValue(), ((SensorReply)reply).getTemperature(), 0);
	}

	@Override
	public void onCommand(ConsoleCommand command) {
		cmdResult = command;
		System.out.println(command);
	}

	@Override
	public void onSensorReply(SensorReply reply) {
		this.reply = reply;
		System.out.println(reply);
	}

	@Test
	public void testParseSuccessiveCommands() {
		String cmd = "[setpoint 22.00]\n[sensor]";
		parser.parse(cmd);
		Assert.assertNotNull(cmdResult);
	}
	
	@Test
	public void testParseSuccessiveCommandsAndReply() {
		String cmd = "[setpoint 22.00]\n[sensor]\n[@sensor 33.00]";
		parser.parse(cmd);
		Assert.assertNotNull(cmdResult);
		Assert.assertEquals(Double.valueOf("33.00").doubleValue(), ((SensorReply)reply).getTemperature(), 0);
	}
}
