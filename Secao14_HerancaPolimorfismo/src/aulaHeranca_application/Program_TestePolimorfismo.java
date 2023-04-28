package aulaHeranca_application;

import aulaHeranca_entities.Account;
import aulaHeranca_entities.SavingsAccount;

public class Program_TestePolimorfismo {

	public static void main(String[] args) {
		Account x = new Account(1020, "Alex", 1000.0);
		Account y = new SavingsAccount(1023, "Maria", 1000.0,0.01);

		x.withdraw(50.0);
		y.withdraw(50.0);
		
		System.out.println(x.getBalance());
		System.out.println(y.getBalance());
	}

}
