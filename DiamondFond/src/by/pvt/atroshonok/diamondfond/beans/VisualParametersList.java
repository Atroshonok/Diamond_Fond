/**
 * 
 */
package by.pvt.atroshonok.diamondfond.beans;

import by.pvt.atroshonok.diamondfond.enums.GemColor;

/**
 * @author Atroshonok Ivan
 *
 */
public class VisualParametersList {

	private GemColor gemColor;
	private int transparency;
	private int facesCount;

	/**
	 * Default constructor without parameters
	 */
	public VisualParametersList() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facesCount;
		result = prime * result + ((gemColor == null) ? 0 : gemColor.hashCode());
		result = prime * result + transparency;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisualParametersList other = (VisualParametersList) obj;
		if (facesCount != other.facesCount)
			return false;
		if (gemColor != other.gemColor)
			return false;
		if (transparency != other.transparency)
			return false;
		return true;
	}

	/*
	 * Overrides the toString() method
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VisualParameters [\n\t Color=" + gemColor + ", \n\t transparency=" + transparency
				+ " %, \n\t facesCount=" + facesCount + "]";
	}

	/**
	 * @return the gemColor
	 */
	public GemColor getGemColor() {
		return gemColor;
	}

	/**
	 * @param gemColor
	 *            the gemColor to set
	 */
	public void setGemColor(GemColor gemColor) {
		this.gemColor = gemColor;
	}

	/**
	 * @return the transparency
	 */
	public int getTransparency() {
		return transparency;
	}

	/**
	 * @param transparency
	 *            the transparency to set
	 */
	public void setTransparency(int transparency) {
		this.transparency = transparency;
	}

	/**
	 * @return the facesCount
	 */
	public int getFacesCount() {
		return facesCount;
	}

	/**
	 * @param facesCount
	 *            the facesCount to set
	 */
	public void setFacesCount(int facesCount) {
		this.facesCount = facesCount;
	}

}
