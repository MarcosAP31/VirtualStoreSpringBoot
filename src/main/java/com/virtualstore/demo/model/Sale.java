package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int SaleId;
	public float Price;
	public String Date;
	public String State;
	public int ClientId;
	public int UserId;
	public Sale() {
	}
	public Sale(int SaleId,float Price,String Date,String State,int ClientId,int UserId) {
		super();
		this.SaleId = SaleId;
		this.Price = Price;
		this.Date = Date;
		this.State = State;
		this.ClientId = ClientId;
		this.UserId = UserId;
	}
	public int getSaleId() {
		return SaleId;
	}
	public void setSaleId(int SaleId) {
		this.SaleId = SaleId;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String getState() {
		return State;
	}
	public void setState(String State) {
		this.State = State;
	}
	public int getClientId() {
		return UserId;
	}
	public void setClientId(int ClientId) {
		this.ClientId = ClientId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
}
