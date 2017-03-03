package com.lh.super_market.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@RequestMapping("/staffList.do")
	public String query(){
		return "staff/list";
	}
}
