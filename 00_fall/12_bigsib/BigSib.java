/*
Ubuntus: Salaj: George, May: Perry Jr., Faiyaz: Atlas and Payne
APCS
HW 10 -- Refactor Big Sib One -- Make the method return a value
2021-10-04

DISCOVERIES:
-You can instance a class using "className" + "variableName" = new "className"();
-You can access class methods using the variableName you assigned to it.
-You can call variable whatever you want.


UNRESOLVED QUESTIONS:
-What part does keyword static have in this?
-Is there a better way to change the variable rather than using a function? Like is there a more direct way?

*/
public class BigSib{

	static String helloMsg;
	public static void main(String[] args){
	}

	public void setHelloMsg(String msg){
		helloMsg = msg + " ";
	
	}

	public static String greet(String str){
		return helloMsg + str;

	}
}

