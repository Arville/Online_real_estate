<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>线上房地产服务平台</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/index.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/hsgbanner.css"/>
<link rel="stylesheet" type="text/css" href="css/default.css"/>
<link rel="stylesheet" type="text/css" href="css/fangyuanxinxidetail.css"/>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/koala.min.1.5.js"></script>
<script type="text/javascript" src="js/jquery.kxbdMarquee.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>


<jsp:include page="hsgbanner.jsp"></jsp:include>

<div class="layui-carousel" id="test1">
  <div carousel-item>
    <div><img src="upload/one.jpg"/></div>
    <div><img src="upload/two.jpg"/></div>
    <div><img src="upload/three.jpg"/></div>
    <div><img src="upload/four.jpg"/></div>
    <div><img src="upload/five.jpg"/></div>
  </div>
</div>



<div class="intitle">
	<ul>
    	<li><h1>最新房源/</h1><span>New House</span></li>
    </ul>
</div>

<div class="contain19">
		<span>
			<a href="fyxxList.do?currentPage=1&navigation=default&keyword=" style="font-size: 16px;">了解更多房源>></a>
		</span>
	</div>
   
    <div class="contain20">
		<c:forEach items="${syfangyuanxinxi1}" var="r">
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
<script src="layui/layui.js"></script>
<script>
layui.use('carousel', function(){
	  var carousel = layui.carousel;
	  //建造实例
	  carousel.render({
	    elem: '#test1'
	    ,width: '100%' //设置容器宽度
	    ,height: '500px' //设置容器宽度
	    ,arrow: 'always' //始终显示箭头
	    //,anim: 'updown' //切换动画方式
	  });
	});
</script>
</body>
</html>
