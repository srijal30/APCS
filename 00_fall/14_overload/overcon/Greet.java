/*
Salaj Rijal
APCS
HW 14 -- Customize Your Creation -- Create BigSib Classes that make Gree.java function properly
2021-10-07

Discoveries:


Questions/Comments/Concerns:


*/

public class Greet {
	public static void main( String[] args ) {
		String greeting;
		BigSib richard = new BigSib("Word up");
		BigSib grizz = new BigSib("Hey ya");
		BigSib dotCom = new BigSib("Sup");
		BigSib tracy = new BigSib("Salutations");
		greeting = richard.greet("freshman");
		System.out.println(greeting);
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);
		greeting = grizz.greet("Kong Fooey");
		System.out.println(greeting);
		greeting = dotCom.greet("mom");
		System.out.println(greeting);
	} //end main()
} //end Greet

