
public class Karte {
	private int nummer;
    private String name;
	private boolean belegbar;
    private boolean verkauft;
	
  

    public Karte(int nummer,String name, boolean belegbar, boolean verkauft) {
    	
    	this.belegbar=belegbar;
    	this.verkauft=verkauft;
    	this.name=name;
    	this.nummer=nummer;
    }
	public void setBelegbar(boolean belegbar) {
		this.belegbar = belegbar;
	}
	 
	 public boolean isBelegbar() {
		return belegbar;
	}

	public boolean isVerkauft() {
		return verkauft;
	}

	public void setVerkauft(boolean verkauft) {
		this.verkauft = verkauft;
	}

	public String toString()
    {
    	String val = belegbar ? "Belegbar" : "Nicht Belegbar";
    	String val2 = verkauft ? "Verkauft" : "Frei";
    
       return ("Platznr.: " + nummer + "     Name: " + name + "     "+val + "     "+val2+"\n");
      
    }

    public void print()
    {
    	String val = belegbar ? "Belegbar" : "Nicht Belegbar";
    	String val2 = verkauft ? "Verkauft" : "Frei";
    
       System.out.println("Platznr.: " + nummer + "     Name: " + name + "     "+val + "     "+val2);
    }

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }
    public int getNummer()
    {
        return nummer;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
}


