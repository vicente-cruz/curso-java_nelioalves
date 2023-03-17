package aulaHeranca_application;

import aulaHeranca_entities.Account;
import aulaHeranca_entities.BusinessAccount;
import aulaHeranca_entities.SavingsAccount;

public class Program_Override {

	public static void main(String[] args) {

		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(200.0);
		System.out.println(acc1.getBalance());
		
		// Upcasting
		Account acc2 = new SavingsAccount(1002,"Maria", 1000.0, 0.01);
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
		
		// Upcasting
		Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
	}

}
