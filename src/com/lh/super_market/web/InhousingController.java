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
import com.lh.super_market.entity.Inhousing;
import com.lh.super_market.service.impl.InhousingServiceImpl;

@Controller
@RequestMapping("/inhousing")
public class InhousingController {

	@Autowired
	private InhousingServiceImpl inhousingServiceImpl;
	
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
	public String addInhousing(){
		return "inhousing/add";
	}
	
	@RequestMapping(value = "/addInhousing.do", method = RequestMethod.POST)
	public String addInhousingInfo(Inhousing inhousing){
		System.out.println("---------------------");
		System.out.println(inhousing.getGoods_name());
		System.out.println(inhousing.getSupplier_id());
		inhousingServiceImpl.add(inhousing);
		return "inhousing/add";
	}
	
	@RequestMapping(value = "/updateInhousing.do", method = RequestMethod.GET)
	public String upInhousing(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "inhousing_id="+id);
		List<Inhousing> list = inhousingServiceImpl.queryByStr(map);
		model.addAttribute("inhousing", list.get(0));
		return "inhousing/update";
	}
	
	@RequestMapping(value = "/updateInhousing.do", method = RequestMethod.POST)
	public String upInhousingInfo(Inhousing inhousing, HttpServletResponse response){
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
				out.println("<script>alert('操作成功');window.location.href='inhousingList.do'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='inhousingList.do'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
