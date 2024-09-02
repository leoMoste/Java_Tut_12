import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// find AVG of some numbers.
		
		/* DoubleStream ds = DoubleStream.of(10, 20, 303, 392, 32.20, 53.40);
		
		OptionalDouble avg = ds.filter(d->d%10==0).average();
		
		if(avg.isPresent()) {
			System.out.println(avg);
		}else {
			System.out.println("No AVG found");
		}
		*/
		
		/*
		 * ON "DoubleStream", "IntegerStream" can I use the reduce, count ,sum, max, min..
		 * ON Stream<Double>, Stream<Integer> I can not use the reduce, count ,sum, max, min..
		 * */
		
		Stream<Integer> integerStream = Stream.of(10, 20, 303, 392, 32,20, 53, 40);

		Integer value = integerStream.filter(i -> i%2==0).reduce(0, (a,b) -> a + b);
		
		System.out.println(value);
	
	}

}
