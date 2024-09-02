import java.util.*;
import java.util.function.Predicate;

public class Programm
{
    static BetterArrayList<Karte> kinokarteArrayList = new BetterArrayList<>();

    public static void main(String[] args)
    {
        kinokarteArrayList.add( new Karte(10, "Huber", true, true));
        kinokarteArrayList.add( new Karte(11, "", false, false));
        kinokarteArrayList.add( new Karte(20, "Maier", true, true));
        kinokarteArrayList.add( new Karte(13, "", true, false));
        kinokarteArrayList.add( new Karte(16, "", true, false));
        kinokarteArrayList.add( new Karte(12, "", true, false));
        kinokarteArrayList.add( new Karte(9, "", true, false));
        kinokarteArrayList.add( new Karte(3, "", true, false));

        String eingabe;
        Scanner scanner = new Scanner(System.in);
       do
       {
           eingabe = EingabeString("(1)Kinokarten Buchen \n(2)Reservierung verwalten \n(0)Beenden",scanner);

       }while (!pruefeEingabe(eingabe));


        switch(eingabe)
        {
            case "1" ->
            {
                zeigeFreiePlaetze();
                platzBuchen(scanner);
            }
            case "2" ->
            {
                ausgabeUnsotiert();
                ausgabeSortiert();
            }
            case "0" -> beenden();
        }
        scanner.close();
    }

    // CASE 1
    private static void zeigeFreiePlaetze()
    {
        printKarte(x -> x.isBelegbar() && !x.isVerkauft());
    }
    private static void platzBuchen(Scanner scanner)
    {
        String eingabeName;
        String eingabeNummer;
        do
        {
            eingabeNummer = EingabeString("Welchen Platz möchten Sie buchen?",scanner);
        }while(!pruefeFreienPlatz(eingabeNummer));

        eingabeName = EingabeString("Geben Sie Ihren Namen ein: ", scanner);

        // Arraylist wird aktualisiert
        aktualisiereListe(eingabeName, eingabeNummer);
        zeigeEigeneBuchungen(eingabeName);
    }

    //CASE 2

    private static void ausgabeSortiert()
    {
        kinokarteArrayList.sort(Comparator.comparing((Karte::isBelegbar)).reversed());
        kinokarteArrayList.sort(Comparator.comparing((Karte::getNummer)).reversed());
        System.out.println("Ausgabe Sortiert");
        kinokarteArrayList.forEach(Karte::print);

    }

    private static void ausgabeUnsotiert()
    {
        System.out.println("Ausgabe Unsortiert");
        kinokarteArrayList.forEach( x -> x.print());
    }

    // CASE 0
    private static void beenden()
    {
        System.out.println("Beende Programm");
        System.exit(0);
    }

    private static void aktualisiereListe(String eingabeName, String eingabeNummer)
    {
        kinokarteArrayList.forEach(x -> {
            if(x.getNummer() == Integer.parseInt(eingabeNummer))
            {
                x.setName(eingabeName);
                x.setBelegbar(false);
                //x.setVerkauft(true);
            }
        });
    }



    private static void zeigeEigeneBuchungen(String eingabe)
    {
        System.out.println("Ihre eigenen Buchungen");
        printKarte(x -> x.getName().equals(eingabe));
    }


    private static String EingabeString(String text, Scanner scanner)
    {
        String eingabe ="";
        System.out.println(text);
        eingabe = scanner.next();

        return eingabe;
    }

    private static boolean pruefeFreienPlatz(String eingabe)
    {
        int eingabeInt;
        try
        {
            eingabeInt  = Integer.parseInt(eingabe);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return kinokarteArrayList.exists(x -> x.isBelegbar()
                && !x.isVerkauft() && x.getNummer() == eingabeInt);

    }

    public static void printKarte(Predicate<Karte> predicate)
    {
        kinokarteArrayList.forEach(x -> {
            if(predicate.test(x))
            {
                x.print();
            }
        });
    }

    private static boolean pruefeEingabe(String eingabe)
    {
        if(eingabe == null) {
           eingabe ="";
        }

        return switch (eingabe) {
            case "0", "1", "2" -> true;
            default -> false;
        };

    }
}
---------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;


public class BetterArrayList<T> extends ArrayList<T>
{
    public BetterArrayList() { }    
    public BetterArrayList(List<T> lst)
    {
        super(lst);
    }
    
    /**
     * Searches for an element that matches the conditions defined by the specified function, and returns the first occurrence within the entire BetterArrayList.
     * @param func The Function that defines the conditions of the element to search for
     * @return The first element that matches the conditions defined by the specified function, if found; otherwise, null.
     */
    public T find(Predicate<T> func)
    {
        for(T t : this)
        {
            if(func.test(t))
            {
                return t;
            }
        }
        return null;
    }
    
    /**
     * Retrieves all the elements that match the conditions defined by the specified function.
     * @param func The Function that defines the conditions of the elements to search for
     * @return A BetterArrayList containing all the elements that match the conditions defined by the specified function, if found; otherwise, an empty BetterArrayList
     */
    public BetterArrayList<T> findAll(Predicate<T> func)
    {
        BetterArrayList<T> lst = new BetterArrayList<T>();
        this.forEach( x -> {
            if(func.test(x))
            {
                lst.add(x);
            }
        });

        return lst;
    }

    public Boolean exists(Predicate<T> func)
    {
        for(T t : this)
        {
            if(func.test(t))
            {
                return true;
            }
        }
        return false;
    }
}
--------------------------------------------------------------------

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

    public void print()
    {
        System.out.println(this.toString());
    }




    @Override
    public String toString() {
        return "Kinokarte{" +
                "nummer=" + nummer +
                ", name='" + name + '\'' +
                ", belegbar=" + belegbar +
                ", verkauft=" + verkauft +
                '}';
    }
}
