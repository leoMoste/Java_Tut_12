import java.util.Arrays;
import java.util.Comparator;

public class PersonVergleicherAnwendung
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person[] personen = {
			new Person("Meier", 'm', 178),
			new Person("Maier", 'm', 182),
			new Person("Mayer", 'w', 168),
			new Person("Mair", 'w', 160),
			new Person("Beier", 'm', 176),
			new Person("Baier", 'w', 158),
			new Person("Detterl", 'm', 190),
			new Person("Pollack", 'w', 155)
		};
		
		printPersonen(personen, "Peronen unsortiert");
		
		Arrays.sort(personen, (p1,p2) -> Integer.compare(p1.getGroesse(), p2.getGroesse()));
		printPersonen(personen, "Personen nach Körpergröße sortiert");
		
		Arrays.sort(personen, (p1,p2) -> p1.getName().compareTo(p2.getName()));
		printPersonen(personen, "Personen nach Namen sortiert");
		
//		Arrays.sort(personen,  new Comparator<Person>()
//			{
//				@Override
//				public int compare(Person p1, Person p2)
//				{
//					if( p1.getGeschlecht()<p2.getGeschlecht()) return -1;
//					if( p1.getGeschlecht()>p2.getGeschlecht()) return 1;
//					else return p1.getName().compareTo(p2.getName());
//				}
//			});

//ternärer bzw. Bedingungsoperator
		Arrays.sort(personen, (p1, p2) ->
						p1.getGeschlecht()<p2.getGeschlecht()? -1 : 
								p1.getGeschlecht()>p2.getGeschlecht()?  1 :
										p1.getName().compareTo(p2.getName())
				);
		printPersonen(personen, "Personen nach Geschlecht und dann nach Namen sortiert");

	}


	private static void printPersonen(Person[] personen, String msg)
	{
		System.out.println(msg);
		for(Person p : personen) System.out.println(p);
		System.out.println();
	}

}
