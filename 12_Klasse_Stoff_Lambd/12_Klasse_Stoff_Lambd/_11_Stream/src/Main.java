
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Integer[] myIntegers = new Integer[] {10, 20, 22, 33, 50};

			// Arrays.stream => this function will take my
			// Array and create a stream from it 
		Stream<Integer> myStream = Arrays.stream(myIntegers);
		
	  long count = myStream.filter(i -> (i % 2 == 0)).count();
		
	 //System.out.println(count);
	 
	 
	/* that will throw Exception because, once we use the
	 * Stream we can not do another oprations on it
	 * long count2 = myStream.filter(i -> (i % 2 == 1)).count();
	 System.out.println(count2);
	*/
	 
	 List<String> myStrings = List.of("Ahmad" ,"Ali", "Mohammad", "Hasan");
	 // convert our List to stream like this
	 //myStrings.stream().sorted().filter(s -> s.startsWith("A")).forEach(System.out::println);
	 
	 
	 ////////////////
	 DoubleStream dStream = DoubleStream.of(10, 20, 303, 392, 299);
	 OptionalDouble avgDouble = dStream.filter(db -> db % 10 == 0).average(); // reduce()
	 if (avgDouble.isPresent()) {
		 System.out.println(avgDouble);
	}
	 else {
		System.out.println("No average found!!");
	}
	 
	 DoubleStream dStream2 = DoubleStream.of(100, 200, 3030, 3902, 2999);
	 
	 OptionalDouble valueInteger = dStream2.filter(i -> i % 2 == 0).average(); //with Intger or Double we use this because they do not have avg(), sum() ... methods => .reduce(0, (a , b) -> a +b);
	 System.out.println(valueInteger);
	}

}
