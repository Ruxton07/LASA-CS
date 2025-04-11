public class Deal
{
	//instance variables (DO NOT ADD ANY MORE)
	private int prizeLoc;
	private int userGuess;
	
	//constructor
	public Deal()
	{
		setPrizeLoc();
		setUserGuess();
	}
	
	//modifier method for userGuess (should call random number method)
	public void setUserGuess() {
    userGuess = randomNum();
  }
	
	//modifier method for prizeLoc (should call random number method)
	public void setPrizeLoc() {
    prizeLoc = randomNum();
  }
	
	//accessor method for userGuess
	public int getUserGuess() {
    return userGuess;
  }
	
	//accessor method for prizeLoc
	public int getPrizeLoc() {
    return prizeLoc;
  }
	
	//method to generate random number between 1 & 3
	public int randomNum() {
    return (int) (Math.random() * 3 + 1);
  }
	
	//method to reveal the door
	public int getView() {
    int view = 1;
    boolean flag = true;
    while (flag) {
      view = randomNum();
      if ((view != userGuess) && (view != prizeLoc)) {
        flag = false;
      }
    }
    
    return view;
  }
	//method to update user's guess
  public int getNewGuess(int view) {
    userGuess++;
    if (userGuess == 4) {
      userGuess = 1;
    }
    if (userGuess == view) {
      userGuess++;
    }
    if (userGuess == 4) {
      userGuess = 1;
    }
    return userGuess;
  }
	//toString method
	public String toString() {
		return "user guess: " + userGuess + " prizeLoc: " + prizeLoc;
	}
}
