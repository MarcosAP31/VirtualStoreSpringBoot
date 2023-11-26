package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "output")
public class Output {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int OutputId;
	public String Date;
	public int Amount;
	public int ProductId;
	public int ClientId;
	public int UserId;
	public Output() {
	}
	public Output(int OutputId,String Date,int Amount,int ProductId,int ClientId,int UserId) {
		super();
		this.OutputId = OutputId;
		this.Date = Date;
		this.Amount = Amount;
		this.ProductId = ProductId;
		this.ClientId = ClientId;
		this.UserId = UserId;
	}
	public int getOutputId() {
		return OutputId;
	}
	public void setOutputId(int OutputId) {
		this.OutputId = OutputId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int Amount) {
		this.Amount = Amount;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
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
