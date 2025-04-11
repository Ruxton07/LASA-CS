// Try to write the WHOLE program. See if you can define the class and 
// main method from memory.  Remember repl.it requires the class containing
// the main method to be named Main.
import java.util.Scanner;
public class Main {
  public static void main (String[] args) {
    Scanner scan = new Scanner (System.in);
    System.out.println("Enter jelly bean length (cm):");
    double averageLength = scan.nextDouble();
    System.out.println("Enter jelly bean height (cm):");
    double averageHeight = scan.nextDouble();
    System.out.println("Enter jar size (mL):");
    double jarSize = scan.nextDouble();
    double numJellies = count(averageLength, averageHeight, jarSize);
    System.out.println("Estimate for number of jelly beans with average");
    System.out.println("length: " + averageLength + " cm");
    System.out.println("height: " + averageHeight + " cm");
    System.out.println("in a jar of size " + (int) jarSize + " mL is");
    System.out.println((int) numJellies);
  }
  public static double count(double length, double height, double size) {
    double beanVol = 5*Math.PI*length*(Math.pow(height, 2) /24);
    double numJellies = size*0.698/beanVol;
    return numJellies;
  }
}