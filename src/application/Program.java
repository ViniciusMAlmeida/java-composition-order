package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;
import entities.Product;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthdate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthdate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		sc.nextLine();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
		
		for(int i=1; i<=itemsQuantity; i++) {
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantidy = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantidy, productPrice, product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order.toString());
		
		sc.close();
	}
}
