package fif_core;

import java.util.Arrays;



/**This is an utility class that provides useful and multipurpose methods.<br><br>
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class Filters {
	
	
	/**
	 * Complements the filtered value of a filter.<br><br>
	 * This method do a complement passing value 1 as inital value to the filter during filtering.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The filter is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The complement is done correctly returning a value between 0 and 1.<br><br>
	 * 
	 * @param r The resource you want to filter.
	 * @param f The filter you want to use for filtering.
	 * 
	 * @return the complement of filtered value.
	 */
	
	public static double complement(Resource r, Filter f) throws Exception {
		

		
		return complement(r, 1.0, f); 
		
	}
	
	/**
	 * Complements the filtered value of a filter, with a initial starting value.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The value is between 0 and 1.<br>
	 * 3-The filter is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The complement is done correctly returning a value between 0 and 1.<br><br>
	 * 
	 * @param r The resource you want to filter.
	 * @param f The filter you want to use for filtering.
	 * @param v The starting initial filtering value.
	 * 
	 * @return the complement of filtered value.
	 */
	
	
	public static double complement(Resource r,double v, Filter f) throws Exception {
		
		assert (r!=null) :"Filters : null resource.";
		assert (v>=0.0 && v<=1.0) :"Filters : the initial value is not valid.";
		assert (f!=null) :"Filters : null filter.";
		
		
		
		return 1.0 - f.doFilter(r,v);
		
	}
	
	/**
	 * Returns the maximum value of a list of double values.<br><br>
	 * You can set a variable number of values or directly an array of values.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The input value can't be null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the maximum value of the list of values.<br><br>
	 * 
	 * @param number The list of values between you want to find the maximum.
	 * 
	 * @return the maximum value of the list of values.
	 */
	
	
	
	public static double max(double ... number){
		
	assert number!=null : "Filters: are not accepted null array.";	
		
	Arrays.sort(number);
		
	return number[number.length-1];
	
}
	
	
	/**
	 * Returns the minimum value of a list of double values.<br><br>
	 * You can set a variable number of values or directly an array of values.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The input value can't be null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the minimum value of the list of values.<br><br>
	 * 
	 * @param number The list of values between you want to find the minimum.
	 * 
	 * @return the minimum value of the list of values.
	 */

	public static double min(double ... number){
	
	assert number!=null : "Filters: are not accepted null array.";
	
	Arrays.sort(number);
		
	return number[0];

	}
	
	

	/**
	 * Returns the sum of a list of double values.<br><br>
	 * You can set a variable number of values or directly an array of values.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The array can't be null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the sum of the list of values.<br><br>
	 * 
	 * @param values The list of values for which you want to calculate the sum.
	 * 
	 * @return the sum of the list of values.
	 */
	
	
	public static double sum (double ... values){
		
	assert values!=null : "Filters: are not accepted null array.";
		
		double sum=0;
		
		for (double i : values)
		    sum = sum + i;
		
		return sum;
	}
	
	

}
