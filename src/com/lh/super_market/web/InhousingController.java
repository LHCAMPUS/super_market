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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.lh.super_market.dao.impl.SupplierDAOImpl;
import com.lh.super_market.dao.impl.WarehouseDAOImpl;
import com.lh.super_market.entity.Goods;
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.entity.Outhousing;
import com.lh.super_market.entity.Stock;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.impl.GoodsServiceImpl;
import com.lh.super_market.service.impl.InhousingServiceImpl;
import com.lh.super_market.service.impl.StockServiceImpl;
import com.lh.super_market.service.impl.SupplierServiceImpl;
import com.lh.super_market.service.impl.WarehouseServiceImpl;
import com.lh.super_market.util.Jacksons;

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
	
	@Autowired
	private StockServiceImpl stockServiceImpl; 
	
	@RequestMapping("/inhousingList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Inhousing> list = inhousingServiceImpl.queryByPage(Integer.parseInt(pageIndex), 5, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "inhousing/list";
	}
	
	@RequestMapping("/inhousingAnalysis.do")
	public String queryAnaly(String pageIndex, String pageSize, String date1, String date2, Model model){
		String strWhere="";
		if(!StringUtil.isEmpty(date1)){
			strWhere += " and inhousing_date>='"+date1+"'";
		}
		if(!StringUtil.isEmpty(date2)){
			strWhere += " and inhousing_date<='"+date2+"'";
		}
		PageInfo<Inhousing> list = inhousingServiceImpl.queryByPage(Integer.parseInt(pageIndex), 5, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		model.addAttribute("date1", date1);
		model.addAttribute("date2", date2);
		return "inhousing/analysis";
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
	public String addInhousingInfo(Inhousing inhousing, HttpServletResponse response){
		int id = inhousingServiceImpl.add(inhousing);
		boolean bo = id>0?true:false;
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", " and Goods_id="+inhousing.getGoods_id()+" and warehouse_id="+inhousing.getWarehouse_id());
		List<Stock> list = stockServiceImpl.queryByStr(map);
		Stock stock = list.size()>0?list.get(0):null;
		if(stock == null){
			outStr(false, response, "采购");
			return null;
		}
		
		stock.setCount(stock.getCount()+inhousing.getGoods_counts());
		boolean b = stockServiceImpl.update(stock);
		if (!b) {
			outStr(b, response, "采购");
			return null;
		}
		
		outStr(bo, response, "采购");
		return null;
	}
	
	@RequestMapping(value = "/updateInhousing.do", method = RequestMethod.GET)
	public String upInhousing(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", " and inhousing_id="+id);
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
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", " and Goods_id="+inhousing.getGoods_id()+" and warehouse_id="+inhousing.getWarehouse_id());
		List<Stock> list = stockServiceImpl.queryByStr(map);
		Stock stock = list.size()>0?list.get(0):null;
		if(stock==null){
			outStr(false, response, "更新");
			return null;
		}
		stock.setCount(stock.getCount()+inhousing.getGoods_counts()-inhousing_up.getGoods_counts());
		boolean b = stockServiceImpl.update(stock);
		if (!b) {
			outStr(b, response, "入库更新");
			return null;
		}
		boolean bo = inhousingServiceImpl.update(inhousing);
		outStr(bo, response, "更新");
		return null;
	}
	
	@RequestMapping(value = "/deleteInhousing.do", method = RequestMethod.GET)
	public String deleteInhousing(String id, HttpServletResponse response){
		boolean b = inhousingServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response, "删除");
		return null;
	}
	
	
	@RequestMapping(value = "/getgoodAndWare.do", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String getCateAndWare(String goods_id, String warehouse_id, String supplier_id){
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsName", goodsServiceImpl.queryById(Integer.parseInt(goods_id)).getGoods_name());
		map.put("warehouseName", warehouseServiceImpl.queryById(Integer.parseInt(warehouse_id)).getWarehouse_name());
		map.put("supplierName", supplierServiceImpl.queryById(Integer.parseInt(supplier_id)).getSupplier_name());
		return Jacksons.writeJson(map);
	}
	
	public void outStr(boolean b, HttpServletResponse response, String errMess){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='inhousingList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('"+errMess+"操作失败');window.location.href='inhousingList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
