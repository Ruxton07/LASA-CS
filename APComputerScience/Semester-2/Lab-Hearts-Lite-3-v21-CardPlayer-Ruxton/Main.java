import java.util.*;    // required to use ArrayList

class Main {

  // test the getValue() and compareCard() methods
  public static void main(String[] args) {
  
    ArrayList<Card> hand = new ArrayList<Card>();
    CardPlayer player1 = new CardPlayer("Kara Jones",0,hand);
    System.out.println("New CardPlayer -> " + player1);
    Card card1 = new Card("2","clubs",2);
    Card card2 = new Card("3","clubs",3);
    Card card3 = new Card("3","diamonds",3);
    Card card4 = new Card("A","hearts",14);
    Card card5 = new Card("7","spades",7);
    Card card6 = new Card("6","spades",6);
    player1.addCard(card1);
    player1.addCard(card2);
    player1.addCard(card3);
    player1.addCard(card4);
    player1.addCard(card5);
    player1.addCard(card6);
    System.out.println("After adding 6 cards. Player -> " + player1);
    Card cardPlayed = player1.playCard(5);
    player1.updateScore(27);
    System.out.println("Played " +  cardPlayed + " at index 5 and updated score to 27 points. Player -> " + player1);
    ArrayList<Card> cardsPlayedInRound = new ArrayList<Card>();
    ArrayList<Card> cardsPlayedInGame = new ArrayList<Card>();
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    System.out.println("Cards played in game -> " + cardsPlayedInGame);
    Card chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("Chose 2 of clubs -> " + chosenCard + " Player -> " + player1);
    Card card7 = new Card("10","spades",10);
    cardsPlayedInRound.add(card7);
    cardsPlayedInGame.add(card7);
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    cardsPlayedInGame.add(chosenCard);
    System.out.println("RANDOMLY chosen spade -> " + chosenCard + " Player -> " + player1);
    cardsPlayedInRound.clear();
    Card card8 = new Card("9","clubs",9);
    cardsPlayedInRound.add(card8);
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("heart chosen -> " + chosenCard + " Player -> " + player1);
    cardsPlayedInRound.clear();
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("RANDOMLY chosen card -> " + chosenCard + " Player -> " + player1);
  }
}
