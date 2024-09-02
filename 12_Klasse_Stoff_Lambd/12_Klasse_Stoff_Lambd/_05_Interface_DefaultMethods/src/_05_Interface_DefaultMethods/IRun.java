package _05_Interface_DefaultMethods;

public interface IRun {

	default int getSpeed() {
		System.out.println("I walk....");
		return 5;
	}
	
}

