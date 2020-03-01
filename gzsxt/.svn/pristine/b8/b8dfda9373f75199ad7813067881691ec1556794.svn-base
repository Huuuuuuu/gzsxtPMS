$(function() {
	// 获取select节点
	var select = $("#select");
	var roleno = $("input[name=roleno]");
	var roleName = $("input[name=roleName]");
	var remarks = $("#remarks");
	// 获取提示错误信息的节点
	var inputError = $("#inputError");
	// 获取部门列表
	$.ajax({
		type : "GET",
		url : "user.action",
		data : {
			cmd : "roleDeptReplace",
		},
		dataType : "json",
		success : function(data) {
			for ( var i in data) {
				var option = $("<option></option>");
				option.html(data[i].d_name);
				option.val(data[i].d_deptno);
				select.append(option);
			}
		}
	});
	// 取消修改
	$("#reset").click(function() {
		if (confirm("您真的要取消本次修改吗？")) {
			window.location.href = "user.action?cmd=roleList";
		}
	});
	// 提交表单
	$("form").ajaxForm({
		beforeSubmit : function() {
			// 创建是否可以提交的标签flag
			var flag = false;			
			if(confirm("您确定要修改这个角色的信息吗？")){
				// 获取需要校验的表单数据
				flag = checkRoleno() && checkRoleName() && checkRemarks();
			}
			return flag;
		},
		dataType : "json",
		success : function(data) {
			//响应消息
			alert(data.info);			
			if(data.id == 1){
				//跳转
				window.location.href = "user.action?cmd=roleList";
			}
		}
	});
	// 失去焦点
	roleno.blur(function() {
		checkRoleno();
	});
	roleName.blur(function() {
		checkRoleName();
	});
	remarks.blur(function() {
		checkRemarks();
	});
});
// 校验角色编号
function checkRoleno() {
	// 调用checkAction的方法
	return checkAction({
		name : "roleno",
		span : "inputError",
		reg : /^\w{1,20}$/i,
		errorMsg : "角色编码长度1-20，且由字母、数字、下划线组成",
		emptyMsg : "请输入角色编号！",
		isMust : true
	});
}
// 校验角色名称
function checkRoleName() {
	// 调用checkAction的方法
	return checkAction({
		name : "roleName",
		span : "inputError",
		reg : /^[\u4e00-\u9fa5\w]{1,60}$/i,
		errorMsg : "角色名称长度1-60，且由中文、字母、数字、下划线组成",
		emptyMsg : "请输入角色名称！",
		isMust : true
	});
}
//校验备注说明
function checkRemarks() {
	// 调用checkAction的方法
	return checkLongText({
		id : "remarks",
		span : "inputError",
		reg : /[\<\>\{\}\/\\]/,
		errorMsg : "备注说明长度6-255，且不能出现 \< \> \{ \} \/ \\等特殊字符"
	});
}