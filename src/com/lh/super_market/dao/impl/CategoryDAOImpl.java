package com.lh.super_market.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.CategoryDAO;
import com.lh.super_market.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Category.";
	
	@Override
	public List<Category> query() {
		List<Category> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
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
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getCategory_id();
	}

	@Override
	public List<Category> queryByStr(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

}
