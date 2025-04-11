import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

   static Scanner sc;

	public static void main(String[] args)
   {
      System.out.println("Hello LASA Free Response L!");
   
      sc = new Scanner(System.in);
      
      System.out.println("Select test");
   
      int choice = sc.nextInt();
      sc.nextLine();
   
      switch (choice)
      {
         case 1:
            System.out.println("\n Scramble Test");
            scrambleTest();
            break;
         case 2:       
            System.out.println("\n Seating Chart Test");
            seatingChartTest();
            break;
         case 3:       
            System.out.println("\n Trio Test");
            trioTest();
            break;
         case 0:
            scrambleTest();
            seatingChartTest();
            trioTest();
          break;
      }
      sc.close();
    
   }
   
   
   	public static void trioTest()
	{
		System.out.println("\nTesting Trio");
      System.out.println("-------------");
		Sandwich cheeseburger = new Sandwich("Cheeseburger", 2.75);
		Sandwich clubsandwich = new Sandwich("Club Sandwich", 2.75);
		
		Salad spinachsalad = new Salad("Spinach Salad", 1.25);
		Salad coleslaw = new Salad("Coleslaw", 1.25);
		
		Drink orangesoda = new Drink("Orange Soda", 1.25);
		Drink cappuccino = new Drink("Cappuccino", 3.50);
		
		System.out.println("Testing Part 1");
		Trio trio1 = new Trio(cheeseburger, spinachsalad, orangesoda);
		System.out.println( "Name : " + trio1.getName() );
		System.out.println( "Price : $" + trio1.getPrice() );
		System.out.println();
		
		
		System.out.println("Testing Part 2");
		Trio trio2 = new Trio(clubsandwich, coleslaw, cappuccino);
		System.out.println( "Name : " + trio2.getName() );
		System.out.println( "Price : $" + trio2.getPrice() );
		System.out.println();
		
	}
   
   
   public static void seatingChartTest()
	{
      System.out.println("\nTesting SeatingChart");
      System.out.println("---------------------");
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Karen", 3) );
		studentList.add(new Student("Liz", 1) );
		studentList.add(new Student("Paul", 4) );
		studentList.add(new Student("Lester", 1) );
		studentList.add(new Student("Henry", 5) );
		studentList.add(new Student("Renee", 9) );
		studentList.add(new Student("Glen", 2) );
		studentList.add(new Student("Fran", 6) );
		studentList.add(new Student("David", 1) );
		studentList.add(new Student("Danny", 3) );
		
		SeatingChart sc = new SeatingChart(studentList, 3, 4);
		
		System.out.println("Testing for part A");
		sc.printSeatingChart();
		System.out.println();
		
		System.out.println("Testing for part B");
		System.out.println("Students removed = " + sc.removeAbsentStudents(4) );;
		sc.printSeatingChart();
	}
   
   
   public static void scrambleTest()
	{
      System.out.println("\nTesting Scramble");
      System.out.println("-----------------");
		Scramble s = new Scramble();
		
		System.out.println( "Testing part A " );
		System.out.println( s.scrambleWord("TAN") );
		System.out.println( s.scrambleWord("ABRACADABRA") );
		System.out.println( s.scrambleWord("WHOA") );
		System.out.println( s.scrambleWord("AARDVARK") );
		System.out.println( s.scrambleWord("EGGS") );
		System.out.println( s.scrambleWord("A") );
		System.out.println();
		
		List<String> wordList = new ArrayList<String>();
		wordList.add("TAN");
		wordList.add("ABRACADABRA");
		wordList.add("WHOA");
		wordList.add("APPLE");
		wordList.add("EGGS");
		
		System.out.println( "Testing part B " );
		s.scrambleOrRemove( wordList);
		System.out.println( wordList );
	}
}