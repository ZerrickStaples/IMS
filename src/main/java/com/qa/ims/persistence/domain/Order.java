package com.qa.ims.persistence.domain;

public class Order {
	private Long order_id;
	private Long customer_id;
	private Long item_id;
	
	public Order(Long customer_id, Long item_id) {
		this.setCustomerID(customer_id);
		this.setItemID(item_id);
	}
	
	public Order(Long order_id, Long customer_id, Long item_id) {
		this.setOrderID(order_id);
		this.setCustomerID(customer_id);
		this.setItemID(item_id);
	}
	
	public Long getOrderID() {
		return order_id;
	}
	public void setOrderID(Long order_id) {
		this.order_id = order_id;
	}
	public Long getCustomerID() {
		return customer_id;
	}
	public void setCustomerID(Long customer_id) {
		this.customer_id = customer_id;
	}
	
	public Long getItemID() {
		return item_id;
	}
	public void setItemID(Long item_id) {
		this.item_id = item_id;
	}

	
	@Override
	public String toString() {
		return "Order ID: " + order_id + " Customer ID: " + customer_id+ " Item ID: " + item_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getCustomerID() == null) {
			if (other.getCustomerID() != null)
				return false;
		} else if (!getCustomerID().equals(other.getCustomerID()))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		return true;
	}

}
