<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="com.gzsxt.domain.User"%>
<%@ page import="com.gzsxt.domain.Message"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>Cloud客户关系管理系统 - 角色管理</title>
<meta name="keywords" content="Cloud客户关系管理系统">
<meta name="description" content="Cloud客户关系管理系统">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">				
		<div class="row">
			<div class="col-sm-9">
				<div class="ibox float-e-margins">					
					<div class="ibox-title">
						<h5>角色管理</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="table_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="table_basic.html#">选项1</a></li>
								<li><a href="table_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<form action="user.action" method="POST">
							<input type="hidden" name="cmd" value="roleList">
							<label>角色信息列表：</label>
							<input type="text" name="roleName" style="width:220px;height:30px;" value="${requestScope.roleName}"
							placeholder="请输入需要查询的角色名称"/>
							&nbsp;&nbsp;<button type="submit" style="height:30px;">查询</button>&nbsp;&nbsp;
							<button type="button" style="height:30px;float:right;">授权</button>
							<button type="button" id="roleRemove" style="height:30px;float:right;margin-right:20px;">删除</button>
							<button type="button" id="roleReplace" style="height:30px;float:right;margin-right:20px;">修改</button>							
							<a href="page/user/roleAdd.jsp" style="color:#6B6B6B;"><button type="button" style="height:30px;float:right;margin-right:20px;">添加</button></a>								
						</form>
					</div>					
					<div class="ibox-content" style="text-align:center;">						
						<table class="table table-bordered" style="text-align:center;">
							<thead>
								<tr>								
									<th style="text-align:center;">选择</th>
									<th style="text-align:center;">角色id</th>
									<th style="text-align:center;">角色编号</th>
									<th style="text-align:center;">角色名称</th>
									<th style="text-align:center;">所属部门</th>
									<th style="text-align:center;">最后修改时间</th>
									<th style="text-align:center;">操作人</th>
									<th style="text-align:center;">备注说明</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.roleList}" var="role">
									<tr>										
										<td><input type="radio" name="roleno" value="${role.r_id}"/></td>
										<td>${role.r_id}</td>
										<td>${role.r_roleno}</td>
										<td>${role.r_name}</td>	
										<td>${role.dept.d_name}</td>	
										<td>${role.r_last_time}</td>	
										<td>${role.user.t_username}</td>	
										<td>${role.r_remarks}</td>									
									</tr>
								</c:forEach>																
							</tbody>
						</table>
						<c:choose>
							<c:when test="${requestScope.pageCount==1}">
								<a>首页</a>
								<a style="margin-left:20px;">上一页</a> 
							</c:when>
							<c:otherwise>
								<a href="user.action?cmd=roleList&roleName=${requestScope.roleName}">首页</a>
								<a href="user.action?cmd=roleList&roleName=${requestScope.roleName}&pageCount=${requestScope.pageCount-1}&"style="margin-left:20px;">上一页</a> 
							</c:otherwise>
						</c:choose>	
						<label style="margin-left:20px;"><c:out value="${requestScope.pageCount}"></c:out></label>					
						<c:choose>
							<c:when test="${requestScope.pageCount==requestScope.totalPage}">
								<a style="margin-left:20px;">下一页</a>
								<a style="margin-left:20px;">尾页</a>
							</c:when>
							<c:otherwise>
								<a href="user.action?cmd=roleList&roleName=${requestScope.roleName}&pageCount=${requestScope.pageCount+1}"style="margin-left:20px;">下一页</a>
								<a href="user.action?cmd=roleList&roleName=${requestScope.roleName}&pageCount=${requestScope.totalPage}"style="margin-left:20px;">尾页</a>
							</c:otherwise>
						</c:choose>
						<label style="margin-left:20px;">请选择：第 </label>
						<select id="select">																			
							<c:forEach begin="1" end="${requestScope.totalPage}" var="each">							
								<c:choose>
									<c:when test="${each!=requestScope.pageCount}">
										<option value="${each}">${each}</option>
									</c:when>
									<c:otherwise>
										<option value="${each}" selected="selected" >${each}</option>
									</c:otherwise>
								</c:choose>							
							</c:forEach>	
						</select>
						<label> 页</label>					 	
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/peity/jquery.peity.min.js"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script src="js/demo/peity-demo.min.js"></script>
	<script src="js/user/roleList.js"></script>
	<script>
		$(document).ready(function() {
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			})
		});
	</script>
</body>
</html>
