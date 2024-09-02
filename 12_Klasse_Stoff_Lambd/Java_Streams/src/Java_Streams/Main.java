package Java_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
	/*
	 * Streams
		A Stream is a representation of the collection facilitates 
		the Data processing >
		It doesn't store the data
		You specify what is required NOT how to achieve it.
	 * 
	 * */
		
	// the Wrapper Classes like Integer or Double
	// accept nullable values or in Java "Optional"
	Integer[] myArrayOfInt = new Integer[] {10, 21, 30, 33 ,50};
	
	Stream<Integer> myFirstStream = Arrays.stream(myArrayOfInt);
	
	
	/*
	 * You should not use return in a single-expression lambda. Instead, 
	 * simply write the expression directly. Use return inside a block 
	 * if the lambda body contains multiple statements.
	 * */
	
	// Single Expression: When the lambda expression contains a single 
	// expression, you do not need to use return.
	// long count = myFirstStream.filter(i -> i%2==0).count();
	
	// Block of Statements: When the lambda expression contains a block 
	// of statements enclosed in {},
	long count = myFirstStream.filter(i -> {
	    return i % 2 == 0;
	}).count();

	System.out.println(count);

	/*
	 * stream has already been operated upon or closed
	long count2 = myFirstStream.filter(i -> {
	    return i % 2 == 1;
	}).count();

	System.out.println(count2);
	*/
	
	 List<String> cars = List.of("Volvo", "BMW", "Ford", "Mazda", "Benz");
		/*
		new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    */
	 
     // Using method reference
     // cars.stream().forEach(System.out::println);

	 // Stream Source -> Intermediate operation 1 
	 //        -> Intermediate operation 2 -> Terminal operation (like forEach())
     // Using lambda expression 
     cars.stream()
     .filter(s-> s.startsWith("B"))
     .sorted()
     .forEach(car -> System.out.println(car));
	
}

}
