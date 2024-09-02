package _02_Inner_classes;

public class Outside {
	
	String x = "Hello ";
	
	public class Inside {
		String y = "World!";
		
		  public void Greeting()
		  {
		   System.out.println(x+y);
		  }
	}

}
