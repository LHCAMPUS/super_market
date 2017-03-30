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
import com.lh.super_market.entity.Outhousing;
import com.lh.super_market.service.impl.OuthousingServiceImpl;

@Controller
@RequestMapping("/outhousing")
public class OuthousingController {

	@Autowired
	private OuthousingServiceImpl outhousingServiceImpl;
	
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
	public String addOuthousing(){
		return "outhousing/add";
	}
	
	@RequestMapping(value = "/addOuthousing.do", method = RequestMethod.POST)
	public String addOuthousingInfo(Outhousing outhousing){
		outhousingServiceImpl.add(outhousing);
		return "outhousing/add";
	}
	
	@RequestMapping(value = "/updateOuthousing.do", method = RequestMethod.GET)
	public String upOuthousing(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "outhousing_id="+id);
		List<Outhousing> list = outhousingServiceImpl.queryByStr(map);
		model.addAttribute("outhousing", list.get(0));
		return "outhousing/update";
	}
	
	@RequestMapping(value = "/updateOuthousing.do", method = RequestMethod.POST)
	public String upOuthousingInfo(Outhousing outhousing, HttpServletResponse response){
		boolean b = outhousingServiceImpl.update(outhousing);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteOuthousing.do", method = RequestMethod.GET)
	public String deleteOuthousing(String id, HttpServletResponse response){
		boolean b = outhousingServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='outhousingList.do'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='outhousingList.do'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
