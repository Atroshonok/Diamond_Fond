package by.pvt.atroshonok.diamondfond.builders;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.pvt.atroshonok.diamondfond.beans.Gem;
import by.pvt.atroshonok.diamondfond.beans.VisualParametersList;
import by.pvt.atroshonok.diamondfond.enums.GemColor;
import by.pvt.atroshonok.diamondfond.enums.GemPreciousness;

public class PavilionDOMBuilder extends AbstractPavilionBuilder {

	private DocumentBuilder docBuilder;
	private Gem currentGem;

	public PavilionDOMBuilder() {
		super();
		initBuilder();
	}

	public void initBuilder() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("Error of the parser configuration: " + e);
		}
	}

	@Override
	public void buildPavilion(String fileName) {

		File inputFile = new File(fileName);
		Document doc;
		try {
			doc = docBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("gem");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					pavilion.getGemList().add(buildGem(eElement));

				}

			}
		} catch (SAXException e) {

			System.err.print("Error of the SAX parser: " + e);

		} catch (IOException e) {

			System.err.print("Error of the I/O stream: " + e);

		}

	}

	private Gem buildGem(Element gemElement) {

		currentGem = new Gem();

		currentGem.setId(gemElement.getAttribute("id"));
		currentGem.setName(getElementTextContent(gemElement, "name"));
		currentGem.setPreciousness(GemPreciousness.valueOf(getElementTextContent(gemElement, "preciousness").toUpperCase()));
		currentGem.setOrigin(getElementTextContent(gemElement, "origin"));
		currentGem.setValue(new Double(getElementTextContent(gemElement, "value")));

		NodeList nList1 = gemElement.getElementsByTagName("visual-parameters-list");
		for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
			Node nNode1 = nList1.item(temp1);
			if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement1 = (Element) nNode1;
				currentGem.setVisualParamList(buildGemVisualParametersList(eElement1));
			}

		}
		return currentGem;
	}

	private VisualParametersList buildGemVisualParametersList(Element visualParametersListElement) {

		VisualParametersList visualParametersList = currentGem.getVisualParamList();
		visualParametersList.setGemColor(
				GemColor.valueOf(getElementTextContent(visualParametersListElement, "color").toUpperCase()));
		visualParametersList
				.setTransparency(new Integer(getElementTextContent(visualParametersListElement, "transparency")));
		visualParametersList
				.setFacesCount(new Integer(getElementTextContent(visualParametersListElement, "facescount")));

		return visualParametersList;
	}

	private static String getElementTextContent(Element element, String elementName) {

		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;

	}

}
