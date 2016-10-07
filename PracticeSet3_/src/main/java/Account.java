import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();

	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
	}

	/**
	 * @param id
	 * @param initialbalance
	 */
	public Account(int id, double initialbalance) {
		this();
		this.id = id;
		this.balance = initialbalance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMothlyInterestRate() {
		return annualInterestRate / 12;
	}

	public void withdraw(double withdrawamt) throws InsufficientFundsException, NegativeAmtException {
		if (withdrawamt < 0) {
			throw new NegativeAmtException(withdrawamt);
		} else if (balance < withdrawamt) {
			throw new InsufficientFundsException(withdrawamt - balance);
		} else {
			balance -= withdrawamt;
		}
	}

	public void deposit(double depositamt) throws NegativeAmtException {
		if (depositamt < 0) {
			throw new NegativeAmtException(depositamt);
		} else {
			balance += depositamt;
		}
	}

}
