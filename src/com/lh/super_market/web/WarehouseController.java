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
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.impl.WarehouseServiceImpl;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private WarehouseServiceImpl warehouseServiceImpl;
	
	@RequestMapping("/warehouseList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Warehouse> list = warehouseServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "warehouse/list";
	}
	
	@RequestMapping(value = "/addWarehouse.do", method = RequestMethod.GET)
	public String addWarehouse(){
		return "warehouse/add";
	}
	
	@RequestMapping(value = "/addWarehouse.do", method = RequestMethod.POST)
	public String addWarehouseInfo(Warehouse warehouse){
		warehouseServiceImpl.add(warehouse);
		return "warehouse/add";
	}
	
	@RequestMapping(value = "/updateWarehouse.do", method = RequestMethod.GET)
	public String upWarehouse(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "warehouse_id="+id);
		List<Warehouse> list = warehouseServiceImpl.queryByStr(map);
		model.addAttribute("warehouse", list.get(0));
		return "warehouse/update";
	}
	
	@RequestMapping(value = "/updateWarehouse.do", method = RequestMethod.POST)
	public String upWarehouseInfo(Warehouse warehouse, HttpServletResponse response){
		boolean b = warehouseServiceImpl.update(warehouse);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteWarehouse.do", method = RequestMethod.GET)
	public String deleteWarehouse(String id, HttpServletResponse response){
		boolean b = warehouseServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='warehouseList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='warehouseList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
