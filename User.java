package com.voizfonica.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	private int id;
	private String emailid;
	private String username;
	private String password;
	private String mobilenumber;

	public User() {
	}

	public User(int id, String emailId, String userName, String password, String mobileNumber) {
		super();
		this.id = id;
		this.emailid = emailId;
		this.username = userName;
		this.password = password;
		this.mobilenumber = mobileNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setId(int id) {
		this.id = id;
	}

}
