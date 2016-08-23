package in.ka.util;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	
	private String name;
	private String designation;
	private int empId;
	private int salary;

	public Person(String name, String designation, int empId,int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.empId = empId;
		this.salary=salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Kailash", "Lead Engineer", 1,50000));
		personList.add(new Person("Harish", "CA", 2,4000));
		personList.add(new Person("Kaushal", "Business", 3,8000));
		personList.add(new Person("Sandeep", "SE", 4,6000));
		personList.add(new Person("prateek", "CA", 5,2000));
		personList.add(new Person("Suraj", "SE", 6,1000));
		personList.add(new Person("Krishan", "Business", 7,9000));
		personList.add(new Person("Ashish", "SE", 8,8000));
		personList.add(new Person("Shivam", "CA", 9,10000));
		return personList;

	}
	
	public String toString() {
		return this.getEmpId() + ":" + this.getName();
	}

}
