package _01_Optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Where to use Optional:
			- Best Practice: in method returns.
				- to force Caller code to check for null.
			- " Used With Streams / Functional
			  Programming"
		 *
		 *
		 * When NOT to use Optional:
			- Do NOT use in method arguments.
			- Do NOT declare Member variables as Optional
			- Optional does NOT implement Serializable
			- Do NOT use in Constructor arguments.
			- Do NOT use in Collections, lists.
		 */
		
		Optional<String> data = Optional.ofNullable("Welcome");
		
		// To Read the data in the "data", send a supplier IllegalArgumentException
		//String data2 = data.orElseThrow(IllegalArgumentException::new);
        String data2 = data.orElseThrow(() -> new IllegalArgumentException("No value present"));

		System.out.println(data2);
	}

}
