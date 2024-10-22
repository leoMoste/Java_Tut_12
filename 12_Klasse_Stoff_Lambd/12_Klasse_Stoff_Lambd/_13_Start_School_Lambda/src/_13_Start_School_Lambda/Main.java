package _13_Start_School_Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
	            new Person("Alice", 30, "Mann"),
	            new Person("Bob", 25,"Mann"),
	            new Person("Charlie", 35, "Frau")
	        );
		
		// Sortieren der Liste nach Alter
		//people.sort((p1,  p2)-> Integer.compare(p1.age, p2.age));

		
		people.sort(Comparator.comparingInt(p -> p.koerpergroesse));
		
		//System.out.println(people);

	    people.sort(Comparator.comparingInt((Person p) -> p.koerpergroesse).reversed());
		
	   // people.sort((p1,  p2)-> Integer.compare(p1.age, p2.age));
		
		//System.out.println(people);
		
	    people.sort(Comparator.comparing((p) -> p.name)); // comparing for String
		//System.out.println(people);
		
		
		people.sort(Comparator.comparing((Person p) -> p.geschlecht).thenComparing((Person p) -> p.name));
		//System.out.println(people);

		//Sortieren mit dem ternären Operator in einem Lambda-Ausdruck
		people.sort((p1, p2) -> 
	    p1.geschlecht.equals(p2.geschlecht) 
	        ? p1.name.compareTo(p2.name) 
	        : p1.geschlecht.compareTo(p2.geschlecht)
	    );
		
		System.out.println(people);

		
		
	}

}
