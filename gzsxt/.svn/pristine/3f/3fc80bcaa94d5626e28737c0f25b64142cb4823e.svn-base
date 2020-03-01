$(function(){
	//获取提示框对象
	var inputError1 = $("#inputError1");
	//提交表单
	$("form").ajaxForm({		
		beforeSubmit : function(){
			//创建是否可以提交的标签flag
			var flag = true;
			//获取username、password、code的value
			var usernameValue = $("input[name=username]").val();
			var passwordValue = $("input[name=password]").val();
			var codeValue = $("input[name=code]").val();
			if(usernameValue==null || usernameValue.length==0){
				flag = false;
				inputError1.html("请输入用户名");
			}else if(passwordValue==null || passwordValue.length==0){
				flag = false;
				inputError1.html("请输入密码");
			}else if(codeValue==null || codeValue.length==0){
				flag = false;
				inputError1.html("请输入验证码");
			}
			return flag;
		},
		dataType : "json",
		success : function(data){
			if(data.id == 1){
				//跳转到首页
				window.location.href = "page/index.jsp";
			}else{
				//响应消息
				inputError1.html(data.info);
			}
		}
	});
	//刷新验证码
	$("#vcode1,#vcode2").click(function(){
		$("#vcode1").attr("src","image.jsp?time="+new Date());
	});
});