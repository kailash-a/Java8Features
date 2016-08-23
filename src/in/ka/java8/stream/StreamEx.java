package in.ka.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
	// get a sequential stream from list.
	static Stream<Person> personSeqStream = Person.getPersonList().stream();
	// get a parallel stream from list.
	static Stream<Person> personParallelStream = Person.getPersonList().parallelStream();

	public static void main(String[] args){
		//filter stream example to get only those employees having designation as "SE"
		List<Person> person = personSeqStream.filter(personSeqStream -> "SE".equals(personSeqStream.getDesignation())).collect(Collectors.toList());
		System.out.println("person : "+person);
		//combine multiple conditions
		//cannot use the same stream twice as it is already consumed above
		List<Person> personCondition = Person.getPersonList().stream().filter(personSeqStream -> "SE".equals(personSeqStream.getDesignation())&& personSeqStream.getEmpId()>5).collect(Collectors.toList());
		System.out.println("person : "+personCondition);
	}
	
}

class Person {
	
	
	private String name;
	private String designation;
	private int empId;

	public Person(String name, String designation, int empId) {
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Kailash", "Lead Engineer", 1));
		personList.add(new Person("Harish", "CA", 2));
		personList.add(new Person("Kaushal", "Business", 3));
		personList.add(new Person("Sandeep", "SE", 4));
		personList.add(new Person("prateek", "CA", 5));
		personList.add(new Person("Suraj", "SE", 6));
		personList.add(new Person("Krishan", "Business", 7));
		personList.add(new Person("Ashish", "SE", 8));
		personList.add(new Person("Shivam", "CA", 9));
		return personList;

	}

	public String toString() {
		return this.getEmpId() + ":" + this.getName();
	}

}