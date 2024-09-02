package _06_Functional_Intrface;


	/*
	 * - It's an interface that contains Single Abstract Method. (SAM)
	   - Are the basis for Lambda Expressions in functional programming.
	   - Lambda Expressions: is a block of Code that gets Passed around.
	   - Lambda Expressions: is code that will be executed later.
	   - Lambda Expressions: is like an anonymous class that define
	 * */
    @FunctionalInterface
	public interface MyFunctionalInterface {
	
    	public void tryString(String str);
    	//public void tryInt(Integer intOne); not allow to be @Functional Interface
    	
    	default String reveriseString(String str) {
    		return new StringBuilder(str).reverse().toString();
    	}
	}
