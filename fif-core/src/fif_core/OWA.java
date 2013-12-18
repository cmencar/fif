package fif_core;


import fif_core.interfaces.Aggregator;

/**This class represents the ordered weighted averaging, a particular implementation of an aggregator.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class OWA implements Aggregator {

	private double[] weights;
	
	/**The constructor sets an array of weights, used in aggregation algorithm.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The array is not equal to null.<br>
	 * 2-The size of array is different from 0.<br>
	 * 3-Each number of the array should be between 0 and 1.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The array of weights is set for the OWA object.<br><br>
	 * 
	 * @param weights The array of weights you want to set.
	 */
	
	
	public OWA(double... weights)  {
	
		assert weights!=null : "OWA: Null array";
		assert weights.length!=0 : "OWA: Empty array";
		assert isValidArray(weights): "OWA: Illegal weights in array"; /* verifica che i valori sono in [0,1] */
		
		this.weights=weights.clone();
		

	}
	
	/**This methods aggregate a sets of values, calculating the ordered weighted averaging.<br><br>
	 *
	 * Preconditions: <br><br>
	 * 1-The array is not equal to null.<br>
	 * 2-The size of array must be equal to the size of weights.<br>
	 * 3-Each number of the array should be between 0 and 1.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned a calculated ordered weighted averaging value.<br><br>
	 * 
	 * @param values The array of values you want to aggregate.
	 * @return the calculated value.
	 */
	
	
	 public double aggregate(double... values)   {
	 
		 	assert values!=null : "OWA: null array";
	        assert values.length == weights.length : "OWA: Illegal number of values";
	        assert isValidArray(values): "OWA: Illegal values in array"; /* verifica che i valori siano in [0,1] */
	        
		

			double sum=0;
			double product=0;
			
			for(int i=0;i<values.length;i++){
				
					product=weights[i]*values[i];
					sum=sum+product;					
	
			}

		
		return sum;
	}


	private boolean isValidArray(double[] values) {
	
		boolean isValid=true;
		
		for(int i=0;i<values.length;i++){
			
	
			if((values[i]>=0 && values[i]<=1)){
			
				isValid=isValid && true;
			}
			else{
				isValid=isValid && false;
			}
				
			
			
		}
		return isValid;
	}

}
