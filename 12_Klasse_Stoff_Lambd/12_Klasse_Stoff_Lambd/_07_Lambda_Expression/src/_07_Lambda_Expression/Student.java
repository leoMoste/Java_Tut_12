package _07_Lambda_Expression;

public class Student {

	private String firstName;
	private String lastName;
	private int score;

	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(String firstName, String lastName, int score) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student: [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + "]";
	}
	
	
	
}
