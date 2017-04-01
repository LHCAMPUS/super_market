package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.GoodsDAOImpl;
import com.lh.super_market.entity.Goods;
import com.lh.super_market.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAOImpl goodsDAOImpl;
	
	@Override
	public List<Goods> query() {
		List<Goods> list = goodsDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(Goods model) {
		return goodsDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return goodsDAOImpl.delete(id);
	}

	@Override
	public int add(Goods model) {
		model.setDel(0);
		return goodsDAOImpl.add(model);
	}

	@Override
	public List<Goods> queryByStr(Map map) {
		return goodsDAOImpl.queryByStr(map);
	}

	@Override
	public Goods queryById(int id) {
		return goodsDAOImpl.queryById(id);
	}

	public PageInfo<Goods> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return goodsDAOImpl.queryByPage(pageIndex, pageSize, map);
	}
}
