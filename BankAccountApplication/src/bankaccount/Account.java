package bankaccount;

public abstract class Account implements IBaseRate{

	// List common properties for savings and checking accounts
	
	private String name;
	private String sSN;
	protected String accountNumber;
	
	private static int index = 10000;
	private double balance;
	protected double rate;
	
	// Constructor to set base properties and initialize the account
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		//System.out.println("NAME: " + name + " SSN: " + sSN + " BALANCE: $" + balance);
		
		index++;
		this.accountNumber = setAccountNumber();


		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		
		String lastTwoOfSSN = sSN.substring(sSN.length() -2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10,3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued interest: $" + accruedInterest);
		showBalance();
	}
	
	// List common methods
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		showBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		showBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		showBalance();
	}
	
	public void showBalance(){
		System.out.println("Your balance is now: $" + balance);
	}
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\n RATE: " + rate + "%"
				);
	}
}
