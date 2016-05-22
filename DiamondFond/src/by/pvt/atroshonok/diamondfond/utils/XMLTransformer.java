package by.pvt.atroshonok.diamondfond.utils;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLTransformer {
	private String xslFileName;
	private String htmlFileName;

	// private static final String XSL_FILE = "files/DiamondFondStylesheet.xsl";
	// private static final String HTML_FILE = "files/DiamondFondTable.html";

	public XMLTransformer() {
	}

	/**
	 * @param xslFileName
	 * @param htmlFileName
	 */
	public XMLTransformer(String xslFileName, String htmlFileName) {
		super();
		this.xslFileName = xslFileName;
		this.htmlFileName = htmlFileName;
	}

	public void transformToHTML(String xmlFileName) {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer(new StreamSource(xslFileName));
			transformer.transform(new StreamSource(xmlFileName), new StreamResult(htmlFileName));
			System.out.println("File:\n" + new File(xmlFileName).getAbsolutePath() + "\n transformed to the html file:\n"
					+ new File(htmlFileName).getAbsolutePath());
		} catch (TransformerException e) {
			System.err.println("Impossible transform file " + xmlFileName + " : " + e);
		}
	}

	/**
	 * @return the xslFileName
	 */
	public String getXslFileName() {
		return xslFileName;
	}

	/**
	 * @param xslFileName
	 *            the xslFileName to set
	 */
	public void setXslFileName(String xslFileName) {
		this.xslFileName = xslFileName;
	}

	/**
	 * @return the htmlFileName
	 */
	public String getHtmlFileName() {
		return htmlFileName;
	}

	/**
	 * @param htmlFileName
	 *            the htmlFileName to set
	 */
	public void setHtmlFileName(String htmlFileName) {
		this.htmlFileName = htmlFileName;
	}

}
