import  java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Gleb {
public static void main(String[] args) throws FileNotFoundException {
String[] piano = {"A0", "B0", "C1", "D1", "E1", "F1", "G1","A1", "B1", "C2", "D2", "E2", "F2", "G2","A2", "B2", "C3", "D3", "E3", "F3", "G3","A3", "B3", "C4", "D4", "E4", "F4", "G4","A4", "B4", "C5", "D5", "E5", "F5", "G5","A5", "B5", "C6", "D6", "E6", "F6", "G6","A6", "B6", "C7", "D7", "E7", "F7", "G7", "A7", "B7", "C8"};
  Scanner scanner = new Scanner(new File("gleb.dat"));
  while(scanner.hasNextLine()){
    String line = scanner.nextLine();
    int counter = 1;
    Scanner lineScan = new Scanner(line);
    lineScan.next();
    while (lineScan.hasNextInt()) {
      counter ++;
      lineScan.nextInt();
    }
    String[] music = new String[counter];
    lineScan = new Scanner(line);
    music[0] = lineScan.next();
    String temp = music[0];
    for (int i = 1; i < music.length; i++) {
      for (int j = 0; j < piano.length; j++) {
        if (temp.equals(piano[j])) {
          int add = lineScan.nextInt();
          if (add > 0)
          temp = piano[j + add - 1];
          if (add < 0)
          temp = piano [j + add + 1 ];
          break;
        }
      }
      music[i] = temp;
    }
    for (String note: music) {
      System.out.print(note + " ");
    }
    System.out.println("");
  }
  
}
}


