package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.ViperDAOImpl;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.entity.Viper;
import com.lh.super_market.service.ViperService;

@Service
public class ViperServiceImpl implements ViperService{

	@Autowired
	private ViperDAOImpl viperDAOImpl;
	
	@Override
	public List<Viper> query() {
		List<Viper> list = viperDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Viper model) {
		return viperDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return viperDAOImpl.delete(id);
	}

	@Override
	public int add(Viper model) {
		model.setDel(0);
		return viperDAOImpl.add(model);
	}

	@Override
	public List<Viper> queryByStr(Map map) {
		return viperDAOImpl.queryByStr(map);
	}

	@Override
	public Viper queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PageInfo<Viper> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return viperDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
