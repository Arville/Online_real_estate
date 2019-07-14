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

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/fangyuanxinxilist.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/hsgbanner.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />


<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<script type="text/javascript" src="js/index.js"></script>



</head>

<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="row">
		<div class="col-md-12">
			<div id="searchcon"></div>
		</div>
			
		</div>
	</div>
<br />
<br />
<br />
<br />
<div class="margin_3">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>

				<div class="col-md-8">
				
					<div id="menu2" class="menu">
						<ul>
						<c:choose>
							<c:when test="${navi=='default'}"><li style="background: #00ae66;"><a style="color: #FFFFFF"  href="fyxxList.do?currentPage=1&navigation=default&keyword=${keyword}">默认排序</a></li></c:when>
							<c:when test="${navi=='default2'}"><li style="background: #00ae66;"><a style="color: #FFFFFF"  href="fyxxList.do?currentPage=1&navigation=default2&shaixuan=${shaixuan}">默认排序</a></li></c:when>
							<c:when test="${navi=='newest2'}"><li><a href="fyxxList.do?currentPage=1&navigation=default2&shaixuan=${shaixuan}">默认排序</a></li></c:when>
							<c:when test="${navi=='newest'}"><li><a href="fyxxList.do?currentPage=1&navigation=default&keyword=${keyword}">默认排序</a></li></c:when>
						</c:choose>
							
						<c:choose>
							<c:when test="${navi=='newest'}"><li style="background: #00ae66;"><a style="color: #FFFFFF"  href="fyxxList.do?currentPage=1&navigation=newest&keyword=${keyword}">最新</a></li></c:when>
							<c:when test="${navi=='newest2'}"><li style="background: #00ae66;"><a style="color: #FFFFFF"  href="fyxxList.do?currentPage=1&navigation=newest2&shaixuan=${shaixuan}">最新</a></li></c:when>
							<c:when test="${navi=='default2'}"><li><a href="fyxxList.do?currentPage=1&navigation=newest2&shaixuan=${shaixuan}">最新</a></li></c:when>
							<c:when test="${navi=='default'}"><li><a href="fyxxList.do?currentPage=1&navigation=newest&keyword=${keyword}">最新</a></li></c:when>
						</c:choose>
						</ul>
						<div class="cls"></div>
					</div>
				
			<c:forEach items="${pageResult.listData}" var="p">
			
				<div class="margin_1">
					  <div class="float_1">
							<a href="fyxxDetail.do?id=${p.bianhao}"><img src="${p.zhanshizhaopian}" alt="房源封面" /></a>
					  </div>
						
					  <div class="f2_f3">	
					  
						<div class="float_2">
						
						  <div class="margin_2">
							<c:set var="testStr" value="${p.biaoti}" />
							<c:choose>
								<c:when test="${fn:length(testStr) > 24}">
									<a href="fyxxDetail.do?id=${p.bianhao}"><c:out value="${fn:substring(testStr, 0, 24)}......" /></a>
								</c:when>
								<c:otherwise>
									<a href="fyxxDetail.do?id=${p.bianhao}"><c:out value="${testStr}" /></a>
								</c:otherwise>
							</c:choose>
						  </div>
						
						  <div class="margin_2">
						  	<span class="glyphicon glyphicon-home"></span>&emsp;<span>${p.guihuaqu}</span>&emsp;<span>|&emsp;${p.loupanming}</span>&emsp;<span>|&emsp;${p.huxing}</span>&emsp;
						  	<span>|&emsp;${p.mianji}平米</span>&emsp;<span>|&emsp;${p.chaoxiang}</span>&emsp;<span>|&emsp;${p.zhuangxiu}</span>&emsp;<span>|&emsp;${p.peibeidianti}电梯</span>
						  </div>
						  
						  <div class="margin_2">
						  	<span class="glyphicon glyphicon-map-marker"></span>&emsp;<span>${p.louceng}</span>&emsp;<span>|&emsp;${p.jianzhuleixing}</span>
						  </div>
						  
						  <div class="margin_2">
						  	<span class="glyphicon glyphicon-star-empty"></span>&emsp;<span>${p.guanzhurenshu}人关注</span>&emsp;<span>/&emsp;${fn:substring(p.fabushijian, 0, 10)}发布</span>
						  </div>
						  
						</div>
						
						<div class="float_3"></div>
						
						<input type="hidden" value="${p.bianhao}" />
						
					  </div>
					  
					  <div class="float_4">
					  	<span class="font1">${p.shoujia}&nbsp;万</span>
					  </div>
					  
				</div>
			</c:forEach>
				
				
				<div class="col-md-2"></div>
		</div>
	</div>
</div>
</div>
<div class="margin_3">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
				<div class="col-md-8">
					<nav class="pagination-outer" aria-label="Page navigation">
					<ul id="ul1" class="pagination">
						
						
						
					</ul>
					</nav>
				</div>
				<div class="col-md-2"></div>
		</div>
	</div>
</div>
	<input id="currentPage1" type="hidden" value="${pageResult.currentPage}" />
	<input id="totalPage1" type="hidden" value="${pageResult.totalPage}" />
	<input id="navi1" type="hidden" value="${navi}" />
	<input id="keyword1" type="hidden" value="${keyword}" />
	<input id="shaixuan1" type="hidden" value="${shaixuan}" />
	<input id="ufid1" type="hidden" value="${userInfo.ufid}" />
	
	<jsp:include page="qtdown.jsp"></jsp:include>
	

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/data.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/a.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/layer/3.1.0/layer.js"></script>
<script type="text/javascript" src="js/fangyuanxinxilist.js"></script>

</body>
</html>
