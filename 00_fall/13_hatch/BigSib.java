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
public class BigSib{
	
	//Decleration of helloMsg
	private String helloMsg;

	//Constructor
	BigSib(String msg){
		helloMsg = msg;
	}

	public static void main(String[] args){
	}

	public void setHelloMsg(String msg){
		helloMsg = msg + " ";
	
	}

	public String greet(String str){
		return helloMsg + str;

	}
}

