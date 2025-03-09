package indentChecker;

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

@SuppressWarnings("serial")
class BadIndentationException extends RuntimeException {
	BadIndentationException(String error) {
		super(error);
	}
}

public class IndentChecker {
	Stack<Integer> indentStack = new Stack<Integer>();

	private int findFirstNonBlank(String line) {
		// return index of first non-blank character
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) != ' ') {
				return i;
			}
		}

		// return -1 if the line doesn't contain a non-blank character
		return -1;
	}

	private void processLine(String line, int lineNumber) {
		int index = findFirstNonBlank(line);
		// Skip blank lines ... i.e. return immediately
		if(index == -1) {
			return;}
		// If the stack is empty, then push this index onto the stack and return
		if(indentStack.isEmpty()) {
			indentStack.push(index);
			return;
		}
// If this index > than the top of the stack, then push this index onto the stack and return
		if(index > indentStack.lastElement()) {
			indentStack.push(index);
			return;
		}
		// Pop off all Indentation indexes > index
		if(index < indentStack.lastElement()) {
			while(!indentStack.isEmpty()) {
				indentStack.pop();
				if(index == indentStack.lastElement()) {
					return;
				}
				else if(index > indentStack.lastElement()) {
					throw new BadIndentationException("improper indentation at line " + lineNumber);
				}
			}
			if(indentStack.isEmpty()) {
				throw new BadIndentationException("improper indentation at line " + lineNumber);
			}
		}
		return;
		// At his point the top of the stack should match the current index. If it
// doesn't throw a BadIndentationException. In the error message, include the source Line Number
	}

	public void checkIndentation(String fileName) {
		// Clear the stack
		Scanner input = null;
		String line;
		int lineNumber = 1;
		try {
			input = new Scanner(new File(fileName));
			// read through the file line by line
			do {
				// for each line, call processLine to check indentation
				line = input.nextLine();
				System.out.println(lineNumber + line);
				processLine(line,lineNumber);
				lineNumber++;
			}while(input.hasNextLine());
		}

		catch (BadIndentationException error) {
			System.out.println(error);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file:" + fileName);
		} finally {
			if (input != null)
				input.close();
		}
	}

	public static void main(String[] args) {
		IndentChecker indentChecker = new IndentChecker();
		for (int i = 0; i < args.length; i++) {
			System.out.println("Processing file: " + args[i]);
			indentChecker.checkIndentation(args[i]);
			System.out.println();
		}
	}

}
