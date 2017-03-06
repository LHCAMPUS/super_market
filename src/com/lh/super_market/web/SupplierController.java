package com.lh.super_market.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.super_market.entity.Supplier;
import com.lh.super_market.service.impl.SupplierServiceImpl;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierServiceImpl supplierServiceImpl;
	
	@RequestMapping("/supplierList.do")
	public String query(Model model){
		List<Supplier> list = supplierServiceImpl.query();
		model.addAttribute("list", list);
		return "supplier/list";
	}
	
	@RequestMapping(value = "/addSupplier.do", method = RequestMethod.GET)
	public String addSupplier(){
		return "supplier/add"; 
	}
	
	@RequestMapping(value = "/addSupplier.do", method = RequestMethod.POST)
	public String addSupplierInfo(Supplier supplier){
		supplierServiceImpl.add(supplier);
		return "supplier/add";
	}
	
	
}
