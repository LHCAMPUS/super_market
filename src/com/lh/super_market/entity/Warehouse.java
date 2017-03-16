package com.lh.super_market.entity;

import java.io.Serializable;

public class Warehouse implements Serializable{

	private int warehouse_id;
	private String warehouse_name;
	private String warehouse_address;
	private int del;
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}
	public String getWarehouse_address() {
		return warehouse_address;
	}
	public void setWarehouse_address(String warehouse_address) {
		this.warehouse_address = warehouse_address;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	
}
