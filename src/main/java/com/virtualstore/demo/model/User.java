package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int UserId;
	public String Name;
	public String LastName;
	public String Birthday;
	public String Sex;
	public String Department;
	public String Province;
	public String District;
	public String Direction;
	public long Phone;
	public String UserName;
	public String Email;
	public String Password;
	public String Status;
	public String Image;
	public User() {
		// TODO Auto generated constructor stub
		this.Phone = 0;
	}
	public User(int UserId,String Name,String LastName,String Birthday,String Sex,String Department,
			String Province,String District,String Direction,long Phone,String UserName,String Email,String Password,String Status,String Image) {
		super();
		this.UserId = UserId;
		this.Name = Name;
		this.LastName = LastName;
		this.Birthday = Birthday;
		this.Sex = Sex;
		this.Department = Department;
		this.Province = Province;
		this.District = District;
		this.Direction = Direction;
		this.Phone = Phone;
		this.UserName=UserName;
		this.Email = Email;
		this.Password = Password;
		this.Status = Status;
		this.Image = Image;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
	}

}
