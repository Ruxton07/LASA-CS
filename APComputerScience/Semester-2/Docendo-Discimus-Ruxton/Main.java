import java.util.*;
import java.util.concurrent.TimeUnit;
class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("\n             BATTLE GAME!" + "\n" + "\nBy: Chloe Bao, Ryan Kellar, and Nishtha Verma");
    Board battle = new Board();
    Scanner scan = new Scanner(System.in);
    System.out.println("\n" + "              START GAME");
    boolean game = true;
    System.out.println();
    System.out.println("        --PRESS ENTER TO START--");
    scan.nextLine();
    System.out.println("THE ENEMIES NAVAL UNIT DATA HAS BEEN MOMENTARILY LEAKED, YOU WILL HAVE 3 SECONDS TO VIEW IT.");
    System.out.println();
    Thread.sleep((long)2000);
    System.out.println(battle.toString(true));
    Thread.sleep((long)3500);
    System.out.println("\033[H\033[2J");
    System.out.flush();
    
    
    while (battle.getStatus()) {
      System.out.print("\033[H\033[2J");  
      System.out.flush();
      System.out.println(battle.toString(false));
      System.out.println();
      String coord = scan.nextLine();
      int row = Integer.parseInt(coord.substring(0,1));
      int col = Integer.parseInt(coord.substring(2));
      if (row > 5)
        row = 5;
      if (col > 5)
        col = 5;
      battle.shoot(row,col);
      System.out.println("--PRESS ENTER TO CONTINUE--");
      scan.nextLine();
    }

    System.out.println();
    System.out.println("CONGRATULATIONS! YOU WON THE GAME, WITH A TOTAL SPLASH/HIT RATIO OF " + battle.getRatio() + ".");
    System.out.println("ENEMY'S BOARD:\n" + battle.toString(true));
  }
}