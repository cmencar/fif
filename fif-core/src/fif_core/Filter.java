package fif_core;


/**This class provides an abstraction for different types of filters.
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */

public abstract class Filter {
	
	
	/**This method calls the doFilter(Resource r,double value) passing the value 1 as value.
	 * 
	 * @param r The resource you want to filter.
	 *  
	 * @return The filter value between 0 and 1.
	 */	
	
	public double doFilter(Resource r) throws Exception {
		
		return doFilter(r,1);
	}
	
	/**This is an abstract method implemented from different tipes of filters.
	 *
	 * 
	 * @param r The resource you want to filter.
	 * @param value The maximum threshold value of the filtering.
	 * 
	 * @return The filter value between 0 and 1.
	 */	
	
	
	public abstract double doFilter(Resource r,double value) throws Exception  ;

}
