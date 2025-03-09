package twoDimArray;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoDimArray {

	public static void main(String[] args) {
		int[][] numArr = {{34,89},{56,3},{27,61},{45,8},{45,89}};
		
		Stream.of(numArr).flatMapToInt(e->IntStream.of(e)).sorted()
		.forEach(e->System.out.print(e + " "));;
	}
	
}
