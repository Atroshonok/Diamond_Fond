package by.pvt.atroshonok.diamondfond.builders;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class PavilionSAXBuilder extends AbstractPavilionBuilder {

	private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final Object W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private SAXParser saxParser;
	private PavilionSAXHandler pavilionHandler;

	/**
	 * 
	 */
	public PavilionSAXBuilder() {
		super();
		try {
			pavilionHandler = new PavilionSAXHandler(pavilion);
			SAXParserFactory fact = SAXParserFactory.newInstance();

			fact.setNamespaceAware(true);
			fact.setValidating(true);

			saxParser = fact.newSAXParser();
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

		} catch (SAXException e) {
			System.err.println("Error of the SAX parser: " + e);
		} catch (ParserConfigurationException e) {
			System.err.println("Error of the parser configuration: " + e); 
		}
	}

	@Override
	public void buildPavilion(String fileName) {
		try {
			saxParser.parse(fileName, pavilionHandler);
		} catch (IOException e) {
			System.err.println("Error of the I/O stream: " + e);
		} catch (SAXException e) {
			System.err.println("Error of the SAX parser: " + e);
		}
		pavilion = pavilionHandler.getPavilion();
	}

}
