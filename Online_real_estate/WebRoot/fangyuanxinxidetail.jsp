<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>房源信息</title>

<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<link rel="stylesheet" type="text/css" href="css/fangyuanxinxidetail.css"/>




<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" type="text/css" href="qtimages/hsgbanner.css" />

</head>
<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>


<div class="margin_3">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="margin_3"><br/>
					<span class="h_one">${xinxi.biaoti}</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					&emsp;&emsp;&emsp;
					<span>
					<c:if test="${userInfo!=null}">
					<c:choose>
						<c:when test="${gz1=='ngz'}">
							<button id="guanzhu1" type="button" class="btn btn-success">关注</button>
						</c:when>
						<c:otherwise>
							<button id="guanzhu1" type="button" class="btn btn-success">取消关注</button>
						</c:otherwise>
					</c:choose>
					</c:if>
					</span>
					<input id="ufid1" type="hidden" value="${userInfo.ufid}" />
					<input id="bianhao1" type="hidden" value="${xinxi.bianhao}" />
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>

<div class="contain1">
  <div class="tupian">
	   <div class="swiper-container">
			<div class="swiper-wrapper">
			<c:forEach items="${fytupian}" var="p">
				<div class="swiper-slide">
					<div class="img">
						<img src="${p.tupian}"/>
					</div>
				</div>
			</c:forEach>		
			</div>
			<!-- 分页 -->
			<div class="swiper-pagination"></div>
			<!-- 按钮 -->
			<div class="swiper-button-next swiper-button-black"></div>
			<div class="swiper-button-prev swiper-button-black"></div>
		</div>
	</div>
	
	<div class="jianjie">
		<div class="jianjie1">
			<span class="font_1">${xinxi.shoujia}</span><span class="font_2">万</span>
		</div>
		
		<div class="jianjie2">
			<div class="contain2">
				<div class="font_3">${xinxi.huxing}</div><div class="font_4">${xinxi.louceng}</div>
			</div>
			<div class="contain2">
				<div class="font_3">${xinxi.chaoxiang}</div><div class="font_4">${xinxi.huxingjiegou}/${xinxi.zhuangxiu}</div>
			</div>
			<div class="contain2">
				<div class="font_3">${xinxi.mianji}平米</div><div class="font_4">${xinxi.jianzhuleixing}</div>
			</div>
		</div>
		<br/>
		<div class="contain3">
			<span class="font_5">小区名称</span>&emsp;&emsp;&emsp;<span class="font_6">${xinxi.loupanming}</span>
		</div>
		<br/>
		<div class="contain3">
			<span class="font_5">所在区域</span>&emsp;&emsp;&emsp;<span class="font_6">${xinxi.guihuaqu}</span>
		</div>
		<br/>
		<div class="contain3">
			<span class="font_5">看房时间</span>&emsp;&emsp;&emsp;<span class="font_6">提前预约随时可看</span>
		</div>
		<br/>
		<br/>
		<div class="contain4">
			<div class="img1">
				<img class="img2" src="${jingjiren.touxiang}" alt="经纪人头像" />
			</div>
			<div class="contain5">
				<span class="font_7">${jingjiren.xingming}</span>
				<br/>
				<br/>
				<div id="pc1" class="phone_click">
				<br/>
					&emsp;&emsp;<span class="glyphicon glyphicon-phone font_8"></span>
					&emsp;<span class="font_9">${jingjiren.phone}</span>
				</div>
				<br />
				<c:choose>
					<c:when test="${userInfo==null}">
						您登录后才能留言
					</c:when>
					<c:otherwise>
						<button id="leavemessage1" class="btn btn-success">留言</button>
						<input id="jjrgonghao" type="hidden" value="${jingjiren.gonghao}" />
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>

<div class="contain6">
	<div class="font_10">基本信息</div>
	<br/>
	<br/>
	<div class="contain7">
		<div class="contain8">
			基本属性
		</div>
		<div class="contain9">
			<div class="contain10">
			  <span class="font_11">房屋户型</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.huxing}</span><br/><br/>
			  <span class="font_11">建筑面积</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.mianji}㎡</span><br/><br/>
			  <span class="font_11">房屋朝向</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.chaoxiang}</span><br/><br/>
			  <span class="font_11">装修情况</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.zhuangxiu}</span><br/><br/>
			  <span class="font_11">产权年限</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.chanquannianxian}</span>
			</div>
			<div class="contain10">
			  <span class="font_11">所在楼层</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.louceng}</span><br/><br/>
			  <span class="font_11">户型结构</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.huxingjiegou}</span><br/><br/>
			  <span class="font_11">建筑类型</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.jianzhuleixing}</span><br/><br/>
			  <span class="font_11">建筑结构</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.jianzhujiegou}</span><br/><br/>
			  <span class="font_11">梯户比例</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.tihubili}</span><br/><br/>
			  <span class="font_11">配备电梯</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.peibeidianti}</span><br/><br/>
			</div>
		</div>
	</div>
	<br />
	<div class="contain7">
		<div class="contain8">
			交易属性
		</div>
		<div class="contain9">
			<div class="contain10">
			  <span class="font_11">挂牌时间</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">
			  ${fn:substring(xinxi.fabushijian, 0, 10)}
			  </span><br/><br/>
			  <span class="font_11">房屋年限</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.fangwunianxian}</span><br/><br/>
			  <span class="font_11">抵押信息</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.diyaxinxi}</span><br/><br/>
			</div>
			<div class="contain10">
			  <span class="font_11">交易权属</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.jiaoyiquanshu}</span><br/><br/>
			  <span class="font_11">房屋用途</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.fangwuyongtu}</span><br/><br/>
			  <span class="font_11">产权所属</span>&emsp;&emsp;&emsp;&emsp;<span class="font_12">${xinxi.chanquansuoshu}</span><br/><br/>
			</div>
		</div>
	</div>
	
	<div class="contain11">
		注：房源所示“房屋用途、交易权属、建成年代、产权年限、建筑结构”仅供参考，购房时请以房本信息为准。
	</div>
