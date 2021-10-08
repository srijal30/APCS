/*
Salaj Rijal
APCS
HW 14 -- Customize Your Creation -- Create BigSib Classes that make Gree.java function properly
2021-10-07

Discoveries:
-Overloading a structure means putting parameters when contstructing an object
-

Questions/Comments/Concerns:


*/
public class BigSib{
	
	//Decleration of helloMsg
	private String helloMsg;

	//Constructor 1
	BigSib(){
		helloMsg = "Whats up I had trouble with the cs hw "; 
	}

	public void setHelloMsg(String msg){
		helloMsg = msg + " ";
	
	}

	public String greet(String str){
		return helloMsg + str;

	}
}

