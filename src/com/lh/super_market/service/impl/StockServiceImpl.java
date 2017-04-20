package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.StockDAOImpl;
import com.lh.super_market.entity.Stock;
import com.lh.super_market.service.StockService;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockDAOImpl stockDAOImpl;
	
	@Override
	public List<Stock> query() {
		List<Stock> list = stockDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Stock model) {
		return stockDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return stockDAOImpl.delete(id);
	}

	@Override
	public int add(Stock model) {
		model.setDel(0);
		return stockDAOImpl.add(model);
	}

	@Override
	public List<Stock> queryByStr(Map map) {
		return stockDAOImpl.queryByStr(map);
	}

	@Override
	public Stock queryById(int id) {
		Stock Stock = stockDAOImpl.queryById(id);
		return Stock;
	}
	
	public PageInfo<Stock> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null||strWhere==""?" and 1=1":strWhere;
		map.put("strWhere", str);
		return stockDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