</div>
<br />
<br />
<br />
	<div class="font_10">经纪人带看反馈</div>
	<br /><br />
	<c:if test="${fn:length(fankui)<=0}">
	<div class="contain13">
		目前暂无
	</div>
	</c:if>
	<c:if test="${fn:length(fankui)>0}">
	<c:forEach items="${fankui}" var="f">
	<div class="contain13">
	  <div class="img3">
		<img class="img4" src="${f.touxiang}" alt="经纪人头像" />
	  </div>
	  <div class="contain14">
	  	<div class="contain15">
	  		<span class="font_13">${f.xingming}</span>&emsp;&emsp;&emsp;<span class="font_14">${f.phone}</span>
	  	</div>
	  	
	  	<br />
	  	
	  	<div class="contain16">
	  		${f.feedback}
	  	</div>
	  </div>
	</div>
	</c:forEach>
	</c:if>
	<br />
	
	<div class="font_10">看房记录</div>
	<br /><br />
		<div class="contain17">
			<span class="font_13">带看时间</span>
			&emsp;&emsp;<span class="font_13">带看经纪人</span>
			&emsp;&emsp;&emsp;&emsp;<span class="font_13">本房总带看</span>
			&emsp;&emsp;<span class="font_13">咨询电话</span>
		</div>
		<c:if test="${kanfang=='nodata1'}">
		   <div class="contain18">
			目前暂无
		   </div>
		</c:if>
		<c:if test="${kanfang!='nodata1'}">
		<c:forEach items="${kanfang}" var="k">
		<div class="contain18">
			<span class="font_15">
			${fn:substring(k.kfsj, 0, 10)}
			</span>
			&emsp;&emsp;<img class="img5" src="${k.touxiang}" alt="经纪人头像" />
			&emsp;<span class="font_15">${k.xingming}</span>
			&emsp;&emsp;&emsp;&emsp;&emsp;<span class="font_15">${k.cishu}次</span>
			&emsp;&emsp;&emsp;&emsp;&emsp;<span class="font_15">${k.phone}</span>
		</div>
		</c:forEach>
		</c:if>
	<br /><br /><br />
	
	<div class="font_10">
	周边配套&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<button id="canyin" type="button" class="btn btn-default">餐饮</button>
	&emsp;<button id="tingche" type="button" class="btn btn-default">停车场</button>
	&emsp;<button id="gongjiao" type="button" class="btn btn-default">公交站</button>
	&emsp;<button id="ditie" type="button" class="btn btn-default">地铁站</button>
	</div>
	<br /><br />
	
	<input type="hidden" id="address" value="深圳市${xinxi.loupanming}" />
	<div id="" style="margin: 0 auto;width: 1260px;height: 600px;">
			<div id="" style="width: 850px;height: 600px;float: left;">
				<div id="container"></div>
			</div>
			<div id="" style="width: 400px;height: 600px;float: left;">
				<div id="panel"></div>
			</div>
		</div>
	
		
		
	
	<div class="contain19">
		<span class="font_10">
			为您推荐
		</span>
	</div>
	
	<div class="contain20">
		<c:forEach items="${recommendFyxx}" var="r">
		<div class="contain21">
			<a href="fyxxDetail.do?id=${r.bianhao}"><img class="img6" src="${r.zhanshizhaopian}" alt="房源封面" /></a><br /><br />
			<p class="font_18">${r.guihuaqu}</p>
			<p class="font_18">${r.loupanming}</p>
			<div class="contain22">
				<span class="font_16">${r.huxing}·${r.mianji}平米</span>
				<span class="font_17">${r.shoujia}万</span>
			</div>
		</div>
		</c:forEach>
	</div>
<jsp:include page="qtdown.jsp"></jsp:include>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.14&key=7320a19af57e8e04c3cff15dda368367&plugin=AMap.Geocoder"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/layer/3.1.0/layer.js"></script>
<script type="text/javascript" src="js/swiper.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/fangyuanxinxidetail.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</body>
</html>
