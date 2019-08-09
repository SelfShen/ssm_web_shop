<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>product detail</title>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/product.js" type="text/javascript"></script>
<link href="/css/detail.css" rel="stylesheet" type="text/css">
</head>
<body onload="pro_detail()">
	<div class="content">
		<a href="javascript:;" onclick="back()">返回</a>
		<div class="content-box-main">
			<div class="content-main-img" id="content-main-img"></div>
			<div class="content-main-detail">
				<div class="content-main-descript">HKC 32英寸2K曲面电脑显示器超薄无边框C325Q电竞游戏液晶吃鸡曲面屏台式显示屏高清大屏HDMI网吧咖27宽屏4K </div>
				<div class="detail-name">
					<span>名称:</span>
					<div id="content-main-name"></div>
				</div>
				<div class="detail-price">
					<span>价格:</span>
					<div id="content-main-price"></div>
				</div>
				<div class="content-main-num">
					<span>数量:</span>
					<input type="button" class="content-main-num-cut" id="content-main-num-cut" value="-" onclick="num_cut()">
					<input type="text" id="content-main-number" value="1" class="content-main-num-input">
					<input type="button" value="+" class="content-main-num-incream" onclick="num_incream()">
				</div>
				<a href="javascript:;" onclick="buy()">购买</a>
			</div>
		</div>
		<div class="detail-rates">
			<div class="detail-rates-nav">
				<a href="javascript:;">评价</a>
				<a href="javascript:;" onclick="">商品问答</a>
			</div>
			<div class="detail-rate-box" id="detail-rate-box">
				<div class="box-message" id="box-message">
					<textarea id="message-question" rows="3" cols="70"></textarea>
					<a href="javascript:;" onclick="board()">留言</a>
				</div>
				<div id="box-message-item"></div>
			</div>
		</div>
	</div>
</body>
</html>