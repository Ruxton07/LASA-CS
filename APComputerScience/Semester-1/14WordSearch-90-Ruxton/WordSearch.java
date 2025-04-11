import java.util.Arrays;

public class WordSearch
{
	/** One 2D array instance variable */
	/*  You CANNOT add any additional instance variables */
	char [][] table;
	
	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col*/
	public WordSearch(int row, int col)
	{
		table = new char [row][col];
    
	}
	
	/** method to set an element in the 2D array
		* @param s which is the value to store in the 2D array
		* @param row the row to use
		* @param col the column to use*/
	public void setSpot(String s, int row, int col)
	{
    char spot = s.charAt(0);
		table[row][col] = spot;
    
	}
	
	/** methods to check for the word in the 2D array
		* @param word the word to search for
		* @return return true or false*/
	public boolean inGrid(String s)
	{
    //checking rows
    String row = "";
    for (int i = 0; i < table.length; i++) {
      for (int j = 0;j < table[i].length; j++) {
        row += table[i][j];
      }
      if (row.contains(s)) {
        return true;
      } 

      row = "";
      
      for (int j = table[i].length - 1;j >= 0; j--) {
        row += table[i][j];
      }
      if (row.contains(s)) {
        return true;
      } 

      row = "";
      
    }
    //checking columns
    String cols = "";
    for (int i = 0; i < table[0].length; i++) {
      for (int b = 0; b < table.length; b++) {
        cols += table[b][i];
      }

      if (cols.contains(s)) {
        return true;
      }

      cols = "";

      for (int b = table.length - 1; b >= 0; b--) {
        cols += table[b][i];
      }

      if (cols.contains(s)) {
        return true;
      }

      cols = "";
      
    }
		return false;
	}
	
	/** toString method
		* @return String containing all elements in the 2D array*/
	public String toString()
	{
    String arrayz = "[[";
    for (int i = 0; i < table[0].length - 1; i++) {
      arrayz += table[0][i] + " ";
    }
    arrayz += table[0][table[0].length-1] + "]\n";
    for (int i = 1; i < table.length; i++) {
      arrayz += " [" + table[i][0];
      for (int j = 1; j < table[i].length; j++) 
      arrayz += " " + table[i][j];
      arrayz += "]";
      if (i < table.length - 1)
        arrayz += "\n";
  }
    arrayz += "]";
		return arrayz;
	}
}