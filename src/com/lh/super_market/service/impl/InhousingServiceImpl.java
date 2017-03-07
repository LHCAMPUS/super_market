package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.super_market.dao.impl.InhousingDAOImpl;
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.service.InhousingService;

@Service
public class InhousingServiceImpl implements InhousingService{

	@Autowired
	private InhousingDAOImpl inhousingDAOImpl;
	
	@Override
	public List<Inhousing> query() {
		List<Inhousing> list = inhousingDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Inhousing model) {
		return inhousingDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return inhousingDAOImpl.delete(id);
	}

	@Override
	public int add(Inhousing model) {
		model.setDel(0);
		return inhousingDAOImpl.add(model);
	}

	@Override
	public List<Inhousing> queryByStr(Map map) {
		return inhousingDAOImpl.queryByStr(map);
	}

}
