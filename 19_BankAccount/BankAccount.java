/*
Triumphant Triumvirate: Salaj Rijal: George, Ariel Fuchs: Skelly Ducky, Ben Belotser: TwoFace
APCS
HW 19 -- Mo Money Mo Problems... MORE AWESOME -- Creating authenticate() with the help of conditionals
2021-10-18

DISCO:

QCC:

Q2:
You know that java creates a default constructor becasue if there are not constructors defined in a class and you try to construct it, an instance of the class is still returned. An example of this default constructor is:
public classNam(){
	//no parameters
}

Q3:
BigSib richard = new BigSib();
System.out.println(richard); //Output: "BankAccount@49476842"

*/

public class BankAccount{

	//Intitialization
	private String name;
	private String passwd;
	private short pin;
	private int acctNum;
	private double balance;

	public String toString() {
		String retStr = "\nAccount info:\n=======================";
      		retStr = retStr + "\nName: " + name;
      		retStr = retStr + "\nPassword: " + passwd;
      		retStr = retStr + "\nPIN: " + pin;
      		retStr = retStr + "\nAccount Number: " + acctNum;
      		retStr = retStr + "\nBalance: " + balance;
      		retStr = retStr + "\n=======================";
      		return retStr;
	}
 	
	//mutators
	public String setName( String newName ) {
  		String oldName = name;
		name = newName;
		return oldName;
	}
	
	public String setPasswd( String newPasswd ) {
		String oldPasswd = passwd;
		passwd = newPasswd;
		return oldPasswd;
	}
	
	public short setPin( short newPin ) {
		short oldPin = pin;
		pin = newPin;
		return oldPin;
	}

	public int setAcctNum( int newAcctNum ) {
		int oldAcctNum = acctNum;
		acctNum = newAcctNum;
		return oldAcctNum;
	}

	public double setBalance( double newBalance ) {
		double oldBalance = balance;
		balance = newBalance;
		return oldBalance;
	}	

	//Balance Affecting Methods
	//Withdraw	
	public void withdraw(double amount){
		balance -= amount;
	}

	//Deposit
	public void deposit(double amount){
		balance += amount;
	}

	//main() method
	public static void main(String[] args){
		//Test for initialization and new toString()
		BankAccount elonMusk = new BankAccount();
		System.out.println( elonMusk.toString() ); //expecting null values

		//Test for variable changers (mutator methods)
        System.out.println( "Test for Return Values"); // output should match AccntInfo above	 
        System.out.println( elonMusk.setName("The Elon Musk") );
		System.out.println( elonMusk.setPasswd("tesla123") );
		System.out.println( elonMusk.setPin( (short)4321 ) );
		System.out.println( elonMusk.setAcctNum(123456789) );
        System.out.println( elonMusk.setBalance(10000) );
		System.out.println( elonMusk.toString() );

		//Test for Balance Affecting Methods
		elonMusk.deposit(5000);
		elonMusk.withdraw(250);	
		System.out.println( elonMusk.toString() );
	}
}
