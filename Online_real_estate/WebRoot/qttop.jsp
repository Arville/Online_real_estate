<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
	<div class="box logo">
      <div class="logopart">
          <a href="index.do">线上房地产服务平台</a>
      </div>
	   <div style="padding-top:50px; position:absolute; padding-left:120px;">
         <div style="font-family:宋体; color:#0c9b25; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                    <div align="left">线上房地产服务平台</div>
                </div>
      </div>
      <div class="phonepart">
			<div class="toplink">
            	
               <!-- <a href="jingjirenadd.jsp">经纪人注册</a>| -->
                <c:choose>
                	<c:when test="${userInfo==null}"><a href="userlog.jsp">用户注册/登录</a></c:when>
                	<c:otherwise>
                	<a href="UserCenter.do">${userInfo.username}</a>
                	&nbsp;|&nbsp;
                	<a href="frontdesktuichu.do">退出</a>
                	</c:otherwise>
                </c:choose>
                
            </div>
            <div class="f_c"></div>
            
      </div>
    </div>
</div>