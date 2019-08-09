<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ssm home</title>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/layer.js" type="text/javascript"></script>
<script src="/js/product.js" type="text/javascript"></script>
<script src="/js/user.js" type="text/javascript"></script>
<link href="/css/header.css" rel="stylesheet" type="text/css">
</head>
<body onload="home()">
	<div class="header">
	<a href="javascript:;" onclick="home()">首页</a>
	<a href="javascript:;" onclick="queryBySort(1)">数码科技</a>
	<a href="javascript:;" onclick="queryBySort(2)">时尚服装</a>
	<a href="javascript:;">悠闲零食</a>
	<a href="javascript:;">日常用品</a>
	
	<div class="header-user">
	<c:set var="user" value="${user}"></c:set>
		<c:if test="${empty user}">
			<a class="header-login" id="header-login" href="javascript:;" onclick="ShowLoginText()">登陆</a>
			<a class="header-sign" id="header-login" href="javascript:;">注册</a>
		</c:if>
		<c:if test="${not empty user}">
			welcome&nbsp;back&nbsp;${user.name}
			<input type="button" value="退出" onclick="logout()"/>
		</c:if>
		<span id="log_succ"></span>
	</div>
	
</div>
<div class="content"></div>
<div class="home-main"style="display:none">
别看了，我就是首页
<img src="/imgs/101.gif">
<img src="/imgs/98.gif">
</div>
<div class="content-box" id="content-box">
		<div id="content-box-item">
			
		</div>
	</div>
	
	<div class="log2" id="log2" style="display:none"> 
	<div class="log2-box">
		<span class="log2-close" onclick="CloseLoginText()"></span><br>
				用户名：<input type="text" name="userId" id="login_name"/><br>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" id="login_password"/><br>
				<a href="javascript:;" onclick="login()">登录</a>
				</div>
	</div>
</body>
</html>