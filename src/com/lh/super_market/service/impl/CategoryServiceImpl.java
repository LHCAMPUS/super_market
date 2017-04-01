package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.CategoryDAOImpl;
import com.lh.super_market.entity.Category;
import com.lh.super_market.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAOImpl categoryDAOImpl;
	
	@Override
	public List<Category> query() {
		List<Category> list = categoryDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Category model) {
		return categoryDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return categoryDAOImpl.delete(id);
	}

	@Override
	public int add(Category model) {
		model.setDel(0);
		return categoryDAOImpl.add(model);
	}

	@Override
	public List<Category> queryByStr(Map map) {
		return categoryDAOImpl.queryByStr(map);
	}

	@Override
	public Category queryById(int id) {
		Category category = categoryDAOImpl.queryById(id);
		return category;
	}
	
	public PageInfo<Category> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return categoryDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
