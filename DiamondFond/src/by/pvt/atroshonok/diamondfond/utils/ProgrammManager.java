package by.pvt.atroshonok.diamondfond.utils;

import by.pvt.atroshonok.diamondfond.beans.Pavilion;
import by.pvt.atroshonok.diamondfond.builders.AbstractPavilionBuilder;
import by.pvt.atroshonok.diamondfond.builders.PavilionBuilderFactory;

public class ProgrammManager {
	private static final String XML_FILE_NAME = "files/DiamondFond.xml";
	private static final String XML_SCHEMA_NAME = "files/DiamondFondXMLSchema.xsd";
	private static final String JSON_OUT_FILE_NAME = "files/GeneratedJSONFile.json";
	private static final String XSL_FILE_NAME = "files/DiamondFondStylesheet.xsl";
	private static final String HTML_FILE_NAME = "files/DiamondFondTable.html";
	private static Pavilion currentPavilion;

	public static void validateXMLFile() {
		XMLValidator.validateXML(XML_FILE_NAME, XML_SCHEMA_NAME);
	}

	public static void createPavilionBySAXParser() {
		PavilionBuilderFactory pFactory = PavilionBuilderFactory.getInstance();
		AbstractPavilionBuilder pBuilder = pFactory.createPavilionBuilder("sax");
		pBuilder.buildPavilion(XML_FILE_NAME);
		System.out.println("Pavilion created by SAX Parser:");
		currentPavilion = pBuilder.getPavilion();
		System.out.println(currentPavilion);
	}

	public static void createPavilionByDOMParser() {
		PavilionBuilderFactory pFactory = PavilionBuilderFactory.getInstance();
		AbstractPavilionBuilder pBuilder = pFactory.createPavilionBuilder("dom");
		pBuilder.buildPavilion(XML_FILE_NAME);
		System.out.println("Pavilion created by DOM Parser:");
		currentPavilion = pBuilder.getPavilion();
		System.out.println(currentPavilion);
	}

	public static void createPavilionByStAXParser() {
		PavilionBuilderFactory pFactory = PavilionBuilderFactory.getInstance();
		AbstractPavilionBuilder pBuilder = pFactory.createPavilionBuilder("stax");
		pBuilder.buildPavilion(XML_FILE_NAME);
		System.out.println("Pavilion created by StAX Parser:");
		currentPavilion = pBuilder.getPavilion();
		System.out.println(currentPavilion);
	}

	public static void writePavilionDataToJSONFile() {
		JSONGenerator.createPavilionJSONFile(currentPavilion, JSON_OUT_FILE_NAME);
	}

	public static void transformXMLToHTML() {
		XMLTransformer xmlTransformer = new XMLTransformer(XSL_FILE_NAME, HTML_FILE_NAME);
		xmlTransformer.transformToHTML(XML_FILE_NAME);
	}
	
	
	
	

}
