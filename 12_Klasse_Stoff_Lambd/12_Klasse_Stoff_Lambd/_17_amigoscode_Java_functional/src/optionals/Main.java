package optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object value = Optional.ofNullable("Hello")
					.orElseGet(() -> "default value");
	
			
		System.out.println(value);
		
		
		Optional.ofNullable("john@gmail.com")
				.ifPresent(email -> System.out.println("Sending email to " + email));
		
	}

}
