package api.payload;

import java.sql.Date;

import com.github.javafaker.Bool;
import com.github.javafaker.DateAndTime;
import java.time.LocalDateTime;

public class Store {
	
	int id;
	int petId;
	int quantity;
	DateAndTime shipDate;
	String status;
	boolean complete;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	public DateAndTime getShipDate() {
//		return shipDate;
//	}
//	public void setShipDate(DateAndTime dateAndTime) {
//		this.shipDate = dateAndTime;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean bool) {
		this.complete = bool;
	}
	

}
