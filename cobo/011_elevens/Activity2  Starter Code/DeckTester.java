/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {

		String[] ranks = new String[]{"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		String[] suits = new String[]{"Clubs", "Spades", "Hearts", "Diamonds"};
		int[] values = new int[]{1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		String[] rank = new String[52];
		String[] suit = new String[52];
		int[] vals = new int[52];
		
		//makes a deck for game of 21
		for( int i = 0; i < 52; i++ ){
			int mod = i % 13;
			int thing = i/13;
			System.out.println(mod);
			rank[i] = ranks[mod];
			vals[i] = values[mod];
			suit[i] = suits[thing];
		}

		Deck faiyazDeck = new Deck( rank, suit, vals);
		System.out.println( faiyazDeck );
	}
}
