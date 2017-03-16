package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.WarehouseDAO;
import com.lh.super_market.entity.Category;
import com.lh.super_market.entity.Warehouse;

@Repository
public class WarehouseDAOImpl implements WarehouseDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Warehouse.";
	
	@Override
	public List<Warehouse> query() {
		List<Warehouse> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Warehouse model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Warehouse model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getWarehouse_id();
	}

	@Override
	public List<Warehouse> queryByStr(Map map) {
		List<Warehouse> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}
	
	public Warehouse queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "warehouse_id="+id);
		List<Warehouse> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

}
