package com.lh.super_market.base.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface BaseDAO<T> {

	public List<T> query();
	public boolean update(T model);
	public boolean delete(int id);
	public int add(T model);
	public List<T> queryByStr(Map map);
	public T queryById(int id);
	public PageInfo<T> queryByPage(int pageIndex, int pageSize, Map map);
	
}
