package _15_Sortieren_von_Terminen;

import java.time.LocalDateTime;

public class Termin {
	String beschreibung;
    LocalDateTime zeit;
    String ort;
  
	public Termin(String beschreibung, LocalDateTime zeit, String ort) {
		this.beschreibung = beschreibung;
		this.zeit = zeit;
		this.ort = ort;
	}
	
	
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public LocalDateTime getZeit() {
		return zeit;
	}
	public void setZeit(LocalDateTime zeit) {
		this.zeit = zeit;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}


	@Override
	public String toString() {
		return "Termin [beschreibung=" + beschreibung + ", zeit=" + zeit + ", ort=" + ort + "]";
	}
    
    
	
    
    
}
