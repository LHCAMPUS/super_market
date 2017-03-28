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

import com.lh.super_market.entity.Category;
import com.lh.super_market.service.impl.CategoryServiceImpl;

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
	
	@RequestMapping(value = "/updateCategory.do", method = RequestMethod.GET)
	public String upCategory(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Category_id="+id);
		List<Category> list = categoryServiceImpl.queryByStr(map);
		model.addAttribute("category", list.get(0));
		return "category/update";
	}
	
	@RequestMapping(value = "/updateCategory.do", method = RequestMethod.POST)
	public String upCategoryInfo(Category category, HttpServletResponse response){
		boolean b = categoryServiceImpl.update(category);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteCategory.do", method = RequestMethod.GET)
	public String deleteCategory(String id, HttpServletResponse response){
		boolean b = categoryServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='categoryList.do'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='categoryList.do'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
