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
import com.lh.super_market.dao.impl.StockDAOImpl;
import com.lh.super_market.entity.Category;
import com.lh.super_market.entity.Goods;
import com.lh.super_market.entity.Stock;
import com.lh.super_market.entity.Warehouse;
import com.lh.super_market.service.impl.CategoryServiceImpl;
import com.lh.super_market.service.impl.GoodsServiceImpl;
import com.lh.super_market.service.impl.WarehouseServiceImpl;
import com.lh.super_market.util.Jacksons;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private WarehouseServiceImpl warehouseServiceImpl;
	
	@Autowired
	private StockDAOImpl stockDAOImpl;
	
	@RequestMapping("/goodsList.do")
	public String query(String pageIndex, String pageSize, String strWhere, Model model){
		PageInfo<Goods> list = goodsServiceImpl.queryByPage(Integer.parseInt(pageIndex), 5, strWhere);
		model.addAttribute("list", list.getList());
		model.addAttribute("pageCount", list.getPages());
		model.addAttribute("currentPage", list.getPageNum());
		model.addAttribute("count", list.getSize());
		return "goods/list";
	}
	
	@RequestMapping(value = "/addGoods.do", method = RequestMethod.GET)
	public String addGoods(Model model){
		List<Category> categoryList = categoryServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("warehouseList", warehouseList);
		return "goods/add";
	}
	
	@RequestMapping(value = "/addGoods.do", method = RequestMethod.POST)
	public String addGoodsInfo(Goods goods, HttpServletResponse response){
		int id = goodsServiceImpl.add(goods);
		Stock stock = new Stock();
		stock.setGoods_id(goods.getGoods_id());
		stock.setWarehouse_id(goods.getWarehouse_id());
		int st_result = stockDAOImpl.add(stock);
		if(st_result <= 0){
			outStr(false, response, "添加库存");
		}
		System.out.println("id="+id);
		boolean b = id > 0? true : false;
		outStr(b, response, "添加商品");
		return null;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public String upGoods(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Goods_id="+id);
		List<Goods> list = goodsServiceImpl.queryByStr(map);
		model.addAttribute("goods", list.get(0));
		List<Category> categoryList = categoryServiceImpl.query();
		List<Warehouse> warehouseList = warehouseServiceImpl.query();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("warehouseList", warehouseList);
		return "goods/update";
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public String upGoodsInfo(Goods Goods, HttpServletResponse response){
		boolean b = goodsServiceImpl.update(Goods);
		outStr(b, response, "更新");
		return null;
	}
	
	@RequestMapping(value = "/deleteGoods.do", method = RequestMethod.GET)
	public String deleteGoods(String id, HttpServletResponse response){
		boolean b = goodsServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response, "删除");
		return null;
	}
	
	@RequestMapping(value = "/getCateAndWare.do", method = RequestMethod.POST, produces = {"text/html;charset=UTF-8;"})
	@ResponseBody
	public String getCateAndWare(String category_id, String warehouse_id){
		Map<String, String> map = new HashMap<String, String>();
		map.put("categoryName", categoryServiceImpl.queryById(Integer.parseInt(category_id)).getCategory_name());
		map.put("warehouseName", warehouseServiceImpl.queryById(Integer.parseInt(warehouse_id)).getWarehouse_name());
		return Jacksons.writeJson(map);
	}
	
	public void outStr(boolean b, HttpServletResponse response, String errMess){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='goodsList.do?pageIndex=1'</script>");
			}else{
				out.println("<script>alert('"+errMess+"操作失败');window.location.href='goodsList.do?pageIndex=1'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
