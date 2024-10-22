package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
	int incerement = incrementByOne(1);
	
		System.out.println(incerement);
		
		int incerement2 = incrementByOneFunction.apply(1);
		
		System.out.println(incerement2);
		
		int multipleBy10Func = multipleBy10.apply(1);
		System.out.println(multipleBy10Func);
		
		Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
				incrementByOneFunction.andThen(multipleBy10);
		
		 int result = addBy1AndThenMultiplyBy10.apply(1);
	        System.out.println(result);

	     // BiFunction
	     //System.out.println(incrementByOneAndMultiply(4, 100)); // normal Java Function  
	    
	     System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));   // BiFunctional 
	        
	}
	
	// IN C# is Like the Func<int, int> Delegate
	
	// 1) Function<input, retrun Type>
	// this  and the below function are exact same thing 
	     // "input Type", "retrun Type"
	static Function<Integer, Integer> incrementByOneFunction = 
			(number) -> number + 1; // this is functional style way
			
	static Function<Integer, Integer> multipleBy10 = (number) ->
					number * 10;
	
	// Function<T , R>: Represents a function that accepts one 
	// argument and produce a result.
	// and this function is pretty munch is the same concept
	static int incrementByOne(int number) {
		return number + 1;
	}
	
	// 2) BiFunction<input1, input2,retrun Type>
	static	BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
			(number, numberToMultiplyBy) -> (number + 1) * numberToMultiplyBy;
	
	static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
		return (number + 1) * numberToMultiplyBy;
	}
	
}
