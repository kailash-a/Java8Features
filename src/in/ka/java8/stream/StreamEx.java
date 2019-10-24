package in.ka.java8.stream;

import in.ka.util.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kailash 
 * 		   Java 8 is bringing on new Streams API java.util.stream
 *         package, which allow you to process elements of Java Collections in
 *         parallel. Java is inheritably sequential and there is no direct mean
 *         to introduce parallel processing at library level, stream API is
 *         going to fill that gap. By using this, you can filter elements of
 *         collection on given criterion e.g. if you have a List of Person, you
 *         can filter orders Person upon there states/properties.
 */

public class StreamEx {
	// get a sequential stream from list.
	static Stream<Person> personSeqStream = Person.getPersonList().stream();
	// get a parallel stream from list.
	static Stream<Person> personParallelStream = Person.getPersonList().parallelStream();

	public static void main(String[] args) {

		// filter stream example to get only those employees having designation as "SE"
		List<Person> person = personSeqStream
				.filter(personSeqStream -> "SE".equals(personSeqStream.getDesignation()))
				.collect(Collectors.toList());
		System.out.println("person : " + person);

		// combine multiple conditions
		// cannot use the same stream twice as it is already consumed above
		List<Person> personCondition = Person.getPersonList().stream()
				.filter(personSeqStream -> "SE".equals(personSeqStream.getDesignation()) && personSeqStream.getEmpId() > 5)
				.collect(Collectors.toList());
		System.out.println("person : " + personCondition);

		// distinct designations using map
		List<String> personDistinct = Person.getPersonList().stream()
				.map((s) -> s.getDesignation()).distinct()
				.collect(Collectors.toList());
		System.out.println("person : " + personDistinct);

		// Minimum salary from stream
		Person personMinSalary = Person.getPersonList().stream()
				.min((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary())).get();
		System.out.println("person : Min Salary -> " + personMinSalary + "=" + personMinSalary.getSalary());

		// Maximum salary from stream
		Person personMaxSalary = Person.getPersonList().stream()
				.max((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary())).get();
		System.out.println("person : Max Salary -> " + personMaxSalary + "=" + personMaxSalary.getSalary());

	}

}
