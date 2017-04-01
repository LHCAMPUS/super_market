package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.OuthousingDAOImpl;
import com.lh.super_market.entity.Outhousing;
import com.lh.super_market.service.OuthousingService;

@Service
public class OuthousingServiceImpl implements OuthousingService{

	@Autowired
	private OuthousingDAOImpl outhousingDAOImpl;
	
	@Override
	public List<Outhousing> query() {
		List<Outhousing> list = outhousingDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Outhousing model) {
		return outhousingDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return outhousingDAOImpl.delete(id);
	}

	@Override
	public int add(Outhousing model) {
		model.setDel(0);
		return outhousingDAOImpl.add(model);
	}

	@Override
	public List<Outhousing> queryByStr(Map map) {
		return outhousingDAOImpl.queryByStr(map);
	}

	@Override
	public Outhousing queryById(int id) {
		return outhousingDAOImpl.queryById(id);
	}
	
	public PageInfo<Outhousing> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return outhousingDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
