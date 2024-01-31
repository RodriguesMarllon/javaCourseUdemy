package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas: ");
		Integer n = sc.nextInt();
		

		ContractService contractService = new ContractService(null);
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas: ");
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();
	}
}
