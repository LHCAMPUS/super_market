package com.lh.super_market.base.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

	public List<T> query();
	public boolean update(T model);
	public boolean delete(int id);
	public int add(T model);
	public List<T> queryByStr(Map map);
	
}
