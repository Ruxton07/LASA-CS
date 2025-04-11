import java.util.Scanner;
      
// DealRunner
public class Main
{
	public static void main(String[] args)
	{
		//instantiate Scanner object
		Scanner scan = new Scanner(System.in);
		
		//prompt the user for the number of simulations to run
		System.out.println("How many simulations do you want to run?");
		
		//assign input to variable
		int numSims = scan.nextInt();
		
		//declare variables to store stopping condition for loop, prize loc, user guess,
		  //door revealed, the new guess, and wins by changing
		int numWins = 0;
    int userGuess = 0;
    int prizeLoc = 0;
		int newGuess = 0;
    int view = 0;
    
		//loop through the number of simulations
	
	  for (int i = 0; i < numSims; i++)
	  {	
			//instantiate a Deal object inside the loop
			Deal game = new Deal();
      
			//get the user's guess and assign to a variable 
			userGuess = game.getUserGuess();
			
			//get the prize location and assign to a variable
			prizeLoc = game.getPrizeLoc();
			
			//get the door which is revealed and assign to a variable
			view = game.getView();
			
			//get the new guess and assign to a variable
			newGuess = game.getNewGuess(view);
			
			//increment counter for loop
			
			
			//determine if the new guess matches the prize location
			if (newGuess == prizeLoc) {
			
			//increment the win count by changing
			  numWins++;
				
			//output the variables for each simulation
			  System.out.println("prize:" + prizeLoc + " guess:" + userGuess + " revealed:" + view + " new guess:" + newGuess + " win if switching:true if not switching:false");
      }
      else {
        System.out.println("prize:" + prizeLoc + " guess:" + userGuess + " revealed:" + view + " new guess:" + newGuess + " win if switching:false if not switching:true");
      }
    }
		//output the probability of winning/not winning by switching
		System.out.println("Probability of winning if you switch = " + (double)numWins/(double)numSims);
		System.out.println("Probability of winning if you do not switch = " + (1-(double)numWins/(double)numSims));
    scan.close();
	}
}