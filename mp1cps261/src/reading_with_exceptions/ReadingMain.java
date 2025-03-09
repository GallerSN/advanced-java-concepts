package reading_with_exceptions;

import java.io.IOException;

public class ReadingMain {
	
	public static void main(String[] args) {
		ReadingWithExceptions processor = new ReadingWithExceptions();
		
		try {
			processor.process("file1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			processor.process("file2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			processor.process("non_existent_file.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try {
			processor.process("file3.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
