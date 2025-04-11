// UNCOMMENT CODE TO START
// import java.util.*;
/**
public class LabBoard {
  private boolean inGame = true;
  /*private variables to declare:
  2D array board, 2D array shots, double splash counter, double hit counter*/
/**
  public LabBoard() {
    //instantiate 2D arrays and fill with 0s
    //4-length battleships
    for (int i = 5; i <= 6; i++) {
      int x = (int) (Math.random() * 4);
      int y = (int) (Math.random() * 4);
      int dir = (int) (Math.random() * 4); //0 is vertical, 1 is horizontal, 2 is up diagonal, 3 is down diagonal
      while (!isValidPosition(x, y, 4, dir)) {
        x = (int) (Math.random() * 4);
        y = (int) (Math.random() * 4);
        dir = (int) (Math.random() * 4);
      }
      board[x][y] = i;
      if (dir == 0) {
        board[x + 1][y] = i;
        board[x + 2][y] = i;
        board[x + 3][y] = i;
      } else if (dir == 1) {
        board[x][y + 1] = i;
        board[x][y + 2] = i;
        board[x][y + 3] = i;
      } else if (dir == 2) {
        board[x + 1][y - 1] = i;
        board[x + 2][y - 2] = i;
        board[x + 3][y - 3] = i;
      } else { // in this case dir == 3 (down diagonal)
        board[x + 1][y + 1] = i;
        board[x + 2][y + 2] = i;
        board[x + 3][y + 3] = i;
      }
    }
    
    //3-length battleships to be implemented
    
    //2-length battleships to be implemented
    
    //6 ships total: two destroyers (2 units long), Two cruisers (3 units long), two aircraft carriers (4 units long)
  }
  
  private boolean isValidPosition(int x, int y, int len, int dir) {
    if (dir == 1) {
    if (y + len >= 6) {
      return false;
    }
    for (int i = 0; i < len; i++) {
      if (board[x][y + i] != 0) {
        return false;
      }
    }
  } else if (dir == 0) {
    if (x + len >= 6) {
      return false;
    }
    for (int i = 0; i < len; i++) {
      if (board[x + i][y] != 0) {
        return false;
      }
    }
  } else if (dir == 2) {
    if (x - len <= -1 || y + len >= 6) {
      return false;
    }
    for (int i = 0; i < len; i++) {
      if (board[x - i][y + i] != 0) {
        return false;
      }
    }
  } else if (dir == 3) {
    if (x + len >= 6 || y + len >= 6) {
      return false;
    }
    for (int i = 0; i < len; i++) {
      if (board[x + i][y + i] != 0) {
        return false;
      }
    }
  }
  return true;
  }
  
  //getter methods
  public int[][] getBoard() { return board; }
  public boolean getState() { return inGame; }
  public double getSplash() { return cSplash; }
  public double getHits() { return cHits; }
  public int[][] getShotsBoard() { return shots; }
  //setter methods
  public void setBoard(int[][] newBoard) { board = newBoard; }
  public void setState(boolean status) { inGame = status; }
  public void setSplash(double newSplash) { cSplash = newSplash; }
  public void setHits(double newHits) { cHits = newHits; }
  public void setShotsBoard(int[][] newShots) { shots = newShots; }
  //printer methods
  public String printBoard() {
    String msg = "";
    for (int r = 0; r < 6; r++) {
      for (int c = 0; c < 6; c++) {
        msg = msg + "" + board[r][c];
        if (c != 5)
          msg += " ";
      }
      if (r != 5)
        msg += "\n";
    }
    return msg;
  }
  public String printShotsBoard() {
    String msg = "";
    for (int r = 0; r < 6; r++) {
      for (int c = 0; c < 6; c++) {
        msg = msg + "" + shots[r][c];
        if (c != 5)
          msg += " ";
      }
      if (r != 5)
        msg += "\n";
    }
    return msg;
  }

  //shoot method
  public void shoot(int row, int column) {} //to be implemented

  public void printStats() {} // to be implemented
  
  public double getRatio() {} // to be implemented 

  public String toString(boolean permission) {} // to be implemented
}**/