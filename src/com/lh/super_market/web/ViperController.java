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

import com.lh.super_market.entity.Viper;
import com.lh.super_market.service.impl.ViperServiceImpl;

@Controller
@RequestMapping("/viper")
public class ViperController {

	@Autowired
	private ViperServiceImpl viperServiceImpl;
	
	@RequestMapping("/viperList.do")
	public String query(Model model){
		List<Viper> list = viperServiceImpl.query();
		model.addAttribute("list", list);
		return "viper/list";
	}
	
	@RequestMapping(value = "/addViper.do", method = RequestMethod.GET)
	public String addViper(){
		return "viper/add";
	}
	
	@RequestMapping(value = "/addViper.do", method = RequestMethod.POST)
	public String addViperInfo(Viper viper){
		viperServiceImpl.add(viper);
		return "viper/add";
	}
	
	@RequestMapping(value = "/updateViper.do", method = RequestMethod.GET)
	public String upViper(String id, Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("strWhere", "vip_id="+id);
		List<Viper> list = viperServiceImpl.queryByStr(map);
		model.addAttribute("viper", list.get(0));
		return "viper/update";
	}
	
	@RequestMapping(value = "/updateViper.do", method = RequestMethod.POST)
	public String upViperInfo(Viper viper, HttpServletResponse response){
		boolean b = viperServiceImpl.update(viper);
		outStr(b, response);
		return null;
	}
	
	@RequestMapping(value = "/deleteViper.do", method = RequestMethod.GET)
	public String deleteViper(String id, HttpServletResponse response){
		boolean b = viperServiceImpl.delete(Integer.parseInt(id));
		outStr(b, response);
		return null;
	}
	
	public void outStr(boolean b, HttpServletResponse response){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			if(b){
				out.println("<script>alert('操作成功');window.location.href='viperList.do'</script>");
			}else{
				out.println("<script>alert('操作失败');window.location.href='viperList.do'</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	window.location.href='GoodsServlet?action=getList&pageIndex=1&admin=1';
}
