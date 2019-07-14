package com.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Xinwentongzhi;
//import com.chengxusheji.po.News;
import com.server.XinwentongzhiServer;

@Controller
public class XinwentongzhiController {
	@Resource
	private XinwentongzhiServer xinwentongzhiService;


//	
   @RequestMapping("showXinwentongzhi.do")
   public String showXinwentongzhi(int id,ModelMap map,HttpSession session){
	 /*  Map<String,Object> bmap=new HashMap<String,Object>();
	   bmap.put("uid", id);*/
	  // map.put("blist", xinwentongzhiService.getAll(bmap));
	   map.put("xinwentongzhi", xinwentongzhiService.getById(id));
	   return "read";
   }
   
	@RequestMapping("addXinwentongzhi.do")
	public String addXinwentongzhi(HttpServletRequest request,Xinwentongzhi xinwentongzhi,HttpSession session){
		Timestamp time=new Timestamp(System.currentTimeMillis());
		//Users u=(Users)session.getAttribute("user");
		/*if(u==null||u.equals("")){
			return "redirect:showIndex.do";
		}else{*/
			
		    xinwentongzhi.setAddtime(time.toString().substring(0, 19));
			xinwentongzhiService.add(xinwentongzhi);
			session.setAttribute("backxx", "添加成功");
			session.setAttribute("backurl", "xinwentongzhiList.do?lb="+request.getParameter("leibie"));
			return "redirect:postback.jsp";
		/*}*/
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXinwentongzhi.do")
	public String doUpdateXinwentongzhi(int id,ModelMap map,Xinwentongzhi xinwentongzhi){
		xinwentongzhi=xinwentongzhiService.getById(id);
		map.put("xinwentongzhi", xinwentongzhi);
		return "xinwentongzhi_updt";
	}
	
	//	后台详细
	@RequestMapping("XinwentongzhiDetail.do")
	public String XinwentongzhiDetail(int id,ModelMap map,Xinwentongzhi xinwentongzhi){
		xinwentongzhi=xinwentongzhiService.getById(id);
		map.put("xinwentongzhi", xinwentongzhi);
		return "xinwentongzhi_detail";
	}
//	前台详细
	@RequestMapping("xwtzDetail.do")
	public String xwtzDetail(int id,ModelMap map,Xinwentongzhi xinwentongzhi){
		xinwentongzhi=xinwentongzhiService.getById(id);
		map.put("xinwentongzhi", xinwentongzhi);
		return "gg_detail";
	}
	
//	
	@RequestMapping("updateXinwentongzhi.do")
	public String updateXinwentongzhi(int id,ModelMap map,Xinwentongzhi xinwentongzhi){
		xinwentongzhiService.update(xinwentongzhi);
		return "redirect:xinwentongzhiList.do";
	}

	
	@RequestMapping("deleteXinwentongzhi.do")
	public String deleteXinwentongzhi(int id){
		xinwentongzhiService.delete(id);
		return "redirect:xinwentongzhiList.do";
	}
	
	
}
