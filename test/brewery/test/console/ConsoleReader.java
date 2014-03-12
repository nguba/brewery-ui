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
	public enum State {
		ERROR;
	}

	private String tag;
	private StringBuilder buf = new StringBuilder();

	private final ConsoleEventListener listener;

	private State state;

	public ConsoleReader(final ConsoleEventListener listener)
			throws SAXException {
		super(XMLReaderFactory.createXMLReader());
		this.listener = listener;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#characters(char[], int, int)
	 */
	@Override
	public void characters(final char[] ch, final int start, final int length)
			throws SAXException {
		buf.append(ch, start, length);
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
	 * @see org.xml.sax.helpers.XMLFilterImpl#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(final String uri, final String localName,
			final String qName) throws SAXException {
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
	 * @see org.xml.sax.helpers.XMLFilterImpl#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.XMLFilterImpl#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(final String uri, final String localName,
			final String qName, final Attributes atts) throws SAXException {
		tag = qName;
		switch (tag) {
		case "error":
			state = State.ERROR;
			break;
		}
	}
}
