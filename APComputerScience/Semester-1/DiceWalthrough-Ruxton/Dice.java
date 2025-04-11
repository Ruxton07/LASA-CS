/**  A dice object with not only sides and a value but also a color and a name.
*/
public class Dice {

   /** Declare instance Variables.  
 These are variable known only to each created(instantiated object 
   */

   /** name of the dice */
  private String name;
   /** number of sides of the dice */
  private int sides = 6;
   /** value of the dice */
  private int value;
   /** color of the dice */
  
  private String color;
   /** Declare constructors for the Object */
  public Dice() {
    name = "dice";
    sides = 6;
    value = 1;
    color = "red";
    
  }


   /** Creates a 6-sided red dice with the name "dice" and initial value of 1
   */

   /** Creates a dice with the specified name, number of sides, initial value and color.
     * @param initName The name of the dice
     * @param initSides The number of sides of the dice
     * @param initValue The initial value of the dice
     * @param initColor The color of the dice
   */    
  public Dice(String initName, int initSides, int initValue, String initColor) {
    name = initName;
    sides = initSides;
    value = initValue;
    color = initColor;
  }

  
   /** Declare getter methods
    * Simple methods that access the instance variables
   */ 

   /** Get the  name of the dice.
    * @return the name of the dice.
   */   
  public String getName() {
    return name;
  }
   /** Get the number of sides of the dice.
    * @return the number of sides of the dice.
   */   
  public int getSides() {
    return sides;
  }
   /** Get the current value of the dice.
    * @return the current value of the dice.
   */   
  public int getValue() {
    return value;
  }
   /** Get the color of the dice.
    * @return the color of the dice.
   */
  public String getColor() {
    return color;
  }
   /** Declare setter methods
    * Simple methods that mutate (set) the instance variables
   */
       
   /** Set the current value of the dice.
    * @param newValue the new value of the dice.
   */
  public void setValue (int newValue) {
    value = newValue;
  }
  
  public void setName (int newName) {
    value = newName;
  }
  
  public void setColor (int newColor) {
    value = newColor;
  }
  
  public void setSides (int newSides) {
    value = newSides;
  }
  
  
   /** Declare behavioral methods
    * Methods that do things, primarily manipulate the object’s variables
    * These are arbitrarily complicated
   */
  public int roll() {
    value = (int) (Math.random() * sides) + 1;
    return value;
  }
   /** roll(): Roll the dice - randomly sets value to a value between 1 and number of sides (inclusive) 
    * @return the value of the dice after a roll.
   */

   /** Override default Object methods.  These are standardized object 
   *    methods and you add custom behaviors unique to your object
   */
   
   /** toString(): Prints the string object as  name
   *               side=#  value=#   color=#
  @return a string that describes this object.
   */
  public String toString() {
    return name + " sides=" + sides + " value+" + value + " color=" + color;
  }

}
