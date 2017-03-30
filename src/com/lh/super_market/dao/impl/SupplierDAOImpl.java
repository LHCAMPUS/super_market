package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.SupplierDAO;
import com.lh.super_market.entity.Outhousing;
import com.lh.super_market.entity.Staff;
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
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Supplier model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getSupplier_id();
	}

	@Override
	public List<Supplier> queryByStr(Map map) {
		List<Supplier> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}

	@Override
	public Supplier queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "supplier_id="+id);
		List<Supplier> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

	@Override
	public PageInfo<Supplier> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Supplier> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<Supplier> page = new PageInfo<Supplier>(list);
		return page;
	}

}
