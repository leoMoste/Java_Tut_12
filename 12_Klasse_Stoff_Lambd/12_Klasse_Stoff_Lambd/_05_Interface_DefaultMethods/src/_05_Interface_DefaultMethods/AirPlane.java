package _05_Interface_DefaultMethods;

public class AirPlane implements Fly, IRun{

	@Override
	public int getSpeed() {
		return 150;
	}
	
	

}
