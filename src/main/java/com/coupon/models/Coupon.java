package com.coupon.models;

import java.math.BigDecimal;

public class Coupon {
	private int cid;
	private String ccode;
	private BigDecimal discount;
	private String edate;

	public Coupon() {
	}

	protected Coupon(int cid, String ccode, BigDecimal discount, String edate) {
		super();
		this.cid = cid;
		this.ccode = ccode;
		this.discount = discount;
		this.edate = edate;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
}
