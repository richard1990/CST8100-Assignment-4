/**
 * This class simply launches the program, calling TurtleGame's methods.
 * The program as a whole is a little game where you move a turtle around
 * on a grid using the console.
 * @author Richard Barney
 * @version 1.0.0 December 2012
 */
public class TurtleGamePlay {
	/**
	 * main method as required by JVM
	 * @param  args   standard command line parameters as a string array.
	 */
	public static void main(String[] args) {
		// create TurtleGame object and call class methods to play game
		TurtleGame player = new TurtleGame();
		System.out.println("Welcome to the Turtle Game!"
							+"\nIn this game, you can move a turtle around in a 20x20 square."
							+"\nHe also has a pen on him that he can use to draw a path!"
							+"\nEnter a selection to get started.\n");
		player.menu();
		player.moveTurtle();
	} // end method main
} // end class TurtleGamePlay