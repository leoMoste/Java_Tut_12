import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static ArrayList<Kunde> kunden;
	static Scanner s= new Scanner(System.in);
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=0;
		kunden = new ArrayList<Kunde>();
		String datei= "kunden.txt";
		/*InputStreamReader r= new InputStreamReader(System.in);
		try {
			t=r.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println((char)t);*/
		int eingabe;
		
		kundenladen(datei);
		
		do {
			System.out.println("1. Kunde eingeben \n2. Kunde löschen \n3. Kunde bearbeiten \n4. Kundenliste ausgeben\n0. Programm beenden\nIhre Wahl:");
			eingabe=s.nextInt();
			
			//nextInt() liest nur das nächste Zeichen
			//nicht aber die Return-Taste
			//Folge:nächstes NextLine() hier z.B. bei Eingabe
			//wird mit der Return-Taste "verbraten"
			//so dass die Namenseingabe übersprungen wird
			
			//Mit nextLine wird quasi der "Zwischenspeicher" geleert
			s.nextLine();
			
		
		
		switch(eingabe) {
		case 1: kundeingeben(); break;
		case 2: loeschen(); break;
		case 3: bearbeiten(); break;
		case 4: kundenauflisten();s.nextLine();break;
		case 0: System.out.println("Programm wird beendet!");break;
		default: System.out.println("Kein Menüpunkt");
		
		}
		}while(eingabe!=0);
		
		kundenspeichern(datei);
		
		
	}
	
	
	private static void kundenauflistenSortiert() {
		// TODO Auto-generated method stub
		System.out.println("Wonach möchten Sie sortieren?\n 1:Nach Name \n 2:Nach Knr \n 3:Nach Gebdat \n Ihre Wahl:");
		int wahl= s.nextInt();
		s.nextLine();
		
		//Mit Streams deutlich kürzer lösbar, da dort die Ausgangsliste von Haus aus nicht geändert wird!!!
		
		List<Kunde> l= new ArrayList<Kunde>();
		for (Kunde item : kunden) {
			try {
				l.add((Kunde)item.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
		if(wahl==1) {
	    Collections.sort(l,new Comparator<Kunde>() {
	        @Override
	        public int compare(Kunde o1, Kunde o2) {
	            return (o1.getKname()).compareTo(o2.getKname()) ;
	        }});
	    
	    //Streams
	    kunden.stream().sorted((k1,k2)->k1.getKname().compareTo(k2.getKname())).forEach(Kunde::print);
		}
		else if(wahl==2) {
			//Schreibweise mit Lambdas
			Collections.sort(l,(o1,o2)->o1.getKnr()- o2.getKnr());
			
		}
		else if(wahl==3) {
			Collections.sort(l, (o1,o2)->o1.getKgebdat().compareTo(o2.getKgebdat()));
		}
		else {
			System.out.println("Falsche Eingabe. Ursprüngliche Reihenfolge:");
		}
		
		
	    for(Kunde k:l){
			System.out.println(k.getKnr()+" "+k.getKname()+" "+k.getKgebdat());
		}

		s.nextLine();
	}


	private static void bearbeiten() {
		// TODO Auto-generated method stub
		
		kundenauflisten();
		System.out.println("Geben Sie die zu bearbeitende Nummer ein:");
		int nr=s.nextInt();
		s.nextLine();
		for(Kunde k :kunden)
		{
			if(k.getKnr()==nr)
			{
				//Trennzeichen für Token auf Zeilenumbruch setzen  !Windows!
				//s.useDelimiter("\r\n");
				//String t=s.next(); lässt dann auch Leerstellen zu
				s.useDelimiter("\r\n");
				System.out.print("Namen eingeben:");
				
				k.setKname(s.nextLine());
				System.out.println("Knr eingeben:");
				k.setKnr(Integer.parseInt(s.next()));
				s.nextLine();
				System.out.println("Gebdat eingeben (yyyy-MM-dd):");
				String dat= s.nextLine();
				k.setKgebdat(LocalDate.parse(dat,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				
			}
			
		}
		s.nextLine();	
	}


	private static void loeschen() {
		// TODO Auto-generated method stub
		kundenauflisten();
		System.out.println("Geben Sie die zu löschende Nummer ein:");
		int nr=s.nextInt();
		int i=0;
		for(Kunde k :kunden)
		{
			if(k.getKnr()==nr)
			{
				kunden.remove(i);
				break;
				
			}
			i++;
		}
		s.nextLine();	
	}

	private static void kundeingeben() {
		boolean wdh = true;
		LocalDate date=null;
		
		// Trennzeichen für Token auf Zeilenumbruch setzen !Windows!
		s.useDelimiter("\r\n");
		System.out.print("Namen eingeben:");
		String name = s.nextLine();
		System.out.println("Knr eingeben:");
		int knr = Integer.parseInt(s.next());
		while (wdh) {
			try {
				System.out.println("Gebdat eingeben (yyyy-MM-dd):");
				String dat = s.next();
				date = istDatum(dat);
				wdh = false;
			} catch (DatumException e) {
				System.out.println(e.getMessage());
			}
		}
		Kunde k = new Kunde(knr, name, date);
		kunden.add(k);
		s.nextLine();
	}

	public static void kundenauflisten() {
		for(Kunde k:kunden){
			//Alternativ toString()-Methode überladen
			System.out.println(k.getKnr()+" "+k.getKname()+" "+k.getKgebdat());
		}
		
		//Alternativ 
		//kunden.stream().forEach(Kunde::print);
	}
	public static void kundenladen(String datei){
		BufferedReader br=null;
		File f= new File(datei);
		Kunde k=null;
		
		if(f.exists())
		{
		
		try {
			br= new BufferedReader(new FileReader(datei));
			String line = br.readLine();
			String[] felder;
			
			while(line != null)
			{
				felder= line.split("#");
				k=new Kunde(Integer.parseInt(felder[1]), felder[2],LocalDate.parse(felder[3]));
				kunden.add(k);
				
				line = br.readLine();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch( IOException e){}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	public static void kundenspeichern(String datei) {
		BufferedWriter out=null;
		try {
		
			out = new BufferedWriter(new FileWriter(datei))	;		
					

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=1;
		
		for(Kunde k :kunden){
			try {
				out.write(i+ k.ausgabe()+"\n");
				//out.newLine();
				i++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LocalDate istDatum(String date) throws DatumException
	{
		try {
			LocalDate daten = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			if(LocalDate.now().isAfter(daten)) {
				return daten;
			}else {
				
				throw new DatumException("Das eingegebene Datum liegt in der Zukunft!");
			}
			
		} catch (DateTimeParseException e) {
			throw new DatumException("Falsches Format");
		}
	}


}
