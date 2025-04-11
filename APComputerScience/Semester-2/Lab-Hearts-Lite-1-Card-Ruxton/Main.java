class Main {

  // test the getValue() and compareCard() methods
  public static void main(String[] args) {
   System.out.println("Card Class Test Program");
    Card card1 = new Card("3","clubs",3);
    Card card2 = new Card("3","clubs",3);
    Card card3 = new Card("3","diamonds",3);
    Card card4 = new Card("A","hearts",14);
    Card card5 = new Card("7","spades",7);
    Card card6 = new Card("6","spades",6);
    
    System.out.println(card1 + ".equals(" + card2 + ") is " + card1.equals(card2));
    System.out.println(card2 + ".equals(" + card3 + ") is " + card2.equals(card3));
    System.out.println(card1 + ".compareTo(" + card2 + ") is " + card1.compareTo(card2));
    System.out.println(card2 + ".compareTo(" + card3 + ") is " + card2.compareTo(card3));
    System.out.println(card3 + ".compareTo(" + card2 + ") is " + card3.compareTo(card2));
    System.out.println(card4 + ".compareTo(" + card5 + ") is " + card4.compareTo(card5));
    System.out.println(card5 + ".compareTo(" + card4 + ") is " + card5.compareTo(card4));
    System.out.println(card5 + ".compareTo(" + card6 + ") is " + card5.compareTo(card6));

  }
}
