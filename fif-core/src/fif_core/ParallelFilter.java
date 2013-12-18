package fif_core;

import java.util.AbstractList;





import fif_core.interfaces.Aggregator;




/**This class represent a parallel filter, that is a composite structure for two or more filters in which the order is not important.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */


public class ParallelFilter extends Filter {

	private AbstractList<Filter> filters;
	private Aggregator aggregator;
	
	/**
	 * Builder that sets the aggregator and the list of filters composing the parallel filter.<br><br>
	 * 
	 * You can set a variable numbers of filters.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The aggregator is not equal to null.<br><br>
	 * 2-None of the filters must be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The aggregator and filters are set correctly.<br><br>
	 * 
	 * @param a The aggregator you want to set in this filter.
	 * @param list The list of filters you want to set in this filter.
	 */

	
	public ParallelFilter(Aggregator a, Filter... list)  {
		
		assert a!=null : "Parallel Filter: null aggregator";
		assert areFiltersNotNull(list) : "Parallel Filter: at least one of the filter is null";
		
		
		filters=new CheckedLinkedList<Filter>(); //reset the list of filters when set the filters
		
		for(int i=0;i<list.length;i++){
			

				filters.add(list[i]);

			
		}

		aggregator=a;
		
		
	}
	
	
	/**
	 * Overridden method of Filter class: provides the filtering for the parallel filter structure.<br><br>
	 * 
	 * The output value is calculated filtering with each filter and then aggregate with the aggregator the filtered values.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The value is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The filtering and aggregation are done correctly returning a value between 0 and 1.<br><br>
	 * 
	 * @param r The resource you want to filter.
	 * @param value The maximum threshold value of the filtering.
	 * 
	 * @return the aggregated filtered value.
	 */


	
	public double doFilter(Resource r, double value) throws  Exception  {
		
		int size=filters.size();
		double[] array = new double[size];
		
		
		for(int i=0;i<size;i++){
			
			array[i]=filters.get(i).doFilter(r, value);
		}
		

		return aggregator.aggregate(array);
		
	}
	
	
	/**
	 * This method allows to set a list of filters composing the parallel filter.<br><br>
	 * 
	 * Every time you call this method, the previous internal filters are destroyed and replaced by the new filters.<br>
	 * You can set a variable numbers of filters.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-None of the filters must be null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The filters are set correctly.<br><br>
	 * 
	 * @param list The list of filters you want to set in this filter.
	 */
	
	
	public void setParallelFilters( Filter... list)   {
		
		assert areFiltersNotNull(list) : "Parallel Filter: at least one of the filter is null";
		
		filters=new CheckedLinkedList<Filter>(); //reset the list of filters when set the filters
				
		
		for(int i=0;i<list.length;i++){
			

			filters.add(list[i]);

		
		}
		
		
		
		
	}
	
	
	/**
	 * This method returns an abstract list of all the filters in the parallel filter.<br><br>
	 * 
	 * You can modify internal state of the parallel filters using the abstract list methods.<br><br>
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
	
	/**
	 * This method allows to set the aggregator of this filter.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The aggregator is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The aggregator is set correctly.<br><br>
	 * 
	 * @param a The aggregator you want to set in this filter.
	 */
	
	public void setAggregator(Aggregator a)  {
		
		assert a==null : "Parallel Filter: null aggregator";
			
			aggregator=a;
		
		
	}
	
	
	private boolean areFiltersNotNull(Filter[] list) {
		
		boolean isValid=true;
		
		for(int i=0;i<list.length;i++){
			
						
			isValid=isValid && list[i]!=null;	
		}
					
		
		return isValid;
	}



}
