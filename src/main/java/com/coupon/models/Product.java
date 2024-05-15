package com.coupon.models;

import java.math.BigDecimal;

public class Product {
	private int pid;
	private String pname;
	private String description;
	private BigDecimal price;
	private String ccode;

	public Product() {
	}

	protected Product(int pid, String pname, String description, BigDecimal price, String ccode) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.description = description;
		this.price = price;
		this.ccode = ccode;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
}
