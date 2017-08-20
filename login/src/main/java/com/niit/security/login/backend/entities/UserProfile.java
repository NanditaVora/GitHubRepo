package com.niit.security.login.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int userID;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String loginID;
	
	
	
	public String password;
	
	public String email;
	
	@Override
	public String toString()
	{
		return "LoginID : " + loginID + " Password : " + password + " EMail : " + email;
	}
	
}
