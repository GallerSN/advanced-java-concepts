package personIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MP1PersonIO {
	String fileName;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	Scanner kbInput = new Scanner(System.in);

	public MP1PersonIO(String fileName) {
		//fill in the code
		this.fileName = fileName;
		try {
			oos = new ObjectOutputStream(new FileOutputStream (fileName));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		String name;
		int age;
		try {
		System.out.print("Enter the name of the person: ");
		name = kbInput.next();
		System.out.print("Enter the age of the person: ");
		age = kbInput.nextInt();
		Person temp = new Person(name, age);
		oos.writeObject(temp);
		}
		catch(InputMismatchException e) {
			System.out.println("invalid input");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void display() {
		boolean endOfFile = false;

		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(!endOfFile) {
			try {
				System.out.println((Person)ois.readObject());
			}
			catch(EOFException e){
				endOfFile = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
