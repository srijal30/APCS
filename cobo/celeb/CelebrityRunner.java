/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */

import java.io.IOException;
import java.util.Scanner;

public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */


	public static void runTerminalgame(CelebrityGame game) {

		Scanner sc = new Scanner( System.in );

		//add at least 1 celeb
		System.out.print("Please Input a Celeb Name: ");
		
		//get a valid name
		String name = sc.nextLine();
		while( ! game.validateCelebrity(name) ){
			System.out.print("Please Try Again: ");
			name = sc.nextLine();
		}

		//get a valid clue
		System.out.print("\nPlease Input a Clue: ");
		String clue = sc.nextLine();
		while( ! game.validateClue(clue, "") ){
			System.out.print("Please Try Again: ");
			clue = sc.nextLine();
		}

		//add the first celeb
		game.addCelebrity(name, clue, "");

		//ask if they want to input more
		System.out.print( "\nDo you want to add more Celebs?(true/false): ");
		boolean more = sc.nextBoolean();

		//add more celebs
		while(more){
			//get a valid name
			System.out.print("\nPlease Input a Name: ");
			sc.nextLine(); //idk why i need this but seems to work better
			name = sc.nextLine();
			while( ! game.validateCelebrity(name) ){
				System.out.print("Please Try Again: ");
				name = sc.nextLine();
			}
			
			//get a valid clue
			System.out.print("\nPlease Input a Clue: ");
			clue = sc.nextLine();
			while( ! game.validateClue(clue, "") ){
				System.out.print("Please Try Again: ");
				clue = sc.nextLine();
			}

			//add the celeb
			game.addCelebrity(name, clue, "");

			//ask if they want more
			System.out.print( "\nDo you want to add more Celebs?(true/false): ");
			more = sc.nextBoolean();

		}

		int points = 0;
		int currentGuesses = 5;

		//play the game
		game.play();

		System.out.println("\n\nGAME STARTING...");
		while( game.getCelebrityGameSize() > 0 ){
			currentGuesses = 5;
			System.out.println("\nYour clue: " + game.sendClue() );
			String celeb = game.sendAnswer();
			//keep on going while guess count higher than 0
			while( currentGuesses > 0 ){
				System.out.print("You have " + currentGuesses + " guesses left: ");
				String guess = sc.nextLine();
				System.out.println();
				//if right
				if( game.processGuess(guess) ){
					System.out.println("You got it right! You have " + points++ + " points!");
					break;
				}
				else{
					System.out.print("Incorrect! ");
					currentGuesses--;
				}
			}

			System.out.println("The answers was: " + celeb );
		}

		System.out.println("Game is over... you ended with " + points + " points!");
		sc.close();
	}


	public static void main(String [] args) throws IOException
	{

		CelebrityGame game = new CelebrityGame();

		/*terminal running.... make sure Gui stuff commented out*/
		//runTerminalgame(game);


	}
}
