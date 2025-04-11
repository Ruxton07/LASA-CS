import java.util.*;
import java.io.*;
public class QuickSort {

  public static String[] sort(String[] array) {
    // * * * * * * * *
    // Your Code Here
    // * * * * * * * *
    if (array.length <= 1)
      return array;
    
    int pivotI = (int) (Math.random()*array.length);
    ArrayList<String> leftAL = new ArrayList<String>();
    ArrayList<String> rightAL = new ArrayList<String>();

    for (String word : array) {
      if (word.compareTo(array[pivotI]) < 0)
        leftAL.add(word);
      else if (word != array[pivotI])
        rightAL.add(word);
    }
    ArrayList<String> finalAL = new ArrayList<String>();
    String[] leftA = leftAL.toArray(new String[0]);
    String[] rightA = rightAL.toArray(new String[0]);

    for (String word : sort(leftA))
      finalAL.add(word);
    finalAL.add(array[pivotI]);
    for (String word : sort(rightA))
      finalAL.add(word);

    String[] finalA = finalAL.toArray(new String[0]);
    return finalA;
  }
}