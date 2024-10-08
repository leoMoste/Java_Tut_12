package _04_Java_Lambda;

public class main {

	public static void main(String[] args) {
		/* lambda expression = 	feature for Java 8 and above
		* 						also known as an anonymous method
		* 						a shorter way to write anonymous classes with " only one method "
		*
		*						need to use a " functional interface " or use a Pre-defined functional interface
		*						they contain only == one abstract method ==
		*						ex. ActionListener, Runnable, (user-defined)
		*
		*						A Lambda expression can be used in any place where a functional interface is required
		*						How to use a lambda expression:
		*						(arguments) -> {statement/s}
		*/

		
		/* We can do this to access the method in the Interface
		 * MyInterface myInterface = new MyInterface() {
			public void message() {
				
			}
		};*/
		
		// But like this we do it with lambda expression
		String name = "Bro";
		
		/*
		 * So yes, the main reason behind lambdas is to allow functions or blocks of code 
		 * to be passed as parameters easily, making code more modular, reusable, and flexible. 
		 * This capability is particularly powerful in scenarios where you need to pass 
		 * different behaviours to methods, such as in event-driven programming, 
		 * collections processing, or when working with APIs that are designed to
		 * be extended with custom behavior.
		 * */
		MyInterface myInterface = (namex) -> {
			System.out.println("Hello World " + namex);
			System.out.println("Hello World2");
		};
		
		myInterface.message(name);
		
	}

}
