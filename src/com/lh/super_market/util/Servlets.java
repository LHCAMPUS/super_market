package com.lh.super_market.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Servlets {

	public static HttpServletRequest getRequest() {
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		return sra.getRequest();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static HttpSession getSession(boolean isCreate) {
		return getRequest().getSession(isCreate);
	}
}
