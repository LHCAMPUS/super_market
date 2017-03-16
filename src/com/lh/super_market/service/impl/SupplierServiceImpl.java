package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.super_market.dao.impl.SupplierDAOImpl;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
