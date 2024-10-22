package _08_Method_Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		// ::Method Reference::
		// it is a short way to write a lambda exp

		/* A shorthand for Lambda Expression >
		Lambda is a shorthand for Functional Interface
		
		It's a way to call the method and pass the
		parameters in one short step
		*/
		
		/*
		 * Method :: Reference
			Types & Syntax
			1- Instance::member Method
			2- Class::static Method
			3- class::member Method
			4- Class::new  => Contractor Reference
		 */
		/*
		 * 3- class::member Method
		 * (String::concat) // expected x,y
		 * x.concat(y)
		 * */
		
		// 1) Instance::member Method
		 InstanceMethodReferenceExample instance = new InstanceMethodReferenceExample();
	     Consumer<String> methodRef = instance::printMessage; // Instance::memberMethod
	     methodRef.accept("Hello, World!"); // Output: Hello, World!
		
		// 2) Class::static Method
	     BiFunction<Integer, Integer, Integer> methodRefStatic = StaticMethodReferenceExample::add; // Class::staticMethod
	     int result = methodRefStatic.apply(10, 20); // Output: 30
	     System.out.println(result);
	     
	     // 3) class::member Method
	     BiFunction<String, String, String> methodRefMember = String::concat; // Class::memberMethod
	     String resultX = methodRefMember.apply("Hello, ", "World!"); // Output: Hello, World!
	     System.out.println(resultX);
		
	     // 4) Class::new  => Contractor Reference
	     Supplier<ExampleClass> constructorRef = ExampleClass::new; // Class::new
	     ExampleClass instanceOf = constructorRef.get(); // Output: Constructor called!
	   
		//////////////////////////////
	     /////////////////////
	     //TEST Class MethodReferenceEx
	     ////////////////////////
	     
	     List<String> stringList = new ArrayList<>();
	     stringList.add("Ahmed");
	     stringList.add("Ali");
	     stringList.add("Mohmed");
	     
	     MethodReferenceEx instEx = new MethodReferenceEx();
	     
	  // 1) Instance::member Method
	     stringList.forEach(instEx::greetMe);
	     stringList.forEach(x -> instEx.greetMe(x));

	  // 2) Class::static Method
	     stringList.forEach(MethodReferenceEx::greetHim);
	  // lambda Exp with static Method using the class name
	     stringList.forEach(x -> MethodReferenceEx.greetHim(x));
	  
	     
	  // 3) class::member Method
	     stringList.forEach(String::toLowerCase);
	     stringList.forEach(x -> x.toLowerCase());  // the "x" here is the target where I make the changes on it
	     // Not Like the first type where the parameter use also as a parameter in the inner function

	     
	     

	     // in this scanrio I send each element in the List filter(instEx::isMyFriend)
	     // the in the function isMyFriend take the element as parameter
	     // and applay the condition on it
	     System.out.println("My Friend List");
	     stringList.stream().filter(instEx::isMyFriend).forEach(System.out::println);
	     
	     
	    
	     
	     
	}

}
