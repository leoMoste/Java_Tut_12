
public class Person
{
	private String name;
	private char geschlecht;
	private int groesse;

	public Person(String name, char geschlecht, int groesse)
	{
		super();
		this.name = name;
		this.geschlecht = geschlecht;
		this.groesse = groesse;
	}

	
	public String getName()
	{
		return name;
	}


	public char getGeschlecht()
	{
		return geschlecht;
	}


	public int getGroesse()
	{
		return groesse;
	}


	@Override
	public String toString()
	{
		return "Person [name=" + name + ", geschlecht=" + geschlecht
				+ ", groesse=" + groesse + "]";
	}
}
