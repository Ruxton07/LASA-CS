import java.util.ArrayList;

public class RandomStringChooser {
  private String[] arr;

  public RandomStringChooser(String[] array) {
    arr = array;
  }
  
  public String getNext() {
    if (arr.length==0) {
      return "NONE";
    }
    else {
      int randIndex = (int) (Math.random()*arr.length);
      String nextString = arr[randIndex];
      String[] newArr = new String[arr.length-1];
      int x = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] != nextString) {
          newArr[x] = arr[i];
          x++;
        }
      }
      arr = newArr;
      return nextString;
    }
  }
}
