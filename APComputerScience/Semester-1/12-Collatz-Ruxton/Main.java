import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main (String args[]) {
    Scanner scan = new Scanner(System.in);
    int startVal = 1;
    System.out.print("Starting Number ");
    startVal = scan.nextInt();
    Collatz nofriends = new Collatz(startVal);
    System.out.print(nofriends + "\nNumber of steps " + nofriends.steps() + "\nMaximum value " + nofriends.maxValue() + "\nMinimum odd value " + nofriends.minOddValue() + "\nOdd values " + Arrays.toString(nofriends.oddValues()) + "\nSum of all values " + nofriends.sumValues() + "\n");
    int i = 1;
    for (int magicNum: nofriends.sequence()) {
      System.out.println("step " + i + " " + magicNum);
      i++;
    }
  }
}