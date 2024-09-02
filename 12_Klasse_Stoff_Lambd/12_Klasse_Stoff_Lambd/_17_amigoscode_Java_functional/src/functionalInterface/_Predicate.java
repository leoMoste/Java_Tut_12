package functionalInterface;

public class _Predicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPhoneNumberValid("07000000000"));
		System.out.println(isPhoneNumberValid("09000896000"));

	}
	
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	}

}