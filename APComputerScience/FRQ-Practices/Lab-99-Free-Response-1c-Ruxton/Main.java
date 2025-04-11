import java.util.*;

class Main {

  static Scanner sc;

  public static void main(String[] args) {
    System.out.println("Hello LASA Free Response 1!");

    sc = new Scanner(System.in);

    //System.out.println("Run test without output matching");

    String choice = sc.next();
    sc.nextLine();

    System.out.println();

    switch (choice) {
      case "1a":
        System.out.println("Music Download Test");
        musicDownloadTest("1a");
        break;
      case "1b":
        System.out.println("Music Download Test");
        musicDownloadTest("1b");
        break;
      case "2":
        System.out.println("Token Pass Test");
        tokenPassTest();
        break;
      case "3":
        System.out.println("Sky View Test");
        skyViewTest();
        break;
      case "0":
        musicDownloadTest("1b");
        tokenPassTest();
        skyViewTest();
        break;
    }
  }

  public static void musicDownloadTest(String choice) {
    /* TODO1a-1 declare and instantiate an ArrayList of DownloadInfo objects called myDownloadsList */
    ArrayList<DownloadInfo> myDownloadsList = new ArrayList<DownloadInfo>();
    /* TODO1a-2 in the DownloadInfo class add a constructor with a string parameter and an integer parameter that initialize both private instance variables */
    //done
    /* TODO1a-3 add these three songs and their download counts to myDownloadsList in the order given ("Hey Jude",5) ("Soul Sister",3) ("Aqualung",10). HINT: Use the new constructor you just added. */
    myDownloadsList.add(new DownloadInfo("Hey Jude", 5));
    myDownloadsList.add(new DownloadInfo("Soul Sister", 3));
    myDownloadsList.add(new DownloadInfo("Aqualung", 10));
    /* TODO1a-4 in the MusicDownloads class add a constructor with a List of DownloadInfo elements as a parameter that initalizes the private instance variable */
    //done
    /* TODO1a-5 declare and instantiate a MusicDownload object named myMusic that is initialized with myDownloadsList. HINT: Use the new constructor you just added. */
    MusicDownloads myMusic = new MusicDownloads(myDownloadsList);
    /* TODO1a-6 AFTER the inialization of myDownloadsList above, add this song to*/
    //myDownloadsList.add(new DownloadInfo("Arc of a Diver", 27));
    /* TODO1a-7 uncomment the 5 lines below  & 'run tests' to  make sure Test 1a passes */
    System.out.println("*** Initial download data\n" + myMusic.toString()); 
    System.out.println("*** Testing getDownloadInfo()...");
    System.out.println(myMusic.getDownloadInfo("Aqualung"));
    System.out.println(myMusic.getDownloadInfo("Happy Birthday"));
    System.out.println(myMusic.getDownloadInfo("Arc of a Diver")); 

    // Testing updateDownloads()
    if (choice.equals("1b")) {
      /* TODO1b-1 declare and instantiate an ArrayList of String objects called songs */
      ArrayList<String> songs = new ArrayList<String>();
      /* TODO1b-2 Add these 6 songs to songs in the order given "Lights", "Aqualung",  "Soul Sister", "Go Now", "Lights", "Soul Sister" */
      songs.add("Lights");
      songs.add("Aqualung");
      songs.add("Soul Sister");
      songs.add("Go Now");
      songs.add("Lights");
      songs.add("Soul Sister");
      
      /* TODO1b-3 invoke updateDownloads for myMusic with songs */
      myMusic.updateDownloads(songs);
      /* TODO1b-4 uncomment the line below & 'run tests' to make sure Test 1b passes */
      System.out.println("\n*** Testing getDownloadInfo()\n" + myMusic.toString());
    }

  }

  public static void tokenPassTest() {
    TokenPass test = new TokenPass(4);
    TokenPass test2 = new TokenPass(4);

    if (test.toString().equals(test2.toString()))
      System.out.println("Token board creation error!");
    else
      System.out.println("Token board creation success!");

    int[] arr = {5,9,9,5};
    test.setBoard(arr);
    test.setCurrentPlayer(2);
    System.out.println("Current player = " + test.getCurrentPlayer());
    test.distributeCurrentPlayerTokens();
    System.out.println(test);
  }

  public static void skyViewTest() {
    double[][] view;
    double[] values = {0.3,0.7,0.8,0.4,1.4,1.1,0.2,0.5,0.1,1.6,0.6,0.9};
    SkyView sView = new SkyView(4, 3, values);
    System.out.println("It should print the following:");
    System.out.println("0.3, 0.7, 0.8,");
    System.out.println("1.1, 1.4, 0.4,");
    System.out.println("0.2, 0.5, 0.1,");
    System.out.println("0.9, 0.6, 1.6,");
    System.out.println();
    System.out.println("Your results");
    view = sView.getView();
    for (int row = 0; row < view.length; row++) {
      for (int col = 0; col < view[0].length; col++) {
        System.out.print(view[row][col] + ", ");
      }
      System.out.println();
    }

    System.out.println();

    double[] val2 = {0.3,0.7,0.8,0.4,1.4,1.1};
    sView = new SkyView(3, 2, val2);
    view = sView.getView(); // Correction
    System.out.println("It should print the following:");
    System.out.println("0.3, 0.7,");
    System.out.println("0.4, 0.8,");
    System.out.println("1.4, 1.1,");
    System.out.println();
    System.out.println("Your results");
    for (int row = 0; row < view.length; row++) {
      for (int col = 0; col < view[0].length; col++) {
        System.out.print(view[row][col] + ", ");
      }
      System.out.println();
    }
  } // sviewTest
} //class Main
