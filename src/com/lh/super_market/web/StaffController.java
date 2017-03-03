package com.lh.super_market.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.super_market.entity.Staff;
import com.lh.super_market.service.impl.StaffServiceImpl;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffServiceImpl staffServiceImpl;
	
	@RequestMapping("/staffList.do")
	public String query(Model model){
		List<Staff> list = staffServiceImpl.query();
		model.addAttribute("list", list);
		return "staff/list";
	}
	
	@RequestMapping(value = "/addStaff.do", method = RequestMethod.GET)
	public String addStaff(){
		return "staff/add";
	}
	
	@RequestMapping(value = "/addStaff.do", method = RequestMethod.POST)
	public String addStaffInfo(Staff staff){
		staffServiceImpl.add(staff);
		return "staff/add";
	}
	
	
}
