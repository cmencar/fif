package fif_core;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;



/**This class provides implementation and methods of a fuzzy set.<br><br>
 * It can be instantiate a fuzzy set without values.<br><br>
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class FuzzySet {

	private Hashtable<String, Double> data = new Hashtable<String, Double>();
	
	
	/**
	 * Checks if a specific element exists in this fuzzy set.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The element can't be null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned true if the element exists in this fuzzy set, false otherwise.<br><br>
	 * 
	 * @param element The identification value of the couple.
	 */
	
	
	
	public boolean contains(String element) {
		
		assert (element!=null) : "FuzzySet: null element in input.";
		

		return data.containsKey(element);

	}
	
	/**
	 * Set a specific couple of values for this fuzzy set.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The element can't be null.<br>
	 * 2-The membership value should be between 0 and 1.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The couple of values is set correctly.<br><br>
	 * 
	 * @param element The identification value of the couple.
	 * @param membershipValue The fuzzy value of the couple.
	 */
	

	public void setValue(String element, double membershipValue)  {

		assert (element!=null): "Fuzzy Set: null element";
		assert (membershipValue>=0 && membershipValue<=1): "Fuzzy Set: invalid number to set";
		
		
		if(membershipValue!=0){
			data.put(element, membershipValue);
		}
		else{
			if(!data.contains(element)){
				data.remove(element);
			}
			
		}

		
	}
	
	/**
	 * Get the membershipvalue associated to the input element.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The element can't be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned a value between 0 and 1 if the element exists and the value is mapped, 0 otherwise.<br><br>
	 * 
	 * @param element The identification value of the couple.
	 * @return the membership value associated to the element.
	 */
	

	public double getValue(String element) {
		
		assert (element!=null) : "FuzzySet: null element in input.";
		
		double membershipValue=0;
				
		if(data.containsKey(element)){ 

			membershipValue=data.get(element);
		}
		else{
			membershipValue=0;
		}
		

		return membershipValue;

	}
	
	/**
	 * Removes the element and his membershipValue from this fuzzyset.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The element can't be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The element has been removed correctly.<br><br>
	 * 
	 * @param element The identification value of the couple.
	 */
	

	public void removeElement(String element) {
		
		assert (element!=null) : "FuzzySet: null element in input.";

		data.remove(element);

	}
	
	/**
	 * Returns the set of all elements of this fuzzy set.<br><br>
	 * If there are no element, will be returned an empty set.
	 * 
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned a set of all the elements.<br><br>
	 * 
	 * @return the set of all the elements.
	 */

	public Set<String> getSupport() {

		Set<String> s = new HashSet<String>(data.keySet());
		
		return s;

	}

}
