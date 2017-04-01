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
import com.lh.super_market.dao.impl.SupplierDAOImpl;
import com.lh.super_market.dao.impl.WarehouseDAOImpl;
import com.lh.super_market.entity.Goods;
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.impl.GoodsServiceImpl;
import com.lh.super_market.service.impl.InhousingServiceImpl;
import com.lh.super_market.service.impl.SupplierServiceImpl;
import com.lh.super_market.service.impl.WarehouseServiceImpl;

@Controller
@RequestMapping("/inhousing")
public class InhousingController {

	@Autowired
	private InhousingServiceImpl inhousingServiceImpl;
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	private SupplierServiceImpl supplierServiceImpl;

	@Autowired
	private WarehouseServiceImpl warehouseServiceImpl; 
	
	@RequestMapping("/inhousingList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Inhousing> list = inhousingServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "inhousing/list";
	}
	
	@RequestMapping(value = "/addInhousing.do", method = RequestMethod.GET)
	public String addInhousing(Model model){
		List<Goods> goodList = goodsServiceImpl.query();
		List<Supplier> supplierList = supplierServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("goodList", goodList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("warehouseList", warehouseList);
		return "inhousing/add";
	}
	
	@RequestMapping(value = "/addInhousing.do", method = RequestMethod.POST)
	public String addInhousingInfo(Inhousing inhousing){
		inhousingServiceImpl.add(inhousing);
		Goods good = goodsServiceImpl.queryById(inhousing.getGoods_id());
		good.setGoods_counts(good.getGoods_counts()+inhousing.getGoods_counts());
		goodsServiceImpl.update(good);
		return "inhousing/add";
	}
	
	@RequestMapping(value = "/updateInhousing.do", method = RequestMethod.GET)
	public String upInhousing(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "inhousing_id="+id);
		List<Inhousing> list = inhousingServiceImpl.queryByStr(map);
		List<Goods> goodList = goodsServiceImpl.query();
		List<Supplier> supplierList = supplierServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("goodList", goodList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("inhousing", list.get(0));
		return "inhousing/update";
	}
	
	@RequestMapping(value = "/updateInhousing.do", method = RequestMethod.POST)
	public String upInhousingInfo(Inhousing inhousing, HttpServletResponse response){
		Inhousing inhousing_up = inhousingServiceImpl.queryById(inhousing.getInhousing_id());
		Goods good = goodsServiceImpl.queryById(inhousing.getGoods_id());
		good.setGoods_counts(good.getGoods_counts()+inhousing.getGoods_counts()-inhousing_up.getGoods_counts());
		goodsServiceImpl.update(good);
		boolean b = inhousingServiceImpl.update(inhousing);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteInhousing.do", method = RequestMethod.GET)
	public String deleteInhousing(String id, HttpServletResponse response){
		boolean b = inhousingServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='inhousingList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='inhousingList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
