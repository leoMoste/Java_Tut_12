import java.time.LocalDate;

public class Kunde implements Cloneable {
	/*
	 * KopierKunstruktor public Kunde(Kunde k) { this.knr = k.getKnr(); this. ....
	 * 
	 * }
	 */
	private String kname;
	private LocalDate kgebdat;

	public Kunde(int knr, String kname, LocalDate kgebdat) {

		this.knr = knr;
		this.kname = kname;
		this.kgebdat = kgebdat;
	}

	private int knr;

	public int getKnr() {
		return knr;
	}

	public void setKnr(int knr) {
		this.knr = knr;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public LocalDate getKgebdat() {
		return kgebdat;
	}

	public void setKgebdat(LocalDate kgebdat) {
		this.kgebdat = kgebdat;
	}

	public String ausgabe() {
		String aus = "#" + this.knr + "#" + this.kname + "#" + this.kgebdat;
		return aus;
	}

	public void print() {

		System.out.println(this.getKnr() + " " + this.getKname() + " " + this.getKgebdat());
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
