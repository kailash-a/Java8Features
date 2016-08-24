package in.ka.java8.defaultmethods;

/**
 * Interface for Default Method Example
 * @author kailash
 *
 */
public interface Toy {
	public String type();
	default public String color(){
		return "WHITE";
	}
}
