<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/Kanfangjilu_insert.css" />
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>
<body>
<c:choose>
<c:when test="${flag=='ok'}">
<c:forEach items="${Kanfang}" var="k">
	<div style="margin: 0 auto;width: 700px; height: 200px;">
	<form action="deleteKanfangjilu2.do" method="post">
	房源编号：    ${k.bianhao}&emsp;&emsp;&emsp;    
	日期：     <input type="date" name="Date" value="${k.kfsj}" /> 
	&emsp;&emsp;&emsp;
	<input type="hidden" name="bianhao" value="${k.bianhao}"  />
	<input type="hidden" name="gonghao" value="${jjrxinxi.gonghao}"  />
	<input type="submit" value="删除" />
	 </form> 
	</div>
</c:forEach>
</c:when>
<c:otherwise>
<form action="deleteKanfangjilu1.do" method="post">
	<div class="contain1">
  		<div class="contain2">
			<span class="input input--jiro">
					<input class="input__field input__field--jiro" type="text" name="bianhao" id="bianhao" />
					<label class="input__label input__label--jiro" for="bianhao">
						<span class="input__label-content input__label-content--jiro">房源编号</span>
					</label>
				</span>
			<br />
			<br />
    <input type="hidden" name="gonghao" value="${jjrxinxi.gonghao}"  />
    <input type="submit" value="查询">
  </div>
</div>
</form>
</c:otherwise>
</c:choose>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/classie.js"></script>
<!-- input框需要的js -->
<script type="text/javascript" src="js/Kanfangjilu_insert.js"></script>
</body>
</html>