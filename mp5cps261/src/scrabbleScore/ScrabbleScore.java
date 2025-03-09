package scrabbleScore;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ScrabbleScore {
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	Map<Character, Integer> letterValues = new HashMap();
	 ScrabbleScore() {
		 letterValues.put('a', 1);
		 letterValues.put('b', 3);
		 letterValues.put('c', 3);
		 letterValues.put('d', 2);
		 letterValues.put('e', 1);
		 letterValues.put('f', 4);
		 letterValues.put('g', 2);
		 letterValues.put('h', 4);
		 letterValues.put('i', 1);
		 letterValues.put('j', 8);
		 letterValues.put('k', 5);
		 letterValues.put('l', 1);
		 letterValues.put('m', 3);
		 letterValues.put('n', 1);
		 letterValues.put('o', 1);
		 letterValues.put('p', 3);
		 letterValues.put('q', 10);
		 letterValues.put('r', 1);
		 letterValues.put('s', 1);
		 letterValues.put('t', 1);
		 letterValues.put('u', 1);
		 letterValues.put('v', 8);
		 letterValues.put('w', 4);
		 letterValues.put('x', 8);
		 letterValues.put('y', 4);
		 letterValues.put('z', 10);
	 }
	 
	 int score(String word) {
		 return word.toLowerCase().chars().map(e -> letterValues.get((char)e)).sum();
	 }
	 
	 public static void main(String[] args) {
		 ScrabbleScore processor = new ScrabbleScore();
		 double average = Stream.of(args)
			        .mapToInt(processor::score)
			        .average()
			        .orElse(0.0);
		 System.out.println("Top three scores are:");
		 Stream.of(args).sorted(Comparator.comparingInt(processor::score).reversed()).limit(3)
		 	.forEach(e-> System.out.println(e + ": " + processor.score(e)));
		 
		 System.out.println("Average Score: " + average);
		 
		 System.out.println("Words above average:");
		 Stream.of(args).filter(e-> processor.score(e) > average)
		 	.forEach(e-> System.out.println(e));;
		 System.out.println("Words below average:");
		 Stream.of(args).filter(e-> processor.score(e) < average)
		 	.forEach(e-> System.out.println(e));;
	 }


}
