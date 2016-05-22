package by.pvt.atroshonok.diamondfond.builders;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class PavilionErrorSAXHandler extends DefaultHandler {
	private Logger logger = Logger.getLogger(getClass().getName());

	public PavilionErrorSAXHandler(String log) throws IOException {
		logger.addAppender(new FileAppender(new SimpleLayout(), log));
		
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
	 */
	@Override
	public void warning(SAXParseException e) throws SAXException {
		logger.warn(getLineAddress(e) + "-" + e.getMessage());
		throw e; 
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		logger.error(getLineAddress(e) + "-" + e.getMessage());
		throw e;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		logger.fatal(getLineAddress(e) + "-" + e.getMessage());
		throw e;
	}
	
	private String getLineAddress(SAXParseException e) {
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
	
	

}
