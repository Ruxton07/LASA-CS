import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {  
		//create a world for your turtles
		World turtleWorld = new World(600, 800);
		
		//create your first turtle
		Turtle deb = new Turtle(turtleWorld);
		Turtle tim = new Turtle(50, 50, turtleWorld);
    Turtle joe = new Turtle(300, 150, turtleWorld);
    Picture turtlePic = new Picture("images.jpg");
    
		//move the turtled forward
    joe.penUp();
    joe.forward(50);
    joe.penDown();
    /**deb.makeSquare();
    tim.makeTriangle();
    joe.makeTriangle();*/
    deb.square(turtlePic);
    tim.triangle(turtlePic);
    joe.triangle(turtlePic);


    Turtle dot = new Turtle(250, 250, turtleWorld);
    dot.shape(5, 75, turtlePic);
    dot.turnLeft();
    dot.penUp();
    dot.forward(100);
    dot.penDown();
    dot.shape (6, 75, turtlePic);
  }


  public static void delaySeconds(int d)
  {
    try {
      TimeUnit.SECONDS.sleep(d);
    }
    catch(InterruptedException exception) {
            // Output expected InterruptedExceptions.
            System.out.println("Exception: "+exception);
        } catch (Exception exception) {
            // Output unexpected Exceptions.
            System.out.println("Exception: "+exception+", "+false);
        }
  }


}
