package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ProductId;
	public String Description;
	public String Category;
	public int Amount;
	public float PurchasePrice;
	public float SalePrice;
	public int SupplierId;
	public String Image;
	public Product() {
		// TODO Auto generated constructor stub	
	}
	public Product(int ProductId, String Description, String Category, int Amount, float PurchasePrice, float SalePrice,
			int SupplierId, String Image) {
		super();
		this.ProductId = ProductId;
		this.Description = Description;
		this.Category = Category;
		this.Amount = Amount;
		this.PurchasePrice = PurchasePrice;
		this.SalePrice = SalePrice;
		this.SupplierId = SupplierId;
		this.Image = Image;
		
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public float getPurchasePrice() {
		return PurchasePrice;
	}

	public void setPurchasePrice(float PurchasePrice) {
		this.PurchasePrice = PurchasePrice;
	}

	public float getSalePrice() {
		return SalePrice;
	}

	public void setSalePrice(float SalePrice) {
		this.SalePrice = SalePrice;
	}

	public int getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(int SupplierId) {
		this.SupplierId = SupplierId;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

	
}
