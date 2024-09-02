package Wetterstation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WetterdatenVerwaltung {

	private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String leseTemperatur(String datei) {
        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            return "Fehler beim Dateizugriff! – angegebene Datei nicht vorhanden!";
        } catch (IOException e) {
            return "Fehler beim Dateizugriff! – Lesefehler!";
        }
    }

    public boolean schreibeTemperatur(String datei, double tempWert) {
        String timestamp = TIMESTAMP_FORMAT.format(new Date());
        String data = timestamp + ";" + tempWert;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datei))) {
            writer.write(data);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        } 
    }

    public String maxWertSpeichern(double tempWert) {
        String datei = "H:\\12. Klasse\\Java\\Dateiverarbeitung\\Wetterstation\\maxtemp.txt";
        try {
            String temp = leseTemperatur(datei);
            if (temp.equals("Fehler beim Dateizugriff! – Lesefehler!")
                    || temp.equals("Fehler beim Dateizugriff! – angegebene Datei nicht vorhanden!")) {
                return temp;
            }

            String[] parts = temp.split(";");
            double gespeicherterWert = Double.parseDouble(parts[1]);
            if (tempWert > gespeicherterWert) {
                if (schreibeTemperatur(datei, tempWert)) {
                    return TIMESTAMP_FORMAT.format(new Date()) + ";" + tempWert;
                } else {
                    return "Fehler beim Dateizugriff – Schreibfehler!";
                }
            } else {
                return temp;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Fehler beim Dateizugriff! – Ungültiges Format in der Datei!";
        }
    }
}
