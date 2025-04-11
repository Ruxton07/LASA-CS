import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    //asks what user's name is
    System.out.println("What is your name?");
    String name = scan.nextLine();
    System.out.println("Hello " + name + "!");
    //asks what user's age is
    System.out.println("How old are you?");
    int age = scan.nextInt();
    int ageInMonths = (age*12);
    System.out.println("Your age in months is " + ageInMonths + ".");
    //asks for user's favorite band
    System.out.println("What is your favorite band?");
    scan.nextLine();
    String fband1 = scan.nextLine();
    System.out.println("What is your 2nd favorite band?");
    String fband2 = scan.nextLine();
    System.out.println("I like " + fband1 + " and " + fband2 + " too!!!");
  }
}