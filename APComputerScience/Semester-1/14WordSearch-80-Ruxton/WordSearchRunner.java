import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

 public class WordSearchRunner {
	public static void wsMain(String fileName) throws FileNotFoundException
	{
    System.out.println("Starting main");
		// instantiate Scanner object to read in from file
		Scanner words2scan = new Scanner(new File(fileName));
		// read in rows
		int rows = words2scan.nextInt();
		// read in columns
		int columns = words2scan.nextInt();
		// instantiate WordSearch object passing in number of rows & columns for 2D array
		WordSearch wordsearch = new WordSearch(rows,columns);
		// loop through the rows in the file
    
    words2scan.nextLine();
    words2scan.nextLine();
		for (int i = 0; i < rows; i++) {
      String um = "";
			// loop through the columns in the file
			for (int j = 0; j < columns; j++) {
				// read in value from file using local variable
				um = words2scan.next();
				// pass row, column, and value into the 2D array
        wordsearch.setSpot(um, i, j);
      }
    }
    System.out.println("Done with array");
		// read number of words to search for from file
    int wordsNumber = words2scan.nextInt(); 
		// loops through the words
    System.out.println("");
    for (int i = 0; i < wordsNumber; i++) {
    
			// read in word from file
			String word = words2scan.next();
			// method call to search for the word in the 2D array
	    boolean found = wordsearch.inGrid(word);
			// print out word to search for and true/false
      System.out.println(word + " -> " + found);
    }	
	}
}