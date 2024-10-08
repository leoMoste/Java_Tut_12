package _03_Anonymous_Class;

public class Main {

	public static void main(String[] args) {
		/*anonymous class = an inner class without a name
          only a single object is created from one "when we use this"
	      The object may have “extras” or "changes"
	      and no need to create a " Separate inner class "
	      ** when it only need it once.
	      => Helps us to avoid cluttering code with a separate class name
	
	      Syntax is similar to a constructor,
	      except that there is also a class definition
	      within a block of code.  
	      GREAT FOR LISTENERS
		 */
		
		
		/* The object may have “extras” or "changes"
	      and no need to create a " Separate inner class "
	      when it only need it once.
	     */
		
		Greeting greeting = new Greeting() {
			// this is like a whole new class definition
			// we can make a change to one of the methods
			// within Greeting class
			
			@Override // good practice
			public void Welcome() {
				System.out.println("Welcome, Hi bro!!!");
			}
			
		};
		
		Greeting greeting2 = new Greeting();
		
		//greeting.Welcome();
		//greeting2.Welcome();
		
		///////////////////////////////////
		// Real Coding scenario
		//////////////////////////////
		
		MyFrame myFrame = new MyFrame();
		
	}

}
