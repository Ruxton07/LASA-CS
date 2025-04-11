/*
 * The empire is ruled like a democracy and a dictatorship at the same time. For
 * instance, if the Caesar is present then
 * whatever he votes for will be the decision. If he’s not present then the
 * decision will fall to a democratic vote.
 * Meaning whatever most of the people want will be followed. A person can
 * change their vote by voting again, but
 * only the last vote counts.
 * Input
 * An integer N will denominate the number of test cases. The following N cases
 * will contain an
 * integer M. This integer, M, denominates the number of people participating in
 * the vote. The
 * following M lines will contain a name following by the letter Y or N meaning
 * yes or no,
 * respectively. All the names will be in lowercase for simplicity’s sake.
 * Output
 * If the Caesar is not present print out what most of the people choose, YES or
 * No. Else if the
 * Caesar is present print out what the Caesar choose. In the event of a tie
 * print out Tie.
 * Example Input File
 * 3
 * 2
 * rem Y
 * ram Y
 * 3
 * rem Y
 * rem N
 * ram N
 * 4
 * emilia Y
 * rem Y
 * ram Y
 * caesar N
 * Example Output to Screen
 * YES
 * No
 * No
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class yes {
  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\YesOrNo\\yes.dat";
    Scanner scanner = new Scanner(new File(inputFile));
    int N = scanner.nextInt(); // Number of test cases
    scanner.nextLine(); // Consume the newline character

    for (int i = 0; i < N; i++) {
      int M = scanner.nextInt(); // Number of people participating in the vote
      scanner.nextLine(); // Consume the newline character
      Map<String, Character> votes = new HashMap<>();
      boolean caesarPresent = false;
      char caesarVote = 'N';

      for (int j = 0; j < M; j++) {
        String[] vote = scanner.nextLine().split(" ");
        String name = vote[0];
        char decision = vote[1].charAt(0);

        if (name.equals("caesar")) {
          caesarPresent = true;
          caesarVote = decision;
        } else {
          votes.put(name, decision);
        }
      }

      if (caesarPresent) {
        System.out.println(caesarVote == 'Y' ? "YES" : "No");
      } else {
        int yesCount = 0;
        int noCount = 0;

        for (char decision : votes.values()) {
          if (decision == 'Y') {
            yesCount++;
          } else {
            noCount++;
          }
        }

        if (yesCount > noCount) {
          System.out.println("YES");
        } else if (noCount > yesCount) {
          System.out.println("No");
        } else {
          System.out.println("Tie");
        }
      }
    }

    scanner.close();
  }
}