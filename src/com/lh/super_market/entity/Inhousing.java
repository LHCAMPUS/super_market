package com.lh.super_market.entity;

import java.util.Date;

public class Inhousing {

	private int inhousing_id;
	private String goods_name;
	private int goods_counts;
	private int goods_id;
	private int supplier_id;
	private Date inhousing_date;
	private int del;
	private int warehouse_id;
	
	public int getInhousing_id() {
		return inhousing_id;
	}
	public void setInhousing_id(int inhousing_id) {
		this.inhousing_id = inhousing_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_counts() {
		return goods_counts;
	}
	public void setGoods_counts(int goods_counts) {
		this.goods_counts = goods_counts;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Date getInhousing_date() {
		return inhousing_date;
	}
	public void setInhousing_date(Date inhousing_date) {
		this.inhousing_date = inhousing_date;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	
}
