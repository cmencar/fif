package fif_core;


import fif_core.interfaces.Interpretation;

/**This class provides implementation and methods of a metadata.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */


public class Metadata {
	
	private Attribute attribute;
	private FuzzySet fuzzyset;
	private Interpretation interpretation;
	
	/**The constructor sets an attribute and a fuzzy set for the metadata.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The attribute is not equal to null.<br>
	 * 2-The fuzzy set is not equal to null.<br>
	 * 3-The interpretation is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The attribute, the fuzzy set and the interpretation are set for this metadata.<br><br>
	 * 
	 * @param a The attribute you want to set.
	 * @param fs The fuzzy set you want to set.
	 * @param i The interpretation you want to set.
	 */

	
	public Metadata(Attribute a,FuzzySet fs, Interpretation i) {
		
		assert a!=null : "Metadata: null attribute";
		assert fs!=null : "Metadata: null fuzzy set";
		assert i!=null : "Metadata: null interpretation";
		
		
			attribute=a;
			fuzzyset=fs;
			interpretation=i;
		
		
	}
	
	/**This method sets an attribute for the metadata.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The attribute is not equal to null.<br><br>	 
	 * 
	 * Postconditions:<br><br>
	 * 1-The attribute is set for this metadata.<br><br>
	 * 
	 * @param a The attribute you want to set.
	 */

	
	
	public void setAttribute(Attribute a) {
		
		assert a!=null : "Metadata: null attribute";
		
			attribute=a;			
	}
	
	
	/**This method returns the attribute associated to the metadata.<br><br>
	 * 
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the attribute of the metadata.<br><br>
	 * 
	 * @return the attribute of the metadata.
	 */
	
	public Attribute getAttribute(){
		
		return attribute;
	}
	
	/**This method sets a fuzzy set for the metadata.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The fuzzy set is not equal to null.<br><br>	 
	 * 
	 * Postconditions:<br><br>
	 * 1-The fuzzy set is set for this metadata.<br><br>
	 * 
	 * @param fs The fuzzy set you want to set.
	 */

	
	public void setFuzzySet(FuzzySet fs) {
		
		assert fs!=null : "Metadata: null fuzzy set";
		
			fuzzyset=fs;

		
	}
	
	
	/**This method returns the fuzzy set associated to the metadata.<br><br>
	 * 
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the fuzzy set of the metadata.<br><br>
	 * 
	 * @return the fuzzy set of the metadata.
	 */
	
	
	public FuzzySet getFuzzySet(){
		
		return fuzzyset;
		
	}
	
	/**This method sets an interpretation for the metadata.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The interpretation object is not equal to null.<br><br>	 
	 * 
	 * Postconditions:<br><br>
	 * 1-The interpretation is set for this metadata.<br><br>
	 * 
	 * @param i The interpretation object you want to set.
	 */
	
	public void setInterpretation(Interpretation i){
		
		assert i!=null : "Metadata: null interpreation";
		
		interpretation=i;
		
	}
	
	/**This method returns the interpretation associated to the metadata.<br><br>
	 * 
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the interpretation of the metadata.<br><br>
	 * 
	 * @return the interpretation of the metadata.
	 */
	
	
	public Interpretation getInterpretation(){
		
		return interpretation;
		
	}
	

}
