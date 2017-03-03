package com.lh.super_market.entity;

import java.io.Serializable;

public class Staff implements Serializable{

	private int staff_id;
	private String staff_name;
	private String staff_sex;
	private int staff_age;
	private String staff_title;
	private double staff_wage;
	private String staff_address;
	private String staff_phone;
	private int del;
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_sex() {
		return staff_sex;
	}
	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}
	public int getStaff_age() {
		return staff_age;
	}
	public void setStaff_age(int staff_age) {
		this.staff_age = staff_age;
	}
	public String getStaff_title() {
		return staff_title;
	}
	public void setStaff_title(String staff_title) {
		this.staff_title = staff_title;
	}
	public double getStaff_wage() {
		return staff_wage;
	}
	public void setStaff_wage(double staff_wage) {
		this.staff_wage = staff_wage;
	}
	public String getStaff_address() {
		return staff_address;
	}
	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	
	
	
	
}
