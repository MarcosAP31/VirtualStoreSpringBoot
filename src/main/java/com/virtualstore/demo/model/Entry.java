package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entry")
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int EntryId;
	public String Date;
	public int Amount;
	public int ProductId;
	public int UserId;
	public Entry() {
	}
	public Entry(int EntryId,String Date,int Amount,int ProductId,int UserId) {
		super();
		this.EntryId = EntryId;
		this.Date = Date;
		this.Amount = Amount;
		this.ProductId = ProductId;
		this.UserId = UserId;
	}
	public int getEntryId() {
		return EntryId;
	}
	public void setEntryId(int EntryId) {
		this.EntryId = EntryId;
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
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
}
