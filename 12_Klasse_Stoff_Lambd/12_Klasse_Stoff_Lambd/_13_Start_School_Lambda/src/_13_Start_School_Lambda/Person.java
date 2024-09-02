package _13_Start_School_Lambda;

public class Person {
	
		String name;
	    int koerpergroesse;
	    String geschlecht;

	    Person(String name, int koerpergroesse, String geschlecht) {
	        this.name = name;
	        this.koerpergroesse = koerpergroesse;
	        this.geschlecht = geschlecht;
	    }

	    @Override
	    public String toString() {
	        return name + " (" + koerpergroesse + " cm, " + geschlecht + ")";
	    }
}
