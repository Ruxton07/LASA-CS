// RYAN KELLAR AND CHLOE BAO!!!! ULTAMITE DUO
import java.util.Scanner;

public class Main     //CalculatorRunner
{
	public static void main(String[] args)
	{
		double num1;
		double num2;
		char operator;
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the operator:");
    operator = (scan.nextLine()).charAt(0);
    if (!(operator == '+'||operator == '-'|| operator == '/' || operator == '*')) {
      System.out.println("Invalid operator");
    }
    else {
      System.out.println("Enter the first operand:");
      num1 = scan.nextDouble();
      System.out.println("Enter the second operand:");
      num2 = scan.nextDouble();
      if (operator == '/') {
        if (num2 == 0) {
        System.out.println("Cannot Divide by Zero");
  
        }
      }
      Calculator bop = new Calculator(operator, num1, num2);
      bop.calcResult();
      System.out.println(bop);
    }

    

		//setup a set of conditions below to determine if the operator is valid
		//get the remaining inputs from the user
		//check for division by zero
		//instantiate Calculator object with the values entered by the user
		//call the toString() method to print the results



	}
}
