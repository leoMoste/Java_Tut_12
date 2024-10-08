package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// The Action<int> in C# is indeed analogous to the Consumer<Integer> 
// in Java
public class _Consumer {

	public static void main(String[] args) {
		
		greetCustomer(new Customer("Hassan", "888888"));
		
		greetCustomerConsumer.accept(new Customer("Ali", "555555"));
		greetCustomerConsumerBi.accept(new Customer("Ahmad", "7545848"), false);
	}
	
	// take the type of input parameter like here "Customer"
	// and return "void"
	static Consumer<Customer> greetCustomerConsumer = customer -> {
		System.out.println("Hello " + customer.customerName +
				", thanks for registering phone number " + 
				customer.customePhoneNumber);
	};
	
	
	static BiConsumer<Customer, Boolean> greetCustomerConsumerBi = (customer, showPhoneNumber) -> {
		System.out.println("Hello " + customer.customerName +
				", thanks for registering phone number " + 
				(showPhoneNumber ? customer.customePhoneNumber : "******"));
	};
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName +
				", thanks for registering phone number " + 
				customer.customePhoneNumber);
	}
	
	
	static class Customer {
		private String customerName ;
		private String customePhoneNumber ;
		
		
		public Customer(String customerName, String customePhoneNumber) {
			this.customerName = customerName;
			this.customePhoneNumber = customePhoneNumber;
		}
		
		
		
		
	}

}
