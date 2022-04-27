/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */
public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */
	public static void main(String [] args)
	{
		Celebrity[] celebs = new Celebrity[] {

			new Celebrity( "Tom Holland", "New Spiderman" ),
			new Celebrity( "Zendaya", "Dune and Spiderman and Euphoria actressa" ), 
			new Celebrity( "Will Smith", "Slapped Chris Rock" ), 
			new Celebrity( "Elon Musk", "Tesla and SpaceX visionary"), 
			new Celebrity( "Jeff Bezos", "Amazon Bajiollionore") 
		}


		for( Celebrity c: celebs ){
			System.out.println(c)
		}
	}
}
