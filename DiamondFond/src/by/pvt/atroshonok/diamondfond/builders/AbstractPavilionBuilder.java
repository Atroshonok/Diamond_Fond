/**
 * 
 */
package by.pvt.atroshonok.diamondfond.builders;

import by.pvt.atroshonok.diamondfond.beans.Pavilion;

/**
 * @author Atroshonok Ivan
 *
 */
public abstract class AbstractPavilionBuilder {
	protected Pavilion pavilion;

	/**
	 * 
	 */
	public AbstractPavilionBuilder() {
		super();
		pavilion = new Pavilion();
	}

	 public Pavilion getPavilion() {
		 return pavilion;
	}

	abstract public void buildPavilion(String fileName);

}
