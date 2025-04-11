// REPL.IT requires the root class be named "Main".  Normally you'd call this class
// something more descriptive such as Pages.
import java.util.Scanner;
public class Main 
{
   // main(): program starting point
  final static int maxPages = 100;
   public static void main( String[] args ) 
   {
      // set up input scanner
      Scanner scan = new Scanner (System.in);
      int usersAge;
      // get the age
      System.out.println("Enter your age:");
      usersAge = scan.nextInt();
      // call the pages method to compute the number of pages to be read
      int minPages = pages(usersAge);
      // display result (pages to be read)
      System.out.println(usersAge + " year olds should read at least " + minPages + " pages before giving up on a book");
      
   }
   
   public static int pages(int usersAge) {
     int minPages;
     minPages = maxPages - usersAge;
     return minPages;
   }
}