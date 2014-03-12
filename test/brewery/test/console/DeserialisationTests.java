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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private ConsoleReader reader;

	@Override
	public void errorEvent(final String message) {
		System.out.println(message);
	}

	@Before
	public void setUp() throws Exception {
		reader = new ConsoleReader(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testErrorMessage() throws Exception {
		final String xml = "<error>Unable to find address for Device 0</error>";
		final Source src = new SAXSource(reader, new InputSource(
				new StringReader(xml)));
		final Result res = new StreamResult(System.out);
		TransformerFactory.newInstance().newTransformer().transform(src, res);
	}

}
