package com.lh.super_market.base.dao;

import java.util.List;

import com.lh.super_market.entity.Staff;

public interface BaseDAO<T> {

	public List<T> query();
	public boolean update(T model);
	public boolean delete(int id);
	public int add(T model);
	
}
