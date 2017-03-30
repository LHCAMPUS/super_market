package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.OuthousingDAO;
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.entity.Outhousing;

@Repository
public class OuthousingDAOImpl implements OuthousingDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Outhousing.";
	
	@Override
	public List<Outhousing> query() {
		List<Outhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Outhousing model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Outhousing model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getOuthousing_id();
	}

	@Override
	public List<Outhousing> queryByStr(Map map) {
		List<Outhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}

	@Override
	public Outhousing queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "outhousing_id="+id);
		List<Outhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

	@Override
	public PageInfo<Outhousing> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Outhousing> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<Outhousing> page = new PageInfo<Outhousing>(list);
		return page;
	}
}
