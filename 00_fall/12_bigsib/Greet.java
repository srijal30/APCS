/* 
Missing Duo: Salaj Rijal (George)... Groupmate (Undefined)
APCS
HW 12 -- On Elder Individuality and the Elimination of Radio Fuzz - Creating Instance of a Class
2021-10-05

DISCOVERIES:
on BigSib.java

UNRESOLVED QUESTIONS:
on BigSib.java

*/
public class Greet {
	public static void main(String[] args){
		String greeting; //Decalring String Variable
		BigSib richard = new BigSib(); //Create an instance of the class BigSib() called richard

		//Greeting Example
		richard.setHelloMsg("Word up");
		greeting = richard.greet("freshman");
		System.out.println(greeting);

		//Greeting One
		richard.setHelloMsg("Salutations");
		greeting = richard.greet("Dr. Spaceman");
		System.out.println(greeting);

		//Greeting Two
		richard.setHelloMsg("Hey ya");
		greeting = richard.greet("Kong Fooey");
		System.out.println(greeting);

		//Greeting Three
		richard.setHelloMsg("Sup");
		greeting = richard.greet("mom");
		System.out.println(greeting);

	}
}
