import java.util.*;
public class Deck {
  
  private ArrayList<Card> deck;
  public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
  public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
  public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
  
  public Deck() {
    deck = new ArrayList<Card>();
    initializeDeck();
  }
  
//getter methods
  public ArrayList<Card> getDeck() {
    return deck;
  }
//setter methods
  public void setDeck(Deck newDeck) {
    deck = newDeck.getDeck();
  }
//initialize deck
  public void initializeDeck() {

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {
        deck.add(new Card(NAMES[j], SUITS[i], RANKS[j]));

       // for (int rank : RANKS) {
          //deck.add(new Card(name, suit, rank));
       // }
      }
    }
  }
  //getCard
  public Card getCard(int idx) {
    return deck.get(idx);
  }
  //deal Top card
  public Card dealTopCard() {
    return deck.remove(0);
  }
  //shuffle
  public void shuffle() {
    int randomNumber = (int) ((Math.random() * (9)) + 2);

    ArrayList<Card> cards = new ArrayList<Card>();
    for (int i = 0; i < randomNumber; i++) {
      
      cards.add(deck.get(i));
      deck.remove(i);
    }
    int indexToPlace = (int) ((Math.random() * (51 - randomNumber))); 
    deck.addAll(indexToPlace, cards); 
  }
  public String toString() {
    if (deck.size() == 0)
      return "No cards in the deck!";
    String newString = "";
    for (Card card : deck) {
      newString += card.toString();
    }
    return newString;
  }
}