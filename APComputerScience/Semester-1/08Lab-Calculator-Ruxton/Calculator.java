public class Calculator
{
	//instance variables
	private double num1;
	private double num2;
	private char operator;
  private double answer;
	
	//default constructor
	public Calculator()
  {
		num1 = 0;
		num2 = 0;
		operator = 0;
    answer = 0.0;
  }

	//operator checker

  
	//inialization constructor
	public Calculator(char x, double y, double z) {
    operator = x;
    num1 = y;
    num2 = z;
  }

  public double calcResult() {
    if (operator == '/') {
      answer = num1 / num2;
    }
    else if (operator == '*') {
      answer = num1 * num2;
    }
    else if (operator == '+'){
      answer = num1 + num2;
    }
    else if (operator == '-'){
      answer = num1 - num2;
    }
    return answer;
  }
	//modifier method for num1
	public void setNum1(double n1)
	{
		num1 = n1;
	}
	
	//modifider method for num2
	public void setNum2(double n2)
	{
		num2 = n2;
	}
	
	//modifier method for operator
  public void setOperator(char op) {
    operator = op;
  }

	
	//accessor method for num1
	public double getNum1()
	{
		return num1;
	}
	
	//accessor method for num2
	public double getNum2()
	{
		return num2;
	}
	
	//accessor method for operator


	
	//Create method to calculate the result


	
	//Create the toString() method
	public String toString() {
    return "result = " + answer + "\n" + num1 + " " + operator + " " + num2 + " = " + answer;
  }
	
}