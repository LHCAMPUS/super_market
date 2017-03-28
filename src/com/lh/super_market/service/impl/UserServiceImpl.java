package com.lh.super_market.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.super_market.dao.impl.UserDAOImpl;
import com.lh.super_market.entity.User;
import com.lh.super_market.service.UserService;
import com.lh.super_market.util.Result;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAOImpl userDAOImpl;
	
	public Result<User> loginVerification(String userName, String password) {
		User user = userDAOImpl.queryByName(userName);
		if (!user.getPassword().equals(password)) {
			System.err.println("密码不同");
			return Result.create("PASSWORD_ERROR", "密码错误");
		}
		return Result.createForOk(user);
	}

	@Override
	public List query() {
		return null;
	}

	@Override
	public boolean update(Object model) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public int add(Object model) {
		return 0;
	}

	@Override
	public List queryByStr(Map map) {
		return null;
	}

	@Override
	public Object queryById(int id) {
		return null;
	}

}
