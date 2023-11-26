package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salexproduct")
public class SaleXProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int SaleXProductId;
	public int Amount;
	public int SaleId;
	public int ProductId;
	public SaleXProduct() {
	}
	public SaleXProduct(int SaleXProductId,int Amount,int SaleId,int ProductId) {
		super();
		this.SaleXProductId = SaleXProductId;
		this.Amount = Amount;
		this.SaleId = SaleId;
		this.ProductId = ProductId;
	}
	public int getSaleXProductId() {
		return SaleXProductId;
	}
	public void setSaleXProductId(int SaleXProductId) {
		this.SaleXProductId = SaleXProductId;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int Amount) {
		this.Amount = Amount; 
	}
	public int getSaleId() {
		return SaleId;
	}
	public void setSaleId(int SaleId) {
		this.SaleId = SaleId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
}
