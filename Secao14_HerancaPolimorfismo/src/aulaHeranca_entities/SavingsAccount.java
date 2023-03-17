package aulaHeranca_entities;

// "final": evita criação de subclasses de SavingsAccounts
public class SavingsAccount extends Account {

	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	// "final": evita sobrescritas futuras de withdraw
	@Override
	public final void withdraw(double amount) {
		balance -= amount;
	}
	
}
