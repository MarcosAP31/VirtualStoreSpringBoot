package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ClientId;
	public String Name;
	public String LastName;
	public String Birthday;
	public String Sex;
	public String Department;
	public String Province;
	public String District;
	public String Direction;
	public long Phone;
	public String Email;
	public String Image;
	public Client() {
		// TODO Auto generated constructor stub
		this.Phone = 0;
	}
	public Client(int ClientId, String Name, String LastName, String Birthday, String Sex, String Department,
			String Province, String District, String Direction, long Phone, String Email, String Image) {
		super();
		this.ClientId = ClientId;
		this.Name = Name;
		this.LastName = LastName;
		this.Birthday = Birthday;
		this.Sex = Sex;
		this.Department = Department;
		this.Province = Province;
		this.District = District;
		this.Direction = Direction;
		this.Phone = Phone;
		this.Email = Email;
		this.Image = Image;
	}

	public int getClientId() {
		return ClientId;
	}

	public void setClientId(int ClientId) {
		this.ClientId = ClientId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String Birthday) {
		this.Birthday = Birthday;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String Sex) {
		this.Sex = Sex;
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

	public String getImage() {
		return Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

}
