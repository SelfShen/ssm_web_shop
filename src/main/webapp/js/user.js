
var index;
function ShowLoginText(){
	index=layer.open({
		type:1,
		content:$("#log2"),
	});
}
function CloseLoginText(){
	layer.close(index);
}

function login(){
	var id=$("#login_name")[0].value;
	var password=$("#login_password")[0].value;
	$.ajax({
		url:"http://localhost/ssm/user/login",
		type:"POST",
		async:false,
		data:{"Id":id,"password":password},
		dataType:"TEXT",
		success:function(data){
			window.location.href="http://localhost/ssm/home"; 
		}
	});
}

function logout(){
	$.ajax({
		url:"http://localhost/ssm/user/logout",
		type:"POST",
		async:false,
		data:{},
		dataType:"TEXT",
		success:function(data){
//			alert(data);
			window.location.href="http://localhost/ssm/home"; 
		}
	});
}

function sign(){
	
}