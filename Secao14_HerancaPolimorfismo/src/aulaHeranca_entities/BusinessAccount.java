package aulaHeranca_entities;

public class BusinessAccount extends Account {
	private Double loanLimit;
	
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			// deposit(amount);
			// Balance eh atributo protected de Account
			balance += amount;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		// Chama withdraw do pai
		super.withdraw(amount);
		balance -= 2.0;
	}
}
