package _101_Comparing;

import java.util.Comparator;


public class StudentGPACompartor implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		//return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
		
		// Compare by GPA first
		int gpaComparison = Double.compare(o1.gpa, o2.gpa);
		
		if(gpaComparison == 0)
		{
			
			/*
			 * Even though Comparator and Comparable are distinct interfaces, 
			 * using compareTo within a Comparator implementation is common
			 * because many fields you compare (such as String, Integer, Double) 
			 * already implement the Comparable interface.
			 * 
			 * */
		
			return o1.name.compareTo(o2.name);
			
			// Alternatively, you could use:
			// return Comparator.comparing(String::toString).compare(o1.name, o2.name);
		}
		
		 // Otherwise, return the GPA comparison result
        return gpaComparison;
	}

}
