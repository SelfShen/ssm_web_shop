
function logout(){
//	alert("logout");
	$.ajax({
		url:"http://localhost/ssm/admin/admin_out",
		type:"POST",
		dataType:"TEXT",
		success:function(data){
//			alert(data);
			window.location.href="http://localhost/ssm/admin/login"; 
		}
	});
}

var bac_color='background-color:#000';
var bac_de='background-color:transparent';

/*
 * 用户管理
 * */
function admin_user(){
	$('.nav-item-pro')[0].style.cssText=bac_de;
	$('.nav-item-order')[0].style.cssText=bac_de;
	$('.nav-item-user')[0].style.cssText=bac_color;
	$.ajax({
		url:"http://localhost/ssm/admin/adminUser",
		type:"POST",
		data:{},
		dataType:"json",
		success:function(data){
			$('#form').remove();//删除之前的数据		
			$('#content-box-item div:gt(0)').remove();//删除之前的数据	
			var str2='<form id="form"><table class="item-table"><tr>'
					+'<td>用户ID</td>'
					+'<td>email</td>'
					+'<td>昵称</td>'
					+'<td>性别</td>'
					+'<td>收件人</td>'
					+'<td>收货地址</td>'
					+'<td>联系电话</td>'
					+'<td>操作</td></tr>';
			for(var i=0;i<data.length;i++){
				str2+='<tr><td>'+data[i].iD+'</td>'
					+'<td>email</td>'
					+'<td>'+data[i].name+'</td>'
					+'<td>性别</td>'
					+'<td>收件人</td>'
					+'<td>收货地址</td>'
					+'<td>联系电话</td>'
					+'<td><a href="#" onclick="admin_user_edit()">操作</a></td>'
					+'</tr>';
			}
			str2+='</table></form>';
//			alert(str2);
			$('#content-box-item').append(str2);
		},
		error:function(data){
			alert("faile");
		}
	});
}
function admin_user_edit(){
	alert("edit");
}

/*
 * 产品管理
 * */
function admin_product(){
//	alert("admin product")
	$('.nav-item-user')[0].style.cssText=bac_de;
	$('.nav-item-order')[0].style.cssText=bac_de;
	$('.nav-item-pro')[0].style.cssText=bac_color;
	$.ajax({
		url:"http://localhost/ssm/source/queryProduct",
		type:"POST",
		data:{},
		dataType:"json",
		success:function(data){
//			alert(data);
			$('#form').remove();//删除之前的数据		
			$('#content-box-item div:gt(0)').remove();//删除之前的数据		
			var str2='<div><div><a href="#" onclick="show(1)">添加商品</a></div><br>';
			for(var i=0;i<data.length;i++){
				str2+='<div class="contenter">'
					+'<div class="contenter-img"><img src="http://localhost/ssm/source/show?img='+data[i].imgUUID+'"></div>'
					+'<div class="contenter-name">'+data[i].name+'</div>'
					+'<div class="contenter-price">'+data[i].price+'</div>'
					+'<div class="contenter-number">'+data[i].number+'</div></div>';
			}
			str2+='</div>';
//			alert(str2);
			$('#content-box-item').append(str2);
		},
		error:function(data){
			alert("faile");
		}
	});
}
function show(s){
	if(s==1){
//		alert("add product");
		$('#content-box-item div:gt(0)').remove();//删除之前的数据
		var str2='<div>'
			+'<div>图片<input type="file" id="admin_add_pro_img"></div>'
			+'<div>名称<input type="text" id="admin_add_pro_name"></div>'
			+'<div>价格<input type="text" id="admin_add_pro_price"></div>'
			+'<div>数量<input type="text" id="admin_add_pro_num"></div>'
			+'<div>类型<input type="text" id="admin_add_pro_sort"></div>'
			+'<div><a href="#" onclick="admnin_pro_edit(1)">上架</a></div>'
			+'<div><a href="#" onclick="admnin_pro_edit(0)">取消</a></div>'
			+'</div>';
//		alert(str2);
		$('#content-box-item').append(str2);
	}
}
function admnin_pro_edit(select){
	if(select==1){
		var img= $("#admin_add_pro_img")[0].files[0];
		var name=$("#admin_add_pro_name")[0].value;
		var price=$("#admin_add_pro_price")[0].value;
		var number=$("#admin_add_pro_num")[0].value;
		var sort=$("#admin_add_pro_sort")[0].value;
		var form_data=new FormData();
		form_data.append("name",name);
		form_data.append("price",price);
		form_data.append("number",number);
		form_data.append("sort",sort);
		form_data.append("img",img);
		$.ajax({
			url:"http://localhost/ssm/source/addProduct",
			type:"POST",
			data:form_data,
			dataType:"json",
			contentType:false,
			processData:false,
			success:function(data){
				$('#content-box-item div:gt(0)').remove();//删除之前的数据
				admin_product();
			}
		});
	}else if(select==0){
		admin_product();
	}else if(select==2){
		alert("change product");
	}else if(select==3){
		alert("delete product");
	}
}

/*
 * 订单管理
 */
function admin_order(){
//	alert("admin order")
	$('.nav-item-user')[0].style.cssText=bac_de;
	$('.nav-item-pro')[0].style.cssText=bac_de;
	$('.nav-item-order')[0].style.cssText=bac_color;
	$.ajax({
		url:"http://localhost/ssm/source/queryOrder",
		type:"POST",
		data:{},
		dataType:"json",
		success:function(data){
//			alert(data);
			$('#form').remove();//删除之前的数据		
			$('#content-box-item div:gt(0)').remove();//删除之前的数据	
			var str='<form id="form"><table class="item-table"><tr>'
					+'<td>订单号</td>'
					+'<td>购买店号</td>'
					+'<td>支付状态</td>'
					+'<td>购买数量</td>'
					+'<td>产品总额</td>'
					+'<td>订单总额</td>'
					+'<td>订单创建时间</td>'
					+'<td>订单创建时间</td>'
					+'<td>操作</td></tr>';
			for(var i=0;i<data.length;i++){
				str+='<tr><td>'+data[i].id+'</td>'
					+'<td>'+data[i].shop_id+'</td>'
					+'<td>'+data[i].order_status+'</td>'
					+'<td>'+data[i].product_count+'</td>'
					+'<td>'+data[i].product_total+'</td>'
					+'<td>'+data[i].order_total+'</td>'
					+'<td>'+data[i].order_create_time+'</td>'
					+'<td>'+data[i].order_settle_time+'</td>'
					+'<td><a href="#" onclick="admin_user_edit()">操作</a></td>'
					+'</tr>';
			}
			$('#content-box-item').append(str);
		},
		error:function(data){
			alert("faile");
		}
	});
}
function admin_order_edit(){
	alert("order edit");	
}

/*
 * 留言管理
 */
function admin_board(){
	$.ajax({
		url:'http://localhost/ssm/source/queryQA',
		type:'POST',
		data:{},
		dataType:'JSON',
		success:function(data){
			$('#form').remove();//删除之前的数据		
			$('#content-box-item div:gt(0)').remove();//删除之前的数据	
			var str='<div>';
			for(var i=0;i<data.length;i++){
				str+='<div>'+data[i].question+'</div>';
			}
			str+='</div>';
//			alert(str);
			$('#content-box-item').append(str);
		}
	});
}

/*
 * 修改资料
 * */
function admin_source(){
	alert("waiting for write!");
}