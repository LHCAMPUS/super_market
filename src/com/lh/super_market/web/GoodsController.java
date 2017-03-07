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

import com.lh.super_market.entity.Goods;
import com.lh.super_market.service.impl.GoodsServiceImpl;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	@RequestMapping("/goodsList.do")
	public String query(Model model){
		List<Goods> list = goodsServiceImpl.query();
		model.addAttribute("list", list);
		return "goods/list";
	}
	
	@RequestMapping(value = "/addGoods.do", method = RequestMethod.GET)
	public String addGoods(){
		return "goods/add";
	}
	
	@RequestMapping(value = "/addGoods.do", method = RequestMethod.POST)
	public String addGoodsInfo(Goods Goods){
		goodsServiceImpl.add(Goods);
		return "goods/add";
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public String upGoods(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "Goods_id="+id);
		List<Goods> list = goodsServiceImpl.queryByStr(map);
		model.addAttribute("goods", list.get(0));
		return "goods/update";
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public String upGoodsInfo(Goods Goods, HttpServletResponse response){
		boolean b = goodsServiceImpl.update(Goods);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteGoods.do", method = RequestMethod.GET)
	public String deleteGoods(String id, HttpServletResponse response){
		boolean b = goodsServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='goodsList.do'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='goodsList.do'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
