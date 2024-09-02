package Aufgabe3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> personen = new ArrayList<>();
		personen.add(new Person("Kevin", 178.0, "männlich", LocalDate.of(2005, 9, 26)));
		personen.add(new Person("Emad", 200.0, "männlich", LocalDate.of(2010, 12, 28)));
		personen.add(new Person("Julian", 190.0, "männlich", LocalDate.of(2005, 6, 12)));
		personen.add(new Person("Maria", 150.0, "weiblich", LocalDate.of(2002, 5, 15)));
		personen.add(new Person("Monkey", 160.0, "weiblich", LocalDate.of(2006, 3, 10)));
		personen.add(new Person("Lara", 163.0, "weiblich", LocalDate.of(2007, 2, 2)));
		
		//alle männer
		double averageMenHeight = personen.stream()
				.filter(person -> person.getGeschlecht().equals("männlich"))
                .mapToDouble(Person::getKoerpergroesse)
                .average()
                .orElse(0.0); //Wenn Stream leer ist, Standardwert
                
		
		//alle männer unter 18
		double averageMenHeightUnder18 = personen.stream()
                .filter(person -> person.getGeschlecht().equals("männlich") && !person.isVolljaehrig())
                .mapToDouble(Person::getKoerpergroesse)
                .average()
                .orElse(0.0);  
                
		
		//anzahl frauen
		long womenCount = personen.stream()
                .filter(person -> person.getGeschlecht().equals("weiblich"))
                .count();
		
		//prozentaler Anteil minderjährige frauen
		long womenCountProzent = personen.stream()
                .filter(person -> person.getGeschlecht().equals("weiblich") && !person.isVolljaehrig())
                .count();
        double prozentWomenunder18 = (double) womenCountProzent / personen.size() * 100;
        
        //Aufzählung nach Körpergrösse
        List<Person> sortHeight = personen.stream()
                .sorted((p1, p2) -> Double.compare(p1.getKoerpergroesse(), p2.getKoerpergroesse()))
                .collect(Collectors.toList());
        
        //Volljährige personen nach name sortiert
        List<Person> personsOver18 = personen.stream()
                .filter(Person::isVolljaehrig)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList()); //umwandlung in eine liste

        System.out.println("a. Durchschnittliche Größe aller Männer: " + averageMenHeight + " cm");
        System.out.println("b. Durchschnittliche Größe aller minderjährigen Männer: " + averageMenHeightUnder18 + " cm");
        System.out.println("c. Anzahl der Frauen: " + womenCount);
        System.out.println("d. Prozentualer Anteil der minderjährigen Frauen: " + prozentWomenunder18 + "%");
        System.out.println("e. Aufzählung nach Körpergröße sortiert: " + sortHeight);
        System.out.println("f. Volljährige Personen nach Namen sortiert: " + personsOver18);
		
	}

}
