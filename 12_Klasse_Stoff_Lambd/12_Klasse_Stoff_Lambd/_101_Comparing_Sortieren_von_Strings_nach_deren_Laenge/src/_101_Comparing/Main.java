package _101_Comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//demo1();
			//demo2();
		     demo3();

     
	}
	
	private static void demo1() {
				System.out.println("Demo 1:");
				/*Arbeitsauftrag 1:*/
				Comparator<Student> gpaComparator = new StudentGPACompartor();
				Arrays.sort(students, gpaComparator);
				//Arrays.sort(students, gpaComparator.reversed());
				
				System.out.println(Arrays.toString(students));	
	}
	
	
	private static void demo2() {
		System.out.println("Demo 2:");
		/*Arbeitsauftrag 2:
		 * demo2 verwendet als Comparator eine anonyme innere Klasse,
		 * die das Interface Comparator<T> implementiert
		 * */
		//Comparator<Student> gpaComparator = new StudentGPACompartor();
		Arrays.sort(students, new StudentGPACompartor() {
			@Override
			public int compare(Student o1, Student o2) {
				
				int gpaComparison = Double.compare(o1.gpa, o2.gpa);
				if(gpaComparison == 0)
				{

					return o1.name.compareTo(o2.name);
					
					// Alternatively, you could use:
					// return Comparator.comparing(String::toString).compare(o1.name, o2.name);
				}
		        return gpaComparison;
			}
		});

		System.out.println(Arrays.toString(students));	
}
	
	
	private static void demo3() {
		System.out.println("Demo 3:");
		/*Arbeitsauftrag 3:
		 * * demo3 verwendet als Comparator ein Lambda
		 	* (es wird als Parameter übergeben)
		 * */
		//Comparator<Student> gpaComparator = new StudentGPACompartor();
		Arrays.sort(students, (Student o1, Student o2) -> {
				
				int gpaComparison = Double.compare(o1.gpa, o2.gpa);
				if(gpaComparison == 0)
				{

					return o1.name.compareTo(o2.name);
					
					// Alternatively, you could use:
					// return Comparator.comparing(String::toString).compare(o1.name, o2.name);
				}
		        return gpaComparison;
			
		});

		System.out.println(Arrays.toString(students));	
}

}
