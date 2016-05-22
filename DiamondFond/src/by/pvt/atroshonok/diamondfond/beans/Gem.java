/**
 * 
 */
package by.pvt.atroshonok.diamondfond.beans;

import by.pvt.atroshonok.diamondfond.enums.GemPreciousness;

/**
 * @author Atroshonok Ivan
 *
 */
public class Gem {

	private String id;
	private String name;
	private GemPreciousness preciousness;
	private String origin;
	private double value;
	private VisualParametersList visualParameterList = new VisualParametersList();

	/**
	 * Default constructor without parameters
	 */
	public Gem() {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((preciousness == null) ? 0 : preciousness.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((visualParameterList == null) ? 0 : visualParameterList.hashCode());
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
		Gem other = (Gem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (preciousness != other.preciousness)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		if (visualParameterList == null) {
			if (other.visualParameterList != null)
				return false;
		} else if (!visualParameterList.equals(other.visualParameterList))
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
		return "Gem [\n id=" + id + ", \n name=" + name + ", \n preciousness=" + preciousness + ", \n origin=" + origin
				+ ", \n value=" + value + " ct.\n " + visualParameterList + "\n]";
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prreciousness
	 */
	public GemPreciousness getPreciousness() {
		return preciousness;
	}

	/**
	 * @param prreciousness
	 *            the prreciousness to set
	 */
	public void setPreciousness(GemPreciousness prreciousness) {
		this.preciousness = prreciousness;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin
	 *            the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the visualParamList
	 */
	public VisualParametersList getVisualParamList() {
		return visualParameterList;
	}

	/**
	 * @param visualParamList
	 *            the visualParamList to set
	 */
	public void setVisualParamList(VisualParametersList visualParamList) {
		this.visualParameterList = visualParamList;
	}

}
