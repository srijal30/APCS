/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card firstCard = new Card("King", "Diamonds", 12);
		Card secondCard = new Card("Queen", "Hearts", 11);
		Card thirdCard = new Card("Ace", "Spades", 13);
		System.out.println(firstCard);
		System.out.println(secondCard);
		System.out.println(thirdCard);
	}
}
