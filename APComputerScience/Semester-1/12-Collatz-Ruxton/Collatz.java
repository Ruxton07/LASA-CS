// If you are doing this correctly your code should not be more then 125 lines
import java.util.Arrays;
import java.util.Scanner;
// (including comments & blank lines separating the methods).
public class Collatz {
	// instance variables (aka members, fields)
  private int startNum;
   // default constructor
  public Collatz() {
    startNum = 0;
  }
   // initialization constructor
  public Collatz(int num) {
    startNum = num;
  }
   // Add a method called steps() that returns the number of steps 
   // that are required for the starting number to reach 1.
  public int steps() {
    int count = 1;
    int newNum = startNum;
    while (newNum != 1) {
      if (newNum % 2 == 0) {
        newNum /= 2;
      } else {
        newNum = 3 * newNum + 1;
      }
      count++;
    }
    return count;
  }
   // Add a method called sequence() that returns an array of the sequence of 
   // numbers from the starting number to 1. Use your steps() function to 
   // determine how the size of your array.
  public int[] sequence() {
    int[] sequence = new int[steps()];
    int newNum = startNum;
    int count = steps();
    int sequenceArr[] = new int[count];
    sequenceArr[0] = startNum;
    for (int i = 1; i < count; i++) {
      if (newNum % 2 == 0) {
        newNum /= 2;
      } else {
        newNum = 3 * newNum + 1;
      }
      sequenceArr[i] = newNum;
    }
    return sequenceArr;
  }
   // Add a method called maxValue() that returns the maximum value in the sequence.
   // Iterate through the values returned by a call to sequence().
  public int maxValue() {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < sequence().length; i++) {
      if (sequence()[i] > max) {
        max = sequence()[i];
      }
    }
    return max;
  }
   // A method called minOddValue() that returns the minimum value of all the odd numbers, 
   // except for 1, in the sequence. Iterate through the values returned by a call to sequence().
  public int minOddValue() {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < sequence().length; i++) {
      if (sequence()[i] % 2 == 1 && sequence()[i]!= 1) {
        if (sequence()[i] < min) {
          min = sequence()[i];
        }
      }
    }
    return min;
  }
   // Add a method called oddValues() that returns an array of all the odd numbers in the sequence. 
   // Iterate through the values returned by a call to sequence().  
  public int[] oddValues() {
    int oddCount = 0;
    int oddIndex = 0;
    for (int i = 0; i < sequence().length; i++) {
      if (sequence()[i] % 2 == 1) {
        oddCount++;
      }
    }
    int[] oddSequence = new int[oddCount];
    for (int i = 0; i < sequence().length; i++) {
      if (sequence()[i] % 2 == 1) {
        oddSequence[oddIndex] = sequence()[i];
        oddIndex++;
      }
    }
    return oddSequence;
  }
   // Add a method called sumValues() that returns the sum of all the values in the sequence.
   // Iterate through the values returned by a call to sequence().
  public int sumValues() {
    int sum = 0;
    for (int i = 0; i < sequence().length; i++) {
      sum += sequence()[i];
    }
    return sum;
  }
   // Add a toString() method that returns ...    Starting number # takes # steps
  public String toString() {
    return "Starting Number " + startNum + " takes " + steps() + " steps";
  }
}