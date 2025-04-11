/*
 * Chess is an amazing game. A true game of wit and deception. Print out a chess
 * board identical to that in the output.
 * The uppercase letters represent the black pieces and the lowercase letters
 * represent the white ones. The letters
 * R,H,B,Q,K,P represent Rook, Horse, Bishop, Queen, King, and Pawn
 * respectively.
 * Input
 * None.
 * Output
 * Print out a chess board identical to the one in the output.
 * Example Input File
 * None.
 * Example Output to Screen
 * RHBQKBHR
 * PPPPPPPP
 * ........
 * ........
 * ........
 * ........
 * pppppppp
 * rhbkqbhr
 */

public class chess {
  public static void main(String[] args) {
    String[] board = {
        "RHBQKBHR",
        "PPPPPPPP",
        "........",
        "........",
        "........",
        "........",
        "pppppppp",
        "rhbkqbhr"
    };

    for (String row : board) {
      System.out.println(row);
    }
  }
}