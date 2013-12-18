package fif_core;

import java.util.Iterator;
import java.util.Set;

import fif_core.interfaces.Interpretation;

	/**This class provides a specific implementation of an interpretation.
	 * @author Troiano Lorenzo
	 * @version 1.0
	 */

public class OpenVeristicInterpretation implements Interpretation {
	
	
	private static OpenVeristicInterpretation instance = null;
	
	
	/**This method implements the singleton pattern and returns the only possible instance of this class.
	 * @return the instance of this class
	 */	
	
	public static synchronized OpenVeristicInterpretation getinstance() {
		if (instance == null)
			instance = new OpenVeristicInterpretation();
		return instance;
	}
	
	/**This method do the match between two metadata, according to open veristic interpretation algorithm.
	 * This interpretation is NOT commutative for the input metadata (this means inverting the metadata in input will produce different results).
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

	assert filterMetadata!=null && resourceMetadata!=null : "Open Verisitic Interpretation: at least of the metadata is null";
		
		
		
		FuzzySet filterMetadataFuzzySet=filterMetadata.getFuzzySet();
		FuzzySet resourceMetadataFuzzySet=resourceMetadata.getFuzzySet();
		
		Set<String> filterFuzzySetElements=filterMetadataFuzzySet.getSupport();
		
		
		double intersectionArray[]=new double[filterFuzzySetElements.size()];
		double firstValueArray[]=new double[filterFuzzySetElements.size()];
		
		Iterator<String> iterator=filterFuzzySetElements.iterator();
		
		
		for(int i=0;i<filterFuzzySetElements.size();i++){
			
			String currentValue=iterator.next();
			
			double firstValue;
			double secondValue;
			
			
			
			firstValue=filterMetadataFuzzySet.getValue(currentValue);
			secondValue=resourceMetadataFuzzySet.getValue(currentValue);

			
			intersectionArray[i]=Math.min(firstValue, secondValue);
			firstValueArray[i]=firstValue;
			
		}
		
		
		double intersectionSum=Filters.sum(intersectionArray);
		double firstValueSum=Filters.sum(firstValueArray);

		return (intersectionSum/firstValueSum);

	}

}
