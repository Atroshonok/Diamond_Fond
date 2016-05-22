package by.pvt.atroshonok.diamondfond.builders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.pvt.atroshonok.diamondfond.beans.Gem;
import by.pvt.atroshonok.diamondfond.beans.VisualParametersList;
import by.pvt.atroshonok.diamondfond.enums.GemColor;
import by.pvt.atroshonok.diamondfond.enums.GemPreciousness;

public class PavilionStAXBuilder extends AbstractPavilionBuilder {

	private XMLInputFactory inputFactory;
	private Gem currentGem;

	public PavilionStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}

	@Override
	public void buildPavilion(String fileName) {

		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String tagName = null;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);

			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					tagName = reader.getLocalName();
					if (tagName.equalsIgnoreCase("gem")) {
						Gem gem = buildCurrentGem(reader);
						pavilion.getGemList().add(gem);
					}
				}
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file " + fileName + " : " + e);
			}
		}
	}

	private Gem buildCurrentGem(XMLStreamReader reader) throws XMLStreamException {
		currentGem = new Gem();
		currentGem.setId(reader.getAttributeValue(null, "id"));

		String tagName = null;
		int type = 0;
		while (reader.hasNext()) {
			type = reader.next();

			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				tagName = reader.getLocalName();
				switch (tagName) {
				case "name":
					currentGem.setName(getXMLText(reader));
					break;
				case "preciousness":
					currentGem.setPreciousness(GemPreciousness.valueOf(getXMLText(reader).toUpperCase()));
					break;
				case "origin":
					currentGem.setOrigin(getXMLText(reader));
					break;
				case "value":
					currentGem.setValue(Double.parseDouble(getXMLText(reader)));
					break;
				case "visual-parameters-list":
					currentGem.setVisualParamList(getXMLVisualParametersList(reader));
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				tagName = reader.getLocalName();
				if (tagName.equalsIgnoreCase("gem")) {
					return currentGem;
				}
				break;

			}
		}
		throw new XMLStreamException("Unknown element in tag gem");
	}

	private VisualParametersList getXMLVisualParametersList(XMLStreamReader reader) throws XMLStreamException {
		VisualParametersList visualParametersList = new VisualParametersList();

		String tagName = null;
		int type = 0;
		while (reader.hasNext()) {
			type = reader.next();

			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				tagName = reader.getLocalName();
				switch (tagName) {
				case "color":
					visualParametersList.setGemColor(GemColor.valueOf(getXMLText(reader).toUpperCase()));
					break;
				case "transparency":
					visualParametersList.setTransparency(Integer.parseInt(getXMLText(reader)));
					break;
				case "facescount":
					visualParametersList.setFacesCount(Integer.parseInt(getXMLText(reader)));
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				tagName = reader.getLocalName();
				if (tagName.equalsIgnoreCase("visual-parameters-list")) {
					return visualParametersList;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in tag visual-parameters-list");
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}
