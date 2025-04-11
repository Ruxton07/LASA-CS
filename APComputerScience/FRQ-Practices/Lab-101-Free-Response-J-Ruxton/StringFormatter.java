import java.util.List;
import java.util.ArrayList;

public class StringFormatter
{
  /* Part (a) */

  public static int totalLetters(List<String> wordList)
  {
    /* to be implemented in part (a) */
    int count = 0;
    for (String i : wordList) {
      count += i.length();
    }
    return count;
  }

  /* Part (b) */

  public static int basicGapWidth(List<String> wordList,
                                  int formattedLen)
  {
      /* to be implemented in part (b) */
    int letterCount = totalLetters(wordList);
    return (20-letterCount)/(wordList.size()-1);
  }
  /***********/
  /* Part (c) */

  public static String format(List<String> wordList, int formattedLen)
  {
      /* to be implemented in part (c) */
    String fullStr = "";
    int leftover = leftoverSpaces(wordList, formattedLen);
    for (String i : wordList) {
      fullStr += i;
      if (!(i.equals(wordList.get(wordList.size()-1)))) {
        for (int j = 0; j < basicGapWidth(wordList, formattedLen); j++) {
          fullStr += " ";
        }
        if (leftover > 0) {
          fullStr += " ";
          leftover--;
        }
      }
    }
    return fullStr;
  }
  
  public static int leftoverSpaces(List<String> wordList, int formattedLen)
  {
    return formattedLen - totalLetters(wordList) -
                 basicGapWidth(wordList, formattedLen) * (wordList.size() - 1);
  }


}
