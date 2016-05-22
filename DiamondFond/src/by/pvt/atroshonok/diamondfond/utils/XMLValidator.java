package by.pvt.atroshonok.diamondfond.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import by.pvt.atroshonok.diamondfond.builders.PavilionErrorSAXHandler;

public class XMLValidator {
	private static String schemaLanguage = XMLConstants.W3C_XML_SCHEMA_NS_URI;

	public XMLValidator() {
	}

	public static void validateXML(String xmlFileName, String xsdSchemaName) {
		SchemaFactory factory = SchemaFactory.newInstance(schemaLanguage);
		File schemaLocation = new File(xsdSchemaName);
		try {
			PavilionErrorSAXHandler errorHandler = new PavilionErrorSAXHandler("logs/log.txt");
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(xmlFileName);
			validator.setErrorHandler(errorHandler);
			validator.validate(source);
			System.out.println(new File(xmlFileName).getAbsolutePath() + " is valid.");
		} catch (SAXException e) {
			System.out.println(new File(xmlFileName).getAbsolutePath() + " is not valid. See to file: \"logs/log.txt\"");
		} catch (IOException e) {
			System.out.print(xmlFileName + " is not valid bacause: " + e.getMessage());
		}

	}

}
