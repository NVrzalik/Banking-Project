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
			throw new InvalidAccountNumberException(accountNumber);
		}
		
		if(isBalance(balance))
		{
			this.balance = balance;
		}
		else
		{
			throw new InvalidMoneyException(balance);
		}
		
		if(isAccountOwner(accountOwners))
		{
			this.accountOwners = accountOwners;
		}
		
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
	
	private boolean isAccountOwner(long[] input) throws AccountOwnersException
	{
		if (input.length < 1 || input.length > 5)
		{
			throw new InvalidNumberOfOwnersException(input);
		}
		
		for (int i = 0; i < input.length; i++)
		{
			if(!isIDNumber(input[i]))
			{
				throw new InvalidAccountOwnerIDException(input[i]);
			}
		}
		
		return true;
	}
	
	public abstract class AccountException extends Exception
	{
		public AccountException()
		{
			super();
		}
		
		public AccountException(String message)
		{
			super(message);
		}
	}
	
	public class InvalidAccountNumberException extends AccountException
	{
		public InvalidAccountNumberException(long accountNumber)
		{
			super(accountNumber + " is not a valid account number ID");
		}
		
		public InvalidAccountNumberException()
		{
			super("Invalid account number ID");
		}
	}
	
	public class InvalidMoneyException extends AccountException
	{
		public InvalidMoneyException(double amount)
		{
			super(amount + " is not a valid money amount");
		}
		
		public InvalidMoneyException()
		{
			super("Invalid money amount");
		}
	}
	
	public abstract class AccountOwnersException extends AccountException
	{
		public AccountOwnersException()
		{
			super("Account owner error");
		}
		
		public AccountOwnersException(String message)
		{
			super(message);
		}
	}
	
	public class InvalidNumberOfOwnersException extends AccountOwnersException
	{
		public InvalidNumberOfOwnersException(long[] owners)
		{
			super("Account cannot have " + owners.length + " owners");
		}
		
		public InvalidNumberOfOwnersException()
		{
			super("Invalid number of account owners");
		}
	}

}
