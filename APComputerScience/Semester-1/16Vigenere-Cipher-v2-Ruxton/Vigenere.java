
/*
/   Vigenere class
/    Implement the class to include the methods exactly
/    as described in the comments.
/   Do not add any additional instance variables
/
*/


class Vigenere
{
   // declare instance variables for text and keyword
   private String plainText;
   private String key;

  // default constructor
   public Vigenere ()
   {
	   plainText = " ";
     key = "";
   }
    
   // initialization constructor
   public Vigenere (String theMsg, String theKey)
   {
     plainText = theMsg;
     key = theKey;
   }
    
   // modifier method for plainText
   public void setPlainText(String newText) {
     plainText = newText;
   }
    
   // modifier method for key
   public void setKey(String newKey) {
     key = newKey;
   }
    
   // accessor method for plainText
   public String getPlainText() {
     return plainText;
   }
    
   // accessor method for key
   public String getKey() {
     return key;
   }
    
   // encrypt method
   //   return a String
   //   no parameters
   public String encrypt()
   {
     String cipher = "";
     int codeIndex = 0;
     int result = 0;
     for (int i = 0; i < plainText.length(); i++) {
       result = 0;
       if (codeIndex >= key.length()) {
         codeIndex = 0;
       }
       int asciiText = ((int) plainText.charAt(i)) - 65;
       int asciiKey = ((int) key.charAt(codeIndex)) - 65;
       result = asciiText + asciiKey;
       result %= 26;
       cipher += (char) (result + 65);  
       codeIndex++;
     }
     return cipher;
   }
   
   // equals method
   //   return a boolean
   //   Vigenere reference parameter
   public boolean equals (Vigenere newV) {
     boolean accEquals = false;
     if (((newV.getPlainText()).equals(plainText)) && ((newV.getKey()).equals(key))) {
       accEquals = true;
     }
     return accEquals;
   }
    
   
   // toString() method
   public String toString()
   {
        return("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt() + "\n");
   }
    
}





