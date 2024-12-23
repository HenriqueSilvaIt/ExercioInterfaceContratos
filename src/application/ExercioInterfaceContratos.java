package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class ExercioInterfaceContratos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter with  contract data: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/mm/yyyy): ");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt); 
		System.out.print("Enter with contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Enter with installment numbers: ");
			
		Contract contract = new  Contract(number, date, totalValue); // instanciando objeto
		
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(contract, n);
		
		System.out.println("Parcelas: ");
		
		for (Installment installment : contract.getList())	{
			
				System.out.println(installment);
		}
		
		sc.close();

	}

}
