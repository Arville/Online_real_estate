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


<div class="contain1">
	<div class="contain2">
	  <form action="deleteFyxx.do" method="post">
		<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="delete_info" id="delete_info" />
					<label class="input__label input__label--jiro" for="delete_info">
						<span class="input__label-content input__label-content--jiro">请输入要删除房源的编号： </span>
					</label>
		</span> &emsp;&emsp;
		<span><input type="submit" value="提交"></span>
	  </form>
	</div>
</div>



<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<script type="text/javascript" src="js/fangyuanxinxi_update.js"></script>
</body>
</html>