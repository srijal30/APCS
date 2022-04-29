/*
TNPG: Flying Sullen Actors (Alif Rahman, Salaj Rijal, Faiyaz Rafee)
APCS
L09: Some Folks Call It A Charades
2022-04-27
time spent: 4 hours
*/
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

/**
 * Subclass of Celebrity to show how methods can be overridden and super can be called while changing functionality.
 * @author cody.henrichsen
 * @version 1.0 15/09/2018
 */
public class ImageCelebrity extends Celebrity
{
	/**
	 * The list of clues for the Literature Celebrity. They can be titles of texts, important characters, settings, etc...s
	 */

     private String imgLocal;
     private String imgPublic;
	/**
	 * Builds a LiteratureCelebrity instance with an answer and a series of clues as a String separated by commas.
	 * @param answer The literature celebrity
	 * @param clues Clues for the literature celebrity 
	 */
	public ImageCelebrity(String answer, String clues) throws IOException,InterruptedException
	{
		super(answer, clues);
        imgPublic = clues;
		processClues();
	}
	
	/**
	 * Processes the series of clues for the LiteratureCelebrity by adding all the values to an ArrayList<String> by
	 * splitting the original clue to an array of String.
	 * The original value is not impacted, thus preserving data and inheritance integrity.
	 */
	private void processClues() throws IOException, InterruptedException
	{
        String command = "wget -P tmp/ " + imgPublic;
        Process proc = Runtime.getRuntime().exec(command);
        
        int splitter = imgPublic.lastIndexOf("/");
        imgLocal = "tmp/" + imgPublic.substring(splitter+1);

        proc.waitFor();
	}
	
	/**
	 * Overridden version of the getClue() method that cycles through each of the individual clues in the series.
	 * It recreates the clueList if the user has finished the series of clues.
	 */
	@Override
	public String getClue()
	{
        return "temp";
	}
	
	
	@Override
	public String toString()
	{
		String dsc = "This is the img celebrity: " + getAnswer() + "\nThe clues are:\n\t"+imgLocal+"\n\t"+imgPublic;
		return dsc;
	}

    public static void main(String[] args) throws IOException, InterruptedException {
        
        ImageCelebrity celeb = new ImageCelebrity("", "https://techcrunch.com/wp-content/uploads/2021/01/GettyImages-1229901940.jpg?w=730&crop=1");
        System.out.println(celeb);

    }
}
