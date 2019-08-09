<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ssm admin login</title>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/admin_login.js" type="text/javascript"></script>
<link href="/css/admin_login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login" id="login"> 
	<div class="login-box">
				用户名：<input type="text" name="userId" id="login_name"/><br>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" id="login_password"/><br>
				<a href="javascript:;" onclick="login()">登录</a>
				</div>
	</div>
</body>
</html>