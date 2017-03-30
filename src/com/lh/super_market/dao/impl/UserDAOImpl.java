package com.lh.super_market.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.UserDAO;
import com.lh.super_market.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String NAMESPACE = "User.";
	
	@Override
	public List<User> query() {
		List<User> list = sqlSessionTemplate.selectList(NAMESPACE+"selectAll");
		return list;
	}

	@Override
	public boolean update(User model) {
		int result = sqlSessionTemplate.update(NAMESPACE+"update", model);
		return result > 0 ? true : false;
	}

	@Override
	public boolean delete(int id) {
		int result = sqlSessionTemplate.update(NAMESPACE+"deleteByPrimaryKey", id);
		return result > 0 ? true : false;
	}

	@Override
	public int add(User model) {
		sqlSessionTemplate.insert(NAMESPACE+"insert", model);
		return model.getId();
	}

	@Override
	public List<User> queryByStr(Map map) {
		List<User> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list;
	}
	
	@Override
	public User queryById(int id) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "id="+id);
		List<User> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.get(0);
	}
	
	public User queryByName(String username) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "username='"+username+"'");
		List<User> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere", map);
		return list.size()>0?list.get(0):null;
	}

	@Override
	public PageInfo<User> queryByPage(int pageIndex, int pageSize, Map map) {
		PageHelper.startPage(pageIndex,pageSize);
		List<User> list = sqlSessionTemplate.selectList(NAMESPACE+"selectBystrWhere",map);
		PageInfo<User> page = new PageInfo<User>(list);
		return page;
	}
}
