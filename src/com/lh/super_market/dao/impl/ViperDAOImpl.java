package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.ViperDAO;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.entity.User;
import com.lh.super_market.entity.Viper;

@Repository
public class ViperDAOImpl implements ViperDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Viper.";
	
	@Override
	public List<Viper> query() {
		List<Viper> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Viper model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Viper model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getVip_id();
	}

	@Override
	public List<Viper> queryByStr(Map map) {
		List<Viper> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}

	@Override
	public Viper queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "viper_id="+id);
		List<Viper> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

	@Override
	public PageInfo<Viper> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Viper> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<Viper> page = new PageInfo<Viper>(list);
		return page;
	}
}
