/*
*
*   Your Player.java
*
*/
public class Player {
  private String name;
  private int score;

  public Player(String n, int s) {
    this.name = n;
    this.score = s;
  } //use "this" keyword in constructor

  //accessor methods
  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  //mutator methods
  public void setName(String n) {
    name = n;
  }

  public void setScore(int s) {
    score = s;
  }

  //updateScore method
  public void updateScore(int addToScore) {
    score += addToScore;
  }

  //toString method
  public String toString() {
    
    return "" + name + " " + score;
  }
}