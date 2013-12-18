package fif_core;

import fif_core.exceptions.DescriptorWithNoValidMetadataException;
import fif_core.exceptions.InterpretationNotEqualException;

/**This class provides the real implementation of a filter.
 * This filter works on one single metadata and can filter resources.
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class DescriptionBasedFilter extends Filter{

	private Metadata metadata;
	
	/**
	 * Builder that saves the metadata value.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The metadata is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The metadata is set correctly.<br><br>
	 * 
	 * @param md The metadata you want to set in this filter.
	 */

	public DescriptionBasedFilter(Metadata md) {
		
		assert md!=null : "DescriptionBasedFilter : null metadata";
		

			metadata=md;
		
		
	}
	
	/**
	 * This method provides the real implementation of filtering.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The value is between 0 and 1.<br><br>
	 * 3-Must exists an descriptor (associated to the resource in the ResourceRegister class) containing a metadata with the same attribute of the description based filter.
	 * 4-The metadata of the filter and the metadata (with the same attribute) of the descriptor associated to the resource must have the same interpretation.
	 * 
	 * Postconditions:<br><br>
	 * 1-The filtering is done correctly returning a value between 0 and 1.<br><br>
	 * 
	 * @param r The resource you want to filter.
	 * @param value The starting initial filtering value.
	 * 
	 * @throws InterpretationNotEqualException when trying to matching two metadata with different interpretation.
	 * @throws DescriptorWithNoValidMetadataException when a descriptor hasn't a metadata with the specified attribute.
	 */

	
	public double doFilter(Resource r, double value) throws InterpretationNotEqualException, DescriptorWithNoValidMetadataException {
		
		assert (r!=null) : "Description Based Filter: null resource";
		assert (value>=0 && value<=1): "Description Based Filter: invalid input value";
		
		double finalValue=0;
		ResourceRegister register=ResourceRegister.getinstance();
		Descriptor descriptor=register.getDescriptor(r);
		
		Metadata resourceMetadata=descriptor.getMetadata(metadata.getAttribute());
		
		if(resourceMetadata!=null){
			
			if(resourceMetadata.getInterpretation().equals(metadata.getInterpretation())){
				
				finalValue=metadata.getInterpretation().match(metadata, resourceMetadata);				
			}
			else{
				throw new InterpretationNotEqualException(); 
			}
			
			
		}
		else{
			throw new DescriptorWithNoValidMetadataException(); //l'eccezione dovrà avvisare che il descrittore non contiene nessun metadato con quell'attributo
		}

		
		return Filters.min(finalValue,value);
	}
	
	/**
	 * This method allows to set a metadata.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The metadata is not equal to null.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The metadata is set correctly.<br><br>
	 * 
	 * @param md The metadata you want to set in this filter.
	 */
	
	public void setMetadata(Metadata md) {
		
		assert md!=null : "DescriptionBasedFilter : null metadata";
		
			metadata=md;			
		
	}
	
	/**
	 * This method returns the current metadata of this filter.<br><br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the metadata of this filter.<br><br>
	 * 
	 * @return  The metadata of this filter.
	 */
	
	public Metadata getMetadata() {
		
		return metadata;
		
	}

}
