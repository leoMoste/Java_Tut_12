package _07_Lambda_Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 List<Student> students = new ArrayList<Student>();

	     // Add data to the list
	     students.add(new Student("John", "Doe", 85));
	     students.add(new Student("Jane", "Smith", 92));
	     students.add(new Student("Alice", "Johnson", 78));
	     students.add(new Student("Bob", "Brown", 88));	
	     
	     
	     // lambda Exp: (Student) -> "John".equalsIgnoreCase(Student.getFirstName())
	     // to Override a function of Functional Interface 
	     // Printname(students, (Student) -> "John".equalsIgnoreCase(Student.getFirstName()));
	     // Printname(students, (Student) -> "Brown".equalsIgnoreCase(Student.getLastName()));
	     //Printname(students, (Student) -> Student.getScore() > 85);
	    
	     Predicate<Student> myScorePredicate = (Student) -> Student.getScore() == 85;
	     Printname(students, (Student) -> Student.getScore() >= 85);
	     System.out.println("---------------");
	     Printname(students, myScorePredicate);
		
	}
	
	
	private static void Printname(List<Student> list, Predicate<Student> predicate) 
	{
		for (Student student : list) {
			if (predicate.test(student)) {
				System.out.println(student);
			}
		}
	}

}
