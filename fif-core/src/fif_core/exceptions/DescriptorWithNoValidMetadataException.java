package fif_core.exceptions;

/**This exception is launched when a descriptor hasn't a valid metadata to match.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */


public class DescriptorWithNoValidMetadataException extends Exception{


	private static final long serialVersionUID = 1L;

	public DescriptorWithNoValidMetadataException() {

		super("The descriptor has not valid medatata to match.");
	}

}
