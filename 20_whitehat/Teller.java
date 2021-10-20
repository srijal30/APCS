/*
Triumphant Triumvirate: Salaj Rijal: George, Ariel Fuchs: Skelly Ducky, Ben Belotser: TwoFace
APCS
HW 20 -- External Audit -- Hack other Trio and find their mistakes
2021-10-19
DISCO:
-BankAccount is not secure
-When a value exceeds maximum value, Java registers it as INFINITY
-You need to use (short) when defining a short otherwise it will register as int



QCC:
-How can we make BankAccount more secure?
-Why is it necassary to set accountNumber and pin to 99... by default? Doesnt this pose a security risk?
-Should we have constructors for this class?

*/

public class Teller {
	public static void main(String[] args){
      	//Test for methods
		BankAccount Whitehat = new BankAccount(123456789, (short)4321);
		System.out.println( Whitehat.toString() );
      	System.out.println( Whitehat.setName("Triumvirate") );
        System.out.println( Whitehat.setPasswd("123456789") );
      	System.out.println( Whitehat.setPin((short) 1234) );
      	System.out.println( Whitehat.authenticate(123456789, "123456789") );
	
      
        //Attempt to breaking
      
      	//You can set up accountNumber and pin that do not meet requirments because there is a constructor
      	BankAccount Blackhat = new BankAccount(21, (short)66);
      
      	//If we use setPin() and purposely use wrong parameter, then we will know the pin is 9999 (security risk)
      	System.out.println( Blackhat.setPin( (short)12 ) );
      	System.out.println( Blackhat.toString() );
      	
      	//If we input negative parameter in withdraw() we get free money
      	System.out.println( Blackhat.withdraw(-10000) );
      	System.out.println( Blackhat.toString() );
      
      	//We can also lose money when we deposit
      	Blackhat.deposit(-10000);
      	System.out.println( Blackhat.toString() );
      
      	//Also there is a max amount of money
      	Blackhat.deposit(Double.MAX_VALUE);
      	System.out.println( Blackhat.toString() );
      	Blackhat.deposit(Double.MAX_VALUE);
      	System.out.println( Blackhat.toString() ); //The amount changes to infinity
                  
                  
	}//End of Main
} //End of Class 