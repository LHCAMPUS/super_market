package com.lh.super_market.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.dao.impl.UserDAOImpl;
import com.lh.super_market.entity.User;
import com.lh.super_market.entity.User;
import com.lh.super_market.service.UserService;
import com.lh.super_market.util.Result;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	public Result<User> loginVerification(String userName, String password) {
		User user = userDAOImpl.queryByName(userName);
		if(user == null){
			return Result.create("USER_NULL", "用户名不存在");
		}
		if (!user.getPassword().equals(password)) {
			System.err.println("密码不同");
			return Result.create("PASSWORD_ERROR", "密码错误");
		}
		return Result.createForOk(user);
	}

	@Override
	public List<User> query() {
		List<User> list = userDAOImpl.query();
		return list;
	}

	@Override
	public boolean update(User model) {
		return userDAOImpl.update(model);
	}

	@Override
	public boolean delete(int id) {
		return userDAOImpl.delete(id);
	}

	@Override
	public int add(User model) {
		model.setDel(0);
		return userDAOImpl.add(model);
	}

	@Override
	public List<User> queryByStr(Map map) {
		return userDAOImpl.queryByStr(map);
	}

	@Override
	public User queryById(int id) {
		return userDAOImpl.queryById(id);
	}

	public PageInfo<User> queryByPage(int pageIndex, int pageSize, String strWhere) {
		Map<String, String> map = new HashMap<String, String>();
		String str = strWhere==null?"1=1":strWhere;
		map.put("strWhere", str);
		return userDAOImpl.queryByPage(pageIndex, pageSize, map);
	}

}
