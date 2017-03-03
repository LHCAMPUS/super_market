package com.lh.super_market.base.dao;

public interface BaseDAO<T> {

	public T query();
	public boolean update(T model);
	public boolean delete(int id);
	public int add(T model);
	
}
