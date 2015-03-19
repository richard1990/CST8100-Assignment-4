//import statements
import java.util.Scanner;
/**
 * This class holds the data and methods that move the turtle around
 * in a small grid. Some code was provided by my professor. The game
 * prints a 20x20 floor and the user is presented with a menu where they
 * can choose to move a turtle around the floor. The turtle can also
 * put a pen down on the floor to draw a path behind him.
 * @author Prof. Linda Crane, Richard Barney
 * @version 1.0.0 December 2012
 */
public class TurtleGame {

	/** two-dimensional array of ints to create the floor */
	private int [] [] floor;
	/** row size of grid as an integer */
	private int nRowSize;
	/** column size of grid as an integer */
	private int nColSize;
	/** current row as an integer */
	private int nCurrentRow;
	/** current column as an integer */
	private int nCurrentCol;
	/** menu option as an integer */
	private int nOption;
	/** boolean to determine if pen is on ground */
	private boolean booleanPen;
	
	/**
	 * Default constructor. Grid is 20x20 by default.
	 */
	public TurtleGame() {
		nRowSize = 20;
		nColSize = 20;
		reset();
	}
	
	/**
	 * Void method that resets the grid.
	 */
	public void reset() {
		floor = new int[nRowSize][nColSize];
		for (int i = 0; i < nRowSize; i++) {
			for (int j = 0; j < nColSize; j++) {
				floor[i][j] = 0;
			}
		}
		// move turtle back to 0,0 position
		// and take pen off the floor
		nCurrentRow = 0;
		nCurrentCol = 0;
		booleanPen = false;
	} // end method reset
	
	/**
	 * Void method that displays the grid.
	 */
	public void display() {
		// top part
		for (int i = 0; i < nColSize+2; i++) {
			System.out.print("–");
		}
		System.out.println();
		
		// middle, sides and stuff
		for (int i = 0; i < nRowSize; i++) {
			System.out.print("|");
			for (int j = 0; j < nColSize; j++) {
				// display turtle at right spot
				if (i == nCurrentRow && j == nCurrentCol) {
					System.out.print("T");
				}
				
				// if the row and col is 0, display nothing, else
				// display a star showing the turtle's trail
				else if (floor[i][j] == 0) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println ("|");
		}
		
		// bottom part
		for (int i = 0; i < nColSize+2; i++) {
			System.out.print("–");
		}
		System.out.println();
	} // end method display
	
	/**
	 * Void method that displays the menu for user to
	 * select an option.
	 */
	public void menu() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter 1 to lift pen up    Enter 2 to put pen down  Enter 3 to move up"
								+"\nEnter 4 to move down      Enter 5 to move left     Enter 6 to move right"
								+"\nEnter 7 to display floor  Enter 8 to reset floor   Enter 9 to quit program ");
			nOption = input.nextInt();
		} while (nOption < 1 || nOption > 9);
	} // end method menu
	
	/**
	 * Void method that performs all the calculations for the turtle
	 * based on what option the user entered.
	 */
	public void moveTurtle() {
		Scanner input = new Scanner(System.in);
		// while option is not 9, do the stuff needed to move the turtle
		while (nOption != 9) {		
			// if the user enters 1 and booleanPen is not true, lift the pen
			// up so that the turtle does not leave a trail behind him when he moves
			if (nOption == 1 && booleanPen != false) {
				booleanPen = false;
				System.out.println("The turtle lifts his pen up off the ground.");
			}
			
			// if the user enters 1 and booleanPen is true, tell user that the pen is
			// already off the ground and do nothing else
			else if (nOption == 1 && booleanPen == false) {
				System.out.println("The turtle's pen is already off the ground! Try another move.");
			}
			
			// if the user enters 2 and booleanPen is not true, put the pen down
			// so that the turtle leaves a trail (setting booleanPen to true)
			if (nOption == 2 && booleanPen != true) {
				booleanPen = true;
				System.out.println("The turtle puts his pen down on the ground, ready to draw a path.");
			}
			
			// if the user enters 2 and booleanPen is true, tell the user that the pen is
			// already on the groud and do nothing else
			else if (nOption == 2 && booleanPen == true) {
				System.out.println("The turtle's pen is already on the ground! Try another move.");
			}
			
			// if the user enters 3, move the turtle up by 1 square by decrementing the
			// current row
			if (nOption == 3) {
				--nCurrentRow;
				// as long as turtle is in bounds, display message that he moved up 1 square
				if (nCurrentRow >= 0) {
					System.out.println("The turtle moves up 1 square.");
				}
				// if the turtle goes out of bounds, display error message and move him back 1 square
				if (nCurrentRow < 0)	{
					System.out.println("The turtle cannot move up anymore. Try another move.");
					++nCurrentRow;
				}
			}
		
			// if the user enters 4, move the turtle down by 1 square by incrementing the 
			// current row
			if (nOption == 4) {
				++nCurrentRow;
				// as long as turtle is in bounds, display message that he moved down 1 square
				if (nCurrentRow <= 19) {
					System.out.println("The turtle moves down 1 square.");
				}
				// if the turtle goes out of bounds, display error message and move him back 1 square
				if (nCurrentRow > 19) {
					System.out.println("The turtle cannot move down anymore. Try another move.");
					--nCurrentRow;
				}
			}
		
			// if the user enters 3, move left by 1 square by decrementing the current column
			if (nOption == 5) {
				--nCurrentCol;
				// as long as turtle is in bounds, display message that he moved left 1 square
				if (nCurrentCol >= 0) {
					System.out.println("The turtle moves left 1 square.");
				}
				// if the turtle goes out of bounds, display error message and move him back 1 square
				if (nCurrentCol < 0)	{
					System.out.println("The turtle cannot move left anymore. Try another move.");
					++nCurrentCol;
				}
			}
		
			// if the user enters 6, move right by 1 square by incrementing the current column
			if (nOption == 6) {
				++nCurrentCol;
				//as long as turtle is in bounds, display message that he moved right 1 square
				if (nCurrentCol <= 19) {
					System.out.println("The turtle moves right 1 square.");
				}
				//if the turtle goes out of bounds, display error message and move him back 1 square
				if (nCurrentCol > 19)	{
					System.out.println("The turtle cannot move right anymore. Try another move.");
					--nCurrentCol;
				}
			}
				
			// if the user enters 7 display the floor
			if (nOption == 7) {
				display();
			}
		
			// if the user enters 8 reset the floor, moving turtle back to top-left square
			if (nOption == 8) {
				reset();
				System.out.println("The floor has been reset. The turtle is now back in his corner and his pen is off the ground.");
			}
			
			// if booleanPen is true, make sure current spot leaves a trail
			// by setting the position to 1
			if (booleanPen) {
				floor[nCurrentRow][nCurrentCol] = 1;
			}
			menu(); // display the menu again
		} // end big while statement
		
		// if the user enters 9 end the game
		if (nOption == 9) {
			System.out.print("Goodbye. Thanks for playing!");
		}
	} // end method moveTurtle
} // end class TurtleGame