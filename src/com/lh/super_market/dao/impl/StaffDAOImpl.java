package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.StaffDAO;
import com.lh.super_market.entity.Outhousing;
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
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Staff model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getStaff_id();
	}

	@Override
	public List<Staff> queryByStr(Map map) {
		List<Staff> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}

	@Override
	public Staff queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "staff_id="+id);
		List<Staff> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

	@Override
	public PageInfo<Staff> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Staff> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<Staff> page = new PageInfo<Staff>(list);
		return page;
	}
}
