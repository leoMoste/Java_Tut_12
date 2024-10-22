package _09_Optionals_John;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// Optional: is a Container, that either has something 
		// in it or doesn't
		
	Optional<Cat> optionalmyCat =findCatByName("Fred");
		
		// Null check
	/*	
	 * if(myCat != null) 
		{
			System.out.println(myCat.getAge());
		}
		else {
			System.out.println(0);
		}
	 */
	
	/*
		if (optionalmyCat.isPresent()) {
			System.out.println(optionalmyCat.get().getAge());
		}
		else {
			System.out.println(0);
		}
	 */
	
	 /// second way to Null checking
	 Cat myCat = optionalmyCat.orElse(new Cat("UNKNOWN", 0));
	  // optionalmyCat.orElseGet() // this takes lambda exp Supplier<>
	 System.out.println(myCat);

	}
	
	/*
	 * this whole situation is where optionals come in 
	 * optionals are a better way to handle a situation
	 * where a method like this might not have a value
	 * and might send "NULL"
	 * */
	
	/*
	 private static Cat findCatByName(String name) {
		
		Cat cat = new Cat(name, 3);
		
		return null;		
	}
	*/
	
	// TO handle the null with Optional
	 private static Optional<Cat> findCatByName(String name) {
		Cat cat = new Cat(name, 3);
		return Optional.ofNullable(cat); // this cat can be either be null or not	
	}

}
