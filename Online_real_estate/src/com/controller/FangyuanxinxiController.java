package com.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.entity.Fabu;
import com.entity.Fangyuantupian;
import com.entity.Fangyuanxinxi;
import com.entity.Fankui;
import com.entity.Fkjj;
import com.entity.Guanzhu;
import com.entity.Jingjiren;
import com.entity.Kanfang;
import com.entity.Kfjj;
import com.entity.Yonghu;
import com.server.FangyuanxinxiServer;
import com.util.PageResult;

@Controller
public class FangyuanxinxiController {
	@Resource
	private FangyuanxinxiServer fangyuanxinxiService;
	
	//前台房源list
	@RequestMapping("fyxxList.do")
	public String fyxxList(@RequestParam(value="currentPage",required=false) Integer page,
			@RequestParam(value="navigation",required=false) String navigation,
			@RequestParam(value="keyword",required=false) String keyword,
			@RequestParam(value="shaixuan",required=false) String shaixuan,
			ModelMap map,
			HttpSession session){
		if(page==null||page<=0){
			page=1;
		}
		if(keyword==null||keyword.equals("")||keyword.trim().equals("")){
			keyword="none";
		}
		int currentPage=page;
		int pageSize=5;
		int beginIndex=(currentPage-1)*pageSize;
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("beginIndex", beginIndex);
		pmap.put("pageSize", pageSize);
		if ("newest".equals(navigation)&&"none".equals(keyword)) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			int totalCount=fangyuanxinxiService.getCount();
			List<Fangyuanxinxi> listData = fangyuanxinxiService.getFyxxByTime(pmap);
			for (Fangyuanxinxi fangyuanxinxi : listData) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, listData, totalCount);
			map.put("pageResult", pageResult);
			map.put("navi", navigation);
			return "fangyuanxinxilist";
		}
		if ("default".equals(navigation)&&"none".equals(keyword)) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			int totalCount=fangyuanxinxiService.getCount();
			List<Fangyuanxinxi> listData = fangyuanxinxiService.getFangyuanxinxiByPage(pmap);
			for (Fangyuanxinxi fangyuanxinxi : listData) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, listData, totalCount);
			map.put("pageResult", pageResult);
			map.put("navi", navigation);
			return "fangyuanxinxilist";
		}
		if("default".equals(navigation)&&!"none".equals(keyword)) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			pmap.put("keyword",keyword);
			int countByCondition = fangyuanxinxiService.getCountByCondition(pmap);
			List<Fangyuanxinxi> fyxxByKeyword = fangyuanxinxiService.getFyxxByKeyword(pmap);
			for (Fangyuanxinxi fangyuanxinxi : fyxxByKeyword) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, fyxxByKeyword, countByCondition);
			map.put("pageResult", pageResult);
			map.put("navi", navigation);
			map.put("keyword", keyword);
			return "fangyuanxinxilist";
		}
		if("newest".equals(navigation)&&!"none".equals(keyword)) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			pmap.put("keyword",keyword);
			int countByCondition = fangyuanxinxiService.getCountByCondition(pmap);
			List<Fangyuanxinxi> fyxxByKeywordOrderTime = fangyuanxinxiService.getFyxxByKeywordOrderTime(pmap);
			for (Fangyuanxinxi fangyuanxinxi : fyxxByKeywordOrderTime) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, fyxxByKeywordOrderTime, countByCondition);
			map.put("pageResult", pageResult);
			map.put("navi", navigation);
			map.put("keyword", keyword);
			return "fangyuanxinxilist";
		}
		if ("default2".equals(navigation)&&shaixuan!=null&&!shaixuan.equals("")) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			List<String> tiaojian1 = new ArrayList<String>();
			List<String> tiaojian3 = new ArrayList<String>();
			List<String> tiaojian4 = new ArrayList<String>();
			List<String> tiaojian5 = new ArrayList<String>();
			String[] split = shaixuan.split("\\|");
			for (int i = 0; i < split.length; i++) {
				if(split[i].equals("位置")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian1.add(string);
					}
				}
				if(split[i].equals("售价")) {
					if("200万以下".equals(split[i-1])) {
						pmap.put("beginPrice", 0);
						pmap.put("endPrice", 200);
					}
					if("200-300万".equals(split[i-1])) {
						pmap.put("beginPrice", 200);
						pmap.put("endPrice", 300);
					}
					if("300万-400万".equals(split[i-1])) {
						pmap.put("beginPrice", 300);
						pmap.put("endPrice", 400);
					}
					if("400-500万".equals(split[i-1])) {
						pmap.put("beginPrice", 400);
						pmap.put("endPrice", 500);
					}
					if("500-800万".equals(split[i-1])) {
						pmap.put("beginPrice", 500);
						pmap.put("endPrice", 800);
					}
					if("800-1000万".equals(split[i-1])) {
						pmap.put("beginPrice", 800);
						pmap.put("endPrice", 1000);
					}
				}
				if(split[i].equals("房型")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian3.add(string);
					}
				}
				if(split[i].equals("电梯")) {
					tiaojian4.add(split[i-1]);
				}
				if(split[i].equals("装修")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian5.add(string);
					}
				}
			}
			pmap.put("position1", tiaojian1);
			pmap.put("roomtype1", tiaojian3);
			pmap.put("elevator1", tiaojian4);
			pmap.put("decoration1", tiaojian5);
			int findShaixuanCount = fangyuanxinxiService.FindShaixuanCount(pmap);
			List<Fangyuanxinxi> findShaixuanFyxx = fangyuanxinxiService.FindShaixuanFyxx(pmap);
			for (Fangyuanxinxi fangyuanxinxi : findShaixuanFyxx) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, findShaixuanFyxx, findShaixuanCount);
			session.setAttribute("pageResult", pageResult);
			session.setAttribute("navi", "default2");
			session.setAttribute("shaixuan", shaixuan);
		}
		if ("newest2".equals(navigation)&&shaixuan!=null&&!shaixuan.equals("")) {
			session.removeAttribute("pageResult");
			session.removeAttribute("navi");
			session.removeAttribute("shaixuan");
			List<String> tiaojian1 = new ArrayList<String>();
			List<String> tiaojian3 = new ArrayList<String>();
			List<String> tiaojian4 = new ArrayList<String>();
			List<String> tiaojian5 = new ArrayList<String>();
			String[] split = shaixuan.split("\\|");
			for (int i = 0; i < split.length; i++) {
				if(split[i].equals("位置")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian1.add(string);
					}
				}
				if(split[i].equals("售价")) {
					if("200万以下".equals(split[i-1])) {
						pmap.put("beginPrice", 0);
						pmap.put("endPrice", 200);
					}
					if("200-300万".equals(split[i-1])) {
						pmap.put("beginPrice", 200);
						pmap.put("endPrice", 300);
					}
					if("300万-400万".equals(split[i-1])) {
						pmap.put("beginPrice", 300);
						pmap.put("endPrice", 400);
					}
					if("400-500万".equals(split[i-1])) {
						pmap.put("beginPrice", 400);
						pmap.put("endPrice", 500);
					}
					if("500-800万".equals(split[i-1])) {
						pmap.put("beginPrice", 500);
						pmap.put("endPrice", 800);
					}
					if("800-1000万".equals(split[i-1])) {
						pmap.put("beginPrice", 800);
						pmap.put("endPrice", 1000);
					}
				}
				if(split[i].equals("房型")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian3.add(string);
					}
				}
				if(split[i].equals("电梯")) {
					tiaojian4.add(split[i-1]);
				}
				if(split[i].equals("装修")) {
					String[] split2 = split[i-1].split("\\,");
					for (String string : split2) {
						tiaojian5.add(string);
					}
				}
			}
			pmap.put("position1", tiaojian1);
			pmap.put("roomtype1", tiaojian3);
			pmap.put("elevator1", tiaojian4);
			pmap.put("decoration1", tiaojian5);
			int findShaixuanCount = fangyuanxinxiService.FindShaixuanCount(pmap);
			List<Fangyuanxinxi> findShaixuanFyxxByTime = fangyuanxinxiService.FindShaixuanFyxxByTime(pmap);
			for (Fangyuanxinxi fangyuanxinxi : findShaixuanFyxxByTime) {
				int guanzhurenshu = fangyuanxinxiService.getGuanzhurenshu(fangyuanxinxi.getBianhao());
				fangyuanxinxi.setGuanzhurenshu(guanzhurenshu);
			}
			PageResult pageResult = new PageResult(currentPage, pageSize, findShaixuanFyxxByTime, findShaixuanCount);
			session.setAttribute("pageResult", pageResult);
			session.setAttribute("navi", "newest2");
			session.setAttribute("shaixuan", shaixuan);
		}
		return "fangyuanxinxilist";
	}
	
	//前台房源detail
	@RequestMapping("fyxxDetail.do")
	public String fyxxDetail(
			@RequestParam(value="id",required=true) String bianhao,
			ModelMap map,
			HttpSession session){
		Fangyuanxinxi selectByBianhao = fangyuanxinxiService.selectByBianhao(bianhao);
		List<Fangyuantupian> selectTupianByBihao = fangyuanxinxiService.selectTupianByBihao(bianhao);
		Jingjiren selectJingjirenByBihao = fangyuanxinxiService.selectJingjirenByBihao(bianhao);
		List<Fkjj> selectFkByBh = fangyuanxinxiService.selectFkByBh(bianhao);
		List<Kfjj> selectKfByBh = fangyuanxinxiService.selectKfByBh(bianhao);
		map.put("xinxi", selectByBianhao);
		map.put("fytupian", selectTupianByBihao);
		map.put("jingjiren", selectJingjirenByBihao);
		map.put("fankui", selectFkByBh);
		if(selectKfByBh.get(0).getCishu()==0) {
			map.put("kanfang", "nodata1");
		}else {
			map.put("kanfang", selectKfByBh);
		}
		
		Yonghu yonghu = (Yonghu) session.getAttribute("userInfo");
		String ufid="";
		if(yonghu!=null) { ufid= yonghu.getUfid();}
		Map<String,Object> gzxx =new HashMap<String,Object>();
		gzxx.put("ufid", ufid);
		gzxx.put("bianhao", bianhao);
		Guanzhu findguanzhu = fangyuanxinxiService.Findguanzhu(gzxx);
		if (findguanzhu==null) {
			map.put("gz1", "ngz");
		}
		Map<String,Object> pmap1 =new HashMap<String,Object>();
		pmap1.put("ufid",ufid);
		int findCountguanzhuByufid = fangyuanxinxiService.FindCountguanzhuByufid(pmap1);
		if(yonghu==null||findCountguanzhuByufid==0) {
			Map<String,Object> pmap2 =new HashMap<String,Object>();
			pmap2.put("guihuaqu", selectByBianhao.getGuihuaqu());
			pmap2.put("bianhao", selectByBianhao.getBianhao());
			List<Fangyuanxinxi> fyxxByGuihuaqi = fangyuanxinxiService.getFyxxByGuihuaqi(pmap2);
			map.put("recommendFyxx",fyxxByGuihuaqi);
		}else {
		pmap1.put("bianhao",bianhao);
		List<Fangyuanxinxi> recommendFyxx = fangyuanxinxiService.RecommendFyxx(pmap1);
		map.put("recommendFyxx", recommendFyxx);
		}
		return "fangyuanxinxidetail";
	}
	
	//前台房源关注
	@RequestMapping("fyattention.do")
	public void fyattention(
			@RequestParam("ufid")String ufid,
			@RequestParam("bianhao")String bianhao,
			HttpServletResponse response
    		) throws Exception{
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("ufid", ufid);
		pmap.put("bianhao", bianhao);
		fangyuanxinxiService.insertGuanzhu(pmap);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("success");
	}
	
	//前台房源取消关注
	@RequestMapping("fycancel.do")
	public void fycancel(
			@RequestParam("ufid")String ufid,
			@RequestParam("bianhao")String bianhao,
			HttpServletResponse response
    		) throws Exception{
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("ufid", ufid);
		pmap.put("bianhao", bianhao);
		fangyuanxinxiService.killGuanzhu(pmap);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("success");
	}
   
	//前台房源查询是否关注
	@RequestMapping("findguanzhu.do")
	public void findguanzhu(
			@RequestParam("ufid")String ufid,
			@RequestParam("bianhao")String bianhao,
			HttpServletResponse response) throws Exception{
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("ufid", ufid);
		pmap.put("bianhao", bianhao);
		Guanzhu findguanzhu = fangyuanxinxiService.Findguanzhu(pmap);
		if (findguanzhu==null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("nohaved");
		}else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("haved");
		}
	}
	
	
	@RequestMapping("insertFangyuanxinxi.do")
	public String insertFangyuanxinxi(
			MultipartHttpServletRequest request,
			@RequestParam(value="input_2",required=false) String input_2,
			@RequestParam(value="input_3",required=false) String input_3,
			@RequestParam(value="input_4",required=false) String input_4,
			@RequestParam(value="input_5",required=false) String input_5,
			@RequestParam(value="input_7",required=false) String input_7,
			@RequestParam(value="input_8",required=false) String input_8,
			@RequestParam(value="input_9",required=false) String input_9,
			@RequestParam(value="input_10",required=false) String input_10,
			@RequestParam(value="input_11",required=false) String input_11,
			@RequestParam(value="input_12",required=false) String input_12,
			@RequestParam(value="input_13",required=false) String input_13,
			@RequestParam(value="input_14",required=false) String input_14,
			@RequestParam(value="input_15",required=false) String input_15,
			@RequestParam(value="input_16",required=false) String input_16,
			@RequestParam(value="input_17",required=false) String input_17,
			@RequestParam(value="input_18",required=false) String input_18,
			@RequestParam(value="input_19",required=false) String input_19,
			@RequestParam(value="input_20",required=false) String input_20,
			@RequestParam(value="input_21",required=false) String input_21,
			@RequestParam(value="input_22",required=false) String input_22,
			HttpSession session,
			ModelMap map
			) throws Exception{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String path1="";
		String path2="";
		String filename="";
		String fistfilename="";
		boolean first=true;
		Iterator<String> fileNames = request.getFileNames();
		while (fileNames.hasNext()) {
			String fileName=fileNames.next();
			List<MultipartFile> fileList=request.getFiles(fileName);
			if (fileList.size()>1) {
				Iterator<MultipartFile> fileIte=fileList.iterator();
				while (fileIte.hasNext()) {
					MultipartFile multipartFile=fileIte.next();
					filename = multipartFile.getOriginalFilename();
					path1 = "/fdc/Listing_photos/";
					path2 = "C:\\fangdichan\\Listing_photos";
                    File filepath = new File(path2,uuid+filename);
                    if (!filepath.getParentFile().exists()) { 
        	        	filepath.getParentFile().mkdirs();
        	        }
                    multipartFile.transferTo(new File(path2+File.separator+uuid+filename));
        			System.out.println("上传文件路径：" + path2+File.separator+uuid+filename);
        			if(first){
        				fistfilename=path1+uuid+filename;
        				first=false;
        			}
        			Map<String, Object> pmap2=new HashMap<String,Object>();
        			pmap2.put("bianhao", uuid);
        			pmap2.put("tupian", path1+uuid+filename);
        			pmap2.put("tupian2", path2+File.separator+uuid+filename);
        			fangyuanxinxiService.insertFytp(pmap2);
                    
				}
			}
		}
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("bianhao", uuid);
		pmap.put("guihuaqu", input_2);
		pmap.put("loupanming", input_3);
		pmap.put("shoujia", input_4);
		pmap.put("biaoti", input_5);
		pmap.put("zhanshizhaopian", fistfilename);
		pmap.put("huxing", input_7);
		pmap.put("louceng", input_8);
		pmap.put("mianji", input_9);
		pmap.put("huxingjiegou", input_10);
		pmap.put("jianzhuleixing", input_11);
		pmap.put("jianzhujiegou", input_12);
		pmap.put("chaoxiang", input_13);
		pmap.put("zhuangxiu", input_14);
		pmap.put("tihubili", input_15);
		pmap.put("peibeidianti", input_16);
		pmap.put("chanquannianxian", input_17);
		pmap.put("jiaoyiquanshu", input_18);
		pmap.put("fangwuyongtu", input_19);
		pmap.put("fangwunianxian", input_20);
		pmap.put("chanquansuoshu", input_21);
		pmap.put("diyaxinxi", input_22);
		pmap.put("fabushijian", time.toString().substring(0, 19));
		fangyuanxinxiService.insertFyxx(pmap);			
		Jingjiren jingjiren = (Jingjiren)session.getAttribute("jjrxinxi");	
		Map<String,Object> pmap2 = new HashMap<String,Object>();
		pmap2.put("gonghao", jingjiren.getGonghao());
		pmap2.put("bianhao", uuid);
		fangyuanxinxiService.insertFyjj(pmap2);	
		map.put("msg","success");
		return "fangyuanxinxi_insert";
		//return "redirect:fangyuanxinxiList.do";
	}
	
	@RequestMapping("updateFangyuanxinxi1.do")
	public String updateFangyuanxinxi1(
			@RequestParam(value="update_info",required=false) String update_info,
			@RequestParam(value="currentPage",required=false) Integer currentPage,
			ModelMap map
			) {
		if(currentPage==null||currentPage<=0) {
			currentPage=1;
		}
		int pageSize=1;
		int beginIndex=(currentPage-1)*pageSize;
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("beginIndex", beginIndex);
		pmap.put("pageSize", pageSize);
		pmap.put("keyword", update_info);
		int fyxxByUpdateByCount = fangyuanxinxiService.getFyxxByUpdateByCount(pmap);
		if(fyxxByUpdateByCount>0) {
		Fangyuanxinxi fyxxByUpdate = fangyuanxinxiService.getFyxxByUpdate(pmap);
		PageResult pageResult = new PageResult(currentPage, pageSize, fyxxByUpdate, fyxxByUpdateByCount); 
		map.put("pageResult", pageResult);
		map.put("keyword", update_info);
		map.put("flag", "ok");
		}
		return "fangyuanxinxi_update";
	}
	
	@RequestMapping("updateFangyuanxinxi2.do")
	public String updateFangyuanxinxi2(
			MultipartHttpServletRequest request,
			@RequestParam(value="input_1",required=false) String input_1,
			@RequestParam(value="input_2",required=false) String input_2,
			@RequestParam(value="input_3",required=false) String input_3,
			@RequestParam(value="input_4",required=false) String input_4,
			@RequestParam(value="input_5",required=false) String input_5,
			@RequestParam(value="input_7",required=false) String input_7,
			@RequestParam(value="input_8",required=false) String input_8,
			@RequestParam(value="input_9",required=false) String input_9,
			@RequestParam(value="input_10",required=false) String input_10,
			@RequestParam(value="input_11",required=false) String input_11,
			@RequestParam(value="input_12",required=false) String input_12,
			@RequestParam(value="input_13",required=false) String input_13,
			@RequestParam(value="input_14",required=false) String input_14,
			@RequestParam(value="input_15",required=false) String input_15,
			@RequestParam(value="input_16",required=false) String input_16,
			@RequestParam(value="input_17",required=false) String input_17,
			@RequestParam(value="input_18",required=false) String input_18,
			@RequestParam(value="input_19",required=false) String input_19,
			@RequestParam(value="input_20",required=false) String input_20,
			@RequestParam(value="input_21",required=false) String input_21,
			@RequestParam(value="input_22",required=false) String input_22
			) throws Exception{
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String path1="";
		String path2="";
		String filename="";
		String fistfilename="";
		boolean first=true;
		boolean deleteFile=false;
		Iterator<String> fileNames = request.getFileNames();
		while (fileNames.hasNext()) {
			String fileName=fileNames.next();
			List<MultipartFile> fileList=request.getFiles(fileName);
			if (fileList.size()>1) {
				deleteFile=true;
				Iterator<MultipartFile> fileIte=fileList.iterator();
				if(deleteFile) {
					List<String> fytpByUpdate = fangyuanxinxiService.getFytpByUpdate(input_1);
					for (String string : fytpByUpdate) {
						File file2 = new File(string);
						file2.delete();
					}
					fangyuanxinxiService.deleteFytp(input_1);
				}
				while (fileIte.hasNext()) {
					MultipartFile multipartFile=fileIte.next();
					filename = multipartFile.getOriginalFilename();
                    //String path ="D:/testUpload/";
					path1 = "/fdc/Listing_photos/";
					path2 = "C:\\fangdichan\\Listing_photos";
                    File filepath = new File(path2,uuid+filename);
                    if (!filepath.getParentFile().exists()) { 
        	        	filepath.getParentFile().mkdirs();
        	        }
                    multipartFile.transferTo(new File(path2+File.separator+uuid+filename));
        			System.out.println("上传文件路径：" + path2+File.separator+uuid+filename);
        			if(first){
        				fistfilename=path1+uuid+filename;
        				first=false;
        			}
        			Map<String, Object> pmap2=new HashMap<String,Object>();
        			pmap2.put("bianhao", input_1);
        			pmap2.put("tupian", path1+uuid+filename);
        			pmap2.put("tupian2", path2+File.separator+uuid+filename);
        			fangyuanxinxiService.insertFytp(pmap2);
                    /*String contentType=multipartFile.getContentType();
                    System.out.println("contentType: "+contentType);
                    String name=multipartFile.getName();
                    System.out.println("name: "+name);
                    long size=multipartFile.getSize();
                    System.out.println("size: "+size);*/
				}
			}
		}
		
		
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("bianhao", input_1);
		pmap.put("guihuaqu", input_2);
		pmap.put("loupanming", input_3);
		pmap.put("shoujia", input_4);
		pmap.put("biaoti", input_5);
		pmap.put("zhanshizhaopian", fistfilename);
		pmap.put("huxing", input_7);
		pmap.put("louceng", input_8);
		pmap.put("mianji", input_9);
		pmap.put("huxingjiegou", input_10);
		pmap.put("jianzhuleixing", input_11);
		pmap.put("jianzhujiegou", input_12);
		pmap.put("chaoxiang", input_13);
		pmap.put("zhuangxiu", input_14);
		pmap.put("tihubili", input_15);
		pmap.put("peibeidianti", input_16);
		pmap.put("chanquannianxian", input_17);
		pmap.put("jiaoyiquanshu", input_18);
		pmap.put("fangwuyongtu", input_19);
		pmap.put("fangwunianxian", input_20);
		pmap.put("chanquansuoshu", input_21);
		pmap.put("diyaxinxi", input_22);
		
		fangyuanxinxiService.updateFyxx(pmap);
		
		
		return "fangyuanxinxi_update";
	}
	
	@RequestMapping("deleteFyxx.do")
	public String deleteFyxx(
			@RequestParam(value="delete_info",required=false) String delete_info
			) {
		List<String> fytpByUpdate = fangyuanxinxiService.getFytpByUpdate(delete_info);
		for (String string : fytpByUpdate) {
			File file2 = new File(string);
			file2.delete();
		}
		fangyuanxinxiService.deleteFytp(delete_info);
		fangyuanxinxiService.deleteFyGuanzhu(delete_info);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("delete_info", delete_info);
		fangyuanxinxiService.deleteFyxx(pmap);
		return "fangyuanxinxi_delete";
	} 
	
	@RequestMapping("insertFankui.do")
	public String insertFankui(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="content",required=false) String feedback,
			@RequestParam(value="gonghao",required=false) String gonghao
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		pmap.put("feedback", feedback);
		fangyuanxinxiService.insertFankui(pmap);
		return "Kanfangfankui_insert";
	}
 
	@RequestMapping("updateFankui1.do")
	public String updateFankui1(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			ModelMap map
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		Fankui selectupdateFankui = fangyuanxinxiService.selectupdateFankui(pmap);
		map.put("Fankui", selectupdateFankui);
		map.put("flag", "ok");
		return "Kanfangfankui_update";
	}
	
	@RequestMapping("updateFankui2.do")
	public String updateFankui2(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="content",required=false) String feedback,
			@RequestParam(value="gonghao",required=false) String gonghao
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		pmap.put("feedback", feedback);
		fangyuanxinxiService.updateFankui(pmap);
		return "Kanfangfankui_update";
	}
	
	@RequestMapping("deleteFankui.do")
	public String deleteFankui(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		fangyuanxinxiService.deleteFankui(pmap);
		return "Kanfangfankui_delete";
	}
	
	@RequestMapping("insertKanfangjilu.do")
	public String insertKanfangjilu(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			@RequestParam(value="Date",required=false) String Date
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		pmap.put("kfsj", Date);
		fangyuanxinxiService.insertKanfangjilu(pmap);
		return "Kanfangjilu_insert";
	}
	
	@RequestMapping("deleteKanfangjilu1.do")
	public String deleteKanfangjilu1(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			ModelMap map
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		List<Kanfang> selectKanfangjilu = fangyuanxinxiService.selectKanfangjilu(pmap);
		map.put("flag", "ok");
		map.put("Kanfang", selectKanfangjilu);
		return "Kanfangjilu_delete";
	}
	
	@RequestMapping("deleteKanfangjilu2.do")
	public String deleteKanfangjilu2(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			@RequestParam(value="Date",required=false) String Date
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		pmap.put("kfsj", Date);
		fangyuanxinxiService.deleteKanfangjilu(pmap);;
		return "Kanfangjilu_delete";
	}
	
	@RequestMapping("updateKanfangjilu1.do")
	public String updateKanfangjilu1(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			ModelMap map
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		List<Kanfang> selectKanfangjilu = fangyuanxinxiService.selectKanfangjilu(pmap);
		map.put("flag", "ok");
		map.put("Kanfang", selectKanfangjilu);
		return "Kanfangjilu_update";
	}
	
	@RequestMapping("updateKanfangjilu2.do")
	public String updateKanfangjilu2(
			@RequestParam(value="bianhao",required=false) String bianhao,
			@RequestParam(value="gonghao",required=false) String gonghao,
			@RequestParam(value="Date",required=false) String Date
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("gonghao", gonghao);
		pmap.put("bianhao", bianhao);
		pmap.put("kfsj", Date);
		fangyuanxinxiService.updateKanfangjilu(pmap);
		return "Kanfangjilu_update";
	}
	
	@RequestMapping("fangyuanfabu.do")
	public String fangyuanfabu(
			@RequestParam(value="xiaoqu1",required=false) String xiaoqu,
			@RequestParam(value="dizhi1",required=false) String dizhi,
			@RequestParam(value="jiage1",required=false) String jiage,
			@RequestParam(value="chenghu1",required=false) String chenghu,
			@RequestParam(value="tel1",required=false) String tel
			) {
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("xiaoqu", xiaoqu);
		pmap.put("dizhi", dizhi);
		pmap.put("jiage", jiage);
		pmap.put("chenghu", chenghu);
		pmap.put("tel", tel);
		pmap.put("chuli","0");
		fangyuanxinxiService.insertFabu(pmap);
		return "fangyuanxinxi_fangyuanfabu";
	}
	
	@RequestMapping("yonghufangyuan.do")
	public String yonghufangyuan(
			@RequestParam(value="currentPage",required=false) Integer currentPage,
			ModelMap map
			) {
		if(currentPage==null) {
			currentPage=1;
		}
		Map<String, Object> pmap=new HashMap<String,Object>();
		int pageSize=1;
		int beginIndex=(currentPage-1)*pageSize;
		pmap.put("beginIndex", beginIndex);
		pmap.put("pageSize", pageSize);
		int selectCountUncheckFy = fangyuanxinxiService.selectCountUncheckFy();
		List<Fabu> selectUncheckFy = fangyuanxinxiService.selectUncheckFy(pmap);
		PageResult pageResult = new PageResult(currentPage, pageSize, selectUncheckFy, selectCountUncheckFy);
		map.put("pageResult", pageResult);
		map.put("flag1", "ok");
		return "fangyuanxinxi_yonghufangyuan";
	}
	
	@RequestMapping("yonghufangyuan2.do")
	public String yonghufangyuan2(
			@RequestParam(value="id1",required=false) String id1,
			ModelMap map
			) {
		Map<String, Object> pmap2=new HashMap<String,Object>();
		int parseInt = Integer.parseInt(id1);
		pmap2.put("id", parseInt);
		fangyuanxinxiService.updateFabubychuli0(pmap2);
		Map<String, Object> pmap=new HashMap<String,Object>();
		int pageSize=1;
		int beginIndex=(1-1)*pageSize;
		pmap.put("beginIndex", beginIndex);
		pmap.put("pageSize", pageSize);
		int selectCountUncheckFy = fangyuanxinxiService.selectCountUncheckFy();
		List<Fabu> selectUncheckFy = fangyuanxinxiService.selectUncheckFy(pmap);
		PageResult pageResult = new PageResult(1, pageSize, selectUncheckFy, selectCountUncheckFy);
		map.put("pageResult", pageResult);
		map.put("flag1", "ok");
		return "fangyuanxinxi_yonghufangyuan";
	}
	
}
