package bank;

public abstract class BankAccount {
	
	private long accountNumber;
	private long[] accountOwners;
	private double balance;
	
	public BankAccount(long accountNumber, double balance, long... accountOwners) throws AccountException
	{
		//accountNumber needs to be validated
		if(isIDNumber(accountNumber))
		{
			this.accountNumber = accountNumber;
		}
		else
		{
			throw new invalidAccountNumberException(accountNumber);
		}
		
		if(isBalance(balance))
		{
			this.balance = balance;
		}
		else
		{
			throw new invalidMoneyException(balance);
		}
		isAccountOwner(accountOwners);
		//accountOwners needs to be validated
		this.accountOwners = accountOwners;
	}
	
	private boolean isIDNumber(long input)
	{
		if (input > 1 && input < 10000000)
		{
			return true;
		}
		return false;
	}
	
	private boolean isBalance(double input)
	{
		double temp = (Math.round(input * 100)) / 100.0;
		if (temp == input)
		{
			return true;
		}
		return false;
	}
	
	//Still building this function
	private boolean isAccountOwner(long[] input) throws accountOwnersException
	{
		if (input.length < 1 || input.length > 5)
		{
			throw new invalidNumberOfOwnersException(input);
		}
		
	}

}
