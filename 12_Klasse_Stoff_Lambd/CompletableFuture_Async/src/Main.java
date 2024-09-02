import java.util.concurrent.CompletableFuture;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting process ...");
		
		
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenAccept(value -> System.out.println("Completed: " + value));
		
		// this if u want to call a void method
		// CompletableFuture.runAsync(()-> ...) 

		
		System.out.println("Process called ...");
		
		System.out.println("Sleeping for a little bit...");
		
		sleepAlittle();
		
		System.out.println("Done sleeping");
	}
	
	public static int longNetworkProcess(int value){		
		sleepAlittle();
		return value * 10;
	}
	
	public static void sleepAlittle() {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
