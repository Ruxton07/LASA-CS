import java.util.*;    // required to use ArrayList

class Main {
  public static void main(String[] args) {
    System.out.println("Hello Hearts!");
    TestCardGame();
  }

  public static void TestCardGame()
  {

    String [] names = {"Betty","Bob","Sue","Albert"};
    // game 2
    CardGame game2 = new CardGame("Hearts",4,names,0);
    System.out.println(">>> Printing game in TestCardGame");
    System.out.println(game2);
    for (int i=1; i <= 20; i++) {
       // INFO
       //game2.initializeDeckOfCards();
       game2.getDeckOfCards().initializeDeck();
       game2.getDeckOfCards().shuffle();
       game2.deal(13,0);
       game2.deal(13,1);
       game2.deal(13,2);
       game2.deal(13,3);
       // INFO
       //System.out.println(game2);
       game2.playGame();
    }
    int total = 0;
    for (int i=0; i <= 3; i++) {
      total = total + game2.getPlayer(i).getScore();
    }
    System.out.println(">>> Printing Total Score and Player % in TestCardGame");
    System.out.println("Total Score = " + total);
    double percent;
    for (int i=0; i <= 3; i++) {
      percent = ((int) ((game2.getPlayer(i).getScore()/(double) total) * 10000))/ 100.0;
      System.out.println(game2.getPlayer(i).getName() + " " + percent + "%");
    }    
  }



}