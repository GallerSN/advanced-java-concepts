package spellChecker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;

public class SpellCheck {
	// We could have also used TreeSet for the dictionary
		private HashSet<String> dictionary = new HashSet<String>();
		private TreeSet<String> miss_spelled_words = new TreeSet<String>();

		public SpellCheck() throws FileNotFoundException {
			// Add all of the words from "dictionary.txt" to the dictionary HashSet
			Scanner fin = null;
			String input;
			try {
				fin = new Scanner(new File("dictionary.txt"));
				do {
					input = fin.nextLine();
					dictionary.add(input);
				}while(fin.hasNext());
			}catch (FileNotFoundException e) {
				System.out.println("Can't open file: dictionary.txt");}
			finally {
				if (fin != null)
					fin.close();
			}

		}

		public void checkSpelling(String fileName) throws FileNotFoundException {

			Scanner fin = null;
			Scanner in = new Scanner(System.in);
			System.out.println("======== Spell checking " + fileName + " =========");
			// Clear miss_spelled_words
			miss_spelled_words.clear();
			// Read in each line from "fileName"
			String line;
			String[] words;
			boolean linePrint = false;
			int lineNum = 0;
			String input;
			try {
				fin = new Scanner(new File(fileName));
				while(fin.hasNext()) {
					line = fin.nextLine();
					lineNum++;
					linePrint = false;
					// For each line, break the line into words using split method
					words = line.split(" +|\\p{Punct}");
					for(int i = 0; i < words.length; i++) {
						words[i] = words[i].toLowerCase();
						if (!dictionary.contains(words[i]) && 
								!miss_spelled_words.contains(words[i])
								&& words[i].length() > 0
								&& words[i].charAt(0)>= 97 && words[i].charAt(0)<= 122) {
							if(!linePrint) {
								System.out.println("Line number: " + lineNum);
								linePrint = true;
							}
							System.out.println(words[i] + " add to dictionary? (y/n)");
							try{ 
								input = in.next();
								if(input.equalsIgnoreCase("y"))
									dictionary.add(words[i]);
								else if(input.equalsIgnoreCase("n"))
									miss_spelled_words.add(words[i]);
								else
									throw new IOException();
							}
							catch(IOException io) {
								System.out.println("invalid input");
							}
						}
					}
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("Can't open file: dictionary.txt");}
			
			finally {
				if (fin != null)
					fin.close();
				in.close();
			}
		}

		public void dump_miss_spelled_words() {
			// Print out the miss-spelled words
			Iterator<String> printer = miss_spelled_words.iterator();
			System.out.println("========== miss spelled words ==========");
			while(printer.hasNext()) {
				System.out.println(printer.next());
			}

		}

		public static void main(String[] args) {
			try {
				SpellCheck spellCheck = new SpellCheck();

				for (int i = 0; i < args.length; i++) {
					spellCheck.checkSpelling(args[i]);
					spellCheck.dump_miss_spelled_words();
				}
			} catch (

			FileNotFoundException e) {
				System.out.println(e);
			}
		}

}
