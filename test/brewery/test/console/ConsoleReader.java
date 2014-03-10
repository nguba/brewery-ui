package brewery.test.console;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * 
 * @author nguba_000
 * 
 */
public class ConsoleReader extends XMLFilterImpl {
	private String tag;
	private StringBuilder buf = new StringBuilder();
	private ConsoleEventListener listener;
	
	public enum State {
		ERROR;
	}

	private State state;

	public ConsoleReader(ConsoleEventListener listener) throws SAXException {
		super(XMLReaderFactory.createXMLReader());
		this.listener = listener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		tag = qName;
		switch (tag) {
		case "error":
			state = State.ERROR;
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (state) {
		case ERROR:
			listener.errorEvent(buf.toString());
			buf = new StringBuilder();
			break;
		}
		tag = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		buf.append(ch, start, length);
	}
}
