package _06_Functional_Intrface;

public class FunctionalImpl implements MyFunctionalInterface{

	@Override
	public void tryString(String str) {
		System.out.println(str.toUpperCase());	
	}
	

	
}
