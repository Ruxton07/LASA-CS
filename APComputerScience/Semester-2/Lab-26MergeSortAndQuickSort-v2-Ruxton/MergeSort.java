import java.io.*;
import java.util.*;

public class MergeSort {

    /**
     * Sorts the given array in ascending order.
     * DO NOT MODIFY THIS METHOD SIGNATURE.
     *
     * @param array The array to be sorted.
     * @return The sorted array.
     */
    public static String[] sort(String[] array) {
      if (array.length <= 1) {
        return array;
      }
      ArrayList<String> leftAL = new ArrayList<String>();
      ArrayList<String> rightAL = new ArrayList<String>();

      for (int i = 0; i < array.length/2; i++)
        leftAL.add(array[i]);
      for (int j = array.length/2; j < array.length; j++)
        rightAL.add(array[j]);
      String[] leftA = leftAL.toArray(new String[0]);
      String[] rightA = rightAL.toArray(new String[0]);

      leftA = sort(leftA);
      rightA = sort(rightA);

      ArrayList<String> finalAL = new ArrayList<String>();
      for (int i = 0; i < leftA.length; i++)
        leftAL.set(i, leftA[i]);
      for (int j = 0; j < rightA.length; j++)
        rightAL.set(j, rightA[j]);

      boolean boolVal = true;
      while (boolVal) {
        if (rightAL.size() == 0) {
          finalAL.addAll(leftAL);
          boolVal = false;
        }
        else if (leftAL.size() == 0) {
          finalAL.addAll(rightAL);
          boolVal = false;
        }
        else if (leftAL.get(0).compareTo(rightAL.get(0)) < 0) {
          finalAL.add(leftAL.get(0));
          leftAL.remove(0);
        }
        else {
          finalAL.add(rightAL.get(0));
          rightAL.remove(0);
        }
      }
      String[] finalA = finalAL.toArray(new String[0]);

      return finalA;
      
  }
}