package com.lh.super_market.dao.impl;

import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.StaffDAO;
import com.lh.super_market.entity.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO{

	@Override
	public Staff query() {
		return null;
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
		return 0;
	}

}
