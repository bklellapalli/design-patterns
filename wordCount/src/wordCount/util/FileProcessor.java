package wordCount.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	public enum FileOperation { READ, WRITE };
	
	/**
	 * Creates a character-input and output stream of default capacity.
	 * @param arg read/write operation and file name.
	 * @exception FileNotFoundException if file not found, IOException
	 * @return No return value.
	 */ 
	public FileProcessor(FileOperation oper, String fileName) {	
		Logger.writeMessage("DEBUG_VALUE = 0 [FileProcessor's constructor called]", 
				Logger.DebugLevel.CONSTRUCTOR);
		try {
			switch(oper) {
			case READ: 
				reader = new BufferedReader(new FileReader(fileName));
				break;
			case WRITE: 
				writer = new BufferedWriter(new FileWriter(fileName));
				break;	
			}
		}
		catch(FileNotFoundException ex) {
			System.err.println("File not found.");
			ex.printStackTrace();
			System.exit(0);
		}
		catch(IOException ex) {
			System.err.println("Input/Output Exception.");
			ex.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Reads a line. Not including any line termination character.
	 * @param arg No arguments.
	 * @exception IOException If an I/O error occurs
	 * @return A String containing the contents of the line.
	 */ 
	public String readFile() {
		String line = null;
		try {
			line = reader.readLine();
		}
		catch(IOException ex) {
			System.err.println("Input/Output Exception.");
			ex.printStackTrace();
			System.exit(0);
		}
		return line;
	}

	/**
	 * Write a string to a file.
	 * @param arg string to be written.
	 * @exception IOException If an I/O error occurs.
	 * @return No return value.
	 */ 
	public void writeFile(String line) {
		try {
			writer.write(line);
		}
		catch(IOException ex) {
			System.err.println("Input/Output Exception.");
			ex.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Releases any system resources associated with Reader/Writer.
	 * @param No arguments.
	 * @exception IOException If an I/O error occurs.
	 * @return No return value.
	 */ 
	public void closeFile() {
		try{
			if(reader != null) { reader.close(); }
			if(writer != null) { writer.close(); }
		}
		catch(IOException ex) {
			System.err.println("Input/Output Exception.");
			ex.printStackTrace();
			System.exit(0);
		}
	}
}