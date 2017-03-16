package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.super_market.dao.impl.WarehouseDAOImpl;
import com.lh.super_market.entity.Category;
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseDAOImpl warehouseDAOImpl;
	
	@Override
	public List<Warehouse> query() {
		List<Warehouse> list = warehouseDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Warehouse model) {
		return warehouseDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return warehouseDAOImpl.delete(id);
	}

	@Override
	public int add(Warehouse model) {
		model.setDel(0);
		return warehouseDAOImpl.add(model);
	}

	@Override
	public List<Warehouse> queryByStr(Map map) {
		return warehouseDAOImpl.queryByStr(map);
	}

	@Override
	public Warehouse queryById(int id) {
		Warehouse warehouse = warehouseDAOImpl.queryById(id);
		return warehouse;
	}

}
