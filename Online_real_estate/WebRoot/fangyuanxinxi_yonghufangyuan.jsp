<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/fangyuanxinxi_insert.css"/>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<style type="text/css">
.pagination-outer{ text-align: center; }
		.pagination{
		    font-family: 'Rubik', sans-serif;
		    display: inline-flex;
		    position: relative;
		}
		.pagination li a.page-link{
		    color: #10ac84;
		    background-color: transparent;
		    font-size: 22px;
		    font-weight: 500;
		    line-height: 28px;
		    height: 40px;
		    width: 40px;
		    margin: 0 5px 10px;
		    border: none;
		    border-radius: 0;
		    overflow: hidden;
		    position: relative;
		    transition: all 0.4s ease 0s;
		}
		.pagination li.active a.page-link,
		.pagination li a.page-link:hover,
		.pagination li.active a.page-link:hover{
		    color: #fff;
		    background-color: #10ac84;
		}
		.pagination li:first-child a.page-link:hover,
		.pagination li:last-child a.page-link:hover{
		    box-shadow: 0 0 10px rgba(0,0,0,0.9);
		}
		.pagination li a.page-link:before{
		    content: attr(data-hover);
		    color: rgba(255,255,255,0.2);
		    font-size: 80px;
		    font-weight: 700;
		    height: 100%;
		    width: 100%;
		    opacity: 1;
		    position: absolute;
		    top: 100%;
		    left: 0;
		    transition: all 0.3s ease 0s;
		}
		.pagination li a.page-link:hover:before,
		.pagination li.active a.page-link:before{
		    opacity: 1;
		    top: 10px;
		}
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
<c:choose>
<c:when test="${flag1=='ok'}">
<div class="contain1">
	<div class="contain2">
	
	 <c:forEach items="${pageResult.listData}" var="y">
	  <form action="yonghufangyuan2.do" method="post">
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="city1" id="city1" value="深圳" disabled="disabled" />
					<label class="input__label input__label--jiro" for="city1">
						<span class="input__label-content input__label-content--jiro">小区所在城市</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="xiaoqu1" id="xiaoqu1" value="${y.xiaoqu}"  disabled="disabled" />
					<label class="input__label input__label--jiro" for="xiaoqu1">
						<span class="input__label-content input__label-content--jiro">小区</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="dizhi1" id="dizhi1" value="${y.dizhi}"  disabled="disabled" />
					<label class="input__label input__label--jiro" for="dizhi1">
						<span class="input__label-content input__label-content--jiro">房屋地址</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="jiage1" id="jiage1" value="${y.jiage}" disabled="disabled" />
					<label class="input__label input__label--jiro" for="jiage1">
						<span class="input__label-content input__label-content--jiro">期望售价（万元）</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="chenghu1" id="chenghu1" value="${y.chenghu}" disabled="disabled" />
					<label class="input__label input__label--jiro" for="chenghu1">
						<span class="input__label-content input__label-content--jiro">称呼</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="tel1" id="tel1" value="${y.tel}" disabled="disabled" />
					<label class="input__label input__label--jiro" for="tel1">
						<span class="input__label-content input__label-content--jiro">手机号码</span>
					</label>
		</span>  <br/>
		<input type="hidden" name="id1" value="${y.id}" />
		<span><input type="submit" value="处理"></span>
		</form>
		</c:forEach>
		
	</div>
</div>
</c:when>

<c:otherwise>
<div class="contain1">
	<div class="contain2">
	<form action="yonghufangyuan.do" method="post">
	  <span class="input input--jiro">
						<span class="input__label-content input__label-content--jiro">查询未处理的用户委托</span>
		</span>
		<br />
		<input type="submit" value="查询">
	</form>
	</div>
</div>
</c:otherwise>
</c:choose>

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

<input id="currentPage1" type="hidden" value="${pageResult.currentPage}" />
<input id="totalPage1" type="hidden" value="${pageResult.totalPage}" />



<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<script type="text/javascript" src="js/yonghufangyuan.js"></script>
</body>
</html>