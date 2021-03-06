//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.08 at 09:33:20 PM EEST 
//

package by.pvt.atroshonok.diamondfond.generatedbeans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gem" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="preciousness">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="SEMIPRECIOUS"/>
 *                         &lt;enumeration value="PRECIOUS"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *                   &lt;element name="value">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="([0-9]+)\.?([0-9]{0,2})"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="visual-parameters-list">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="color">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Red"/>
 *                                   &lt;enumeration value="Orange"/>
 *                                   &lt;enumeration value="Yellow"/>
 *                                   &lt;enumeration value="Green"/>
 *                                   &lt;enumeration value="Blue"/>
 *                                   &lt;enumeration value="Purple"/>
 *                                   &lt;enumeration value="Braun"/>
 *                                   &lt;enumeration value="White"/>
 *                                   &lt;enumeration value="Varicolored"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="transparency">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="cutting-type">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="facescount" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                           &lt;minInclusive value="4"/>
 *                                           &lt;maxInclusive value="15"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "gem" })
@XmlRootElement(name = "pavilion")
public class Pavilion {

	@XmlElement(required = true)
	protected List<Pavilion.Gem> gem;

	/**
	 * Gets the value of the gem property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the gem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getGem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Pavilion.Gem }
	 * 
	 * 
	 */
	public List<Pavilion.Gem> getGem() {
		if (gem == null) {
			gem = new ArrayList<Pavilion.Gem>();
		}
		return this.gem;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
	 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="preciousness">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;enumeration value="SEMIPRECIOUS"/>
	 *               &lt;enumeration value="PRECIOUS"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}token"/>
	 *         &lt;element name="value">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;pattern value="([0-9]+)\.?([0-9]{0,2})"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="visual-parameters-list">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="color">
	 *                     &lt;simpleType>
	 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *                         &lt;enumeration value="Red"/>
	 *                         &lt;enumeration value="Orange"/>
	 *                         &lt;enumeration value="Yellow"/>
	 *                         &lt;enumeration value="Green"/>
	 *                         &lt;enumeration value="Blue"/>
	 *                         &lt;enumeration value="Purple"/>
	 *                         &lt;enumeration value="Braun"/>
	 *                         &lt;enumeration value="White"/>
	 *                         &lt;enumeration value="Varicolored"/>
	 *                       &lt;/restriction>
	 *                     &lt;/simpleType>
	 *                   &lt;/element>
	 *                   &lt;element name="transparency">
	 *                     &lt;simpleType>
	 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
	 *                         &lt;minInclusive value="0"/>
	 *                         &lt;maxInclusive value="100"/>
	 *                       &lt;/restriction>
	 *                     &lt;/simpleType>
	 *                   &lt;/element>
	 *                   &lt;element name="cutting-type">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;attribute name="facescount" use="required">
	 *                             &lt;simpleType>
	 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
	 *                                 &lt;minInclusive value="4"/>
	 *                                 &lt;maxInclusive value="15"/>
	 *                               &lt;/restriction>
	 *                             &lt;/simpleType>
	 *                           &lt;/attribute>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "id", "name", "preciousness", "origin", "value", "visualParametersList" })
	public static class Gem {

		@XmlElement(required = true)
		@XmlSchemaType(name = "positiveInteger")
		protected BigInteger id;
		@XmlElement(required = true)
		protected String name;
		@XmlElement(required = true)
		protected String preciousness;
		@XmlElement(required = true)
		@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
		@XmlSchemaType(name = "token")
		protected String origin;
		@XmlElement(required = true)
		protected String value;
		@XmlElement(name = "visual-parameters-list", required = true)
		protected Pavilion.Gem.VisualParametersList visualParametersList;

		/**
		 * Gets the value of the id property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getId() {
			return id;
		}

		/**
		 * Sets the value of the id property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setId(BigInteger value) {
			this.id = value;
		}

		/**
		 * Gets the value of the name property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the value of the name property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Gets the value of the preciousness property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPreciousness() {
			return preciousness;
		}

		/**
		 * Sets the value of the preciousness property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setPreciousness(String value) {
			this.preciousness = value;
		}

		/**
		 * Gets the value of the origin property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getOrigin() {
			return origin;
		}

		/**
		 * Sets the value of the origin property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setOrigin(String value) {
			this.origin = value;
		}

		/**
		 * Gets the value of the value property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Sets the value of the value property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * Gets the value of the visualParametersList property.
		 * 
		 * @return possible object is {@link Pavilion.Gem.VisualParametersList }
		 * 
		 */
		public Pavilion.Gem.VisualParametersList getVisualParametersList() {
			return visualParametersList;
		}

		/**
		 * Sets the value of the visualParametersList property.
		 * 
		 * @param value
		 *            allowed object is
		 *            {@link Pavilion.Gem.VisualParametersList }
		 * 
		 */
		public void setVisualParametersList(Pavilion.Gem.VisualParametersList value) {
			this.visualParametersList = value;
		}

		/**
		 * <p>
		 * Java class for anonymous complex type.
		 * 
		 * <p>
		 * The following schema fragment specifies the expected content
		 * contained within this class.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="color">
		 *           &lt;simpleType>
		 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
		 *               &lt;enumeration value="Red"/>
		 *               &lt;enumeration value="Orange"/>
		 *               &lt;enumeration value="Yellow"/>
		 *               &lt;enumeration value="Green"/>
		 *               &lt;enumeration value="Blue"/>
		 *               &lt;enumeration value="Purple"/>
		 *               &lt;enumeration value="Braun"/>
		 *               &lt;enumeration value="White"/>
		 *               &lt;enumeration value="Varicolored"/>
		 *             &lt;/restriction>
		 *           &lt;/simpleType>
		 *         &lt;/element>
		 *         &lt;element name="transparency">
		 *           &lt;simpleType>
		 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
		 *               &lt;minInclusive value="0"/>
		 *               &lt;maxInclusive value="100"/>
		 *             &lt;/restriction>
		 *           &lt;/simpleType>
		 *         &lt;/element>
		 *         &lt;element name="cutting-type">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;attribute name="facescount" use="required">
		 *                   &lt;simpleType>
		 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
		 *                       &lt;minInclusive value="4"/>
		 *                       &lt;maxInclusive value="15"/>
		 *                     &lt;/restriction>
		 *                   &lt;/simpleType>
		 *                 &lt;/attribute>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "color", "transparency", "cuttingType" })
		public static class VisualParametersList {

			@XmlElement(required = true)
			protected String color;
			protected int transparency;
			@XmlElement(name = "cutting-type", required = true)
			protected Pavilion.Gem.VisualParametersList.CuttingType cuttingType;

			/**
			 * Gets the value of the color property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getColor() {
				return color;
			}

			/**
			 * Sets the value of the color property.
			 * 
			 * @param value
			 *            allowed object is {@link String }
			 * 
			 */
			public void setColor(String value) {
				this.color = value;
			}

			/**
			 * Gets the value of the transparency property.
			 * 
			 */
			public int getTransparency() {
				return transparency;
			}

			/**
			 * Sets the value of the transparency property.
			 * 
			 */
			public void setTransparency(int value) {
				this.transparency = value;
			}

			/**
			 * Gets the value of the cuttingType property.
			 * 
			 * @return possible object is
			 *         {@link Pavilion.Gem.VisualParametersList.CuttingType }
			 * 
			 */
			public Pavilion.Gem.VisualParametersList.CuttingType getCuttingType() {
				return cuttingType;
			}

			/**
			 * Sets the value of the cuttingType property.
			 * 
			 * @param value
			 *            allowed object is
			 *            {@link Pavilion.Gem.VisualParametersList.CuttingType }
			 * 
			 */
			public void setCuttingType(Pavilion.Gem.VisualParametersList.CuttingType value) {
				this.cuttingType = value;
			}

			/**
			 * <p>
			 * Java class for anonymous complex type.
			 * 
			 * <p>
			 * The following schema fragment specifies the expected content
			 * contained within this class.
			 * 
			 * <pre>
			 * &lt;complexType>
			 *   &lt;complexContent>
			 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *       &lt;attribute name="facescount" use="required">
			 *         &lt;simpleType>
			 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
			 *             &lt;minInclusive value="4"/>
			 *             &lt;maxInclusive value="15"/>
			 *           &lt;/restriction>
			 *         &lt;/simpleType>
			 *       &lt;/attribute>
			 *     &lt;/restriction>
			 *   &lt;/complexContent>
			 * &lt;/complexType>
			 * </pre>
			 * 
			 * 
			 */
			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "")
			public static class CuttingType {

				@XmlAttribute(name = "facescount", required = true)
				protected int facescount;

				/**
				 * Gets the value of the facescount property.
				 * 
				 */
				public int getFacescount() {
					return facescount;
				}

				/**
				 * Sets the value of the facescount property.
				 * 
				 */
				public void setFacescount(int value) {
					this.facescount = value;
				}

			}

		}

	}

}
