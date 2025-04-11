import java.util.*;

public class CardPlayerLevel1 extends CardPlayer {
  
  public CardPlayerLevel1(String n, int s, ArrayList<Card> h) {
    super(n,s,h);
  }

  public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
  Card temp = new Card();
  for (Card x: super.getHand()) {
    if (x.getValue() == (2) && x.getSuit().equals("clubs")) { //if they have the two of clubs
      temp = x;
      //round.add(x);
      super.getHand().remove(x);
      return temp; //double check may not need to remove it
    }
  }
  
 //if they are the first player of a round
    if (previousRounds.size() % 4 == 0) {
      int randNum =(int) (Math.random() * (super.getHand().size() - 1));
      temp = super.getHand().get(randNum);
      super.getHand().remove(randNum);
      return temp;
    }
    
    else if (round.size() > 0) {
      for (Card x: super.getHand()) { // for loop for equals same suit
        if (round.get(0).getSuit().equals(x.getSuit())) {
          temp = x;
          super.getHand().remove(x);
          return temp;
        }   
      }
      temp = new Card();
      for (Card x: super.getHand()) { // for loop for if they have queen of spades
        if (x.getSuit().equals("spades") && x.getValue() == 12) {
          temp = x;
          super.getHand().remove(x);
          return temp;
        }
      }
      temp = new Card();
      for (Card x: super.getHand()) {
        if (x.getSuit().equals("hearts")) {//for loop for equals hearts
          if (temp.compareTo(x) == -1) {
            temp = x;
          }
        }
        super.getHand().remove(x);
        return temp;
      }
    }
      int randNum = (int) (Math.random() * (super.getHand().size() - 1)); //for loop for random card if neither of the top two end the method.
      return super.getHand().remove(randNum);
  }  
}