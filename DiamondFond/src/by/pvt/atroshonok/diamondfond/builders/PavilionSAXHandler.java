package by.pvt.atroshonok.diamondfond.builders;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.pvt.atroshonok.diamondfond.beans.Gem;
import by.pvt.atroshonok.diamondfond.beans.Pavilion;
import by.pvt.atroshonok.diamondfond.enums.GemColor;
import by.pvt.atroshonok.diamondfond.enums.GemPreciousness;

public class PavilionSAXHandler extends DefaultHandler {

	private Pavilion pavilion;
	private Gem currentGem;
	private String currentTagName;

	public PavilionSAXHandler() {
	}

	/**
	 * @param pavilion
	 */
	public PavilionSAXHandler(Pavilion pavilion) {
		super();
		this.pavilion = pavilion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTagName = localName.trim();
		
		if (localName.equals("gem")) {
			currentGem = new Gem();
			currentGem.setId(attributes.getValue("id"));			
		}
		// TODO
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		currentTagName = null;
		if ("gem".equals(localName)) {
			pavilion.getGemList().add(currentGem);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String line = new String(ch, start, length).trim();
		if (currentGem != null) {
			switch (currentTagName) {
			case "name":
				currentGem.setName(line);
				break;
			case "preciousness":
				currentGem.setPreciousness(GemPreciousness.valueOf(line.toUpperCase()));
				break;
			case "origin":
				currentGem.setOrigin(line);
				break;
			case "value":
				currentGem.setValue(Double.parseDouble(line));
				break;
			case "color":
				GemColor gemColor = GemColor.valueOf(line.toUpperCase());
				currentGem.getVisualParamList().setGemColor(gemColor);
				break;
			case "transparency":
				int transparency = Integer.parseInt(line);
				currentGem.getVisualParamList().setTransparency(transparency);
				break;
			case "facescount":
				int facesCount = Integer.parseInt(line);
				currentGem.getVisualParamList().setFacesCount(facesCount);
				break;
			default:
				// throw new SAXException("XML document is invalid. Parser TODO
				// does't now this tag name: " + currentTagName);
			}
		}
	}

	/**
	 * @return the pavilion
	 */
	public Pavilion getPavilion() {
		return pavilion;
	}

}
