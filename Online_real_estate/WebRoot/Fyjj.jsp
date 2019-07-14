<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<c:forEach items="${fyjj}" var="f">
		房源编号：${f.bianhao}<br>
		房源标题：${f.biaoti}<br>
		房源市辖区：${f.guihuaqu}<br>
		房源所在小区：${f.loupanming}<br><br>
	</c:forEach>
</body>
</html>