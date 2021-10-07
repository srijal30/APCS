/* 
Linuxers: Salaj Rijal: George, Lea Kwok: Gunter
APCS
HW 13 -- Where do BigSibs come From -- Creating and Using Constructors
2021-10-06
 
DISCOVERIES:
-There can be multiple constructors in a class

UNRESOLVED QUESTIONS:
-How does java tell the difference between constructors if they have same number of arguements?

*/
public class Greet {
	public static void main(String[] args){
		String greeting; //Decalring String Variable

		//Greeting Example
		BigSib richard = new BigSib("Word up ");
		greeting = richard.greet("freshman");
		System.out.println(greeting);

		//Greeting One
		BigSib spaceman = new BigSib("Salutations "); 
		greeting = spaceman.greet("Dr. Spaceman");
		System.out.println(greeting);

		//Greeting Two
		BigSib fooey = new BigSib("Hey ya ");
		greeting = fooey.greet("Kong Fooey");
		System.out.println(greeting);

		//Greeting Three
		BigSib matthew = new BigSib("Sup ");
		greeting = matthew.greet("mom");
		System.out.println(greeting);

	}
}
