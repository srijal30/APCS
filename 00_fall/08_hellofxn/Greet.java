/*
Salaj Rijal
APCS
HW 08 -- Refractor Freshie Zero -- Custom Function
2021-09-30

DISCOVERIES:
-you need the keyword stati
-you cant use the java command to run a file if there is a class verision of itc

UNRESOLVED QUESTIONS:
-why do you need public?
-why did for one of my team memebers, their folder got turned into a file?
-why do you need static?
-why cant u use java command after you use javac command?
--ERROR MESSAGE:
----error: class found on application class path: Greet
0

*/
public class Greet{
	public static void main(String[] args){
		greet("Daniel");
		greet("Raj");
		greet("Caleb");
	}
	static void greet(String str){
		System.out.println("Yo whats up " + str + ", did you do the CS homework?");

	}
}

