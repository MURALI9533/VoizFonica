package com.voizfonica.project;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billing")
public class Billing {
	private int billid;

	private double rcharge;
	private double cgst;
	private double sgst;
	@Column(name="tAmount")
	private double totalamount;
	private Date date;
	private int customerid;
	public Billing() {
		super();
	}
	public Billing(int billid, double acharge, double cgst, double sgst, double totalamount, Date date,
			int customerid) {
		super();
		this.billid = billid;
		this.setRcharge(acharge);
		this.cgst = cgst;
		this.sgst = sgst;
		this.totalamount = totalamount;
		this.date = date;
		this.customerid = customerid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getbillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}

	@Override
	public String toString() {
		return "Billing [billid=" + billid + ", rcharge=" + rcharge + ", cgst=" + cgst + ", sgst=" + sgst
				+ ", totalamount=" + totalamount + ", date=" + date + ", customerid=" + customerid + "]";
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public double getRcharge() {
		return rcharge;
	}
	public void setRcharge(double rcharge) {
		this.rcharge = rcharge;
	}

	
	



}
