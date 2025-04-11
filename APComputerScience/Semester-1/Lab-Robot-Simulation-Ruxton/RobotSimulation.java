import java.awt.geom.Ellipse2D;
import java.util.Random; // for predictable random numbers

public class RobotSimulation {
  /** Distance, in inches, from the starting position to the goal. */
  private int goalDistance;
  /** Maximum number of moves allowed to reach the goal. */
  private int maxMoves;

  Random random = new Random(27000); // predictable random numbers

  /**
   * Constructs a default RobotSimulation object which is 100 inches, from the
   * starting
   * position to the goal, and with 10 maximum number of moves allowed to reach
   * the
   * goal.
   * Precondition: dist > 0; maxMoves > 0
   */
  public RobotSimulation() {
    goalDistance = 100;
    maxMoves = 10;
  }

  /**
   * Constructs a RobotSimulation object where dist is the distance, in inches,
   * from the starting
   * position to the goal, and maxMoves is the maximum number of moves allowed to
   * reach the
   * goal.
   * Precondition: dist > 0; maxMoves > 0
   */
  public RobotSimulation(int dist, int numMoves) {
    goalDistance = dist;
    maxMoves = numMoves;
  }

  /**
   * Returns an integer representing the distance, in inches, to be moved when the
   * robot moves.
   * The integer returned is a random integer between -6 and 20 (inclusive).
   */
  public int moveDistance() { /* to be implemented in part (a) */
   double randNum = random.nextFloat();
    int number = (int) (randNum * 27) - 6;
    return number;
  }

  /**
   * Simulates a robot attempting to reach the goal as described in part (b).
   * Returns true if the robot successfully reached or passed the goal during the
   * simulation;
   * false otherwise.
   */
  public boolean simulate(boolean printInfo) { /* to be implemented in part (b) */
    int position = 0;
    int maximum = maxMoves;
    while (maximum > 0) {
      if (position >= goalDistance) {
        if (printInfo) {
          System.out.println("final position is " + position);
        }
        return true;
      } else if (position < 0) {
        if (printInfo) {
          System.out.println("final position is " + position);
        }
        return false;

      } else {
        if (printInfo) {
          System.out.print(position);
        }
        maximum--;
        int moves = moveDistance();
        position += moves;
        if (printInfo) {
          System.out.print("(" + moves + ") ");
        }
      }
    }
    if (printInfo) {
      System.out.println("final position is " + position);
    }
    return false;
  }

  /**
   * Runs num simulations and returns the proportion of simulations in which the
   * robot
   * successfully reached or passed the goal.
   * Precondition: num > 0
   */
  public double runSimulations(int num) { /* to be implemented in part (c) */
    int numTrue = 0;
    int number = num;
    while (number > 0) {
      if (simulate(false)) {
        numTrue++;
      
        number--;
    }
      else if (simulate(false) == false) {
      number--;
      }
  }
    return  (double)numTrue / (double) (num);
  }
}
