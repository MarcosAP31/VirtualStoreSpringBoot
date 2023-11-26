package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int SupplierId;
	public long RUC;
	public String BusinessName;
	public String TradeName;
	public String Kind;
	public String Department;
	public String Province;
	public String District;
	public String Direction;
	public long Phone;
	public String Email;
	public Supplier() {
		// TODO Auto generated constructor stub
		this.Phone = 0;
		this.RUC=0;
	}
	public Supplier(int SupplierId, long RUC, String BusinessName, String TradeName, String Kind, String Department,
			String Province, String District, String Direction, long Phone, String Email, String Image) {
		super();
		this.SupplierId = SupplierId;
		this.RUC = RUC;
		this.BusinessName = BusinessName;
		this.TradeName = TradeName;
		this.Kind = Kind;
		this.Department = Department;
		this.Province = Province;
		this.District = District;
		this.Direction = Direction;
		this.Phone = Phone;
		this.Email = Email;
	}

	public int getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(int SupplierId) {
		this.SupplierId = SupplierId;
	}

	public long getRUC() {
		return RUC;
	}

	public void setRUC(long RUC) {
		this.RUC = RUC;
	}

	public String getBusinessName() {
		return BusinessName;
	}

	public void setBusinessName(String BusinessName) {
		this.BusinessName = BusinessName;
	}

	public String getTradeName() {
		return TradeName;
	}

	public void setTradeName(String TradeName) {
		this.TradeName = TradeName;
	}

	public String getKind() {
		return Kind;
	}

	public void setKind(String Kind) {
		this.Kind = Kind;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String Department) {
		this.Department = Department;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String Province) {
		this.Province = Province;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String District) {
		this.District = District;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String Direction) {
		this.Direction = Direction;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long Phone) {
		this.Phone = Phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}


}
