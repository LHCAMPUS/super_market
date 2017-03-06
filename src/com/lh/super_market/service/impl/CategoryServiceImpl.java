package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public int add(Category model) {
		model.setDel(0);
		return categoryDAOImpl.add(model);
	}

	@Override
	public List<Category> queryByStr(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

}
