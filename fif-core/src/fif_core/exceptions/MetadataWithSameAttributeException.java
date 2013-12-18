package fif_core.exceptions;

public class MetadataWithSameAttributeException extends Exception{
	
	/**This exception is launched when it's trying to insert in a descriptor two or more metadata with the same attribute.<br><br>
	 * 
	 * @author Troiano Lorenzo
	 * @version 1.0
	 */


	private static final long serialVersionUID = 1L;

	public MetadataWithSameAttributeException() {

		super("You are trying to set two or more metadata with the same attribute.");
	}

}
