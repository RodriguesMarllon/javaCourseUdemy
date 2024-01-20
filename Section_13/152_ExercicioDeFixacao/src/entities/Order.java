package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public String total() {
		double sum = 0.0;
		for (OrderItem c: items) {
			sum += c.subTotal();
		}
		return String.format("%.2f" , sum);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
			for (OrderItem c: items) {
				sb.append(c.getProduct().getName() + ", ");
				sb.append("$" + String.format("%.2f", c.getProduct().getPrice()) + ", ");
				sb.append("Quantity: " + c.getQuantity() + ", ");
				sb.append("Subtotal: " + "$" +  String.format("%.2f", c.subTotal()) + "\n");
			}
		return sb.toString();
	}
}
