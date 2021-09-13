package bankaccount;

public class Checking extends Account {
	
	// List properties specific to a Checking account
	private long debitCardNumber;
	private int debitCardPIN;
	

	// Constructor to initialize checking account properties
	
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		
		setDebitCard();
		
		//System.out.println("New Checking Account.");
		//System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
		
	}

	
	// List any methods specific to the checking account
	private void setDebitCard() {
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
		
		
		
	}
	
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Feateures" + 
		"\n Debit Card Number: " + debitCardNumber +
		"\n Debit Card PIN: " + debitCardPIN
				);
	}

	
}
