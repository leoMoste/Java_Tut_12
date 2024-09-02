import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {

		//Beispieldaten
		Termin[] terminArray = {
			new Termin("weiter arbeiten", "arbeit", LocalDateTime.now().plusHours(13)),
			new Termin("schlafen", "zuhause", LocalDateTime.now()),
			new Termin("mehr schlafen", "zuhause", LocalDateTime.now().plusHours(2)),
			new Termin("schlafen", "zuhause", LocalDateTime.now().plusDays(1)),
			new Termin("essen", "zuhause", LocalDateTime.now().plusHours(17)),
			new Termin("arbeiten", "arbeit", LocalDateTime.now().plusHours(8)),
			new Termin("leiden", "zahnartzt", LocalDateTime.now().plusHours(18)),
			new Termin("pause machen", "arbeit", LocalDateTime.now().plusHours(12))
								
		};
		
		//Sort-Methode aufrufen
		//SortNachZeit(terminArray);
		printTermine(terminArray, e -> e.getZ);

	}
	
	
	//Sortiert Termine nach der Zeit. die n�chstliegenden termine zuerst.
	public static void SortNachZeit(Termin[] array)
	{	  
		System.out.println("Sort 1 (Zeit):");
		System.out.println("");
		System.out.println("Vor dem Sortieren:");
		//TerminAusgeben(array);
		
//		Arrays.sort(array, (t1, t2) -> t1.getZeit().compareTo(t2.getZeit()));
//		
//		System.out.println("Nach dem Sortieren:");
		//TerminAusgeben(array);
	}

	
	//Methode zur tabellarischen ausgabe eines Termin-Arrays
	public static void TerminAusgeben(Termin[] array)
	{
		System.out.println("------------------------------------------------------------------");
		System.out.println(Termin.padRight("|Beschreibung", 25) + Termin.padRight("|Ort", 20) + Termin.padRight("|Zeit", 20) + "|");
		System.out.println("------------------------------------------------------------------");
		for(Termin t : array)
		{
			System.out.println(t.toString());
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	public static void printTermine(Termin[]array, Predicate<Termin> p) {
		for(Termin t : array) {
			if(p.test(t)) {
				System.out.println(t.toString());
			}
			
		}
	}
	
	
}
