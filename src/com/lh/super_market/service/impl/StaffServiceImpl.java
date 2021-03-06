package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
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
	
	public PageInfo<Staff> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return staffDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
