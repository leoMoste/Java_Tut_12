package _16_Kinokartenverwaltung;

public class Karte {
	private int nummer;
	private String name;
	private boolean belegbar;
	private boolean verkauft;
	
	
	
	
	public Karte(int nummer, String name, boolean belegbar, boolean verkauft) {
		this.nummer = nummer;
		this.name = name;
		this.belegbar = belegbar;
		this.verkauft = verkauft;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBelegbar() {
		return belegbar;
	}
	public void setBelegbar(boolean belegbar) {
		this.belegbar = belegbar;
	}
	public boolean isVerkauft() {
		return verkauft;
	}
	public void setVerkauft(boolean verkauft) {
		this.verkauft = verkauft;
	}
	
	
	public void print() {
		 System.out.println("Karte [nummer=" + this.nummer + ", name=" + this.name + ", belegbar=" + this.belegbar + ", verkauft=" + this.verkauft + "]");
	}
	
	
	
	
	
	
}
