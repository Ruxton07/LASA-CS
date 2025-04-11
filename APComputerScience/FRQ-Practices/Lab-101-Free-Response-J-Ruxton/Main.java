import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{

   static Scanner sc;

	public static void main(String[] args)
   {
      System.out.println("Hello LASA Free Response J!");
   
      sc = new Scanner(System.in);
      
      System.out.println("Select test");
   
      int choice = sc.nextInt();
      sc.nextLine();
   
      switch (choice)
      {
         case 1:
            System.out.println("\nRandom String Chooser Test");
            rscTest();
            System.out.println();
            break;

         case 2:       
            System.out.println("\nSystem Log Test");
            sysLogTest();
            System.out.println();
            break;

         case 3:       
            System.out.println("\nCrossword Test");
            crosswordTest();
            System.out.println();
            break;
         case 4:       
            System.out.println("\nString Formatter Test");
            stringFormatterTest();
            System.out.println();
            break;

        default:
          System.out.println("No test selected");
          break;
      }
      sc.close();
    
   }

  public static void stringFormatterTest()
  {
    List<String> wordList1 = new ArrayList<String>();
    wordList1.add("AP");
    wordList1.add("COMP");
    wordList1.add("SCI");
    wordList1.add("ROCKS");
    System.out.println(StringFormatter.format(wordList1, 20));

    List<String> wordList2 = new ArrayList<String>();
    wordList2.add("GREEN");
    wordList2.add("EGGS");
    wordList2.add("AND");
    wordList2.add("HAM");
    System.out.println(StringFormatter.format(wordList2, 20));

    List<String> wordList3 = new ArrayList<String>();
    wordList3.add("BEECH");
    wordList3.add("BALL");
    System.out.println(StringFormatter.format(wordList3, 20));
  }
   
   
   public static void crosswordTest()
  {
    boolean blackSquares[][] = {
    {true,  false, false, true,  true,  true,  false, false, false},
    {false, false, false, false, true,  false, false, false, false},
    {false, false, false, false, false, false, true,  true,  true},
    {false, false, true,  false, false, false, true,  false, false},
    {true,  true,  true,  false, false, false, false, false, false},
    {false, false, false, false, true,  false, false, false, false},
    {false, false, false, true,  true,  true,  false, false, true}};

    Crossword crossword = new Crossword(blackSquares);

    for (int r = 0; r < blackSquares.length; r++)
    {
      for (int c = 0; c < blackSquares[0].length; c++)
        System.out.print(crossword.getSquare(r, c) + " ");
      System.out.println();
    }
  }   //crossword Test
   
   
   public static void sysLogTest()
	{
       String[] messages = {
           "CLIENT3:security alert ñ repeated login failures",
           "Webserver:disk offline",
           "SERVER1:file not found",
           "SERVER2:read error on disk DSK1",
           "SERVER1:write error on disk DSK2",
           "Webserver:error on /dev/disk",
           "True:disk",
           "True:error on disk",
           "True:error on disk DSK1",
           "False:DISK offline",
           "False:error on disk3",
           "False:error on /dev/disk",
           "False:diskette"};
   
       for (String s : messages)
       {
         LogMessage msg = new LogMessage(s);
         System.out.println(msg.getMachineId() + ":" + msg.getDescription() + "==>" + msg.containsWord("disk"));
       }
   
       SystemLog theLog  = new SystemLog(messages);
       List<LogMessage> removed = theLog.removeMessages("disk");
   
       System.out.println("Removed messages:\n");
       for (LogMessage msg : removed)
         System.out.println(msg);
       System.out.println();
   
       System.out.println("Remaining messages:\n");
       System.out.println(theLog);
	
	}  //sys Log Test
   
   
   
   public static void rscTest()
	{
		//Part A
		System.out.println("Part A");
		String[] wordArray = {"wheels", "on", "the", "bus"};
		String[] resultArray = new String[wordArray.length+10];
      for (int k = 0; k < wordArray.length+10; k++)
         resultArray[k] = "NONE";
		RandomStringChooser sChooser = new RandomStringChooser(wordArray);
		for (int k = 0; k < 6; k++)
		{
         resultArray[k] = sChooser.getNext();
			//System.out.print(resultArray[k] + " ");
		}
      System.out.print("\nRandom String Chooser ");
		if (!Arrays.equals(wordArray, resultArray) && compareArrays(wordArray,resultArray))
         System.out.println("OK!");
      else
         System.out.println("Broken!");
               
		//Part B
		System.out.println("\n\nPart B");
      String word = "LiberalArtsAndScienceAcademy";
      String[] lettersArray = new String[word.length()];
      for (int i = 0; i < word.length(); i++)
         lettersArray[i] = word.substring(i,i+1);
      String[] resultLetters = new String[lettersArray.length+1];
		RandomLetterChooser letterChooser = new RandomLetterChooser(word);
		for (int k = 0; k < word.length()+1; k++)
		{
         resultLetters[k] = letterChooser.getNext();
		}
      System.out.print("\nRandom Letter Chooser ");
      if (!Arrays.equals(lettersArray, resultLetters) && compareArrays(lettersArray,resultLetters))
         System.out.println("OK!");
      else
         System.out.println("Broken!");
	}



//
// Helper functions for testing
//
//   

   public static boolean compareChars(char[] arr1, char[] arr2) {
      int l = Math.min(arr1.length, arr2.length);
      for (int i = 0; i < l; i++)
         if (!containsChar(arr1,arr2[i]))
            return false;
      return true;
   }

   public static boolean containsChar(char[] arr, char target) {
   	for(char c: arr){
   		if(c == target)
   			return true;
   	}
   	return false;
   }
   
   public static boolean compareArrays(String[] arr1, String[] arr2) {
      int l = Math.min(arr1.length, arr2.length);
      for (int i = 0; i < l; i++)
         if (!containsString(arr1,arr2[i]))
            return false;
      return true;
   }

   public static boolean containsString(String[] arr, String target) {
   	for(String s: arr){
   		if(s.equals(target))
   			return true;
   	}
   	return false;
   }

   
} //end class