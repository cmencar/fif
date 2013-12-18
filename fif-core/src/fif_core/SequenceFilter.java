package fif_core;

import java.util.AbstractList;



/**This class represent a sequence filter, that is a composite structure for two or more filters in which the order is important and the output of a filter filtering is the input of the next filter.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */



public class SequenceFilter extends Filter {

	private AbstractList<Filter> filters;
	
	
	/**
	 * Builder that sets the the list of filters composing the parallel filter.<br><br>
	 * 
	 * You can set a variable numbers of filters.<br><br>
	 * The order is extremely important. The same order you set the parameters, the same it will be set into the sequence. <br>
	 * So, first parameter is first element of the sequence, second parameter second element etc...<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-None of the filters must be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The filters are set correctly.<br><br>
	 * 
	 * @param list The list of filters you want to set in this filter.
	 */
	
	public SequenceFilter(Filter... list)  {
		
		assert areFiltersNotNull(list) : "Sequence Filter: at least one of the filter is null";
		
		
		filters=new CheckedLinkedList<Filter>();
		
		
		for(int i=0;i<list.length;i++){
				
				filters.add(list[i]);

		}
	}
	
	/**
	 * Overridden method of Filter class: provides the filtering for the sequence filter structure.<br><br>
	 * 
	 * The output value is calculated filtering with each filter, according to sequence: each filter take an input from the previous filter and give the output to the next filter. The output of the last filter is the final filtered value returned from this method.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The value is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The filtering is done correctly returning a value between 0 and 1.<br><br>
	 * 
	 * @param r The resource you want to filter.
	 * @param value The maximum threshold value of the filtering.
	 * 
	 * @return the aggregated filtered value.
	 */

	
	
	public double doFilter(Resource r, double value) throws Exception  {

		
		double inputValue=value;
		
		
		for(int i=0;i<filters.size();i++){
			
			inputValue=filters.get(i).doFilter(r,inputValue);
		}
		
		return inputValue;
	}
	
	
	/**
	 * This method allows to set a list of filters composing the sequence filter.<br><br>
	 * 
	 * Every time you call this method, the previous internal filters are destroyed and replaced by the new filters.<br>
	 * You can set a variable numbers of filters.<br>
	 * The order is extremely important. The same order you set the parameters, the same it will be set into the sequence. <br>
	 * So, first parameter is first element of the sequence, second parameter second element etc...<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-None of the filters must be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The filters are set correctly.<br><br>
	 * 
	 * @param list The list of filters you want to set in this filter.
	 */
	
	
	public void setSequence(Filter... list)  {
		
		assert areFiltersNotNull(list) : "Sequence Filter: at least one of the filter is null";
		
		
		
		filters=new CheckedLinkedList<Filter>(); //reset the list of filters when set the filters
				
		
		for(int i=0;i<list.length;i++){
				
				filters.add(list[i]);
						
		}
	}
	
	/**
	 * This method returns an abstract list of all the filters in the sequence filter.<br><br>
	 * 
	 * You can modify internal state of the sequence filter using the abstract list methods.<br><br>
	 * 
	 *
	 * Postconditions:<br><br>
	 * 1-It's returned the list of filters.<br><br>
	 * 
	 * @return the list of filters
	 */
	
	
	public AbstractList<Filter> getAllFilters() {
		return filters;
		
	}
	
	private boolean areFiltersNotNull(Filter[] list) {
		
		boolean isValid=true;
		
		for(int i=0;i<list.length;i++){
			
			isValid=isValid && list[i]!=null;	
		}
			
		
		
		return isValid;
	}

}
