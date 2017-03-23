package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.CategoryDAO;
import com.lh.super_market.entity.Category;
import com.lh.super_market.entity.Goods;

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
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Category model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getCategory_id();
	}

	@Override
	public List<Category> queryByStr(Map map) {
		List<Category> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}
	
	public Category queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "category_id="+id);
		List<Category> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

}
