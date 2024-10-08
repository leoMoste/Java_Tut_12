package _15_Sortieren_von_Terminen;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;


public class Main {

	static  Termin[] termins = {
            new Termin("Meeting with Zach", LocalDateTime.of(2024, 12, 12, 9, 0), "Office"),
            new Termin("Lunch with Tim", LocalDateTime.of(2024, 5, 12, 12, 30), "Cafe"),
            new Termin("Conference with Ann", LocalDateTime.of(2024, 10, 30, 15, 0), "Convention Center")
        };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Print the array to verify
		System.out.println("Before");
        for (Termin termin : termins) {
            System.out.println(termin);
        }
        
        SortNachTermin();
        System.out.println("After");
        for (Termin termin : termins) {
            System.out.println(termin);
        }
	}
	
	public static void SortNachTermin() {
		Arrays.sort(termins, Comparator.comparing((Termin p) -> p.zeit));
		
	}
	
	
	

}
