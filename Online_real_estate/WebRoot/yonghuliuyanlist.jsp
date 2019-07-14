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
	<c:if test="${pageresult.listData!=null}">
	 <c:forEach items="${pageresult.listData}" var="y">
	  <form action="liuyanlist2.do" method="post">
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="username" id="username" value="${y.ufid}" disabled="disabled" />
					<label class="input__label input__label--jiro" for="username">
						<span class="input__label-content input__label-content--jiro">用户ID</span>
					</label>
		</span>  <br/><br/>
		
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="username" id="username" value="${y.bianhao}" disabled="disabled" />
					<label class="input__label input__label--jiro" for="username">
						<span class="input__label-content input__label-content--jiro">房源编号</span>
					</label>
		</span>  <br/><br/>
		
		用户留言
		<textarea style="width: 450px;height: 150px;resize:none;" name="yonghuliuyan">${y.lyneirong}</textarea>
		<br/><br/>
		
		回复信息
		<textarea style="width: 450px;height: 150px;resize:none;" name="hfxinxi"></textarea>  
		<br/><br/>
		<input type="hidden" name="ufid" value="${y.ufid}" />
		<input type="hidden" name="bianhao" value="${y.bianhao}" />
		<span><input type="submit" value="处理"></span>
		</form>
		</c:forEach>
		</c:if>
		<c:if test="${pageresult.listData==null}">
		无未回复留言
		</c:if>
	</div>
</div>
</c:when>

<c:otherwise>
<div class="contain1">
	<div class="contain2">
	<form action="liuyanlist.do" method="post">
	  <span class="input input--jiro">
		<span class="input__label-content input__label-content--jiro">查询未回复的用户留言</span>
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

<input id="currentPage1" type="hidden" value="${pageresult.currentPage}" />
<input id="totalPage1" type="hidden" value="${pageresult.totalPage}" />



<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<script type="text/javascript" src="js/liuyanban.js"></script>
</body>
</html>