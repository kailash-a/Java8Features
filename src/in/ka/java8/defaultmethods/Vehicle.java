package in.ka.java8.defaultmethods;

/**
 * Interface for Default Method Example
 * @author kailash
 *
 */
public interface Vehicle {
	public static final String basic="BASIC";
	public static final String luxary="LUXARY";
	public static final String commercial="COMMERCIAL";
	
	public String type();
	public int wheels();
	public String vClass();
	
	
	/* Default methods enable us to add new functionalities to interfaces 
	 * without breaking the classes that implements that interface.
	 * This default method is available to all the implementing classes 
	 * and default value returned is "WHITE"
	 */
	default public  String color(){
		return "WHITE";
	}
}
