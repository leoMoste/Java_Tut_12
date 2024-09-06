package Streams;

import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import _17_amigoscode_Java_functional.Gender;
import _17_amigoscode_Java_functional.Person;

public class _Stream {

	public static void main(String[] args) {

		List<Person> people = List.of(
				new Person("John", Gender.MALE),
				new Person("Maria",Gender.FEMALE),
				new Person("Sara", Gender.FEMALE),
				new Person("Alex", Gender.MALE),
		        new Person("Alice", Gender.MALE)
	    );
		
	 	people.stream()
		        .map(person -> person.getGender())
		        .collect(Collectors.toSet())
		        .forEach(System.out::println);
	 	
	 	System.out.println("~~~~~~~");
	 	
	 /*	people.stream()
		        .map(person -> person.getName())
		        .mapToInt(name -> name.length())
		        .sorted()
		        .forEach(System.out::println);
	 
	 //genders.forEach(System.out::println);
	 
	// System.out.println(genders);
	 * 
	 * */
	 	
	 	boolean containsOnlyFemales = people.stream()
	 			.anyMatch(person -> Gender.FEMALE.equals(person.getGender()));
	 	
	 	
	 	
	 	System.out.println(containsOnlyFemales);
		
	}

}