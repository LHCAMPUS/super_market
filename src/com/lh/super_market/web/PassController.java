package com.lh.super_market.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping(value = "/password.do", method = RequestMethod.GET)
	public String password() {
		return "password";
	}
	
	@RequestMapping(value = "/password.do", method = RequestMethod.POST)
	@ResponseBody
	public String password2(String password2, HttpServletResponse response) {
		User user = WebUtils.getCurrUser();
		user.setPassword(password2);
		boolean b = userServiceImpl.update(user);
		outStr(b, response, "修改密码");
		return null;
	}
	
	@RequestMapping(value = "/passwordVer.do", method = RequestMethod.POST)
	@ResponseBody
	public String passwordVer(String repassword) {
		System.out.println("repass:"+repassword);
		User user = WebUtils.getCurrUser();
		System.err.println("pass:"+user.getPassword());
		if(!user.getPassword().equals(repassword)){
			return "1";
		}
		return "0";
	}
	
	public void outStr(boolean b, HttpServletResponse response, String errMess){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='goodsList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('"+errMess+"操作失败');window.location.href='goodsList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
