/**
 * 
 */
package by.pvt.atroshonok.diamondfond.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Atroshonok Ivan
 *
 */
public class Pavilion {

	private List<Gem> gemList = new ArrayList<>();

	/**
	 * Default constructor without parameters
	 */
	public Pavilion() {
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
		result = prime * result + ((gemList == null) ? 0 : gemList.hashCode());
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
		Pavilion other = (Pavilion) obj;
		if (gemList == null) {
			if (other.gemList != null)
				return false;
		} else if (!gemList.equals(other.gemList))
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
		return "****************************\n\t* Pavilion * \n****************************\ngemList:\n" + gemList
				+ "\n****************************";
	}

	/**
	 * @return the gemList
	 */
	public List<Gem> getGemList() {
		return gemList;
	}

	/**
	 * @param gemList
	 *            the gemList to set
	 */
	public void setGemList(List<Gem> gemList) {
		this.gemList = gemList;
	}

}
