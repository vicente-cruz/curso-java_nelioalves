package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class ExemploEnumeracao {

	public static void main(String[] args) {
		// Criar ENUM em "New -> Enum"
		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);		
		System.out.println(order);
		
		// Convertendo STRING para ENUM
		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		System.out.println("Objeto os1: "+ os1+", Objeto os2: "+os2);
	}

}
