package com.lh.super_market.entity;

import java.io.Serializable;
import java.sql.Date;

public class Goods implements Serializable{

	private int goods_id;
	private String goods_name;
	private double goods_money;
	private double goods_saleMoney;
	private Date goods_date;
	private int goods_counts;
	private int category_id;
	private int warehouse_id;
	private int del;
	
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_money() {
		return goods_money;
	}
	public void setGoods_money(double goods_money) {
		this.goods_money = goods_money;
	}
	public double getGoods_saleMoney() {
		return goods_saleMoney;
	}
	public void setGoods_saleMoney(double goods_saleMoney) {
		this.goods_saleMoney = goods_saleMoney;
	}
	public Date getGoods_date() {
		return goods_date;
	}
	public void setGoods_date(Date goods_date) {
		this.goods_date = goods_date;
	}
	public int getGoods_counts() {
		return goods_counts;
	}
	public void setGoods_counts(int goods_counts) {
		this.goods_counts = goods_counts;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	
	
}
