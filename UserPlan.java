package com.voizfonica.project;

import java.sql.Date;

public class UserPlan {
	private int planid;
	private String plandescription;
	private String plantype;
	private String planvalidity;
	private String planamount;
	private int planprice;
	private Date plandate;
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
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
	public int getPlanprice() {
		return planprice;
	}
	public void setPlanprice(int planprice) {
		this.planprice = planprice;
	}
	public Date getPlandate() {
		return plandate;
	}
	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

}
