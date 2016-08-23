package in.ka.java8.lambda;

import in.ka.util.Person;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *  @author kailash
 * Since Lambda expression is effectively going to replace Anonymous inner class in new Java Code,
 * its important to do a comparative analysis of both of them.
 * One key difference between using Anonymous class and Lambda expression is the use of this keyword.
 * For anonymous class ‘this’ keyword resolves to anonymous class, whereas for lambda expression ‘this’ 
 * keyword resolves to enclosing class where lambda is written
 */


public class LambdaEX {
	public static void main(String[] args) {
		LambdaUseCases.runnableEx();
		LambdaUseCases.compratorEx();
		LambdaUseCases.listIterationEx();
		LambdaUseCases.predicateLambdaEx();

	}
}

class LambdaUseCases {
	
	public static void runnableEx() {
		System.out.println("==================Runnble Example ===========");
		Runnable r1 = () -> System.out.println("inside lambda Runnable");
		r1.run();
	}

	public static void compratorEx() {
		System.out.println("==================Compartor Example ===========");
		List<Person> list = Person.getPersonList();
		// Comparator Lambda Example
		Collections.sort(list, (Person o1, Person o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		// print list with new Lambda and for each support for Collections
		list.forEach(person -> {
			System.out.println(person.getName());
		});
	}

	//Iterate a list with lambda for Each loop
	public static void listIterationEx() {
		System.out.println("==================Iterate List Example ===========");
		List<Person> list = Person.getPersonList();
		// print list with new Lambda and for each support for Collections
		list.forEach(person -> {
			System.out.println(person.getName());
		});
	}

	//using predicate with lambda expressions
	public static void predicateLambdaEx() {
		System.out.println("==================Predicate Example ===========");
		List<Person> personList = Person.getPersonList();

		Predicate<String> allSE = (n) -> n.equalsIgnoreCase("SE");
		simpleFilter(personList, allSE);
	}
	
	public static void simpleFilter(List<Person> personList, Predicate<String> condition) {
		for (Person p : personList) {
			if (condition.test(p.getDesignation())) {
				System.out.println(p.getName() + " ");
			}
		}
	}
}
