/*
 * The Caesar will only fight a war if said war is an honorable war. A war is
 * considered honorable if the number of
 * friendly soldiers equals the number of enemy soldiers. However, because the
 * Caesar’s regiments have a high level of
 * comradery they refuse to split up into smaller sub units. It’s is your job to
 * find out if a war will be honorable. If a
 * combination of regiments equals the enemy army then the war is honorable else
 * it will be dishonorable.
 * Input
 * An integer N will denominate the number of test cases. The following N cases
 * will contain an
 * integer M, representing the number of soldiers in the enemy army. On the next
 * line a series of
 * space separated numbers will represent the number of soldiers in each
 * regiment.
 * Output
 * If it’s possible to attain a combination of regiments that equal to the enemy
 * army then print out
 * “HONOR” else print “DISHONOR”.
 * Example Input File
 * 2
 * 3
 * 2 4 4 6
 * 30
 * 16 6 23 84 276 1
 * Example Output to Screen
 * DISHONOR
 * HONOR
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class war {
  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\HonorableWars\\war.dat";
    Scanner scanner = new Scanner(new File(inputFile));
    int N = scanner.nextInt(); // Number of test cases
    scanner.nextLine(); // Consume the newline character

    for (int i = 0; i < N; i++) {
      int M = scanner.nextInt(); // Number of soldiers in the enemy army
      scanner.nextLine(); // Consume the newline character
      String[] regimentsStr = scanner.nextLine().split(" ");
      int[] regiments = new int[regimentsStr.length];
      for (int j = 0; j < regimentsStr.length; j++) {
        regiments[j] = Integer.parseInt(regimentsStr[j]);
      }

      if (isHonorableWar(M, regiments)) {
        System.out.println("HONOR");
      } else {
        System.out.println("DISHONOR");
      }
    }

    scanner.close();
  }

  private static boolean isHonorableWar(int M, int[] regiments) {
    int n = regiments.length;
    boolean[][] dp = new boolean[n + 1][M + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= M; j++) {
        if (regiments[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - regiments[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][M];
  }
}