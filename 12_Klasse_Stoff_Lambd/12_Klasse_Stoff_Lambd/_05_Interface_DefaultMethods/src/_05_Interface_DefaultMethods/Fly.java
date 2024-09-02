package _05_Interface_DefaultMethods;

public interface Fly {
	
	default int getSpeed() {
		System.out.println("I can Flay....");
		return 110;
	}

}
