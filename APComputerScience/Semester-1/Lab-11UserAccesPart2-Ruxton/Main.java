
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

  public static final Scanner scanInput = new Scanner(System.in);  
  
  public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
    File file = new File("users1.dat");
    System.out.println("(l)ogin or (r)egister?");
    boolean search = true;
    while (search) {
      String answer = scanInput.nextLine();
      if (answer.charAt(0) == 'l'){
        while (!(login(file))) {
          System.out.println("Username and/or password do not match. Try again.");
        }
        System.out.println("Welcome!!!");
        search = false;
      }
      else if (answer.charAt(0) == 'r')
        register(file);
      else
        System.out.println("Please enter either 'l' or 'r'");
    }
  }
   
   
   public static boolean login(File userFile)  throws FileNotFoundException,NoSuchAlgorithmException {
     Scanner in = new Scanner(new File ("users1.dat"));
	   System.out.println("Username? ");
     String user = scanInput.next();
     System.out.println("Password? ");
     String pass = scanInput.next();
     while (in.hasNext()) {
      if (user.equals(in.next())) {
        String hash = in.next();
        String salt = in.next();
        String password = pass + salt;
        String hashedPassword = toHexString(getSHA(password));
        if (hashedPassword.equals(hash)) {
           return true;
        }
      }
    }
     return false;
   }
   
   
   public static void register(File userFile) throws FileNotFoundException,IOException,NoSuchAlgorithmException {
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
        }
        else if (match) {
          
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
    }
    String pass = "";
    boolean validator = true;
    while (validator) {
      System.out.println("Password? ");
      pass = scanInput.next();
      System.out.println("Verify Password? ");
      String passVer = scanInput.next();
      if (pass.equals(passVer)) {
        System.out.println("Welcome!!!");
        validator = false;
      }
      else
        System.out.println("Passwords do not match. Try again.");
    }
  }
   
   public static String makeSalt() {
   
      char[] ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
      String salt = "";
      for (int i=0; i < 25; i++) {
         int randomCharIdx = (int) (Math.random() * ALPHANUMERIC.length);
         salt += ALPHANUMERIC[randomCharIdx];
      }
     
      return salt;
   
   }
   
   

   // getSHA() and toHexString() from https://www.geeksforgeeks.org/sha-256-hash-in-java/

   public static byte[] getSHA(String input) throws NoSuchAlgorithmException
   {
        // Static getInstance method is called with hashing SHA
      MessageDigest md = MessageDigest.getInstance("SHA-256");
   
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
      return md.digest(input.getBytes(StandardCharsets.UTF_8));
   }
     
   public static String toHexString(byte[] hash)
   {
        // Convert byte array into signum representation
      BigInteger number = new BigInteger(1, hash);
   
        // Convert message digest into hex value
      StringBuilder hexString = new StringBuilder(number.toString(16));
   
        // Pad with leading zeros
      while (hexString.length() < 64)
      {
         hexString.insert(0, '0');
      }
   
      return hexString.toString();
   }
  
}

