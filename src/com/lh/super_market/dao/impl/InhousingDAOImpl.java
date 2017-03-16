package com.lh.super_market.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lh.super_market.dao.InhousingDAO;
import com.lh.super_market.entity.Inhousing;

@Repository
public class InhousingDAOImpl implements InhousingDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Inhousing.";
	
	@Override
	public List<Inhousing> query() {
		List<Inhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Inhousing model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Inhousing model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getInhousing_id();
	}

	@Override
	public List<Inhousing> queryByStr(Map map) {
		List<Inhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}
}