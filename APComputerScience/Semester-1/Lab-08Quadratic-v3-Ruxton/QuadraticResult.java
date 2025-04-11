public class QuadraticResult {
  
  private boolean isReal;
  private int numRoots;
  private String result1;
  private String result2;  
  
  public QuadraticResult() {
    isReal = true;
    numRoots = 1;
    result1 = "";
    result2 = "";
  }

  public QuadraticResult(boolean real, int rootNum, double root1) {
    isReal = real;
    numRoots = rootNum;
    result1 = "" + root1;
  }
  public QuadraticResult(boolean real, int rootNum, double root1, double root2) {
    isReal = real;
    numRoots = rootNum;
    result1 = "" + root1;
    result2 = "" + root2;
  }

  public QuadraticResult(boolean notReal, int rootNum, double rootA, double root1B, double root2B) {
    isReal = notReal;
    numRoots = rootNum;
    result1 = "" + rootA + "+" + root1B + "i";
    result2 = "" + rootA + "-" + root2B + "i";
  }


    /***
    * Print if:
    equation " has not been solved yet!!!"
    Or, equation + "real root " + result
    Or, equation + "real root1 " + result
    Or, equation + "real root2 " + result
    Or, equation + "imaginary root1 " + result + "i"
    Or, equation + "imaginary root2 " + result "i"

    */
   
   public String toString() {
     String str = "";
     if (isReal == true && numRoots == 1) {
       str = "real root " + result1;
     }
     else if (isReal == true && numRoots == 2) {
       str = "real root1 " + result1 + " real root2 " + result2;
     }
     else if (isReal == false && numRoots == 2) {
       str = "imaginary root1 " + result1 + " imaginary root2 " + result2;
     }
     return str; 
   }
   
}