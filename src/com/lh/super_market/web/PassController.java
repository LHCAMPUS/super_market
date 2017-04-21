package com.lh.super_market.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.super_market.entity.User;
import com.lh.super_market.service.impl.UserServiceImpl;
import com.lh.super_market.util.Jacksons;
import com.lh.super_market.util.Result;
import com.lh.super_market.util.WebUtils;

@Controller
public class PassController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String index() {
		return "main";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String user, String passw){
		if (StringUtils.isEmpty(user) || StringUtils.isEmpty(passw)) {
			return "redirect:/login.do";
		}
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/exit.do", method = RequestMethod.GET)
	public String exit(){
		WebUtils.removeUser();
		return "redirect:/login.do";
	}
	
	@RequestMapping(value = "/loginVer.do", produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String loginVerification(String user,String passw){
		Result<User> result = userServiceImpl.loginVerification(user, passw);
		System.out.println("loginver进来了");
		if(result.isOk()){
			WebUtils.setCurrentUser(result.getValue());
		}
		return Jacksons.writeJson(result);
	}
}
