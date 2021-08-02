package com.voizfonica.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plans {
	private int planid;
	private String plandescription;
	private String plantype;
	private String planvalidity;
	private String planamount;
	private int planprice;
	public Plans() {
		
	}
	public Plans(int planid,String plandescription,String plantype,String planvalidity,String planamount,int planprice) {
		super();
		this.planid=planid;
		this.plandescription=plandescription;
		this.plantype=plantype;
		this.planvalidity=planvalidity;
		this.planamount=planamount;
		this.planprice=planprice;
	}
	public int getPlanprice() {
		return planprice;
	}
	public void setPlanprice(int planprice) {
		this.planprice = planprice;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getplanid() {
		return planid;
	}
	public String getPlandescription() {
		return plandescription;
	}
	public void setPlandescription(String plandescription) {
		this.plandescription = plandescription;
	}
	public String getPlantype() {
		return plantype;
	}
	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}
	public String getPlanvalidity() {
		return planvalidity;
	}
	public void setPlanvalidity(String planvalidity) {
		this.planvalidity = planvalidity;
	}
	public String getPlanamount() {
		return planamount;
	}
	public void setPlanamount(String planamount) {
		this.planamount = planamount;
	}
	public void setPlanid(int planId) {
		this.planid=planId;
		
	}


}
