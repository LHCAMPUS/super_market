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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.lh.super_market.entity.Stock;
import com.lh.super_market.service.impl.GoodsServiceImpl;
import com.lh.super_market.service.impl.StockServiceImpl;
import com.lh.super_market.service.impl.SupplierServiceImpl;
import com.lh.super_market.service.impl.WarehouseServiceImpl;
import com.lh.super_market.util.Jacksons;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockServiceImpl stockServiceImpl;
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	private SupplierServiceImpl supplierServiceImpl;

	@Autowired
	private WarehouseServiceImpl warehouseServiceImpl; 
	
	@RequestMapping("/stockList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Stock> list = stockServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "stock/list";
	}
	
	@RequestMapping("/stockAnalysis.do")
	public String queryAnaly(String pageIndex, String pageSize, String count1, String count2, Model model){
		String strWhere=null;
		if(!StringUtil.isEmpty(count1)){
			strWhere = " and count>="+count1;
		}
		if(!StringUtil.isEmpty(count2)){
			strWhere = " and count<="+count2;
		}
		PageInfo<Stock> list = stockServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "stock/analysis";
	}
	
	@RequestMapping(value = "/addStock.do", method = RequestMethod.GET)
	public String addStaff(){
		return "Stock/add";
	}
	
	@RequestMapping(value = "/addStock.do", method = RequestMethod.POST)
	public String addStockInfo(Stock Stock){
		stockServiceImpl.add(Stock);
		return "Stock/add";
	}
	
	@RequestMapping(value = "/updateStock.do", method = RequestMethod.GET)
	public String upStock(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "stock_id="+id);
		List<Stock> list = stockServiceImpl.queryByStr(map);
		model.addAttribute("stock", list.get(0));
		return "Stock/update";
	}
	
	@RequestMapping(value = "/updateStock.do", method = RequestMethod.POST)
	public String upStockInfo(Stock Stock, HttpServletResponse response){
		boolean b = stockServiceImpl.update(Stock);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteStock.do", method = RequestMethod.GET)
	public String deleteStock(String id, HttpServletResponse response){
		boolean b = stockServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/getgoodAndWare.do", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String getCateAndWare(String goods_id, String warehouse_id){
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsName", goodsServiceImpl.queryById(Integer.parseInt(goods_id)).getGoods_name());
		map.put("warehouseName", warehouseServiceImpl.queryById(Integer.parseInt(warehouse_id)).getWarehouse_name());
		return Jacksons.writeJson(map);
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='stockList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='stockList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
