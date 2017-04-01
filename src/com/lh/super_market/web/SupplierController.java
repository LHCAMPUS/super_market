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

import com.github.pagehelper.PageInfo;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.service.impl.SupplierServiceImpl;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierServiceImpl supplierServiceImpl;
	
	@RequestMapping("/supplierList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Supplier> list = supplierServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
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
	
	@RequestMapping(value = "/updateSupplier.do", method = RequestMethod.GET)
	public String upSupplier(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Supplier_id="+id);
		List<Supplier> list = supplierServiceImpl.queryByStr(map);
		model.addAttribute("supplier", list.get(0));
		return "supplier/update";
	}
	
	@RequestMapping(value = "/updateSupplier.do", method = RequestMethod.POST)
	public String upSupplierInfo(Supplier supplier, HttpServletResponse response){
		boolean b = supplierServiceImpl.update(supplier);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteSupplier.do", method = RequestMethod.GET)
	public String deleteSupplier(String id, HttpServletResponse response){
		boolean b = supplierServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='supplierList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='supplierList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
