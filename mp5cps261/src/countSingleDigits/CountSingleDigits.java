package countSingleDigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CountSingleDigits {
	
	
	public static void main(String[] args) {
		Random random = new Random();
		IntSupplier supp = () -> random.nextInt(10);
		int[] arr = IntStream.generate(supp)
                .limit(100)
                .toArray();
		
		System.out.println("Occurrences of Each Digit:");
		
		Arrays.stream(arr)
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
        .stream()
        .collect(Collectors.groupingBy(e -> e))
        .forEach((e, v) -> System.out.println(e+": "+v.size()));
	}

}
