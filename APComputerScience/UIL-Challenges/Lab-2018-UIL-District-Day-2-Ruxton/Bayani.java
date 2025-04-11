import  java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Bayani {
public static void main(String[] args) throws FileNotFoundException {
  String totalString = "";
  double sum = 0.0;
  File text = new File("bayani.dat");
  Scanner scan = new Scanner(text);
  while (scan.hasNextDouble()) {
  double expense = scan.nextDouble();
  sum += expense;
  String printer = "$";
  String expenseString = "" + (int)(expense);
    if (expenseString.length() == 4)
 printer += "";
    if (expenseString.length() == 3)
printer += " ";
    if (expenseString.length() == 2)
printer += "  ";
    if (expenseString.length() == 1)
printer += "   ";
  totalString += ("\n"+ "        " + printer + expense  );
  }
  System.out.println(totalString);
  String sumString = "" + (int)(sum);
  if (sumString.length() == 4)
  System.out.println("Total = " + "$" + sum);
    if (sumString.length() == 3)
  System.out.println("Total = " + "$ " + sum);
    if (sumString.length() == 2)
  System.out.println("Total = " + "$  " + sum);
    if (sumString.length() == 1)
  System.out.println("Total = " + "$   " + sum);
  
}
}
