package com.qa.ims.persistence.domain;

public class Item {
	private Long item_id;
	private String item_name;
	private Long item_value;
	
	public Item(String item_name, Long item_value) {
		this.setItemName(item_name);
		this.setItemValue(item_value);
	}
	
	public Item(Long item_id, String item_name, Long item_value) {
		this.setItemID(item_id);
		this.setItemName(item_name);
		this.setItemValue(item_value);
	}
	
	public Long getItemID() {
		return item_id;
	}
	public void setItemID(Long item_id) {
		this.item_id = item_id;
	}
	
	public String getItemName() {
		return item_name;
	}
	public void setItemName(String item_name) {
		this.item_name = item_name;
	}
	
	public Long getItemValue() {
		return item_value;
	}
	public void setItemValue(Long item_value) {
		this.item_value = item_value;
	}
	
	@Override
	public String toString() {
		return "Item ID: " + item_id + " Item Name: " + item_name + " Item Value: " + item_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_value == null) ? 0 : item_value.hashCode());
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_value == null) {
			if (other.item_value != null)
				return false;
		} else if (!item_value.equals(other.item_value))
			return false;
		return true;
	}

}
