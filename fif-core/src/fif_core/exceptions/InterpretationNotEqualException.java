package fif_core.exceptions;

/**This exception is launched when it's trying to matching two metadata with different interpretation.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */

public class InterpretationNotEqualException extends Exception {


	private static final long serialVersionUID = 1L;

	public InterpretationNotEqualException() {
		
		super("The medatada matched have not the same interpreation.");
	}

}
