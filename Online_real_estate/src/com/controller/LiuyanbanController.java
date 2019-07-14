package com.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Jingjiren;
import com.entity.Liuyanban;
import com.entity.UserLiuyanban;
import com.entity.Yonghu;
import com.server.LiuyanbanServer;
import com.util.PageResult;

@Controller
public class LiuyanbanController {
	@Resource
	private LiuyanbanServer liuyanbanService;

	@RequestMapping("yonghuliuyan.do")
	public void yonghuliuyan(
			@RequestParam("ufid")String ufid,
			@RequestParam("jjrgonghao")String jjrgonghao,
			@RequestParam("liuyan")String liuyan,
			@RequestParam("bianhao")String bianhao,
			HttpServletResponse response) throws Exception{
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("ufid", ufid);
		pmap.put("gonghao", jjrgonghao);
		pmap.put("lyneirong", liuyan);
		pmap.put("bianhao", bianhao);
		pmap.put("ishf", "0");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		pmap.put("addtime", time.toString().substring(0, 19));
		liuyanbanService.insertLiuyan(pmap);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("success");
	}

	@RequestMapping("liuyanlist.do")
	public String liuyanlist(
			@RequestParam(value="currentPage",required=false) Integer currentPage,
			HttpSession session,
			ModelMap map
			) {
		System.out.println("进入");
		if(currentPage==null) {
			currentPage=1;
		}
		Jingjiren jingjiren = (Jingjiren) session.getAttribute("jjrxinxi");
		String gonghao = jingjiren.getGonghao();
		Map<String, Object> pmap=new HashMap<String,Object>();
		int pageSize=1;
		int beginIndex=(currentPage-1)*pageSize;
		pmap.put("gonghao", gonghao);
		int selectCountLiuyanByishf = liuyanbanService.selectCountLiuyanByishf(pmap);
		pmap.put("beginIndex", beginIndex);
		pmap.put("pageSize", pageSize);
		List<Liuyanban> selectLiuyanByishf = liuyanbanService.selectLiuyanByishf(pmap);
		PageResult pageresult = new PageResult(currentPage,pageSize,selectLiuyanByishf,selectCountLiuyanByishf);
		System.out.println(selectCountLiuyanByishf);
		System.out.println(selectLiuyanByishf);
		map.put("pageresult", pageresult);
		map.put("flag1", "ok");
		return "yonghuliuyanlist";
	}
	
	@RequestMapping("liuyanlist2.do")
	public String liuyanlist2(
			@RequestParam("hfxinxi")String hfxinxi,
			@RequestParam("ufid")String ufid,
			@RequestParam("bianhao")String bianhao,
			ModelMap map
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("jjrhf", hfxinxi);
		pmap.put("ishf", "1");
		pmap.put("ufid", ufid);
		pmap.put("bianhao", bianhao);
		Timestamp time=new Timestamp(System.currentTimeMillis());
		pmap.put("addtime", time.toString().substring(0, 19));
		liuyanbanService.updateLiuyanban(pmap);
		return "yonghuliuyanlist";
	}
	
	@RequestMapping("liuyanhuifu.do")
	public String liuyanhuifu(ModelMap map,HttpSession session){
		Yonghu yonghu = (Yonghu)session.getAttribute("userInfo");
		List<UserLiuyanban> selectLiuyanByYonghu = liuyanbanService.selectLiuyanByYonghu(yonghu.getUfid());
		map.put("LiuyanList", selectLiuyanByYonghu);
		return "UserCenter";
		
	}
}
