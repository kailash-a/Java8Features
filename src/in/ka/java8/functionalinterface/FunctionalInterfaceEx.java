package in.ka.java8.functionalinterface;

import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceEx {
	public static void main(String[] args) {
		// Functional Function interface
		Function<Integer, Integer> adder = (number) -> number + 3;
		System.out.println(adder.apply(8));

		// predicate example
		Predicate<Object> isValid = (Object t) -> (t instanceof String);
		System.out.println(isValid.test(0));

		// Unary example
		UnaryOperator<StringBuilder> uOpertor = (StringBuilder s) -> s.append("this is newly appended");
		System.out.println(uOpertor.apply(new StringBuilder("Hi !!!!!")).toString());

		// Binary Operator
		BinaryOperator<StringBuilder> concatStrings = (StringBuilder t, StringBuilder s) -> t.append(s);
		System.out.println(concatStrings.apply(new StringBuilder("Hello "), new StringBuilder("World")).toString());

		// supplier
		Supplier<String> getRandomUUUID = () -> UUID.randomUUID().toString() + "1";
		System.out.println(getRandomUUUID.get());
		
		//consumer
		Consumer<String> log2kafka=(String t)->System.out.println("logging to kafka :: "+t);
		log2kafka.accept("message 2");

	}

}

/*
 * The Function interface represents a function (method) that takes a single
 * parameter and returns a single value Method 1
 */
class IncrementBy3 implements Function<Integer, Integer> {
	@Override
	public Integer apply(Integer t) {
		return t + 3;
	}
}

/*
 * Predicate represents a simple function that takes a single value as
 * parameter, and returns true or false
 */
class isValidPredicate implements Predicate<Object> {
	@Override
	public boolean test(Object t) {
		if (t instanceof String)
			return true;
		return false;
	}
}

/*
 * he Java UnaryOperator interface is a functional interface that represents an
 * operation which takes a single parameter and returns a parameter of the same
 * type
 */

class ChangeName implements UnaryOperator<StringBuilder> {
	@Override
	public StringBuilder apply(StringBuilder t) {
		return t.append("this is added newly.");
	}

}

/*
 * BinaryOperator interface is a functional interface that represents an
 * operation which takes two parameters and returns a single value. Both
 * parameters and the return type must be of the same type.
 */
class StringConcat implements BinaryOperator<StringBuilder> {
	@Override
	public StringBuilder apply(StringBuilder t, StringBuilder u) {
		return t.append(u);
	}

}
/*
 * The Java Supplier interface is a functional interface that represents an
 * function that supplies a value of some sorts. The Supplier interface can also
 * be thought of as a factory interface.
 */

class SupplierEx implements Supplier<Integer> {
	@Override
	public Integer get() {
		return (int) (Math.random() * 10);
	}

}

/*
 * The Java Consumer interface is a functional interface that represents an
 * function that consumes a value without returning any value. A Java Consumer
 * implementation could be printing out a value, or writing it to a file, or
 * over the network etc
 */
class ConsumerEx implements Consumer<String>{
	@Override
	public void accept(String t) {
		System.out.println("writing to kafka :: "+t);
	}
	
}

