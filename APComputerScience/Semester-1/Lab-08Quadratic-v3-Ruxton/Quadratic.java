public class Quadratic
{

  static int realRoots, imaginaryRoots;
   // instance variables - replace the example below with your own
   private double a;
   private double b;
   private double c;
   private double root1;
   private double root2;
   private double rootC;
   private double d;
   double rootA;
   double root1B;
   double root2B;
   private QuadraticResult result;

   public Quadratic()
  {
      a = 0.0;
      b = 0.0;
      c = 0.0;
      result = null;
   }

   public Quadratic(double givA, double givB, double givC) {
     a = givA;
     b = givB;
     c = givC;
     result = null;
   } 

   public void solve()
   {
     double d = (Math.pow(b,2)) - (4*a*c);
     if (d>0) {
       root1 = ((-1*b) + (Math.sqrt(Math.pow(b, 2) - (4*a*c)))) / (2*a);
       root2 = ((-1*b) - (Math.sqrt(Math.pow(b, 2) - (4*a*c)))) / (2*a);
       QuadraticResult newResult = new QuadraticResult(true, 2, root1, root2);
       result = newResult;
       realRoots += 1;
     }
     else if (d==0) {
       root1 = (-1*b) / (2*a);
       QuadraticResult newResult = new QuadraticResult(true, 1, root1);
       result = newResult;
       realRoots += 1;
     }
     else if (d<0) {
       rootA = ((-1*b)/(2*a));
       root1B = ((Math.sqrt(-1 * (Math.pow(b, 2) - (4*a*c)))) / (2*a));
       root2B = ((Math.sqrt(-1 * (Math.pow(b, 2) - (4*a*c)))) / (2*a));
       QuadraticResult newResult = new QuadraticResult(false, 2, rootA, root1B, root2B);
       result = newResult;
       imaginaryRoots += 1;
     }
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
     double d = (Math.pow(b,2)) - (4*a*c);
     if (result == null) {
       return "" + a + "x^2" + " + " + b + "x" + " + " + c + " has not been solved yet!!!";
     }
     else {
       return "" + a + "x^2" + " + " + b + "x" + " + " + c + " " + result;
     }
   }
}
