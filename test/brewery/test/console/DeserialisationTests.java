package brewery.test.console;

import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.InputSource;

public class DeserialisationTests implements ConsoleEventListener {

	private  ConsoleReader reader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		reader = new ConsoleReader(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testErrorMessage() throws Exception  {
		String xml = "<error>Unable to find address for Device 0</error>";
		Source src = new SAXSource(reader, new InputSource(
				new StringReader(xml)));
		Result res = new StreamResult(System.out);
		TransformerFactory.newInstance().newTransformer().transform(src, res);
	}

	@Override
	public void errorEvent(String message) {
		System.out.println(message);
	}

}
