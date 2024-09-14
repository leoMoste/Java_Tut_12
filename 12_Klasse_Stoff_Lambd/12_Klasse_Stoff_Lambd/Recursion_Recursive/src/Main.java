
public class Main {

	
	// Recursion:
	// Recursion in Java is a process in which a ,ethod calls itself continuously.
	// Amethod in Java that calls itself is called recursive method
	public static void main(String[] args) {
		//recursive method
		//fun();
		//int facturial = fact(5);
		//System.out.println("fact = " +facturial);
		
		int fib = fibonacci(9);
		System.out.println("fibonacci 7= " + fib);
	}
	
	static int count = 0;
	static void fun() {
		count++;
		if(count < 5) {  // base case => it is the condition, 
						 //that decide when the method will stop
			
			System.out.println("Hi");
			
			fun();
		}
	}
	
	static int fact(int n) {
		if(n == 1 || n == 0) {  
			return 1;
		}
		else {
			return n * fact(n-1);
		}
	}
	
	static int fibonacci(int n) {
		
		if(n == 0 || n == 1) { // base case may be one case or more than 1 case
			return n;
		}
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
	}

}
