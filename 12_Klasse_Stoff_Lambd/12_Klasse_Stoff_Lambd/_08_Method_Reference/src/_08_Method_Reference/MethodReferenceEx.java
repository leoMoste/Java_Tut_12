package _08_Method_Reference;

public class MethodReferenceEx {
	
	public String concatTwice(String x, String y) {
		return x + y + y;
	}
	
	/*
	 * First Type of Method Refernce (instance with parameters)
	 * */
	
	public void greetMe(String me) {
		System.out.println("Greeting, " + me.toUpperCase());
	}
	
	
	public static void greetHim(String me) {
		System.out.println("Welcome, " + me);
	}
	
	

	public boolean isMyFriend(String x) {
		
		if("Ahmed".equalsIgnoreCase(x) || "Ali".equalsIgnoreCase(x)) {
			return true;
		}
		
		return false;
		
	}
	
	
}
