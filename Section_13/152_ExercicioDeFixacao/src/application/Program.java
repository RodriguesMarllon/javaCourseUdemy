package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateTimeLocal = LocalDateTime.now();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String stringBirthDate = sc.nextLine();
		
		LocalDate localDateBirthDate = LocalDate.parse(stringBirthDate, fmt1);	// Converte String para LocalDate.
		Date birthDate = java.sql.Date.valueOf(localDateBirthDate);             // Converte LocalDate para Date.
		Client client = new Client(name, email, birthDate);						// Criando cliente.
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		sc.nextLine();
		Order order = new Order(birthDate, OrderStatus.valueOf(status), client); // Criando ordem.
		
		
		for (int i=1; i<=items; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
			sc.nextLine();
		}
		System.out.println();
		
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + dateTimeLocal.format(fmt2));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + client.toString());
		System.out.println("Order items:");
		System.out.println(order.toString());
		System.out.println("Total price: $" + order.total());
		
		sc.close();
	}

}
