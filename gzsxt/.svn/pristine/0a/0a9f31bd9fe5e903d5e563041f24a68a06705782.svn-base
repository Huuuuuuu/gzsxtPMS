<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="com.gzsxt.domain.User"%>
<%@ page import="com.gzsxt.domain.Message"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>Cloud客户关系管理系统  - 角色修改</title>
<meta name="keywords" content="Cloud客户关系管理系统 ">
<meta name="description" content="Cloud客户关系管理系统 ">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>角色修改</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="form_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="form_basic.html#">选项1</a></li>
								<li><a href="form_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<form class="form-horizontal m-t" action="user.action">
							<input type="hidden" name="cmd" value="roleReplace" />
							<input type="hidden" name="roleid" value="${sessionScope.role.r_id}" />
							<div class="form-group">
								<label class="col-sm-3 control-label">提示信息：</label>
								<div class="col-sm-6">
									<span id="inputError" style="height:30px;line-height:30px;color:red;" >当前正在修改的角色id为[ <c:out value="${sessionScope.role.r_id}"></c:out> ]</span>
								</div>
							</div>						
							<div class="form-group">
								<label class="col-sm-3 control-label">角色编号：</label>
								<div class="col-sm-6">
									<input name="roleno" type="text"
										class="form-control" value="${sessionScope.role.r_roleno}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">角色名称：</label>
								<div class="col-sm-6">
									<input name="roleName" type="text"
										class="form-control" value="${sessionScope.role.r_name}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">所属部门：</label>
								<div class="col-sm-6">
									<select name="deptno" id="select">
										<option value="${sessionScope.role.r_roleno}"><c:out value="${sessionScope.role.dept.d_name}"></c:out></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注信息：</label>
								<div class="col-sm-6">
									<textarea name="remarks" id="remarks" style="width:375px;height:200px;"><c:out value="${sessionScope.role.r_remarks}"></c:out></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">操作：</label>
								<div class="col-sm-4 col-sm-offset-0">
									<button class="btn btn-primary" type="submit">保存</button>
									<button class="btn btn-primary" type="button" id="reset">取消</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script src="js/plugins/validate/jquery.validate.min.js"></script>
	<script src="js/plugins/validate/messages_zh.min.js"></script>
	<script src="js/demo/form-validate-demo.min.js"></script>
	<!-- 导入jquery-form -->
	<script src="js/jquery.form.js"></script>
	<script src="js/checkAction.js"></script>
	<script src="js/user/roleReplace.js"></script>
</body>
</html>
