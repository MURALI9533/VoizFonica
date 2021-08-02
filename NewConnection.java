package com.voizfonica.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newconnection")
public class NewConnection {

	private int id;
	private String emailid;
	private String username;
	private String address;
	private String  alternatemobilenumber;
	private String connectiontype;
	public NewConnection() {}
	public NewConnection(String emailid,String username,String address,String  alternatemobilenumber,String connectiontype) {
		this.emailid=emailid;
		this.username=username;
		this.address=address;
		this.alternatemobilenumber=alternatemobilenumber;
		this.connectiontype=connectiontype;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAlternatemobilenumber() {
		return alternatemobilenumber;
	}
	public void setAlternatemobilenumber(String alternatemobilenumber) {
		this.alternatemobilenumber = alternatemobilenumber;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConnectiontype() {
		return connectiontype;
	}
	public void setConnectiontype(String connectiontype) {
		this.connectiontype = connectiontype;
	}
	

}
