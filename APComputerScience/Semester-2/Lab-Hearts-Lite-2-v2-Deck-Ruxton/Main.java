class Main {

  // test to see if a random card appears at a specific location in the deck about once per 52 shuffles.
  public static void main(String[] args) {
    Deck deck1 = new Deck();
    System.out.println("new deck " + deck1);
    deck1.shuffle();
    System.out.println("shuffled " + deck1);
    System.out.println();
    for (int i=0; i < 4; i++) {
      System.out.print("13 cards ");
      for (int j=0; j < 13; j++) {
         System.out.print(deck1.dealTopCard());
      }
      System.out.println("\nremaining " + deck1);
    }
  
    Deck deck2 = new Deck();
    int randCard = (int)(Math.random() * 53);         
    Card testCard = deck2.getCard(randCard);
    System.out.println("\nrandom card from new deck " + testCard + ".");
    int randLocation = (int)(Math.random() * 53);
    System.out.println("random location to check is " + randLocation + ".");
    int foundCard = 0;
    for (int i=0; i < 52000; i++) {
       deck2.shuffle();
       if (testCard.equals(deck2.getDeck().get(randLocation))) {
          foundCard++;
       }
    }
    System.out.println("Found " + testCard + " at location " + randLocation + " in the deck " + foundCard + " times.");
  }

}
