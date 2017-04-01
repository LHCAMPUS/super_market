package com.lh.super_market.entity;

import java.sql.Date;


public class Outhousing {

	private int outhousing_id;
	private int goods_counts;
	private Date outhousing_date;
	private int supplier_id;
	private int goods_id;
	private int del;
	private int warehouse_id;
	public int getOuthousing_id() {
		return outhousing_id;
	}
	public void setOuthousing_id(int outhousing_id) {
		this.outhousing_id = outhousing_id;
	}
	public int getGoods_counts() {
		return goods_counts;
	}
	public void setGoods_counts(int goods_counts) {
		this.goods_counts = goods_counts;
	}
	public Date getOuthousing_date() {
		return outhousing_date;
	}
	public void setOuthousing_date(Date outhousing_date) {
		this.outhousing_date = outhousing_date;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
