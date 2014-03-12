/**
 * 
 */
package brewerycontrol.monitor;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import brewery.BreweryFactory;
import brewery.MashSchedule;
import brewery.MashStep;

/**
 * @author nguba
 * 
 */
public class MashManagerTest implements MashManagerEventListener {

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

	private MashSchedule schedule;
	private MashManager manager;
	private boolean increaseTemperature;
	private boolean scheduleComplete;

	@Override
	public void newSetpointEvent(final MashStep step) {
		System.out.println("NEW SETPOINT: " + step);
		increaseTemperature = true;
	}

	@Override
	public void scheduleCompleteEvent(final MashSchedule schedule) {
		System.out.println("COMPLETE: " + schedule);
		scheduleComplete = true;
	}

	@Override
	public void setpointReachedEvent(final MashStep step) {
		System.out.println("SETPOINT REACHED: " + step);
		increaseTemperature = false;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = new MashManager(this);
		schedule = BreweryFactory.eINSTANCE.createMashSchedule();
		schedule.setName("Test Schedule");
		final MashStep a = BreweryFactory.eINSTANCE.createMashStep();
		a.setDescription("first");
		a.setPause(3000);
		a.setTemperature(5);

		final MashStep b = BreweryFactory.eINSTANCE.createMashStep();
		b.setDescription("second");
		b.setPause(3000);
		b.setTemperature(10);

		final MashStep c = BreweryFactory.eINSTANCE.createMashStep();
		c.setDescription("third");
		c.setPause(5000);
		c.setTemperature(15);

		schedule.getSteps().add(a);
		schedule.getSteps().add(b);
		schedule.getSteps().add(c);
	}

	@Override
	public void stepCompleteEvent(MashStep step) {
		// TODO Auto-generated method stub

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetTemperature() throws Exception {
		manager.start(schedule);
		scheduleComplete = false;
		double temperature = 0;
		while (scheduleComplete == false) {
			Thread.sleep(1000);
			if (increaseTemperature) {
				temperature++;
			}
			System.out.println(temperature);
			manager.setTemperature(temperature);
		}
	}

	@Test(expected = IOException.class)
	public void testStartWithoutSchedule() throws IOException {
		manager.start(null);
	}
}
