/*
TNPG: Froghats 
Roster: Alif Rahman, Salaj Rijal, Kevin Cheng
APCS
HW90 -- Swabbing the Deque -- Implementing our own Deque class
2022-04-12
time spent: .5 hours
*/


public class Driver {
    public static void main(String[] args) {
        
        Deck<String> deck = new Deck<String>();

        deck.addFirst("a");
        deck.addFirst("b");
        deck.addFirst("c");

        deck.addLast("x");
        deck.addLast("y");
        deck.addLast("z"); 

        //remove from end
        System.out.println("Remove from end: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeLast() + " " );
        
        deck.addFirst("a");
        deck.addFirst("b");
        deck.addFirst("c");

        deck.addLast("x");
        deck.addLast("y");
        deck.addLast("z"); 

        //remove from beginning
        System.out.println("\nRemove from beginning: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeFirst() + " " );

        //shuffle the order up
        deck.addFirst("a");
        deck.addLast("x");

        deck.addFirst("b");
        deck.addLast("y");
        
        deck.addFirst("c");
        deck.addLast("z"); 

        //remove from beginning
        System.out.println("\nRemove from beginning w/ a twist: ");
        while ( ! deck.isEmpty() ) System.out.print( deck.removeFirst() + " " );
    	//should give nulls
	System.out.println( deck.pollFirst() );
	System.out.println( deck.pollLast() );
    }
}
