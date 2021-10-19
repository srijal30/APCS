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
	private String password;
	private short pin;
	private int accountNumber;
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
		//Test for initialization and ShowInfo()
		BankAccount elonMusk = new BankAccount();
		elonMusk.ShowInfo(); //expecting null values

		//Test for overloaded constructor
		elonMusk = new BankAccount("Elon Musk", "spaceX123", 1234, 000000001);
		elonMusk.ShowInfo();

		//Test for variable changers
		elonMusk.SetName("The Elon Musk");
		elonMusk.SetPass("tesla123");
		elonMusk.SetPin(4321);
		elonMusk.SetAccount(000000002);
		elonMusk.ShowInfo();

		//Test for Balance Affecting Methods
		elonMusk.ShowBalance();
		elonMusk.Deposit(100.00);
		elonMusk.ShowBalance();
		elonMusk.Withdraw(600.00);
		elonMusk.ShowBalance();
		elonMusk.Deposit(12429.21);
		elonMusk.ShowBalance();
		elonMusk.Withdraw(-1.21);	
		elonMusk.ShowBalance();

		//Test for string representation without .toString()
		System.out.println(elonMusk);
	}
}
