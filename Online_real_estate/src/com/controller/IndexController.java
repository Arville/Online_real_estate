package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Fangyuanxinxi;
import com.entity.Xinwentongzhi;
import com.server.FangyuanxinxiServer;
import com.server.XinwentongzhiServer;
import com.server.YonghuzhuceServer;

@Controller
public class IndexController {
	
	
	@Resource
	private XinwentongzhiServer xinwentongzhiService;
	@Resource	private FangyuanxinxiServer fangyuanxinxiServer;	//jixacxishxu3
	
	
	
//	首页显示内容
	@RequestMapping("index.do")
	public String showIndex(ModelMap map,HttpSession session){

		List<Fangyuanxinxi> syfangyuanxinxi1=fangyuanxinxiServer.getsyfangyuanxinxi1(null);				
	    session.setAttribute("syfangyuanxinxi1", syfangyuanxinxi1);

		return "default";
	}

	

	
}
