import java.util.*;
public class Board {
  private int[][] board;
  private int[][] shots;
  private double cSplash = 0;
  private double cHits = 0;
  private boolean inGame = true;

  public Board() {
    //instantiating 2D boards and filling w/ 0s
    board = new int[6][6];
    shots = new int[6][6];
    for (int r = 0; r < 6; r++) {
      for (int c = 0; c < 6; c++) {
        board[r][c] = 0;
        shots[r][c] = 0;
      }
    }

    //4-length battleships
    for (int i = 5; i <= 6; i++) {
      int x = (int) (Math.random() * 4);
      int y = (int) (Math.random() * 4);
      int dir = (int) (Math.random() * 4); //same rules as 2 and 3
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
    
    //3-length battleships
    for (int i = 3; i <= 4; i++) {
      int x = (int) (Math.random() * 6);
      int y = (int) (Math.random() * 6);
      int dir = (int) (Math.random() * 4); //same rules as 2
      while (!isValidPosition(x, y, 3, dir)) {
        x = (int) (Math.random() * 6);
        y = (int) (Math.random() * 6);
        dir = (int) (Math.random() * 4);
      }
      board[x][y] = i;
      if (dir == 0) {
        board[x + 1][y] = i;
        board[x + 2][y] = i;
      } else if (dir == 1) {
        board[x][y + 1] = i;
        board[x][y + 2] = i;
      } else if (dir == 2) {
        board[x - 1][y + 1] = i;
        board[x - 2][y + 2] = i;
      } else { // in this case dir == 3 (down diagonal)
        board[x + 1][y + 1] = i;
        board[x + 2][y + 2] = i;
      }
    }
    
    //2-length battleships
    for (int i = 1; i <= 2; i++) {
      int x = (int) (Math.random() * 6);
      int y = (int) (Math.random() * 6);
      int dir = (int) (Math.random() * 4); //0 is vertical, 1 is horizontal, 2 is up diagonal, 3 is down diagonal
      while (!isValidPosition(x, y, 2, dir)) {
        x = (int) (Math.random() * 6);
        y = (int) (Math.random() * 6);
        dir = (int) (Math.random() * 4);
      }
      board[x][y] = i;
      if (dir == 0) {
        board[x + 1][y] = i;
      } else if (dir == 1) {
        board[x][y + 1] = i;
      } else if (dir == 2) {
        board[x - 1][y + 1] = i;
      } else { // in this case dir == 3 (down diagonal)
        board[x + 1][y + 1] = i;
      }
    }
    //6 ships: two destroyers (2 units long), Two cruisers (3 units long), two aircraft carriers (4 units long)
  }

  //method I frequently used in constructor, and might need to use again at another time
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
    /*if (x + length > 6 && y + length > 6) {
      return false;
    }
    for (int i = 0; i < length; i++) {
      if (x + i < 6 && board[x + i][y] != 0) {
        return false;
      }
      if (y + i < 6 && board[x][y + i] != 0) {
        return false;
      }
    }
    return true;*/ //THIS IS OLD METHOD BEFORE DIAGONALS EXISTED
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
  public void shoot(int row, int column) {
    boolean sunk = true;
    int ship = board[row][column];
    if (board[row][column] > 0) {
      cHits++;
      System.out.print("A DIRECT HIT ON SHIP NUMBER ");
      System.out.println(ship);
      board[row][column] = 9;
      shots[row][column] = 9; //set to 9 to signify hit spots
      for (int r = 0; r < board.length; r++) {
        for (int c = 0; c < board[r].length; c++) {
          if (board[r][c] == ship) {
            sunk = false;
          }
        }
      }
      if (sunk) { //if they have completely sunk the ship
      System.out.println ("AND YOU SUNK IT.");
      printStats();
      }
    }
    else {
      cSplash++;
      System.out.println("Splash!");
      board[row][column] = 8;
      shots[row][column] = 8; //set to 8 to signify shots that missed
    }
    System.out.println("Try again.");
    System.out.println("");
  }

  
  public void printStats() {
    int destroyers = 2;
    int cruisers = 2;
    int airCarriers = 2;

    boolean d1 = false;
    boolean d2 = false;
    boolean c1 = false;
    boolean c2 = false;
    boolean ac1 = false;
    boolean ac2 = false;
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 1) { //true if the ship is still alive
          d1 = true;
        }
        else if (board[i][j] == 2) {
          d2 = true;
        }
        else if (board[i][j] == 3) {
          c1 = true;
        }
        else if (board[i][j] == 4) {
          c2 = true;
        }
        else if (board[i][j] == 5) {
          ac1 = true;
        }
        else if (board[i][j] == 6) {
          ac2 = true;
        }
      }
    }

    if (d1) {
      destroyers--; //counter is how many you've destroyed
    }
    if (d2) {
      destroyers--;
    }
    if (c1) {
      cruisers--;
    }
    if (c2) {
      cruisers--;
    }
    if (ac1) {
      airCarriers--;
    }
    if (ac2) {
      airCarriers--;
    }

    if (destroyers + airCarriers + cruisers == 6) {
      inGame = false;
    }

    System.out.println("SO FAR, THE BAD GUYS HAVE LOST"); 
    System.out.println(destroyers + " DESTROYER(S), " + cruisers + " CRUISER(s), " + "AND " + airCarriers + " AIRCRAFT CARRIER(S)");
    System.out.println("YOUR CURRENT SPLASH/HIT RATIO IS " + getRatio());
  }

  public boolean getStatus() {
    return inGame;
  }
  
  public double getRatio() { return cSplash / cHits; }

  public String toString(boolean permission) {
    if (permission)
      return "ENEMY BOARD:\n" + printBoard();
    return "ENEMY BOARD:\n" + printShotsBoard();
  }
}