package fif_core;


import java.net.URI;


/**This class represent a placeholder for a resource, identified with a URI.<br><br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */



public class Resource {
	
	private URI identificator;
	
	
	
	/**
	 * Builder that saves the URI of the resource.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The URI object can't be null.<br><br>	 
	 * 
	 * Postconditions:<br><br>
	 * 1-The URI is set correctly.<br><br>
	 * 
	 * @param id The URI you want to set for this resource.
	 */
	
	
	public Resource(URI id) {
		
		assert id!=null : "Resource : null URI";
		
		
			identificator=id;

	}
	
	/**
	 * Method that sets the URI for the resource.<br><br>
	 * 
	 * 
	 * Preconditions: <br><br>
	 * 1-The URI object can't be null.<br><br>	 
	 * 
	 * Postconditions:<br><br>
	 * 1-The URI is set correctly.<br><br>
	 * 
	 * @param id The URI you want to set for this resource.
	 */
	
	
	public void setUri(URI id) {
		
		assert id!=null : "Resource : null URI";
		
			identificator=id;
	}
	
	
	/**
	 * Method that returns the URI of the resource.<br><br>
	 * 
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the URI.<br><br>
	 * 
	 * @return The URI of the resource.
	 */

	public URI getUri(){
	
		return identificator;
	}

}
