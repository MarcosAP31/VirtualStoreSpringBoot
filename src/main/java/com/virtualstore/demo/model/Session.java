package com.virtualstore.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int SessionId;
	public String LoginTime;
	public String LogoutTime;
	public int UserId;
	public Session() {
	}
	public Session(int SessionId,String LoginTime,String LogoutTime,int UserId) {
		super();
		this.SessionId = SessionId;
		this.LoginTime = LoginTime;
		this.LogoutTime = LogoutTime;
		this.UserId = UserId;
	}
	public int getSessionId() {
		return SessionId;
	}
	public void setSessionId(int SessionId) {
		this.SessionId = SessionId;
	}
	public String getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(String LoginTime) {
		this.LoginTime = LoginTime;
	}
	public String getLogoutTime() {
		return LogoutTime;
	}
	public void setLogoutTime(String LogoutTime) {
		this.LogoutTime = LogoutTime;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int UserId) {
		this.UserId = UserId;
	}
}
