package fif_core;

import java.util.Iterator;
import java.util.Set;

import fif_core.interfaces.Interpretation;

/**This class provides a specific implementation of an interpretation.
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class ClosedVeristicInterpretation implements Interpretation  {

	private static ClosedVeristicInterpretation instance = null;
	
	
	/**This method implements the singleton pattern and returns the only possible instance of this class.
	 * @return the instance of this class
	 */
	
	public static synchronized ClosedVeristicInterpretation getinstance() {
		if (instance == null)
			instance = new ClosedVeristicInterpretation();
		return instance;
	}
	
	/**This method do the match between two metadata, according to closed veristic interpretation algorithm.<br>
	 *This interpretation is commutative for the input metadata (this means you can invert the metadata in input and obtain the same result).
	 * 
	 * Preconditions: <br><br>
	 * 1-Both metadata are not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the output of matching algorithm.<br><br>
	 * 
	 * @param filterMetadata the metadata of the filter
	 * @param resourceMetadata the metadata of the resource
	 * @return a double value that represent the output of matching algorithm
	 */

	public double match(Metadata filterMetadata, Metadata resourceMetadata) {
		
		
		assert filterMetadata!=null && resourceMetadata!=null : "Closed Verisitic Interpretation: at least of the metadata is null";
		
		

		
		FuzzySet filterMetadataFuzzySet=filterMetadata.getFuzzySet();
		FuzzySet resourceMetadataFuzzySet=resourceMetadata.getFuzzySet();
		
		Set<String> filterFuzzySetElements=filterMetadataFuzzySet.getSupport();		
		Set<String> resourceFuzzySetElements=resourceMetadataFuzzySet.getSupport();
		
		double intersectionArray[]=new double[filterFuzzySetElements.size()];
		double filterUnionArray[]=new double[filterFuzzySetElements.size()];		
		double resourceUnionArray[]=new double[resourceFuzzySetElements.size()];
		
		Iterator<String> filterIterator=filterFuzzySetElements.iterator();
		Iterator<String> resourceIterator=resourceFuzzySetElements.iterator();
		
		
		for(int i=0;i<filterFuzzySetElements.size();i++){
			
			String currentValue=filterIterator.next();
			
			double firstValue;
			double secondValue;
			

			firstValue=filterMetadataFuzzySet.getValue(currentValue);
			secondValue=resourceMetadataFuzzySet.getValue(currentValue);

			
			
			intersectionArray[i]=Math.min(firstValue, secondValue);
			filterUnionArray[i]=Math.max(firstValue, secondValue);
			
			
		}

		
		
		for(int i=0;i<resourceFuzzySetElements.size();i++){
			
			String currentValue=resourceIterator.next();
			
			double firstValue = 0;
			double secondValue = 0;
			
			
			
			if(!filterMetadataFuzzySet.contains(currentValue)){
				
				firstValue=0;				
				secondValue=resourceMetadataFuzzySet.getValue(currentValue);
				
			}
			resourceUnionArray[i]=Math.max(firstValue, secondValue);

			
		}
		
		
		
		
		double intersectionSum=Filters.sum(intersectionArray);
		double unionSum=Filters.sum(filterUnionArray)+Filters.sum(resourceUnionArray);

		return (intersectionSum/unionSum);

		
	}
	

	

	

}
