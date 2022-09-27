package bank;

public abstract class BankAccount {
	
	private long accountNumber;
	private long[] accountOwners;
	private double balance;
	
	public BankAccount(long accountNumber, double balance, long... accountOwners) throws AccountException
	{
		//accountNumber needs to be validated
		isAccountNumber(accountNumber);
		isBalance(balance);
		isAccountOwner(accountOwners);
		this.accountNumber = accountNumber;
		//balance needs to be validated
		this.balance = balance;
		//accountOwners needs to be validated
		this.accountOwners = accountOwners;
	}
	
	private boolean isAccountNumber(long input) throws invalidAccountNumberException
	{
		if (input < 1 || input > 10000000)
		{
			throw new invalidAccountNumberException(input);
		}
		
		return true;
	}
	
	private boolean isBalance(double input) throws invalidMoneyException
	{
		double temp = (Math.round(input * 100)) / 100.0;
		if (temp != input)
		{
			throw new invalidMoneyException(input);
		}
		
		return true;
	}

}
