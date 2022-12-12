package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {
	private Integer id;
	private Date moment;
	private OrderStatus order;
	
	public Order() {
		
	}

	public Order(Integer id, Date moment, OrderStatus order) {
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", order=" + order + "]";
	}
	
	
}
