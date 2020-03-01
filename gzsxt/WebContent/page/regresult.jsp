<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册结果</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

<script type="text/javascript">
	$(function () {
		window.onload=result()
	})
</script>
</head>
<body>
<%
	int result = (int)application.getAttribute("result");
%>

<script type="text/javascript">

	function redc() {
		window.location.href="http://localhost:8080/gzsxt/page/login.jsp";
	}
	
	function result() {
		if("${result}"==1){
			//跳转页面判断，注册成功"
			swal({
					title:"注册成功",
					type:"success",
				})
			setTimeout(function() {
				redc()
			}, 3000)
		}else{
			//跳转页面判断，注册失败"
			swal({
				title:"注册失败",
				type:"warning",
			})
		}
	}
</script>
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
</body>
</html>