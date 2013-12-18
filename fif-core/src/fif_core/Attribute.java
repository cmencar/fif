package fif_core;




/**This class provides implementation and methods of an attribute for one metadata.
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class Attribute {

	private String attribute;
	
	
	/**
	 * Builder that saves the attribute value.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The attribute value is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The attribute value is set correctly.<br><br>
	 * 
	 * @param a The value you want to set in the attribute.
	 */
	public Attribute(String a)  {
		
		assert a!=null : "Attribute : the value is null";
			
			attribute=a;	
		
		
	}
	
	/**
	 * Returns the current value of the attribute.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the attribute value.<br><br>
	 * 
	 * @return returns the current value of the attribute.
	 */

	public String getAttributeName() {

		return attribute;

	}
	
	/**
	 * Sets the specified value to the attribute value.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The attribute value is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The attribute value is set correctly.<br><br>
	 * 
	 * @param a The value you want to set.
	 */

	public void setAttributeName(String a)  {

		assert a!=null : "Attribute : the value is null";
		
			attribute=a;

	}
	
	/**
	 * Overridden version of the equals Object Class Method. <br><br>
	 * This overridden method provides a matching on THE ATTRIBUTE VALUE (and not object id) between two attributes. So you can call directly this method instead implementing a matching algorithm in your client. The matching is done with ignorecase sensitive.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The object parameter is an attribute.<br><br>
	 * 2-The object parameter is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The attributes are matched correctly and it's returned true if the attributes have the same value, false otherwise.<br><br>
	 * 
	 * 
	 * @param obj The attribute you want to match.
	 * 
	 */

	@Override
	public boolean equals(Object obj) {

		assert (obj!=null) : "Attribute : object parameter can't be null.";
		assert (obj instanceof Attribute) : "Attribute : can't match an attribute with an object that is not an attribute.";
		
		
		Attribute attr = (Attribute) obj;
		return (this.getAttributeName().compareToIgnoreCase(
				(attr.getAttributeName())) == 0);
	}
}
