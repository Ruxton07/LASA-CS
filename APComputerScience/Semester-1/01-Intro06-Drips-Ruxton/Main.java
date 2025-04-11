// Try to write the WHOLE program. See if you can define the class and 
// main method from memory.  Remember repl.it requires the class containing
// the main method to be named Main.
import java.util.Scanner;
public class Main {
  final static int dripsPerGal = 15140;
  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    double dripsPerMin;
    System.out.println("Enter faucet drips per minute:");
    dripsPerMin = scan.nextDouble();
    int days;
    System.out.println("Enter number of days:");
    days = scan.nextInt();
    double dripsPerHour = dripsPerMin*60;
    double dripsPerDay = dripsPerHour*24;
    double dripsTotal = dripsPerDay*days;
    double wasted = dripsTotal/dripsPerGal;
    System.out.println("A faucet with " + dripsPerMin + " drips per minute over " + days + " days will waste " + wasted + " gallons of water");
  }
}