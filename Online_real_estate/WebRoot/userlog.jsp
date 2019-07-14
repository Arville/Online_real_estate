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
<link rel="stylesheet" type="text/css" href="css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>

<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>


<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>
<!--
        	作者：offline
        	时间：2019-05-22
        	描述：登录
        -->
		<div id="q1" style="width: 600px;height: auto;margin: 0 auto;margin-top: 60px;text-align: center;">
		<form class="layui-form layui-form-pane" action="frontdeskdenglu.do" method="post">
			
			<div class="layui-form-item" style="margin-top: 30px;display: inline-block;">
    				<label class="layui-form-label layui-bg-gray">用户名</label>
   	 				<div class="layui-input-inline">
      				<input type="text" name="username" lay-verify="required|username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
   		 			</div>
  			</div>
  			
  			<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
   			 	<label class="layui-form-label layui-bg-gray">密码框</label>
    			<div class="layui-input-inline">
      				<input type="password" name="password" lay-verify="required|pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
   				 </div>
  			</div>
  			
      		<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
				<label class="layui-form-label layui-bg-gray">滑动验证</label>
				<div class="layui-input-inline">
					<div id="slider"></div>
				</div>
			</div>
      		
      		<div class="layui-form-item" style="margin-top: 10px;">
				<div class="layui-input-block" style="margin-left: 150px">
				<button class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
      		
      		<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
      			还没有注册？<a id="a1" href="javascript:void(0);">点击这里注册</a>
      		</div>
      		
		</form>
		
		</div>
		
		
		<!--
        	作者：offline
        	时间：2019-05-22
        	描述：注册
        -->
		<div id="q2" style="width: 600px;height: auto;margin: 0 auto;margin-top: 60px;text-align: center;">
			<form class="layui-form layui-form-pane" enctype="multipart/form-data" action="frontdeskzhuce.do" method="post">
			
			<div class="layui-form-item" style="margin-top: 30px;display: inline-block;">
    				<label class="layui-form-label layui-bg-gray">用户名</label>
   	 				<div class="layui-input-inline">
      				<input id="u1" type="text" name="username" lay-verify="required|username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
   		 			</div>
  			</div>
  			
  			<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
   			 	<label class="layui-form-label layui-bg-gray">密码框</label>
    			<div class="layui-input-inline">
      				<input type="password" name="password" lay-verify="required|pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
   				 </div>
  			</div>
  			
  			<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
				<label class="layui-form-label layui-bg-gray">验证手机</label>
				<div class="layui-input-inline">
					<input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			
      		<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
      			<label class="layui-form-label layui-bg-gray">头像</label>
      			<div class="layui-input-inline">
					<input type="file" name="touxiang" accept="image/png,image/gif,image/jpeg,image/jpg" />
				</div>
			</div>
      		
      		<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
				<label class="layui-form-label layui-bg-gray">滑动验证</label>
				<div class="layui-input-inline">
					<div id="slider3"></div>
				</div>
			</div>
      		
      		<div class="layui-form-item" style="margin-top: 10px;">
				<div class="layui-input-block" style="margin-left: 150px">
				<button class="layui-btn" lay-submit lay-filter="demo2">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
			
			<div class="layui-form-item" style="margin-top: 10px;display: inline-block;">
      			已经有账号？<a id="a2" href="javascript:void(0);">点击这里登录</a>
      		</div>
      		
		</form>
		</div>


<input id="i1" type="hidden" value="${fault}" />


<jsp:include page="qtdown.jsp"></jsp:include>
<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/login_register.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
