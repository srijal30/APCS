/*
TNPG: Flying Sullen Actors (Alif Rahman, Salaj Rijal, Faiyaz Rafee)
APCS
L09: Some Folks Call It A Charades
2022-04-27
time spent: 4 hours
*/

import java.io.IOException;
import java.util.ArrayList;

/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */ //<---- makes no sense
	private Celebrity gameCelebrity;

	/**
	 * The GUI frame for the Celebrity game.
	 */
	private CelebrityFrame gameWindow;


	/**
	 * The ArrayList of Celebrity values that make up the game
	 */
	private ArrayList<Celebrity> celebGameList;

	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		celebGameList = new ArrayList<Celebrity>(); 
		gameWindow = new CelebrityFrame(this);
		
		//prepare the game (adding celebs to the list)
		prepareGame();
	}

	/**
	 * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
	 */
	public void prepareGame()
	{
		//reinitialize (start a new game)
		//open GUI frame that allows user to input celebs
		gameWindow.replaceScreen("START");
	}

	/**
	 * Determines if the supplied guess is correct.
	 * 
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
		if (celebGameList.size() <= 0) System.out.println("SOrry");
		boolean matchFound = false;
		guess = guess.trim();

		matchFound = guess.equalsIgnoreCase( gameCelebrity.getAnswer() );
		if( matchFound ){
			celebGameList.remove(0);
			gameCelebrity = celebGameList.get(0);
		}

		return matchFound;
	}

	/**
	 * Asserts that the list is initialized and contains at least one Celebrity.
	 * Sets the current celebrity as the first item in the list. Opens the game
	 * play screen.
	 */
	public void play()
	{

		//check that celeb game list is not empty so game can actually start
		if (celebGameList != null && celebGameList.size() > 0  ) 
		{ 
			this.gameCelebrity = celebGameList.get(0); 
			gameWindow.replaceScreen("GAME"); 
		}
		//(if it is empty i guess than print some message) <-- shouldnt happen tho
		else{
			System.out.println("CELEB GAME LIST IS EMPTY");
		}
	}

	/**
	 * Adds a Celebrity of specified type to the game list
	 * 
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * 
	 * NOT IMPLEMENTED FOR NOW:
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		Celebrity newCeleb;

		//checks what type of celeb needs to be added
		if( type.equals("Literature") ){
			newCeleb = new LiteratureCelebrity(name, guess);
		}
		else if (type.equals("Image") ){
			try{
				newCeleb = new ImageCelebrity(name, guess);
			}
			catch( Exception e){
				System.out.println(e);
				newCeleb = new Celebrity(name, guess);
			}
		}
		else{
			newCeleb = new Celebrity(name, guess);
		}

		//actually adds the celeb
		celebGameList.add( newCeleb );
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
		name = name.trim();
		return name.length() >= 4;
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity 
	 * @return If the clue is valid.
	 */
	public boolean validateClue(String clue, String type) 
	{
		boolean validClue = false;
		clue = clue.trim();

		//check if at least 10 chars
		if( clue.length() >= 10 ){
			validClue = true;

			//extra recs if
			if ( type.equalsIgnoreCase("Literature") ){

				String[] temp = clue.split(",");
				if( temp.length > 1 ) {
					validClue = true;
				}
			}
		}
		return validClue;
	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 * 
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize()
	{
		return celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 * 
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		//make sure previous image tab is closed
		SimpleGUIRunner.close();
		return gameCelebrity.getClue();
	}

	/**
	 * Accessor method for the games answer to maintain low coupling between
	 * classes
	 * 
	 * @return The String answer from the current celebrity.
	 */
	public String sendAnswer()
	{
		return gameCelebrity.getAnswer();
	}
}
