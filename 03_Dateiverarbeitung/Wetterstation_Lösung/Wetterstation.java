package Wetterstation;

import java.util.Scanner;

public class Wetterstation {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Neuen Temperaturwert eingeben: ");
	        
	        if (scanner.hasNextDouble()) {
	            double neuerWert = scanner.nextDouble();
	            WetterdatenVerwaltung wetterVerwaltung = new WetterdatenVerwaltung();
	            String result = wetterVerwaltung.maxWertSpeichern(neuerWert);

	            if (result.equals("Fehler beim Dateizugriff! – Lesefehler!")
	                    || result.equals("Fehler beim Dateizugriff! – angegebene Datei nicht vorhanden!")
	                    || result.equals("Fehler beim Dateizugriff – Schreibfehler!")
	                    || result.equals("Fehler beim Dateizugriff! – Ungültiges Format in der Datei!")) {
	                System.out.println("Fehlermeldung: " + result);
	            } else {
	                System.out.println("Aktuell gespeicherter Temperaturwert (maximal): " + result);
	            }
	        } else {
	            System.out.println("Ungültige Eingabe für Temperaturwert!");
	        }
	        
	        scanner.close();
	    }
}
