
function home(){
	$('#content-box div:gt(0)').remove();//删除之前的数据
	$('.home-main')[0].style.cssText='display:block';
}

function queryBySort(sort){
	$('.home-main')[0].style.cssText='display:none';
	$.ajax({
		url:"http://localhost/ssm/source/queryProductBySort",
		type:"POST",
		data:{"sort":sort},
		dataType:"json",
		success:function(data){
//			alert("success");
			$('#content-box div:gt(0)').remove();//删除之前的数据
			var str='';
			for(var i=0;i<data.length;i++){
				str+='<a href="javascript:;" onclick="pro_jump('+data[i].iD+')">'
					+'<div class="content-box-item"><div class="item-img">'
					+'<img src="source/show?img='+data[i].imgUUID+'"></div>'
					+'<div class="item-name">'+data[i].name + '</div>'
					+'<div class="item-price">'+data[i].price+'</div></div></a>';
			}
//			alert(str);
			$('#content-box-item').append(str);
		},
		error:function(data){
			alert("faile");
		}
	});
}

function pro_jump(Id){
	window.location.href="http://localhost/ssm/detail?id="+Id; 
}

var sor;
var order_no;
var num_max;
function pro_detail(){
//	alert("pro detail");
	$.ajax({
		url:"http://localhost/ssm/getProId",
		type:"POST",
		success:function(Id){
			$.ajax({
				url:"http://localhost/ssm/source/queryProductById",
				type:"POST",
				data:{"Id":Id},
				dataType:"json",
				success:function(data){
					sor=data.sort;
					order_no=data.iD;
					num_max=data.number;
//					alert(order_no);
//					alert(num_max);
//					alert(data.name);
//					$('#content-box div:gt(0)').remove();//删除之前的数据
					$('#content-main-img')[0].innerHTML='<img src="/imgs/01.jpg">';
					$('#content-main-name')[0].innerHTML=data.name;
					$('#content-main-price')[0].innerHTML=data.price;
					$('#content-main-number')[0].value='1';
					
					board_quesiont();
				},
				error:function(data){
					alert("faile");
				}
			});
		}
	});
}
function num_cut(){
	var num=$('#content-main-number')[0].value;
	if(num-1>0){
		$('#content-main-number')[0].value=num-1;
	}
}
function num_incream(){
	var num=parseInt($('#content-main-number')[0].value);
	if(num+1<=num_max){
		$('#content-main-number')[0].value=num+1;
	}
}
function buy(){
//	alert("buy");
	var shop_id=1001;
	var order_status=1;
	var product_count=$('#content-main-number')[0].value;
	$.ajax({
		url:"http://localhost/ssm/source/addOrder",
		type:"POST",
		data:{"order_no":order_no,"shop_id":shop_id,"order_status":order_status,"product_count":product_count},
		dataType:"TEXT",
		success:function(data){
			alert(data);
		}
	});
}
function back(){
	window.location.href="http://localhost/ssm/home"; 
}

/*
 * 留言/回复 功能
 * */
function board(){
	var question=$('#message-question')[0].value;
	alert(question);
	$.ajax({
		url:"http://localhost/ssm/source/question",
		type:"POST",
		data:{"proId":order_no,"question":question},
		dataType:"TEXT",
		success:function(data){
			alert(data);
			$.ajax({
				url:"http://localhost/ssm/source/queryQAByProId",
				type:"POST",
				data:{"proId":order_no},
				dataType:"json",
				success:function(data){
					var str='';
					for(var i=0;i<data.length;i++){
						str+=data[i].proId+data[i].question;
					}
					alert(str);
				}
			});
		}
	});
}
function board_quesiont(){
//	alert(order_no);
	$.ajax({
		url:"http://localhost/ssm/source/queryQAByProId",
		type:"POST",
		data:{"proId":order_no},
		dataType:"json",
		success:function(data){
//			alert(data);
			var str='';
			for(var i=0;i<data.length;i++){
				str+='<div class="item-question">'
					+'<div>'+data[i].question+'</div>'
					+'<div class="question-answer"><a href="javascript:;" onclick="board_answer('+i+')">回复</a></div>'
					+'<div class="question-answer-main"><input type="text"><a href="javascript:;">确定</a></div>'
					+'</div>';
			}
//			alert(str);
			$('#box-message-item').append(str);
		}
	});
}

var temp=0;
var role;
function board_answer(i){
	if(temp==0){
		$('.question-answer-main')[i].style.cssText='display:block';
		temp=1;
		role=i;
	}else if(temp==1&&role==i){
		$('.question-answer-main')[i].style.cssText='display:none';
		temp=0;
		role=-1;
	}else if(temp==1&&role!=i){
		$('.question-answer-main')[role].style.cssText='display:none';
		$('.question-answer-main')[i].style.cssText='display:block';
		role=i;
	}
}