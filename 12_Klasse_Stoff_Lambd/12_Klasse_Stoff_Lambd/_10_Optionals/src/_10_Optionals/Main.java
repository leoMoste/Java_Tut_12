package _10_Optionals;

import java.util.Optional;

public class Main {

	public static Optional<Integer> sum(int x, int y){
		Optional<Integer> resultOptional = Optional.of(x + y);
		return resultOptional;
	}
	
	
	public static void main(String[] args) {
		//  Where to use Optional
		//- Best Practice: in method returns.
		// - to force Caller code to check for null.
		//- Used With Streams / Functional Programming
		 
		/*
		 * When NOT to use Optiona!!
			
			- Do NOT use in method arguments.
			- Do NOT declare member variables as Optionals
			- Optional does NOT implement Serializable
			- Do NOT use in Constructor arguments,
			- Do NOT use in Collections, lists.
		  */
		
		Optional<String> dataOptional = Optional.empty();
								//IllegalArgumentException::new : supplier
		String data2 = dataOptional.orElseThrow(IllegalArgumentException::new);
		
		
		   // to force Caller code to check for null.
			Optional<Integer> myInt = sum(10, 15);
			if (myInt.isPresent()) {
				System.out.println(myInt.get());	
			}
			
			// in one step "short way"
			myInt.ifPresent(System.out::println);
		

	}

}
