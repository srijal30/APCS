/*
Salaj Rijal
APCS
HW 14 -- Customize Your Creation -- Create BigSib Classes that make Gree.java function properly
2021-10-07

Discoveries:
-Static for a class means that it changes for everything
-If parameter in contstructor it means that it is overloaded
-Default constructor is a constructor without any parameters, and you dont have to initialze it in the begining unless you want

Questions/Comments/Concerns:
-What does a static method mean?


*/
public class BigSib{
	
	//Declererereration of helloMsg
	private String helloMsg;

	//Constructor
	public BigSib(String msg){
		helloMsg = msg +  " ";
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

