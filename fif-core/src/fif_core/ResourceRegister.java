package fif_core;

import java.util.Hashtable;

/**This class is a register containing associations between a resource and its descriptor.<br>
 * 
 * @author Troiano Lorenzo
 * @version 1.0
 */


public class ResourceRegister {

	private static ResourceRegister instance = null;
	private static Hashtable<Resource, Descriptor> associations = new Hashtable<Resource, Descriptor>();

	private ResourceRegister() {}
	
	
	/**This method implements the singleton pattern and returns the only possible instance of this class.
	 * @return the instance of this class
	 */	

	public static synchronized ResourceRegister getinstance() {
		if (instance == null)
			instance = new ResourceRegister();
		return instance;
	}

	/**
	 * Checks if exists a descriptor associated to a resource.<br><br>
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned true if exists associated descriptor or false otherwise.<br><br>
	 * 
	 * @param r The resource of which you want to check if exists an association.
	 * 
	 * @return It's returned true if exists associated descriptor or false otherwise.
	 */
	

	public boolean checkAssociation(Resource r) {
		
		assert (r!=null) : "ResourceRegister: the resource has null value.";

		return associations.containsKey(r);
	}
	
	
	
	/**
	 * Associates a resource to a descriptor.<br><br>
	 * You can associate the same descriptor even to two or more resource. <br>
	 * If you associate a descriptor to a resource already existing in the registry, the old descriptor will be overwrite from the new descriptor.<br>
	 * If you don't want to overwrite an association when the resource already exists, use the method checkAssociation to check for resource presence in the registry.<br><br> 
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 2-The descriptor is not equal to null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-The descriptor is associated correctly.<br><br>
	 * 
	 * @param r The resource for which you want to associate a descriptor.
	 * @param d The descriptor you want to associate.
	 * 
	 */
	
	
	public void associateDescriptor(Resource r, Descriptor d) {
		
		assert (r!=null) : "ResourceRegister: the resource has null value.";
		assert (d!=null) : "ResourceRegister: the descriptor has null value.";

		associations.put(r, d);
	}
	
	/**
	 * Returns the descriptor associated to a resource.<br><br>
	 * Remember: the only condition for which it's returned null is only if resource doesn't exist. This because in the association you can't associate a null descriptor, so any associations will be with two not null values.
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's returned the associated descriptor if resource exists or null otherwise.<br><br>
	 * 
	 * @param r The resource of which you want to get the associated descriptor.
	 * @return  The associated descriptor if resource exists or null otherwise.
	 * 
	 */

	public Descriptor getDescriptor(Resource r) {
		
		assert (r!=null) : "ResourceRegister: the resource has null value.";

		return associations.get(r);

	}
	
	/**
	 * Removes a resource and its associated descriptor from the register.<br><br>	 
	 * 
	 * Preconditions: <br><br>
	 * 1-The resource is not equal to null.<br>
	 * 
	 * Postconditions:<br><br>
	 * 1-It's removed the resource and the associated descriptor.<br><br>
	 * 
	 * @param r The resource-descriptor association you want to remove.
	 * 
	 */


	public void removeAssociation(Resource r) {
		
		assert (r!=null) : "ResourceRegister: the resource has null value.";

		associations.remove(r);


	}


}
