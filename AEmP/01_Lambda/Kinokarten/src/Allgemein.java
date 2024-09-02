import java.util.Scanner;

public class Allgemein {
	public static int version = 1;
	static Scanner s;

    public static String eingabeString(String ausgabe)
    {
        String eingabe;

        System.out.println(ausgabe);
        s=new Scanner(System.in);
        eingabe = s.nextLine();   

        return eingabe;
    }

    
    public static int eingabeInt(String ausgabe)
    {
        String eingabe;
        int ergebnis=0;
        do
        {
            eingabe = eingabeString(ausgabe);
            try{
            ergebnis= Integer.parseInt(eingabe);
            }catch(NumberFormatException e)
            {
            	eingabe=null;
            }
        }
        while (eingabe==null);
        return ergebnis;
    }
    public static int eingabeInt(String ausgabe, int min, int max)
    {
        int ergebnis = 0;
        do
        {
        	System.out.println("Ung�ltige Eingabe!");
            ergebnis = eingabeInt(ausgabe);
        }
        while (ergebnis < min || ergebnis > max);
        return ergebnis;
    }


}

