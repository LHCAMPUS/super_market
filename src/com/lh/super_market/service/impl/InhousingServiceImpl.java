package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
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

	@Override
	public Inhousing queryById(int id) {
		return inhousingDAOImpl.queryById(id);
	}
	
	public PageInfo<Inhousing> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return inhousingDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
