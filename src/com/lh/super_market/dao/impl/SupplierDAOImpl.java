package com.lh.super_market.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.SupplierDAO;
import com.lh.super_market.entity.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Supplier.";
	
	@Override
	public List<Supplier> query() {
		List<Supplier> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Supplier model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public int add(Supplier model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getSupplier_id();
	}

	@Override
	public List<Supplier> queryByStr(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
