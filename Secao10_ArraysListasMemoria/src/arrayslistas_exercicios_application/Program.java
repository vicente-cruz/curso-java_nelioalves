package arrayslistas_exercicios_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import arrayslistas_exercicios_entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int numEmployees = sc.nextInt();
		
		List<Employee> employeeList = new ArrayList<>();
		Integer id; 
		
		int i = 0;
		while (i < numEmployees) {
			System.out.println("Employee #"+(i+1)+": ");
			
			System.out.print("Id: ");
			id = sc.nextInt();
			
			boolean exists = false;
			for (Employee temp : employeeList) {
				if (temp.getId() == id) {
					exists = true;
					break;
				}
			}
			
			if ( ! exists) {
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				
				System.out.print("Salary: ");
				Double salary = sc.nextDouble();
				
				employeeList.add(new Employee(id, name, salary));
				
				i = i + 1;
			} else {
				System.out.println("Id already exists! Insert a different Id!");
			}
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		id = sc.nextInt();
		for (Employee temp : employeeList) {
			if (temp.getId() == id) {
				System.out.print("Enter percentage: ");
				double percentage = sc.nextDouble();
				temp.increaseSalary(percentage);
				break;
			}			
		} 
		
		for (Employee temp : employeeList) {
			System.out.println(temp);
		}
		sc.close();
	}

}
