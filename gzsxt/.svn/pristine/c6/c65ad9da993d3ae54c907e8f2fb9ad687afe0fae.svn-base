$(function(){
	//1.组织删除
	$("#deptRemove").click(function(){
		var deptid = $("input:radio:checked").val();
		if(deptid == null){
			alert("请先选择需要删除的组织");
		}else if(confirm("您确定删除id为 "+deptid+" 的组织吗")){
			//执行删除
			$.ajax({
				type : "POST",
				url : "user.action",
				data : {
					cmd : "deptRemove",
					deptid : deptid
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
	//2.组织修改
	$("#deptReplace").click(function(){
		var deptid = $("input:radio:checked").val();
		if(deptid == null){
			alert("请先选择需要修改的组织");
		}else{
			//执行删除
			$.ajax({
				type : "POST",
				url : "user.action",
				data : {
					cmd : "deptReplaceBefore",
					deptid : deptid
				},
				dataType : "json",
				success : function(data){
					if(data.id == 1){
						window.location.href = "page/user/deptReplace.jsp";
					}else{
						alert(data.info);
					}
				}
			});
		}
	});
	//3.分页select
	$("#select").change(function(){
		//获取select和deptName的value
		var selectValue = $(this).val();
		var deptNameValue = $("input[name=deptName]").val();
		//跳转
		window.location.href = "user.action?cmd=deptList&pageCount="+selectValue+"&deptName="+deptNameValue;
	});
});