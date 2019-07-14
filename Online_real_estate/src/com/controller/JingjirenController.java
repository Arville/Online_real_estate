package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Fangyuanxinxi;
import com.entity.Jingjiren;
import com.server.JingjirenServer;

@Controller
public class JingjirenController {
	@Resource
	private JingjirenServer jingjirenService;
	
	@RequestMapping("selectJingjiren.do")
	public String selectJingjiren(
			@RequestParam(value="zhanghao",required=false) String zhanghao,
			@RequestParam(value="mima",required=false) String mima,
			ModelMap map,
			HttpSession session
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("zhanghao", zhanghao);
		pmap.put("mima", mima);
		Jingjiren selectJinjiren = jingjirenService.selectJinjiren(pmap);
		if(selectJinjiren!=null) {
			session.setAttribute("jjrxinxi", selectJinjiren);
			return "main";
		}else {
		map.put("fault","fault");
		return "Jingjirenlog";
		}
		
	}
	
	@RequestMapping("selectFyjj.do")
	public String selectFyjj(
			HttpSession session,
			ModelMap map,
			@RequestParam(value="currentPage",required=false) Integer currentPage
			) {
		Jingjiren jingjiren = (Jingjiren) session.getAttribute("jjrxinxi");
		List<Fangyuanxinxi> selectFyjjr = jingjirenService.selectFyjjr(jingjiren.getGonghao());
		map.put("fyjj", selectFyjjr);
		return "Fyjj";
	}
	
	
   
}
