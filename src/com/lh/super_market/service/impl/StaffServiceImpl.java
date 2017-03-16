package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.super_market.dao.impl.StaffDAOImpl;
import com.lh.super_market.entity.Staff;
import com.lh.super_market.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffDAOImpl staffDAOImpl;
	
	@Override
	public List<Staff> query() {
		List<Staff> list = staffDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Staff model) {
		return staffDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return staffDAOImpl.delete(id);
	}

	@Override
	public int add(Staff model) {
		System.err.println("sex:"+model.getStaff_sex());
		model.setDel(0);
		return staffDAOImpl.add(model);
	}

	@Override
	public List<Staff> queryByStr(Map map) {
		return staffDAOImpl.queryByStr(map);
	}

	@Override
	public Staff queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
