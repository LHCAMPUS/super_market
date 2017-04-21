package com.lh.super_market.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lh.super_market.entity.User;
import com.lh.super_market.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/userList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<User> list = userServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "user/list";
	}
	
	@RequestMapping(value = "/addUser.do", method = RequestMethod.GET)
	public String addUser(){
		return "user/add";
	}
	
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public String addUserInfo(User user, HttpServletResponse response){
		int id = userServiceImpl.add(user);
		boolean b = id > 0? true : false;
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public String upUser(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "id="+id);
		List<User> list = userServiceImpl.queryByStr(map);
		model.addAttribute("user", list.get(0));
		return "user/update";
	}
	
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.POST)
	public String upUserInfo(User user, HttpServletResponse response){
		boolean b = userServiceImpl.update(user);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.GET)
	public String deleteUser(String id, HttpServletResponse response){
		boolean b = userServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/userVal.do", method = RequestMethod.POST)
	@ResponseBody
	public String userVal(String userName){
		Map<String, String> map = new HashMap<String, String>();
		map.put("strWhere", "userName='"+userName+"'");
		List<User> list = userServiceImpl.queryByStr(map);
		if(list.size()>0){
			return "1";
		}
		return "0";
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='userList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='userList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
