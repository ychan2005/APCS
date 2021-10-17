/*
Quad Puffs -- David Deng / Yat long Chan / Samantha Hua / Lindsay Phung
APCS
HW18 -- CPA-One / codified the UML diagram <BankAccount>
2021-10-14

DISCO
- UML diagrams are very useful.
QCC
- Is there a way we can use user input to create different accounts?

Team Quad puffs’ Latest and Greatest Q2 Response: An instance of a class can still be initialized even if it does not contain a constructor. 
This means that Java provides a blank constructor if one is not declared.

Team Quad puffs’ Latest and Greatest Q3 Response: Make a method with a String as the return type and return the object inside said method. 
If the file is compiled without error, it means that Java has provided a string representation of the object. 
*/

public class BankAccount {
	private String holderName;
	private String password;
	private int PIN;
	private int accNum;
	private float balance;
	public BankAccount(String n, String p, int pin, int accNumber, float b) {
		setName(n);
		setPass(p);
		setPIN(pin);
		setAccNum(accNumber);
		setBalance(b);

	}
	private void setName (String name) {
		holderName = name;
	}
	private void setPass (String pass) {
		password = pass;
	}
	private void setPIN (int p) {
		PIN = p;
	}
	private void setAccNum (int num) {
		accNum = num;
	}
	private void setBalance (float bal) {
		balance = bal;
	}

	public void printInfo(int aNum, String pass) {
		if (aNum != accNum && pass != password){
			System.out. println("Wrong Account Number and Password");
		}
		else if (pass != password){
			System.out.println("Wrong Password");
		}
		else if (aNum != accNum){
			System.out. println("Wrong Account Number");
		}
		else{
		System.out.println("Full name: " + holderName);
		System.out.println("Account Number: " + accNum);
		System.out.println("Your PIN: " + PIN);
		System.out.println("Password: " + password);
		System.out.println("Balance: " + balance);
		}
	}

	public void deposit(float deposit, int aNum, int pin) {
		if (aNum != accNum && pin != PIN){
			System.out. println("Wrong Account Number and PIN");
		}
		else if (pin != PIN){
			System.out.println("Wrong PIN");
		}
		else if (aNum != accNum){
			System.out. println("Wrong Account Number");
		}
		else {
		balance += deposit;
		System.out.println("Your deposit was successful!");
		System.out.println("Your new balance is: $" + balance);
		}
	}

	public void withdraw(float withdrawal,  int aNum, int pin) {
		if (aNum != accNum && pin != PIN){
			System.out. println("Wrong Account Number and PIN");
		}
		else if (pin != PIN){
			System.out.println("Wrong PIN");
		}
		else if (aNum != accNum){
			System.out. println("Wrong Account Number");
		}
		else{
		balance -= withdrawal;
		System.out.println("Your withdrawal was successful!");
		System.out.println("Your new balance is: $" + balance);
		}
	}

	public static void main(String[] args) {
		BankAccount joseph = new BankAccount("joseph","password", 1234, 123456789, 1000000);
		joseph.printInfo(123456789, "password");
		joseph.deposit(1000000, 123456789, 1234);
		joseph.withdraw(1, 123456789, 1234);
		joseph.deposit(1000000, 123456789, 1233); //Wrong PIN
		joseph.withdraw(1, 123456783, 1232); // Wrong PIN and accNum
		joseph.deposit(1000000, 123456729, 1234); //Wrong accNum
	}

}


