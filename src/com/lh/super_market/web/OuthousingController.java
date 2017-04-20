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
import com.lh.super_market.entity.Goods;
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.entity.Outhousing;
import com.lh.super_market.entity.Stock;
import com.lh.super_market.entity.Supplier;
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.impl.GoodsServiceImpl;
import com.lh.super_market.service.impl.OuthousingServiceImpl;
import com.lh.super_market.service.impl.StockServiceImpl;
import com.lh.super_market.service.impl.SupplierServiceImpl;
import com.lh.super_market.service.impl.WarehouseServiceImpl;
import com.lh.super_market.util.Jacksons;
import com.lh.super_market.util.Result;

@Controller
@RequestMapping("/outhousing")
public class OuthousingController {

	@Autowired
	private OuthousingServiceImpl outhousingServiceImpl;
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	private SupplierServiceImpl supplierServiceImpl;

	@Autowired
	private WarehouseServiceImpl warehouseServiceImpl; 
	
	@Autowired
	private StockServiceImpl stockServiceImpl; 
	
	@RequestMapping("/outhousingList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Outhousing> list = outhousingServiceImpl.queryByPage(Integer.parseInt(pageIndex), 2, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "outhousing/list";
	}
	
	@RequestMapping(value = "/addOuthousing.do", method = RequestMethod.GET)
	public String addOuthousing(Model model){
		List<Goods> goodList = goodsServiceImpl.query();
		List<Supplier> supplierList = supplierServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("goodList", goodList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("warehouseList", warehouseList);
		return "outhousing/add";
	}
	
	@RequestMapping(value = "/addOuthousing.do", method = RequestMethod.POST)
	public String addOuthousingInfo(Outhousing outhousing, HttpServletResponse response){
		int id = outhousingServiceImpl.add(outhousing);
		boolean bo = id>0?true:false;
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Goods_id="+outhousing.getGoods_id()+" and warehouse_id="+outhousing.getWarehouse_id());
		List<Stock> list = stockServiceImpl.queryByStr(map);
		Stock stock = list.size()>0?list.get(0):null;
		if(stock!=null){
			stock.setCount(stock.getCount()-outhousing.getGoods_counts());
			boolean b = stockServiceImpl.update(stock);
			if (!b) {
				outStr(b, response, "入库");
				return null;
			}
		}
		outStr(bo, response, "入库");
		return null;
	}
	
	@RequestMapping(value = "/updateOuthousing.do", method = RequestMethod.GET)
	public String upOuthousing(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "outhousing_id="+id);
		List<Outhousing> list = outhousingServiceImpl.queryByStr(map);
		List<Goods> goodList = goodsServiceImpl.query();
		List<Supplier> supplierList = supplierServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("outhousing", list.get(0));
		model.addAttribute("goodList", goodList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("warehouseList", warehouseList);
		return "outhousing/update";
	}
	
	@RequestMapping(value = "/updateOuthousing.do", method = RequestMethod.POST)
	public String upOuthousingInfo(Outhousing outhousing, HttpServletResponse response){
		Outhousing outhousing_up = outhousingServiceImpl.queryById(outhousing.getOuthousing_id());//之前出库的信息
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Goods_id="+outhousing.getGoods_id()+" and warehouse_id="+outhousing.getWarehouse_id());
		List<Stock> list = stockServiceImpl.queryByStr(map);
		Stock stock = list.size()>0?list.get(0):null;
		if(stock==null){
			outStr(false, response, "更新");
			return null;
		}
		stock.setCount(stock.getCount()-(outhousing.getGoods_counts()-outhousing_up.getGoods_counts()));
		boolean b = stockServiceImpl.update(stock);
		if (!b) {
			outStr(b, response, "更新");
			return null;
		}
		boolean bo = outhousingServiceImpl.update(outhousing);
		outStr(bo, response, "更新");
		return null;
	}
	
	@RequestMapping(value = "/deleteOuthousing.do", method = RequestMethod.GET)
	public String deleteOuthousing(String id, HttpServletResponse response){
		boolean b = outhousingServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response,"删除");
		return null;
	}
	
	@RequestMapping(value = "/getgoodAndWare.do", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String getCateAndWare(String goods_id, String count){
		Map<String, String> map = new HashMap<String, String>();
		Goods good = goodsServiceImpl.queryById(Integer.parseInt(goods_id));
		map.put("goodsName", good.getGoods_name());
		map.put("goods_price", String.valueOf(good.getGoods_saleMoney()));
		map.put("sumprice", String.valueOf(good.getGoods_saleMoney()*Integer.parseInt(count)));
//		map.put("warehouseName", warehouseServiceImpl.queryById(Integer.parseInt(warehouse_id)).getWarehouse_name());
//		map.put("supplierName", supplierServiceImpl.queryById(Integer.parseInt(supplier_id)).getSupplier_name());
		return Jacksons.writeJson(map);
	}
	
	@RequestMapping(value = "/getGoods.do", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String getGoods(String goods_id, String count){
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsName", goodsServiceImpl.queryById(Integer.parseInt(goods_id)).getGoods_name());
		Goods good = goodsServiceImpl.queryById(Integer.parseInt(goods_id));
		
		return Jacksons.writeJson(good);
	}
	
	public void outStr(boolean b, HttpServletResponse response, String errMess){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='outhousingList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('"+errMess+"操作失败');window.location.href='outhousingList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
