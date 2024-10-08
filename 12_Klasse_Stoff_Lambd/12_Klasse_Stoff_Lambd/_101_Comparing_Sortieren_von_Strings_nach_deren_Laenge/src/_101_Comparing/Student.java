package _101_Comparing;

import java.util.Random;

public class Student implements Comparable<Student>{

	private static int Last_ID = 1000;
	private static Random random = new Random();
	
	
	String name;
	private int id;
	protected double gpa;
	
	
	public Student(String name) {
		this.name = name;
		id = Last_ID++;
		gpa = 1.0 + (3.0 * random.nextDouble()); 
	}
	
	@Override
	public String toString(){
		return this.id + " - " + this.name + " - " + " ( " + this.gpa + " )";
	}

	@Override
	public int compareTo(Student o) {
		//return this.name.compareTo(o.name);// the will comapare the objects
	
		return Integer.valueOf(this.id).compareTo(Integer.valueOf(id));
	}
	

	/*@Override
	public int compareTo(Student o) {
		Student otherStudent = (Student) o;
		return this.name.compareTo(otherStudent.name);// the will comapare the objects
	}*/
	
}
