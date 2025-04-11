public class Card implements Comparable<Object> {
  
  /**
  * Set instance variables as follows;
  *   variable "name" of type string
  *   variable suit of type string
  *   variable "value" of type primitive integer
  * Note: use the correct access specifier
  */
  private String name;
  private String suit;
  private int value;
   
  /**
  * Card Constuctor - default
  * Creates a default card object with;
  *   name set to "default"
  *   suit set to "default"
  *   value set to 0
  * @param none
  */
  public Card() {
    name = "default";
    suit = "default";
    value = 0;
  }
  
  /**
  * Card Constuctor - initializing
  * Creates a default card object with;
  *   name set to "default"
  *   suit set to "default"
  *   value set to 0
  * @param  name a string with name of card
  * @param  suit a string with name of suit
  * @param  value an integer with the value of the card
  */
  public Card(String n, String s, int v){
    name = n;
    suit = s;
    value = v;
  }


  /**
  * Accessor Methods for each instance variable
  */
  public String getName() {
    return name;
  }
  public String getSuit() {
    return suit;
  }
  public int getValue() {
    return value;
  }

  /**
  * Mutator Methods for each instance variable
  */
  public void setName(String newName) {
    name = newName;
  }
  public void setSuit(String newSuit) {
    suit = newSuit;
  }
  public void setValue(int newVal) {
    value = newVal;
  }
  
  /**
  * sortRank - Helper function to give rank of card, weighted
  *            by suit. 
  *                diamonds 0-12, hearts 13-25, 
  *                spades 26 - 38, clubs 39 - 51
  *  So you simply need to add a wight to value of this card object
  *                diamonds: value + 0
  *                hearts: value + 13
  *                spades: value + 26
  *                clubs: value + 39
  */
  public int sortRank() {     // ** You have to fix this method declaration

    if (suit.equals("diamonds"))
      return value + 0;
    else if (suit.equals("hearts"))
      return value + 13;
    else if (suit.equals("spades"))
      return value + 26;
    else
      return value + 39;
      
  }


  /**
  * compareTo - Override the compareTo() method default
  * 
  */

  public int compareTo (Object obj)  {     // ** You have to fix this method declaration
    Card c = (Card) obj;
    if (c.sortRank() > this.sortRank())
      return -1;
    if (c.sortRank() == this.sortRank())
      return 0;
    if (c.sortRank() < this.sortRank())
      return 1;
    else return 2;
  }

  /**
  * equals - Override the equals() method default
  *  for indexOf() to work on an array of cards we 
  *   need to define what it means for two cards to 
  *   be equal.  We use indexOf() to find the 2 of 
  *   clubs in the CardGame class.
  */
  public boolean equals(Object obj) {
    Card c = (Card) obj;
    return ((c.getName().equals(this.name)) && (c.getSuit().equals(this.suit)) && (c.getValue() == this.value));
  }
  
  // toString - Override the toString method default 
  public String toString() {
    return "" + suit.substring(0,1) + name.substring(0,1) + "(" + value + ")";
  }
}