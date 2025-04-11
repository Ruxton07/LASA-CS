class Main {
  public static void main(String[] args) {
 
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice("intelligence",20,10,"green");
        Dice dice4 = new Dice("perseverance",12,7,"yellow");
        
        // dice 1 & 2        
        System.out.println("Initialized dice 1 & 2");
        System.out.println(dice1.toString()); 
        System.out.println(dice2); 
        
        dice1.roll();
        dice2.roll();
        System.out.println("\nRolled dice 1 & 2");
        System.out.println(dice1); 
        System.out.println(dice2);  
                 
        // dice 3 & 4
        System.out.println("\nInitialized dice 3 & 4");
        System.out.println(dice3); 
        System.out.println(dice4); 

        dice3.roll();
        dice4.roll();
        System.out.println("\nRolled dice 3 & 4");
        System.out.println(dice3); 
        System.out.println(dice4);  

        System.out.println("\nThe " + dice4.getName() + " dice has " + dice4.getSides() + " sides.");
        System.out.println("The " + dice4.getName() + " dice's current value is " + dice4.getValue() + ".");
        System.out.println("The " + dice4.getName() + " dice color is " + dice4.getColor() + ".");
        dice4.setValue(7);
        System.out.println("The " + dice4.getName() + " dice's new value is " + dice4.getValue() + ".");
  }
}