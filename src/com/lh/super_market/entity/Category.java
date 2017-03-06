package com.lh.super_market.entity;

public class Category {

	private int category_id;
	private String category_name;
	private String category_remark;
	private int del;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_remark() {
		return category_remark;
	}
	public void setCategory_remark(String category_remark) {
		this.category_remark = category_remark;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
}
