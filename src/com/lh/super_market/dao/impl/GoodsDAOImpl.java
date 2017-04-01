package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.GoodsDAO;
import com.lh.super_market.entity.Goods;

@Repository
public class GoodsDAOImpl implements GoodsDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "Goods.";
	
	@Override
	public List<Goods> query() {
		List<Goods> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(Goods model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(Goods model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getGoods_id();
	}

	@Override
	public List<Goods> queryByStr(Map map) {
		List<Goods> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}
	
	@Override
	public Goods queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Goods_id="+id);
		List<Goods> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}

	@Override
	public PageInfo<Goods> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<Goods> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		return page;
	}
}
