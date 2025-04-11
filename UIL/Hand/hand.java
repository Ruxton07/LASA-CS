/*
 * A jousting tournament just started, to see which knight is worth enough for m’lady’s hand. Knights from all over the
world come together to fight for m’lady’s hand.
The rules are as follow. First, we will use knockout rules, meaning if a knight loses he will be kicked from the
tournament. Second, knights can only fight each other if the difference in victories between them is less than one.
Third and lastly, all knights are to have fun.
Input
An integer N will denominate the number of test cases. Each test case represents a unique
tournament containing a unique number of knights. The following N lines will contain a number
M denominating the number of knights competing in that tournament. There will be at least 2
knights contesting m’lady’s hand. Tournament configurations are not required to ALWAYS be
valid. They must have at least 1 possible way of being valid.
Output
You are to output the maximum number of battles the winner of the tournament can win.
Example Input File
3
2
4
13
Example Output to Screen
1
2
5
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hand {
  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\Hand\\hand.dat";

    Scanner scanner = new Scanner(new File(inputFile));
    int N = scanner.nextInt();
    for (int i = 0; i < N; i++) {
      int M = scanner.nextInt();
      System.out.println(maxBattles(M));
    }
    scanner.close();
  }

  private static int maxBattles(int M) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < M; i++) {
      pq.add(0);
    }

    int battles = 0;
    while (pq.size() > 1) {
      int knight1 = pq.poll();
      int knight2 = pq.poll();
      pq.add(knight1 + 1);
      battles++;
    }

    return battles;
  }
}