import java.util.*;

public class Main
{
	// main(): program starting point
	public static void main( String[] args ) 
	{ 
		// set up scanner
		Scanner scan = new Scanner(System.in);
    
		// prompt the user for input
		System.out.println( "Enter x, y, and z:" );
		
		// use the scanner to read in the input
		int x = scan.nextInt();
    int y = scan.nextInt();
    int z = scan.nextInt();
    scan.nextLine();
		// create InOrder object by calling the initialization constructor
		InOrder list = new InOrder(x, y, z);

    System.out.println(list.areTheyInOrder());
    System.out.println("The original order is " + list);

    list.sortThem();
    System.out.println("The sorted order is " + list);
    System.out.println("The middle number is " + list.getNumTwo());
    // call the method that puts the data (i.e. numbers) of your object in order.

    // print out "The sorted order is" and then the object

    // print out "The middle number is" and then the middle number		
    
  }
}