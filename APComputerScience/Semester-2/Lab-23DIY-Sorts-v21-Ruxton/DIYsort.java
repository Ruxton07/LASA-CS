/** DIYsort Class
Contains student written sort routines */

import java.util.*;
import java.io.*;

public class DIYsort {

  /** selectionSort - Selection sort for primitive array
  @param int[] Array to sort 
  @param boolean Direction to sort (ascending == true or descending ==              false).
  @return void
  When the method is complete the array is in sorted order */
  
  
  public static void selectionSort(int[] array, boolean type) {
    int n = array.length;
    int minIndex = 0;
    if (type) {
      for (int i = 0; i < n-1; i++) {
        minIndex = i;
        for (int j = i+1; j < n; j++) {
          if (array[j] < array[minIndex]) {
            minIndex = j;
          }
        }
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
      }
    }
    else {
      for (int i = 0; i < n-1; i++) {
        minIndex = i;
        for (int j = i+1; j < n; j++) {
          if (array[j] > array[minIndex]) {
            minIndex = j;
          }
        }
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
      }
    }
  }

  /** selectionSort - Selection sort for ArrayList
  @param ArrayList<Integer> to sort 
  @param boolean Direction to sort (ascending == true or descending == false).
  @return void
  When the method is complete the array list is in sorted order */

  public static void selectionSort(ArrayList<Integer> array, boolean type) {
    int n = array.size();
    int minIndex = 0;
    if (type) {
      for (int i = 0; i < n-1; i++) {
        minIndex = i;
        for (int j = i+1; j < n; j++) {
          if (array.get(j) < array.get(minIndex)) {
            minIndex = j;
          }
        }
        int temp = array.get(minIndex);
        array.set(minIndex, array.get(i));
        array.set(i, temp);
      }
    }
    else {
      for (int i = 0; i < n-1; i++) {
        minIndex = i;
        for (int j = i+1; j < n; j++) {
          if (array.get(j) > array.get(minIndex)) {
            minIndex = j;
          }
        }
        int temp = array.get(minIndex);
        array.set(minIndex, array.get(i));
        array.set(i, temp);
      }
    }
  }
  
  /** bubbleSort - Bubble sort for primitive array
  @param int[] Array to sort 
  @param boolean Direction to sort (ascending == true or descending == false).
  @return void
  When the method is complete the array is in sorted order
  */

  public static void bubbleSort(int[] array, boolean type) {
    int n = array.length;
    boolean swapped = false;

    if (type) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if (array[j] > array[j+1]) {
            int temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
            swapped = true;
          }
        }
        if (!swapped) {
          break;
        }
      }
    }
    else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if (array[j] < array[j+1]) {
            int temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
            swapped = true;
          }
        }
        if (!swapped) {
          break;
        }
      }
    }
  }
  
  /** bubbleSort - Bubble sort for ArrayList
  @param ArrayList<Integer> to sort 
  @param boolean Direction to sort (ascending == true or descending == false).
  @return void
  When the method is complete the array list is in sorted order
  */

  public static void bubbleSort(ArrayList<Integer> array, boolean type) {
    int n = array.size();
    boolean swapped = false;
    if (type) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if (array.get(j) > array.get(j+1)) {
            int temp = array.get(j);
            array.set(j, array.get(j+1));
            array.set(j+1, temp);
            swapped = true;
          }
        }
        if (!swapped) {
          break;
        }
      }
    }
    else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n-i-1; j++) {
          if (array.get(j) < array.get(j+1)) {
            int temp = array.get(j);
            array.set(j, array.get(j+1));
            array.set(j+1, temp);
            swapped = true;
          }
        }
        if (!swapped) {
          break;
        }
      }
    }
  }
}
