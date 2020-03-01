$(function(){
	//1.角色删除
	$("#roleRemove").click(function(){
		var roleid = $("input:radio:checked").val();
		if(roleid == null){
			alert("请先选择需要删除的角色");
		}else if(confirm("您确定删除id为 "+roleid+" 的角色吗")){
			//执行删除
			$.ajax({
				type : "POST",
				url : "user.action",
				data : {
					cmd : "roleRemove",
					roleid : roleid
				},
				dataType : "json",
				success : function(data){
					alert(data.info);
					if(data.id == 1){						
						//刷新当前页面
						window.location.reload();
					}
				}
			});
		}
	});
	//2.角色修改
	$("#roleReplace").click(function(){
		var roleid = $("input:radio:checked").val();
		if(roleid == null){
			alert("请先选择需要修改的角色");
		}else{
			//执行删除
			$.ajax({
				type : "POST",
				url : "user.action",
				data : {
					cmd : "roleReplaceBefore",
					roleid : roleid
				},
				dataType : "json",
				success : function(data){
					if(data.id == 1){
						window.location.href = "page/user/roleReplace.jsp";
					}else{
						alert(data.info);
					}
				}
			});
		}
	});
	//3.分页select
	$("#select").change(function(){
		//获取select和roleName的value
		var selectValue = $(this).val();
		var roleNameValue = $("input[name=roleName]").val();
		//跳转
		window.location.href = "user.action?cmd=roleList&pageCount="+selectValue+"&roleName="+roleNameValue;
	});
});