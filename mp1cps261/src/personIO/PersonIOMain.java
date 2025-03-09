package personIO;

import java.io.IOException;
import java.util.Scanner;

public class PersonIOMain {
	public static void main(String[] args) throws IOException  {
		MP1PersonIO mp1 = new MP1PersonIO("person.dat");
		Scanner kbInput = new Scanner(System.in);

		try {
			int option = -1;
			while (option != 0) {
				System.out.println("Please choose an option:");
				System.out.println("0: quit");
				System.out.println("1: add");
				System.out.println("2: display");
				option = kbInput.nextInt();
				kbInput.nextLine();
				switch (option) {
				case 0:
					System.out.println("Bye");
					break;					
				case 1:
					mp1.add();
					break;
				case 2:
					mp1.display();
					break;
				default:
					System.out.println("Please enter a valid option");
					break;
				}

			}
		} finally {
			if(mp1.oos != null)
				mp1.oos.close();
			
			if(mp1.ois != null)
				mp1.ois.close();
			
			kbInput.close();
		}

	}
}
