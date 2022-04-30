/*
Triumphant Triumvirate: Salaj Rijal: George, Ariel Fuchs: Skelly Ducky, Ben Belotser: TwoFace
APCS
HW 18 -- CPA-One -- Creating/Testing BankAccount.java with the help of UML Diagram
2021-10-16

DISCO:
-The initial value for int is 0, null for string, 0.0 for double

QCC:
-Should balance be set up in overcon + have a SetBalance() method?
-How does java know what constructor to use?
-what is a good name for inputVariables?
-should variables be initialized in default constructor or in the class?
-is it necassary to add an if statement to limit input params?

Q2:
You know that Java provides a default constructor because if you were to create an instance of a class, className variable = new className(), and did not write any default constructor into that class, the code will still work, thus implying a default constructor is provided

Q3:
BigSib richard = new BigSib();
System.out.println(richard);

*/

public class BankAccount{

	//Intitialization
	private String name;
	private String password;
	private int pin;
	private int accountNumber;
	private double balance = 0.0;

	//DefaultConstructor
	public BankAccount(){
	}

	//OverloadedConstructor
	public BankAccount(String _name, String _pass, int _pin, int _accnt){
			name = _name;
			password = _pass;
			pin = _pin;
			accountNumber = _accnt;
	}

	//ShowInfo() method
	public void ShowInfo(){
			System.out.println(name);
			System.out.println(password);
			System.out.println(pin);
			System.out.println(accountNumber);
			System.out.println(balance);
			System.out.println();
	}

	//Set..() methods
	public void SetName(String _name){
			name = _name;
	}

	public void SetPass(String _pass){
			password = _pass;
	}

	public void SetPin(int _pin){
			pin = _pin;
	}

	public void SetAccount(int _account){
		   accountNumber = _account;
	}

	//ShowBalance() Method //NOT NECASSARY BUT HELPFUL FOR TESTING
	public void ShowBalance(){
			System.out.println(balance);
	}

	//Balance Affecting Methods
	//Withdraw
	public void Withdraw(double amount){
			balance -= amount;
	}

	//Deposit
	public void Deposit(double amount){
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
	}
}