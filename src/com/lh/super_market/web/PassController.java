package com.lh.super_market.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PassController {

	@RequestMapping("/login.do")
	public String index(){
		System.err.println("====================================");
		return "login";
	}
	@RequestMapping("/main.do")
	public String main(){
		System.err.println("====================================");
		return "main";
	}
}
