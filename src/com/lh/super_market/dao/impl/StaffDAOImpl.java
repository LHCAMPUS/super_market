package com.lh.super_market.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.StaffDAO;
import com.lh.super_market.entity.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Staff.";
	
	@Override
	public List<Staff> query() {
		List<Staff> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Staff model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public int add(Staff model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getStaff_id();
	}

}
