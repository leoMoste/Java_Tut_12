package _17_amigoscode_Java_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Person> people = List.of(
				new Person("John", Gender.MALE),
				new Person("Maria",Gender.FEMALE),
				new Person("Sara", Gender.FEMALE),
				new Person("Alex", Gender.MALE),
		        new Person("Alice", Gender.MALE)
	    );
		
		// Imperative approach (Imperative Programming)
		// Imperative Programming: we are defining every
		// single detail 
		List<Person> females = new ArrayList<>();
		
		for (Person person : people) {
			if(Gender.FEMALE == person.getGender()) {
				females.add(person);
			}
		}
		System.out.println("People List");
		people.forEach(System.out::println);
		
		System.out.println("~~~~~~~~~~~~~~");
		
		System.out.println("Females List");
		//females.forEach(System.out::println);
		
		
		// Declarative approach (Declarative Programming)
		
		System.out.println("people List with Declarative approach");
		
		Predicate<? super Person> predicate = (person) -> Gender.FEMALE == person.getGender();
		people.stream()
		 .filter(predicate)
		 .collect(Collectors.toList()).forEach(System.out::println);
		
		
	}

}
