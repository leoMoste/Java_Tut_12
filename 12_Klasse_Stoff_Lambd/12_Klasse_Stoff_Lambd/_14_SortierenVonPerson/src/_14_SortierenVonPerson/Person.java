package _14_SortierenVonPerson;

public class Person {
	String name;
    int koerpergroesse;
    String geschlecht;

    Person(String name, int koerpergroesse, String geschlecht) {
        this.name = name;
        this.koerpergroesse = koerpergroesse;
        this.geschlecht = geschlecht;
    }

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getKoerpergroesse() {
		return koerpergroesse;
	}

	public void setKoerpergroesse(int koerpergroesse) {
		this.koerpergroesse = koerpergroesse;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	@Override
    public String toString() {
        return name + " (" + koerpergroesse + " cm, " + geschlecht + ")";
    }


}
