package in.ka.java8.defaultmethods;

/**
 * 
 * @author kailash
 * Java 8 provides us a way to add new methods to existing classes without breaking the
 * existing code of the implementing classes. we have a choice to either use the default 
 * implementation(inside Sedan class) of method provided in interface or override the method in 
 * implementing class(inside Truck class).
 */
public class DefaultMethodsEX {

	public static void main(String[] args) {
		Vehicle vehicle = new Sedan();
		System.out.println(vehicle);
		vehicle=new Truck();
		System.out.println(vehicle);
		vehicle=new ResolveAmbiguityEX();
		System.out.println(vehicle);
		
	}

}

/**
 * In class Sedan we Are using the default implementation of the color() method.
 */
class Sedan implements Vehicle {
	@Override
	public String type() {
		return "Sedan";
	}
	@Override
	public int wheels() {
		return 4;
	}
	@Override
	public String vClass() {
		return Vehicle.luxary;
	}
	
	public String toString(){
		return "[ "+this.wheels()+" Wheels "+this.type()+" with "+this.color()+" color ]";
	}
}


/**
 * In Truck class we are providing the custom implementation to the default color() method
 */
class Truck implements Vehicle{
	@Override
	public String type() {
		return "Truck";
	}

	@Override
	public int wheels() {
		return 6;
	}

	@Override
	public String vClass() {
		return Vehicle.commercial;
	}
	
	@Override
	public String color(){
		return "YELLOW";
	}
	
	public String toString(){
		return "[ "+this.wheels()+" Wheels "+this.type()+" with "+this.color()+" color ]";
	}
	
}

/**
 * If a class implements two interfaces having same default method name and signature
 * then compiler throw error and we are forced to provide the implementation of Default method in our
 * implementing class
 */
class ResolveAmbiguityEX implements Vehicle, Toy{

	@Override
	public String type() {
		return "TOY_VEHICLE";
	}

	@Override
	public int wheels() {
		return 4;
	}

	@Override
	public String vClass() {
		return "TOY";
	}
	
	public String color(){
		return "CUSTOM_FORCED_IMPLEMENTATION";
	}
	
	public String toString(){
		return "[ "+this.wheels()+" Wheels "+this.type()+" with "+this.color()+" of color ]";
	}
	
}