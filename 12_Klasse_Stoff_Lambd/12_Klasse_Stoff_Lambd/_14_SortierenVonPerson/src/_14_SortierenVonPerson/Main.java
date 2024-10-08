package _14_SortierenVonPerson;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static Person[] Persons = {
			new Person("Zach", 180, "Mann"),
			new Person("Tim", 177, "Mann"),
			new Person("Ann", 168, "Frau")};

	public static void main(String[] args) {
		//SortNachKoerperGroesse();
		//SortNachKoerperGroesseAbsteigend();
		//SortNachNamen();
		//SortNachGeschlechtUndNamen();
		/* for (Person person : Persons) {
		        System.out.println(person);
		 }
		 */
		
		Arrays.sort(Persons, (Person p1, Person p2)-> {
			
			  return p1.getName().compareTo(p2.getName());  
		});

		/*for (Person person : Persons) {
	        System.out.println(person);
		}*/
		
		Arrays.sort(Persons, (p1,p2)-> 
			Integer.compare(p2.getKoerpergroesse(), p1.getKoerpergroesse())
		);
		
		for (Person person : Persons) {
	        System.out.println(person);
		}
		
		
		
	}
	
	/*
	 * No Need to Implement Comparator: If you're only using the comparison logic in a single place (like within 
	 * the SortNachKoerperGroesse method), the lambda expression is sufficient, and you don't need to implement 
	 * the Comparator interface explicitly.
	 * 
	 */
	
	
	public static void SortNachKoerperGroesse() {
		Arrays.sort(Persons, Comparator.comparingInt((Person p) -> p.koerpergroesse));
		
	}
	
	public static void SortNachKoerperGroesseAbsteigend() {
	    Arrays.sort(Persons, Comparator.comparingInt((Person p) -> p.koerpergroesse).reversed());
	}
	
	public static void SortNachNamen() {
	    Arrays.sort(Persons, Comparator.comparing((Person p) -> p.name));
	}
	
	public static void SortNachGeschlechtUndNamen() {
	    Arrays.sort(Persons, Comparator.comparing(
	    		(Person p) -> p.geschlecht)
	    		.thenComparing((Person p) -> p.name)
	    );
	}
	

}
