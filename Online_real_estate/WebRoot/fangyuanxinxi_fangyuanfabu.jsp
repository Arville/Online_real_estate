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

</head>
<body>

<jsp:include page="hsgbanner.jsp"></jsp:include>


<div class="contain1">
	<div class="contain2">
	  <form action="fangyuanfabu.do" method="post">
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="city1" id="city1" value="深圳" disabled="disabled" />
					<label class="input__label input__label--jiro" for="city1">
						<span class="input__label-content input__label-content--jiro">小区所在城市</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="xiaoqu1" id="xiaoqu1" placeholder="请输入小区名" />
					<label class="input__label input__label--jiro" for="xiaoqu1">
						<span class="input__label-content input__label-content--jiro">小区</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="dizhi1" id="dizhi1" placeholder="请输入房屋的具体地址" />
					<label class="input__label input__label--jiro" for="dizhi1">
						<span class="input__label-content input__label-content--jiro">房屋地址</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="jiage1" id="jiage1" placeholder="请输入您期望卖出的价格" />
					<label class="input__label input__label--jiro" for="jiage1">
						<span class="input__label-content input__label-content--jiro">期望售价（万元）</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="chenghu1" id="chenghu1" placeholder="我们应该如何称呼您" />
					<label class="input__label input__label--jiro" for="chenghu1">
						<span class="input__label-content input__label-content--jiro">称呼</span>
					</label>
		</span>  <br/>
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="tel1" id="tel1" value="${userInfo.tel}" />
					<label class="input__label input__label--jiro" for="tel1">
						<span class="input__label-content input__label-content--jiro">手机号码</span>
					</label>
		</span>  <br/>
		
		<span><input type="submit" value="提交"></span>
	  </form>
	</div>
</div>



<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<script type="text/javascript" src="js/fangyuanxinxi_update.js"></script>
</body>
</html>