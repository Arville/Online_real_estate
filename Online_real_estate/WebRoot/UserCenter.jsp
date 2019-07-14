<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/hsgbanner.css" />

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style type="text/css">
a{text-decoration: none;}
a:hover{text-decoration: none;}
.pagination-outer{ text-align: center; }
		.pagination{
		    font-family: 'Allerta Stencil', sans-serif;
		    display: inline-flex;
		    position: relative;
		}
		.pagination li a.page-link{
		    color: #fff;
		    background: transparent;
		    font-size: 21px;
		    line-height: 35px;
		    height: 38px;
		    width: 38px;
		    padding: 0;
		    margin: 0 8px;
		    border: none;
		    position: relative;
		    z-index: 1;
		    transition: all 0.4s ease 0s;
		}
		.pagination li.active a.page-link,
		.pagination li a.page-link:hover,
		.pagination li.active a.page-link:hover{
		    color: #fff;
		    background-color: transparent;
		}
		.pagination li a.page-link:before,
		.pagination li a.page-link:after{
		    content:'';
		    background: linear-gradient(225deg,#f857a6,#ff5858);
		    height: 100%;
		    width: 100%;
		    border: 3px solid #fff;
		    box-shadow: 0 0 3px #000;
		    border-radius: 50%;
		    opacity: 1;
		    transform: translateX(-50%) translateY(-50%) rotate(-45deg);
		    position: absolute;
		    top: 50%;
		    left: 50%;
		    z-index: -1;
		    transition: all 0.3s ease-in;
		}
		.pagination li a.page-link:hover:before,
		.pagination li.active a.page-link:before{
		    border-radius: 50% 0 50% 50%;
		}
		.pagination li a.page-link:after{
		    background: #fff;
		    height: 5px;
		    width: 5px;
		    border: none;
		    box-shadow: 0 0 0 transparent;
		    opacity: 0;
		    transform: translateX(-50%) translateY(0) rotate(0);
		    top: auto;
		    bottom: 0;
		}
		.pagination li a.page-link:hover:after,
		.pagination li.active a.page-link:after{
		    opacity: 1;
		    bottom: 85%;
		}
		.pagination li:first-child a.page-link:before{
		    transform: translateX(-50%) translateY(-50%) rotate(-135deg);
		}
		.pagination li:first-child a.page-link:hover:before{ border-radius: 50% 0 50% 50%; }
		.pagination li:first-child a.page-link:after{
		    transform: translateX(0) translateY(-50%);
		    top: 50%;
		    bottom:auto;
		    left: auto;
		    right: 0;
		 }
		.pagination li:first-child a.page-link:hover:after{ right: 80%; }
		.pagination li:last-child a.page-link:before{
		    transform: translateX(-50%) translateY(-50%) rotate(45deg);
		}
		.pagination li:last-child a.page-link:hover:before{ border-radius: 50% 0 50% 50%; }
		.pagination li:last-child a.page-link:after{
		    transform: translateX(0) translateY(-50%);
		    bottom:auto;
		    top: 50%;
		    left: 0;
		}
		.pagination li:last-child a.page-link:hover:after{ left: 80%; }
		@media only screen and (max-width: 480px){
		    .pagination{ display: block; }
		 
		    .pagination li{
		        margin-bottom: 10px;
		        display: inline-block;
		    }
		}
</style>
</head>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>
<div style="margin: 0 auto;width: 1000px;height: 700px; ">
	<div style="width: 152px;height: 600px; float: left;margin-top: 50px;">
		<div style="margin: 0 auto;width: 80px;height: 80px;margin-top:20px; ">
			<img alt="用户头像" src="${userInfo.touxiang}" style="width: 80px;height: 80px;" />
		</div>
		<div style="margin: 0 auto;width: 100px;height: 40px;margin-top:10px; ">
			<span style="font-size: 14px;">&emsp;&emsp;欢迎你<br>&emsp;&emsp;${userInfo.username}</span>
		</div>
		<div style="margin: 0 auto;width: 100px;height: 40px;margin-top:20px; ">
			<a href="UserCenter.do"><span style="font-size: 16px;">&emsp;关注的房源</span></a> <br/><br/>
			<a href="liuyanhuifu.do"><span style="font-size: 16px;">&emsp;留言回复</span></a>
		</div>
	</div>
	<div style="width: 800px;height: auto; float: left;margin-top: 50px;margin-left: 40px;">
		<c:choose>
				<c:when test="${choose2=='guanzhufy'}">
					<c:if test="${fn:length(pageResult.listData) ==0}">
						<span style="font-size: 22px;font-weight: bolder;">暂无关注房源</span>
					</c:if>
					<c:forEach items="${pageResult.listData}" var="f">
						<div class="contain1" style="width: 798px; height: 200px;">
							<div
								style="width: 173px; height: 150px; float: left; margin-top: 20px; margin-left: 20px;">
								<a href="fyxxDetail.do?id=${f.bianhao}"> <img alt="房源封面"
									src="${f.zhanshizhaopian}" style="width: 173px; height: 150px;">
								</a>
							</div>
							<div
								style="width: 530px; height: 150px; float: left; margin-top: 20px; margin-left: 20px;">
								<div style="width: 528px; height: 49px;">
									<c:choose>
										<c:when test="${fn:length(f.biaoti) > 20}">
											<a href="fyxxDetail.do?id=${f.bianhao}">
												<span style="font-size: 22px; font-weight: bolder;">${fn:substring(f.biaoti, 0, 20)}......</span>
											</a>
										</c:when>
										<c:otherwise>
											<a href="fyxxDetail.do?id=${f.bianhao}">
												<span style="font-size: 22px; font-weight: bolder;">${f.biaoti}</span>	
											</a>
										</c:otherwise>
									</c:choose>
									
								</div>
								<div style="width: 528px; height: 49px;">
									<span style="font-size: 14px;">${f.loupanming}</span>&emsp; <span
										style="font-size: 14px;">${f.huxing}</span>&emsp;|&emsp; <span
										style="font-size: 14px;">${f.mianji}平米</span>&emsp;|&emsp; <span
										style="font-size: 14px;">${f.chaoxiang}</span>&emsp;&emsp;&emsp;
									<span
										style="font-size: 20px; font-weight: bolder; color: #E4393C;">${f.shoujia}万</span>
								</div>
								<div style="width: 528px; height: 49px;">
									<span style="font-size: 14px;">${f.guihuaqu}</span>&emsp;/&emsp;
									<span style="font-size: 14px;">${f.louceng}</span>&emsp;/&emsp;
									<span style="font-size: 14px;">${f.jianzhuleixing}</span>
								</div>
							</div>
							<div
								style="width: 50px; height: 30px; float: left; margin-top: 20px;">
							</div>
							<input type="hidden" value="${f.bianhao}">
						</div>
					</c:forEach>
					<div style="margin-top: 30px;">
							<nav class="pagination-outer" aria-label="Page navigation">
					<ul id="ul1" class="pagination">
						
						
						
					</ul>
					</nav>
					</div>
	
				</c:when>
				<c:otherwise>
				   <c:if test="${fn:length(LiuyanList) > 0}">
					  <c:forEach items="${LiuyanList}" var="ly">
						 <div class="contain1" style="width: 798px; height: 200px;font-size: 14px;">
							房源标题：${ly.biaoti}<br/><br/>
							经纪人姓名：${ly.xingming}<br/><br/>
							我的提问：${ly.lyneirong}<br/><br/>
							经纪人回复：${ly.jjrhf}<br/><br/>
							经纪人回复时间：${ly.addtime}<br/><br/>
						 </div>
					  </c:forEach>
				   </c:if>
				   <c:if test="${fn:length(LiuyanList) == 0}">
				   	<span style="font-size: 22px;font-weight: bolder;">暂无回复消息</span>	
				   </c:if>
				</c:otherwise>
			</c:choose>
	</div>
	
	
</div>

<input id="ufid1" type="hidden" value="${userInfo.ufid}">
<input id="currentPage1" type="hidden" value="${pageResult.currentPage}" />
<input id="totalPage1" type="hidden" value="${pageResult.totalPage}" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/UserCenter.js"></script>
</body>
</html>