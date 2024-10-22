package _16_Kinokartenverwaltung;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Karte> kartenListe = new ArrayList<>();

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Adding Karte objects to the ArrayList
	    kartenListe.add(new Karte(10, "Huber", true, true));
	    kartenListe.add(new Karte(11, "", false, false));
	    kartenListe.add(new Karte(20, "Maier", true, true));
	    kartenListe.add(new Karte(13, "", true, false));
		
	    Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Bitte wählen: (1) Karte buchen, (2) Reservierungen verwalten, (0) Beenden");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    buchen(scanner);
                    break;
                case 2:
                    verwalten();
                    break;
                case 0:
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
	    
	}

	public static void buchen(Scanner scanner) {
		// Display all available (bookable and not sold) seats to the user
	      System.out.println("Verfügbare Plätze:");
	        for (Karte karte : kartenListe) {
	            if (karte.isBelegbar() && !karte.isVerkauft()) {
	                karte.print();
	            }
	        }

	     // Prompt the user to enter their desired seat number
	        System.out.println("Bitte Platznummer eingeben:");
	        int nummer = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        // Find the Karte object that matches the entered seat number and is available
	        Karte zuBuchendeKarte = null;
	        for (Karte karte : kartenListe) {
	            if (karte.getNummer() == nummer && karte.isBelegbar() && !karte.isVerkauft()) {
	                zuBuchendeKarte = karte;
	                break; // Stop the loop once the matching seat is found
	            }
	        }

	        // If a valid Karte was found, proceed with booking the ticket
	        if (zuBuchendeKarte != null) {
	            System.out.println("Bitte Ihren Namen eingeben:");
	            String name = scanner.nextLine();
	            
	         // Set the user's name and mark the seat as sold
	            zuBuchendeKarte.setName(name);
	            zuBuchendeKarte.setVerkauft(true);
	            System.out.println("Karte erfolgreich gebucht!");
	            
	            
	            System.out.println("Ihre gebuchten Karten:");
	            for (Karte karte : kartenListe) {
	                if (karte.getName().equals(name)) {
	                    karte.print();
	                }
	            }
	        } else {
	            System.out.println("Ungültige Platznummer oder Platz ist nicht verfügbar.");
	        }
    }
	
	   public static void verwalten() {
	        System.out.println("Alle Karten (unsortiert):");
	        //kartenListe.forEach(System.out::println);
	        kartenListe.forEach(karte -> karte.print());
	        
	        System.out.println("Alle Karten (sortiert nach belegbar und dann absteigend nach Nummer):");

	        // Sortieren der Kartenliste nach belegbar und dann absteigend nach Nummer
	       /* kartenListe.sort(new Comparator<Karte>() {
	            @Override
	            public int compare(Karte k1, Karte k2) {
	                int belegbarComparison = Boolean.compare(k2.isBelegbar(), k1.isBelegbar());
	               
	                if (belegbarComparison == 0) {
	                    return Integer.compare(k2.getNummer(), k1.getNummer());
	                }
	                return belegbarComparison;
	            }
	        });*/
	        
	        /*
	         * In the lambda expression (Karte karte) -> karte.isBelegbar, you're treating isBelegbar as 
	         * if it were a field, but it's actually a method. You should call it as karte.isBelegbar() (with parentheses) 
	         * to correctly reference the method that returns a boolean value.
	         * */
	        kartenListe.sort(Comparator.comparing((Karte karte) -> karte.isBelegbar()).reversed().
	        thenComparing(Comparator.comparingInt((Karte karte) -> karte.getNummer()).reversed()));

	        for (Karte karte : kartenListe) {
	            karte.print();
	        }
	    }
	
	
	
	
}
