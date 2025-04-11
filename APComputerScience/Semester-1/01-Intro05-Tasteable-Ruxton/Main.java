// REPL.IT requires the root class be named "Main".  Normally you'd call this class
// something more descriptive such as Tasteable.
import java.util.Scanner;
public class Main 
{
   // method main(): program starting point
   public static void main( String[] args ) 
   {
      // set up input scanner
      Scanner scan = new Scanner (System.in);
      int shelfLife;
      // get input
      System.out.println("Enter the shelf life:");
      shelfLife = scan.nextInt();
      // compute tasteable age
      int optTime = 7 + (shelfLife/2);
      // display result
      System.out.println(shelfLife + " week shelf life tastes best when it is at least " + optTime + " weeks old.");
   }
}