/*
 * The Caesar is angry at you for sleeping on your job. As punishment, he orders
 * you to sort his chess pieces. Because
 * the Caesar is so rich and powerful he has many chess pieces. He instructs you
 * to sort them by importance. If a piece
 * is white it will be represented by an uppercase letter if its black it will
 * be represented by a lowercase letter. The
 * letters R,H,B,Q,K,P represent Rook, Horse, Bishop, Queen, King, and Pawn
 * respectively. The most important piece
 * is the king followed by the queen, rook, horse, bishop, and finally the pawn.
 * Take note that the Caesar prefers the
 * white pieces over the black ones so even a white pawn is considered more
 * important than a black king.
 * Input
 * An integer N will denominate the number of test cases. The following N lines
 * will contain a
 * series of space separated letter which represent chess pieces.
 * Output
 * Output the chess pieces in ascending order of importance. The output ends
 * immediately after the
 * last chess piece is printed (i.e. there should NOT be a space after the
 * character representing the
 * last chess piece).
 * Example Input File
 * 3
 * P K Q R H
 * K k K R q q
 * P k q q r r k P
 * Example Output to Screen
 * P H R Q K
 * q q k R K K
 * r r q q k k P P
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sort {
  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\ImperialSort\\imperialsort.dat";
    Scanner scanner = new Scanner(new File(inputFile));
    int N = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < N; i++) {
      String line = scanner.nextLine();
      String[] pieces = line.split(" ");
      String[] sortedPieces = sortPieces(pieces);
      System.out.println(String.join(" ", sortedPieces));
    }

    scanner.close();
  }

  private static String[] sortPieces(String[] pieces) {
    for (int i = 0; i < pieces.length - 1; i++) {
      for (int j = 0; j < pieces.length - i - 1; j++) {
        if (getImportance(pieces[j]) > getImportance(pieces[j + 1])) {
          String temp = pieces[j];
          pieces[j] = pieces[j + 1];
          pieces[j + 1] = temp;
        }
      }
    }
    return pieces;
  }

  private static int getImportance(String piece) {
    switch (piece) {
      case "K":
        return 12;
      case "Q":
        return 11;
      case "R":
        return 10;
      case "H":
        return 9;
      case "B":
        return 8;
      case "P":
        return 7;
      case "k":
        return 6;
      case "q":
        return 5;
      case "r":
        return 4;
      case "h":
        return 3;
      case "b":
        return 2;
      case "p":
        return 1;
      default:
        return 13;
    }
  }
}