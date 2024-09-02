import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Karte> klist = new ArrayList<Karte>();
		klist.add(new Karte(10, "Huber", true, true));
		klist.add(new Karte(11, "", false, false)); 
		klist.add(new Karte(31, "", true, false)); 
		klist.add(new Karte(35, "", true, false)); 
		klist.add(new Karte(20, "Maier", true, true));

        int menue, nummer; 
        String name="";
        boolean platzBesetzt = false;
            
        
        
        do
        {
           menue = Allgemein.eingabeInt("Karte Buchen (1) \nReservierungen verwalten(2)\nBeenden(0)\nIhre Wahl:", 0, 2);
           

           if(menue==1) {
        	   System.out.println("Diese Plätze können gebucht werden:");
        	   
        	   print(klist, k-> k.isBelegbar() && !k.isVerkauft());
        	   
        	   nummer = Allgemein.eingabeInt("Welche Nummer möchten Sie buchen?");
        	   for (Karte k :klist)
               { 
                   if (k.getNummer() == nummer && k.isBelegbar()&& !k.isVerkauft())
                   {
                       k.setVerkauft(true);
                       name = Allgemein.eingabeString("Auf welchen Namen soll der Sitzplatz reserviert werden? ");
                       k.setName(name);
                   }
               }
        	   System.out.println("Auf Ihren Namen sind folgende Karten gebucht:");
        	//Alternativ mit der Predicate-Methode--> Achtung Tricksen für eine nahezu finale Variable
        	//String name2=name;
        	//print(klist,karte->karte.GetName().equals(name2));
        	   
        	   for (Karte k :klist)
               {
        		   if(k.getName().equals(name)) {
        			   
        			   k.print();
        		   }
               }
        	     	 
        	   
           }
           else if (menue ==2)
            {
        	   
        	   System.out.println("Unsortiert");
               
               klist.forEach(k->k.print());
               Collections.sort(klist, (k1,k2)-> {
               	if(Boolean.compare(k1.isBelegbar(), k2.isBelegbar())==0){
               	return Integer.compare(k1.getNummer(), k2.getNummer());}else {
               		//negativ wenn erster Para false und zweiter True
               		//positiv wenn erster True und zweiter false
               		return Boolean.compare(k2.isBelegbar(), k1.isBelegbar());}
               		
               	}   );     	
              
               
               System.out.println("Sortiert V1");
               klist.forEach(Karte::print);
               System.out.println("Sortiert V2");
               klist.forEach(System.out::print);
               
            }
           else {
        	   System.out.println("Programm wird beendet!");
           }
           
        } while (menue != 0);

       
    }
	private static void print(ArrayList<Karte> list, Predicate<Karte> kriterium)
	{
		for(Karte i: list)
		{
			if( kriterium.test(i))
			{
				i.print();
			}
		}
		System.out.println();
	}



}
