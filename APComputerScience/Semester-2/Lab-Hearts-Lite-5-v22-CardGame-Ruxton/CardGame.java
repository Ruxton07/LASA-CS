import java.util.*;

public class CardGame {
  //instance variables
  private Deck deckOfCards;
  private String nameOfGame;
  private ArrayList<CardPlayer> players;
  private int numberOfPlayers;
  private int currentPlayer;

  //initialization constructor
  public CardGame(String name, int playerCount, String[] playerNames, int currentPlayerP) {
    deckOfCards = new Deck();
    nameOfGame = name;
    players = new ArrayList<CardPlayer>();
    numberOfPlayers = playerCount;
    currentPlayer = currentPlayerP;
    for (String x: playerNames) {
      players.add(new CardPlayer(x, 0, new ArrayList<Card>()));
      
    }
  }

  public int nextPlayerIdx(int a) {
    return a;
  }
  
  //getter methods
  public Deck getDeckOfCards() {
    return deckOfCards;
  }
  public String getNameOfGame() {
    return nameOfGame;
  }
  public ArrayList<CardPlayer> getPlayers() {
    return players;
  }
  public Player getPlayer(int x) {
    return players.get(x);
  }
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }
  public int getCurrentPlayer() {
    return currentPlayer;
  }

  //setter methods
  public void setDeckOfCards(Deck newDeck) {
    deckOfCards = newDeck;
  }
  public void setNameOfGame(String newString) {
    nameOfGame = newString;
  }
  public void setPlayers(ArrayList<CardPlayer> newPlayerList) {
    players = newPlayerList;
  }
  public void setNumberOfPlayers(int newPlayerCount) {
    numberOfPlayers = newPlayerCount;
  }
  public void setCurrentPlayer(int newCurrentPlayer) {
    currentPlayer = newCurrentPlayer;
  }

  //deal() method
  public void deal(int top, int pIndex) {
    for (int i = 0; i < top; i++) {
      players.get(pIndex).addCard(deckOfCards.dealTopCard());
    }
  }

  //playGame() method
  public void playGame() {
    ArrayList<Card> previousRounds = new ArrayList<Card>();
    ArrayList<Card> round = new ArrayList<Card>();
    this.setCurrentPlayerToStartingPlayer();
    int playerWhoLed = currentPlayer;
    int lastCurrentPlr = currentPlayer;
    for (int i = 0; i < 13; i++) {
      round.add(players.get(currentPlayer).chooseCard(round, previousRounds));
      for (int x = 0; x < 3; x++) {
        currentPlayer += 1;
        currentPlayer %= 4;
        round.add(players.get(currentPlayer).chooseCard(round, previousRounds));
      }
      for (Card x: round) {
        previousRounds.add(x);
      }
      currentPlayer = takesRound(lastCurrentPlr,round);
      int score = 0;
      for (Card x: round) {
        if (x.getSuit().equals("hearts")) {
          score += 1;
        }
        if (x.getValue() == (12)) {
          score += 13;
        }
      }

       players.get(currentPlayer).updateScore(score);
    }
    
      /**if ((card.getSuit().equals("clubs")) && (card.getValue() == 2)) {
          currentPlayer = players.indexOf(plr);
      }**/
    
    players.get(currentPlayer).getTakenCards().addAll(round);
    previousRounds.addAll(round);
    checkRound(round, playerWhoLed);
    }
  
  //takesRound() minimethod
  public int takesRound(int playerThatLed, ArrayList<Card> cardsPlayedThisRound) {
    int sadCard;
    Card minCard = cardsPlayedThisRound.get(0);
    for (int k = 0; k < cardsPlayedThisRound.size(); k++) {
      if (cardsPlayedThisRound.get(k).getSuit().equals(minCard.getSuit()) && cardsPlayedThisRound.get(k).compareTo(minCard) == -1) { 
        minCard = cardsPlayedThisRound.get(k); 
      }
    }
    sadCard = cardsPlayedThisRound.indexOf(minCard);
    return (playerThatLed + sadCard) % 4;
  }

  //score4Game() minimethod
  public int score4Game(ArrayList<Card> cards) {
    int plrScore = 0;
    for (Card m: cards) {
      if (m.getSuit().equals("hearts")) { plrScore++; }
      if (m.getValue() == (12)) { plrScore += 13; }
    }
    return plrScore;
  }

  //setCurrentPlayerToStartingPlayer() minimethod
  public void setCurrentPlayerToStartingPlayer() {
    for (CardPlayer  q: players) {
      for (Card sysCard: q.getHand()) {
        if (sysCard.getValue() == (2) && sysCard.getSuit().equals("clubs")) { currentPlayer = players.indexOf(q); }
      }
    }
  }

  public String toString() {
    String strVal = "";
    strVal += "***" + nameOfGame + "***"+ "\n";
    for (int r = 0; r < numberOfPlayers; r++) { strVal += players.get(r) + "\n"; }
    strVal += "deck -> " + deckOfCards.toString();
    return strVal;
  }

  public void checkRound(ArrayList<Card> round, int startingPlayer) {
    int errorsInCheckRound = 0;
    if (errorsInCheckRound < 5) {
      // System.out.print(startingPlayer + " ");
      String roundSuit = round.get(0).getSuit();  // Suit that was led
      for (int i = 1; i < round.size(); i++) {     // for all other cards played in the round
         if (!round.get(i).getSuit().equals(roundSuit)) {    
            CardPlayer player = players.get((startingPlayer ) % round.size());
            for (Card c : player.getHand()) {   // check each card in that players hand
               if (c.getSuit().equals(roundSuit)) { 
                  System.out.println("*** DID NOT FOLLOW SUIT ***\n  round=" + round + "\n  played=" + round.get(i) + "\n  hand=" + player.getHand());
                  errorsInCheckRound++;
                  break;
               }
            }
         }
      }
    }
  }
}