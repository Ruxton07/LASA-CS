public class InOrder
{
  //instantiation of class variables
	private int numOne;
	private int numTwo;
	private int numThree;
  private boolean inOrder;

  //default constructor
	public InOrder()
	{
		numOne = 0;
    numTwo = 0;
    numThree = 0;
	}

  //initialization constructor
	public InOrder(int x, int y, int z)
	{
    numOne = x;
    numTwo = y;
    numThree = z;
	}

  //order checker
  public String areTheyInOrder() {
    if (numOne <= numTwo && numTwo <= numThree) {
      inOrder = true;
    }
    else {
      inOrder = false;
    }
    return numOne + " <= " + numTwo + " <= " + numThree + " is " + inOrder;
  }

  //setter methods
	public void setNumOne(int n1)
	{
		numOne = n1;
	}

  public void setNumTwo(int n2)
  {
    numTwo = n2;
  }

  public void setNumThree(int n3)
  {
    numThree = n3;
  }
  
	//getter methods
	public int getNumOne()
	{
		return numOne;
	}
	
	public int getNumTwo() 
  {
    return numTwo;
  }
  
	public int getNumThree() 
  {
    return numThree;
  }

  //sorting method
	public void sortThem()
  {
    int lowest = 0;
    int highest = 0;
    int med = numOne;
    lowest = Math.min(numOne, numTwo);
    lowest = Math.min(lowest, numThree);
    highest = Math.max(numOne, numTwo);
    highest = Math.max(highest, numThree);
    if (med == lowest||med == highest) {
      med = numTwo;
    }
    if (med == lowest||med==highest) {
      med = numThree;
    }
    numOne = lowest;
    numTwo = med;
    numThree = highest;
  }
	
	public String toString()
	{
		return "" + numOne + " " + numTwo + " " + numThree;   // DO NOT MODIFY
	}
}

