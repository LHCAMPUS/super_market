package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.SupplierDAOImpl;
import com.lh.super_market.entity.Goods;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDAOImpl supplierDAOImpl;
	
	@Override
	public List<Supplier> query() {
		List<Supplier> list = supplierDAOImpl.query();
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
		model.setDel(0);
		return supplierDAOImpl.add(model);
	}

	@Override
	public List<Supplier> queryByStr(Map map) {
		return supplierDAOImpl.queryByStr(map);
	}

	@Override
	public Supplier queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageInfo<Supplier> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return supplierDAOImpl.queryByPage(pageIndex, pageSize, map);
	}
}
