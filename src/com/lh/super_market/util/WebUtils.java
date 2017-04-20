package com.lh.super_market.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lh.super_market.entity.User;

public class WebUtils {

	public static User getCurrUser() {
		HttpSession session = Servlets.getRequest().getSession();
		Object user = session.getAttribute("user");
		return user == null ? null : (User) user;
	}
	
	public static void setCurrentUser(User currentUser) {
		HttpServletRequest request = Servlets.getRequest();
		request.getSession().invalidate();
		request.getSession(true).setAttribute("user", currentUser);
	}
	
	public static void removeUser(){
		HttpSession session = Servlets.getRequest().getSession();
		session.removeAttribute("user");
	}
}
