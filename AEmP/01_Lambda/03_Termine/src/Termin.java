import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Termin {
	
	//Variablen
	private String beschreibung;
	private String ort;
	private LocalDateTime zeit;
	
	
	//Konstruktor
	public Termin(String b, String o, LocalDateTime z)
	{
		beschreibung = b;
		ort = o;
		zeit = z;		
	}
	
	
	//Getter und Setter
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public LocalDateTime getZeit() {
		return zeit;
	}
	public void setZeit(LocalDateTime zeit) {
		this.zeit = zeit;
	}
	
	
	//To String, für Tabbelarische ausgabe
	@Override
	public String toString()
	{		
		DateTimeFormatter formatter;
		formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		return padRight("|" + beschreibung, 25) + padRight("|" + ort, 20) + "|" + zeit.format(formatter)+"|";
	}
	
	
	//Methode, welche einen String auf eine bestimmte länge auffüllt
	public static String padRight(String input, int length) 
	{
	    if(input.length() >= length) 
		{
	        return input;
	    }
	    
	    String sb = new String();
	    while (sb.length() < length - input.length()) 
	    {
	        sb += ' ';
	    }
	    
	    input += sb;

	    return input;
	}

}
