package reading_with_exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadingWithExceptions {
	
	public void process(String inputFilename) throws IOException {
		Scanner fScan = null;
		PrintWriter fOut = null;
		String outFilename = "";
		int num_to_read = 0;
		int read;
		int count = 0;
		
		try {
			fScan = new Scanner(new FileInputStream(inputFilename));
			outFilename = fScan.next();
			try {
				num_to_read = fScan.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("number to read is not an integer");
				num_to_read = 0;
				fScan.next();
			}
			fOut = new PrintWriter(new FileOutputStream(outFilename));
			System.out.println("Reading " + inputFilename);
			if(num_to_read > 0) {
				for(int i = 0; i < num_to_read; i++) {
					try {
					read = fScan.nextInt();
					fOut.print(read + " ");
					if(i%10 == 0 && i != 0)
					fOut.println();
					}
					catch(InputMismatchException e) {
						System.out.println("input is not an integer");
						fScan.next();
					}
					catch(NoSuchElementException n) {
						System.out.println("no elements left in file");
						break;
					}
				}
				
			}
			else {
				while(fScan.hasNext()) {
					try {
						read = fScan.nextInt();
						fOut.print(read + " ");
						if(count%10 == 0 && count != 0)
						fOut.println();
						}
						catch(InputMismatchException e) {
							System.out.println("input is not an integer");
							fScan.next();
						}
					count++;
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(inputFilename + " not found.");
		}
		
		finally {
			if (fScan != null)
				fScan.close();
			if(fOut != null) {
				fOut.close();
				System.out.println();
				System.out.println("File " + outFilename + " created:");
				fScan = new Scanner(new FileInputStream(outFilename));
				count = 0;
				while(fScan.hasNext()) {
					read = fScan.nextInt();
					System.out.print(read + " ");
					if(count%10 == 0 && count != 0)
						System.out.println();
					count++;
						}
				
				}
			}
			
		}
		
	}


