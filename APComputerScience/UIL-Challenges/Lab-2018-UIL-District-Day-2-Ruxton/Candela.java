import java.util.Scanner;
import java.io.*;

class Candela {
  public static void main (String[] args) throws FileNotFoundException{
    Scanner candelaScan = new Scanner(new File ("candela.dat"));
    int qNum = candelaScan.nextInt();
    candelaScan.nextLine();
    int pTotal = 0;
    
    for (int k = 1; k < qNum+1; k++) {
      if (k != 8) { pTotal += candelaScan.nextInt(); }
      candelaScan.nextLine();
    }
    
    int tDiff1 = candelaScan.nextInt();
    candelaScan.nextLine();
    int tDiff2 = candelaScan.nextInt();
    candelaScan.nextLine();
    int tDiff3 = candelaScan.nextInt();
    System.out.println("Target diff     = " + tDiff1);
    System.out.println("Calculated diff = " + (tDiff1 - 1));
    System.out.println("Expected points = " + (pTotal));
    
    candelaScan = new Scanner(new File ("candela.dat"));
    candelaScan.nextLine();
    
    for (int i = 1; i <= qNum; i++) {
      if (i == 5) {
        int temp = candelaScan.nextInt();
        pTotal -= temp;
        System.out.println("Q# " + i + ",  " + temp + " pts, diff " + candelaScan.nextInt());
      }
      else if (i == 3) {
        System.out.println("Q# " + i + ",  " + candelaScan.nextInt() + " pts, diff " + candelaScan.nextInt());
      }
      else if (i == 10) {
        int temp = candelaScan.nextInt();
        pTotal -= temp;
        System.out.println("Q#" + i + ", " + temp + " pts, diff " + candelaScan.nextInt());
      }
      else if (i != 8) {
        System.out.println("Q# " + i + ", " + candelaScan.nextInt() + " pts, diff " + candelaScan.nextInt());
        candelaScan.nextLine();
      } 
      else if (i == 8) {
        pTotal -= candelaScan.nextInt();
        candelaScan.nextLine();
      }
    }
    System.out.println("=====");

    candelaScan = new Scanner(new File ("candela.dat"));
    candelaScan.nextLine();
    
    System.out.println("Target diff     = " + tDiff2);
    System.out.println("Calculated diff = " + (tDiff2 - 1));
    System.out.println("Expected points = " + (pTotal + 2));
    for (int i = 1; i <= qNum; i++) {
      if (i == 3) {
        System.out.println("Q# " + i + ",  " + candelaScan.nextInt() + " pts, diff " + candelaScan.nextInt());
      }
      else if (i != 8 && i != 5 && i != 10) {
        System.out.println("Q# " + i + ", " + candelaScan.nextInt() + " pts, diff " + candelaScan.nextInt());
      candelaScan.nextLine();
      } 
      else { candelaScan.nextLine(); }
    }
    pTotal = (pTotal+3)/2;
    System.out.println("=====");
    
    candelaScan = new Scanner(new File ("candela.dat"));
    candelaScan.nextLine();
    
    System.out.println("Target diff     = " + tDiff3);
    System.out.println("Calculated diff = " + (tDiff3 - 1));
    System.out.println("Expected points = " + (pTotal));
    for (int i = 1; i <= qNum; i++) {
      if (i == 6 || i == 7 || i == 9) {
        System.out.println("Q# " + i + ", " + candelaScan.nextInt() + " pts, diff " + candelaScan.nextInt());
      }
      candelaScan.nextLine();
    }
    System.out.println("=====");
  }
}