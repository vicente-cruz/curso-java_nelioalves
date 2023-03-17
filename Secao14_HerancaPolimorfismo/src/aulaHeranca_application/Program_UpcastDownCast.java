package aulaHeranca_application;

import aulaHeranca_entities.Account;
import aulaHeranca_entities.BusinessAccount;
import aulaHeranca_entities.SavingsAccount;

public class Program_UpcastDownCast {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Naria", 0.0, 500.0);
		
		// UPCASTING: Variavel Superclasse recebe objeto do tipo Subclasse
		Account acc_bc1 = bacc;
		Account acc_bc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc_sv1 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
		// DOWNCASTING: Variavel Subclasse recebe objeto Superclasse, REQUER TYPECASTING
		BusinessAccount bacc_acc1 = (BusinessAccount) acc_bc2;
		bacc_acc1.loan(100.0);
		
		// Erro em tempo de execução: Fazer SUB BusinessAccount receber a SUB SavingAccount disfarçada da SUPER Account
		if (acc_sv1 instanceof BusinessAccount) {
			BusinessAccount bacc_acc2 = (BusinessAccount) acc_sv1;
			bacc_acc2.loan(100.0);
			System.out.println("Executou loan!");
		}
		
		if (acc_sv1 instanceof SavingsAccount) {
			SavingsAccount sacc_acc1 = (SavingsAccount) acc_sv1;
			sacc_acc1.updateBalance();
			System.out.println("Executou updateBalance");
		}
		
	}

}
