function login(){
//	alert("login");
	var id=$("#login_name")[0].value;
	var password=$("#login_password")[0].value;
	$.ajax({
		url:"http://localhost/ssm/admin/adminLogin",
		type:"POST",
		async:false,
		data:{"id":id,"password":password},
		dataType:"TEXT",
		success:function(data){
			window.location.href="http://localhost/ssm/admin/home"; 
		}
	});
}

function logout(){
	
}
