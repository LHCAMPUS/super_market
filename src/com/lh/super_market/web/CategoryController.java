package com.lh.super_market.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lh.super_market.entity.Category;
import com.lh.super_market.service.impl.CategoryServiceImpl;
import com.lh.super_market.service.impl.StaffServiceImpl;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@RequestMapping("/categoryList.do")
	public String query(Model model){
		List<Category> list = categoryServiceImpl.query();
		model.addAttribute("list", list);
		return "category/list";
	}
	
	@RequestMapping(value = "/addCategory.do", method = RequestMethod.GET)
	public String addStaff(){
		return "category/add";
	}
	
	@RequestMapping(value = "/addCategory.do", method = RequestMethod.POST)
	public String addCategoryInfo(Category category){
		categoryServiceImpl.add(category);
		return "category/add";
	}
	
	
}
