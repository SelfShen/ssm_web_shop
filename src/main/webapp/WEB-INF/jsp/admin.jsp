<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/admin.js"type="text/javascript"></script>
<link href="/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="nav">
		<div class="nav-logo">SSM</div>
		<div class="nav-item-user"><a href="javascript:;" onclick="admin_user()">用户管理</a></div>
		<div class="nav-item-pro"><a href="javascript:;" onclick="admin_product()">商品管理</a></div>
		<div class="nav-item-order"><a href="javascript:;" onclick="admin_order()">订单管理</a></div>
		<div class="nav-item-board"><a href="javascript:;" onclick="admin_board()">留言管理</a></div>
		<div class="nav-item-source"><a href="javascript:;" onclick="#">修改资料</a></div>
	</div>
	<div class="content">
		<div class="content-name">
		后台管理系统
			<div class="content-user" id="content-user">
				<span>welcome&nbsp;${admin.name}</span>
				<a href="javascript:;" onclick="logout()">退出</a>
			</div>
		</div>
		<div class="content-box" id="content-box">
			<div class="content-box-ietm" id="content-box-item">
			</div>
		</div>
	</div>
</body>
</html>