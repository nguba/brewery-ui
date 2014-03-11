/**
 * 
 */
package brewery.test.serialization;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class MashXMLSerializationTest {

	private static ResourceSet resSet;
	private MashSchedule schedule;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BreweryFactory.eINSTANCE.eClass();
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("mash", new XMIResourceFactoryImpl());
		resSet = new ResourceSetImpl();
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
		MashStep first = BreweryFactory.eINSTANCE.createMashStep();
		first.setDescription("First");
		first.setPause(10);
		first.setTemperature(40);
		
		MashStep second = BreweryFactory.eINSTANCE.createMashStep();
		second.setDescription("Second");
		second.setPause(10);
		second.setTemperature(20);
		
		MashStep third = BreweryFactory.eINSTANCE.createMashStep();
		third.setDescription("Third");
		third.setPause(90);
		third.setTemperature(66);
		
		schedule = BreweryFactory.eINSTANCE.createMashSchedule();
		schedule.setName("default schedule");
		schedule.getSteps().add(first);
		schedule.getSteps().add(second);
		schedule.getSteps().add(third);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddOneStep() {
		MashStep step = BreweryFactory.eINSTANCE.createMashStep();
		step.setDescription("First");
		step.setPause(10);
		step.setTemperature(40);
		
		MashSchedule schedule = BreweryFactory.eINSTANCE.createMashSchedule();
		schedule.getSteps().add(step);
		schedule.setName("first schedule");
		System.out.println(schedule.getSteps());
	}
	

	@Test
	public void testLoader() throws Exception {
		final URI uri = URI.createURI("first-schedule.mash");
		System.out.println(uri);
		Resource resource = resSet.createResource(uri);
		resource.getContents().add(schedule);
		resource.save(Collections.EMPTY_MAP);
	
		MashSchedule s = null;
		if (uri.isFile()) {
			final File f = new File(uri.path());
			if (f.exists()) {
				resource = resSet.getResource(uri, true);
				final EObject eObject = resource.getContents().get(0);
				if (eObject != null) {
					s = (MashSchedule) eObject;
				}
			}
		}
		Assert.assertArrayEquals(s.getSteps().toArray(), s.getSteps().toArray());
	}
	
	
}
