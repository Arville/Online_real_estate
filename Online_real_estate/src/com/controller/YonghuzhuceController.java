package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Fangyuanxinxi;
import com.entity.Yonghu;
import com.server.YonghuzhuceServer;
import com.util.PageResult;

@Controller
public class YonghuzhuceController {
	@Resource
	private YonghuzhuceServer yonghuzhuceService;
	

   
	@RequestMapping("frontdeskzhuce.do")
	public String frontdeskzhuce(
			HttpServletRequest request,
			@RequestParam(value="username",required=true) String username,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="phone",required=true) String tel,
			@RequestParam(value="touxiang",required=false) MultipartFile file,
			HttpSession session) {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		// 如果文件不为空，写入上传路径
		String path1="";
		String path2="";
		String filename="";
					if (!file.isEmpty()) {
						// 上传文件路径
						path1 = "/fdc/profile_picture/";
						path2 = "C:\\fangdichan\\profile_picture";
						// 上传文件名
						filename = file.getOriginalFilename();
						File filepath = new File(path2,uuid+filename);
						// 判断路径是否存在，如果不存在就创建一个
						if (!filepath.getParentFile().exists()) {
							filepath.getParentFile().mkdirs();
						}
						// 将上传文件保存到一个目标文件当中
						try {
							file.transferTo(new File(path2+File.separator+uuid+filename));
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} 
				
				Yonghu yonghu=new Yonghu(username, password, tel, uuid, path1+uuid+filename, path2+File.separator+uuid+filename);
				int insertYonghu = yonghuzhuceService.insertYonghu(yonghu);
				session.setAttribute("userInfo", yonghu);
				return "default";
	}
	
	@RequestMapping("yonghuming.do")
	public void yonghuming(@RequestParam(value="username") String username,HttpServletResponse response) throws Exception {
		Yonghu selectBuUsername = yonghuzhuceService.selectBuUsername(username);
		response.setContentType("text/html;charset=utf-8");
		if(selectBuUsername==null) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fault");
		}
	}
	
	@RequestMapping("frontdeskdenglu.do")
	public String frontdeskdenglu(
			@RequestParam(value="username",required=true) String username,
			@RequestParam(value="password",required=true) String password,
			ModelMap map,
			HttpSession session) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("username", username);
		pmap.put("password", password);
		Yonghu selectYonghu = yonghuzhuceService.selectYonghu(pmap);
		if(selectYonghu!=null) {
			session.setAttribute("userInfo", selectYonghu);
			return "default";
		}
		map.put("fault", "fault");
		return "userlog";
	}
	
	
	@RequestMapping("frontdesktuichu.do")
	public String frontdesktuichu(HttpSession session) {
		session.removeAttribute("userInfo");
		return "default";
	}
	
	@RequestMapping("UserCenter.do")
	public String UserCenter(HttpSession session,ModelMap map,
			@RequestParam(value="currentPage",required=false) Integer currentPage) {
		Yonghu yonghu = (Yonghu)session.getAttribute("userInfo");
		List<Fangyuanxinxi> Fylist = new ArrayList<Fangyuanxinxi>();
		Map<String,Object> pmap1 = new HashMap<String,Object>();
		if(currentPage==null) {
			currentPage=1;
		}
		int pageSize=5;
		pmap1.put("beginIndex", (currentPage-1)*pageSize);
		pmap1.put("pageSize", pageSize);
		pmap1.put("ufid", yonghu.getUfid());
		List<String> selectBianhao = yonghuzhuceService.selectBianhao(pmap1);
		for (String bianhao : selectBianhao) {
			Fangyuanxinxi selectGuanzhufangyuan = yonghuzhuceService.selectGuanzhufangyuan(bianhao);
			Fylist.add(selectGuanzhufangyuan);
		}
		int selecCounttBianhao = yonghuzhuceService.selecCounttBianhao(yonghu.getUfid());
		PageResult pageResult = new PageResult(currentPage, pageSize, Fylist, selecCounttBianhao);
		map.put("pageResult",pageResult);
		map.put("choose2", "guanzhufy");
		return "UserCenter";
	}
	
	
}
