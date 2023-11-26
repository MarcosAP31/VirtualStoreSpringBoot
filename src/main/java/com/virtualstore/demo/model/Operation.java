package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int OperationId;
	public String Date;
	public String Description;
	public int ProductId;
	public Operation() {
	}
	public Operation(int OperationId,String Date,String Description,int ProductId) {
		super();
		this.OperationId = OperationId;
		this.Date = Date;
		this.Description = Description;
		this.ProductId = ProductId;
	}
	public int getOperationId() {
		return OperationId;
	}
	public void setOperationId(int OperationId) {
		this.OperationId = OperationId;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
}
