package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {

	public static void main(String[] args) {
		
		System.out.println(getDbConnectionUrl());
		System.out.println(getDbConnectionUrlSupplier.get());
	}
	// IN C# is Like the Func<String> Delegate
	// the perpuse to use this function here
	// is simply to return a value 
	static String getDbConnectionUrl() {
		return "jdbc://localhost:5432/users";
	}
	
	static Supplier<String> getDbConnectionUrlSupplier = () -> {
		return "jdbc://localhost:5432/users";
	};

}
