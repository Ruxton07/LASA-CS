import java.util.ArrayList;
import java.util.List;

public class Scramble
{
	
	public static String scrambleWord(String word)
	{
    /* to be implemented in part (a) */
    String newWord = "";
    for(int i = 0; i < word.length(); i++) {
      if(i != word.length()-1 && word.substring(i, i+1).equals("A") && (!(word.substring(i+1, i+2).equals("A")))) {
        newWord += word.substring(i+1, i+2);
        newWord += word.substring(i, i+1);
        i++;
      } else if(i == word.length()-1) {
        newWord += word.substring(i);
      } else {
        newWord += word.substring(i, i+1);
      }
    }
    return newWord;
	}

	public static void scrambleOrRemove(List<String> wordList)
	{
    /* to be implemented in part (b) */
    ArrayList<String> newWordList = new ArrayList<String>();
    for (int i = 0; i < wordList.size(); i++) {
      newWordList.add(wordList.get(i));
      wordList.set(i, scrambleWord(wordList.get(i)));
    }
    int j = 0;
    for (int i = 0; i < wordList.size(); i++) {
      if (wordList.get(i).equals(newWordList.get(j))) {
        wordList.remove(i);
        i--;
      }
      j++;
    }
	}
}