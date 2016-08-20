package in.ka.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

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

	public static void listIterationEx() {
		System.out.println("==================Iterate List Example ===========");
		List<Person> list = Person.getPersonList();
		// print list with new Lambda and for each support for Collections
		list.forEach(person -> {
			System.out.println(person.getName());
		});
	}

	public static void predicateLambdaEx() {
		System.out.println("==================Predicate Example ===========");
		List<Person> personList = Person.getPersonList();

		Predicate<String> allSE = (n) -> n.equalsIgnoreCase("SE");
		simpleFilter(personList, allSE);
	}

	public static void simpleFilter(List<Person> personList, Predicate condition) {
		for (Person p : personList) {
			if (condition.test(p.getName())) {
				System.out.println(p.getName() + " ");
			}
		}
	}
}

class Person {
	private String name;
	private String designation;
	private String empId;

	public Person(String name, String designation, String empId) {
		super();
		this.name = name;
		this.designation = designation;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Kailash", "Lead Engineer", "01"));
		personList.add(new Person("Harish", "CA", "03"));
		personList.add(new Person("Kaushal", "Business", "03"));
		personList.add(new Person("Sandeep", "SE", "04"));
		personList.add(new Person("prateek", "CA", "05"));
		personList.add(new Person("Suraj", "SE", "06"));
		return personList;

	}

}