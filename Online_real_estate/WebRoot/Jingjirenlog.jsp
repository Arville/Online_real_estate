<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>用户登陆</title>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/userlog.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
	color: #147001;
}
-->
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>


<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>



<div class="container1">

<div class="form" style="position:relative">
		<c:if test="${fault=='fault'}">
			<div style="margin: 0 auto;width: 300px;height: 23px;margin-bottom:10px;font-size: 23px;font-weight: bold;color: red;">
				&emsp;&emsp;用户名或密码错误
			</div>
		</c:if>
		<!--登录表单-->
        <div class="form_login" style="position:absolute;">
			
			<form action="selectJingjiren.do" method="post">
				<h1 class="h1_1">经纪人登录</h1>
				<div class="form_item">
					<label for="username">账号：</label>
					<input type="text" name="zhanghao" id="zhanghao" placeholder="请输入账号" />
				</div>
				<div class="form_item">
					<label for="password">密码：</label>
					<input type="password" name="mima" id="mima" placeholder="请输入密码名" />
				</div>
				<div class="form_item">
					<input type="submit" value="登录" />
				</div>
			</form>
         </div>
    </div>
</div>


<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
