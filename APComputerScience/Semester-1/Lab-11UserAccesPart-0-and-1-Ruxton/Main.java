import java.io.*;
import java.util.Scanner;

public class Main {
    
   // keyboard scanner shared by all methods
   public static final Scanner scanInput = new Scanner(System.in);    

   public static void main(String[] args) throws FileNotFoundException, IOException {
    File file = new File("users1.dat");
    System.out.println("(l)ogin or (r)egister?");
    String answer = scanInput.nextLine();
    if (answer.charAt(0) == 'l'){
      while (!(login(file))) {
        System.out.println("Username and/or password do not match. Try again.");
      }
      System.out.println("Welcome!!!");
    }
    else if (answer.charAt(0) == 'r')
       register(file);
     
    }
   
   
   public static boolean login(File userFile) throws FileNotFoundException {
     Scanner in = new Scanner(new File ("users1.dat"));
	   System.out.println("Username? ");
     String user = scanInput.next();
     System.out.println("Password? ");
     String pass = scanInput.next();
     while (in.hasNextLine()) {
       if ((user + " " + pass).equals( in.nextLine()))
         return true;
     }
     return false;
   }
   
   
   public static void register(File userFile) throws FileNotFoundException,IOException {
     System.out.println("Username? ");
	   String user = scanInput.next();
     boolean checking = true;
     boolean match = true;
     while (checking) {
    Scanner in = new Scanner(new File ("users1.dat"));
     while (in.hasNext()) {
      if (user.equals(in.next())) {
        match = false;
        in.next();
      }}
      if (match) {
        
        checking = false;
      }
      else {
        System.out.println("Username already taken. Please choose a different one. ");
        System.out.println("Username? ");
        user = scanInput.next();
        checking = true;
        match = true;
      }
      
     }
     
     String pass = "";
     boolean run = true;
     while (run) {
     System.out.println("Password? ");
     pass = scanInput.next();
     System.out.println("Verify Password? ");
     String passVer = scanInput.next();
     if (pass.equals(passVer)) {
      System.out.println("Welcome!!!");
      run = false;
         }
      else {
        System.out.println("Passwords do not match. Try again.");
      }
    
     }
       FileWriter fw = new FileWriter(userFile, true);   // open file in append mode by passing true
      PrintWriter pw = new PrintWriter(fw);    // use PrintWriter to write a line using println
      pw.println("");
      pw.println(user + " " + pass);
      pw.flush();   // flush output to file
      pw.close();
     }
     
   }