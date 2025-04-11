import java.util.*;    // required to use ArrayList

public class CardPlayer extends Player {
//instance variables!
ArrayList<Card> hand;
ArrayList<Card> takenCards;

//initialization constructor
public CardPlayer(String n, int s, ArrayList<Card> h) {
  super(n,s);
  this.hand = h;
}

//accessor methods
public ArrayList<Card> getHand() {
  return hand;
}
public ArrayList<Card> getTakenCards() {
  return takenCards;
}
//mutator
public void setHand(ArrayList<Card> newHand) {
  this.hand = newHand;
}
public void setTakenCards(ArrayList<Card> a) {
  this.takenCards = a;
}

//addCard
public void addCard(Card card) {
  this.hand.add(card);
}

//playCard
public Card playCard(int index) {
  return this.hand.remove(index);
}

//chooseCard
public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
  Card temp = new Card();
  for (Card x: hand) {
    if (x.getValue() == (2) && x.getSuit().equals("clubs")) { //if they have the two of clubs
      temp = x;
      //round.add(x);
      this.hand.remove(x);
      return temp; //double check may not need to remove it
    }
  }
  
 //if they are the first player of a round
    if (previousRounds.size() % 4 == 0) {
      int randNum =(int) (Math.random() * (this.hand.size() - 1));
      temp = this.hand.get(randNum);
      this.hand.remove(randNum);
      return temp;
    }
    
  else if (round.size() > 0) {
    for (Card x: hand) { // for loop for equals same suit
      if (round.get(round.size()-1).getSuit().equals(x.getSuit())) {
        temp = x;
        this.hand.remove(x);
        return temp;
      }   
    }
    for (Card x: hand) {
      if (x.getSuit().equals("hearts")) //for loop for equals hearts
        temp = x;
        this.hand.remove(x);
        return temp;
    }
    
  }
  int randNum = (int) (Math.random() * (this.hand.size() - 1)); //for loop for random card if neither of the top two end the method.
      return this.hand.remove(randNum);
    
}

//toString
public String toString() {
  Collections.sort(hand);
  return super.getName() + " (" + super.getScore() + ") " + this.hand;
}
}
