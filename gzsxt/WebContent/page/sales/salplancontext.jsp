<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
							  + request.getServerName() + ":" 
							  + request.getServerPort()+ path + "/";	
%>
<!DOCTYPE html>
<html>



<!-- Mirrored from www.gzsxt.cn/theme/hplus/project_detail.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>绿地中央广场综合物业办公系统 - 项目详情</title>
    <meta name="keywords" content="绿地中央广场综合物业办公系统">
    <meta name="description" content="绿地中央广场综合物业办公系统">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="row">
        <div class="col-sm-9">
            <div class="wrapper wrapper-content animated fadeInUp">
                <div class="ibox">
                    <div class="ibox-content">
                        <div class="row">
		       			<div class="col-sm-2 ">
		       			<button stype="button" style="margin-top:30px;margin-bottom:30px" class="btn btn-primary" onclick="back()"><i class="fa fa-arrow-left"></i>返回</button>
		       			</div>
		       			<div class="col-sm-10"></div>
                        
                            <div class="col-sm-12">
                                <div class="m-b-md">
                                    <a href="project_detail.html#" class="btn btn-white btn-xs pull-right">编辑计划</a>
                                    <h2>计划详情</h2>
                                </div>
                                <dl class="dl-horizontal">
                                    <dt>状态：</dt>
                                    <dd>
                                    <c:set var="status" value="${requestScope.plan.pstatus }"></c:set>
                                    
                                    <span class="label label-success">
                                    <c:choose>
                                    <c:when test="${status==0 }">
                                    	已创建
                                    </c:when>
                                    <c:when test="${status==1 }">
                                    	已提交
                                    </c:when>
                                    <c:when test="${status==2 }">
                                    	已审核
                                    </c:when>
                                    <c:when test="${status==3 }">
                                    	已通过
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                    </c:choose>
                                    </span>
                                    </dd>
                                </dl>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-5">
                                <dl class="dl-horizontal">
									<dt>计划编号：</dt>
                                    <dd>${requestScope.plan.spno }</dd>
                                    <dt>计划月份：</dt>
                                    <dd>${requestScope.plan.planmonth }</dd>
                                    <dt>计划人：</dt>
                                    <dd>${requestScope.plan.pname }</dd>
                                    <dt>创建于：</dt>
                                    <dd>${requestScope.plan.createtime }</dd>
                                </dl>
                            </div>
                            <div class="col-sm-7" id="cluster_info">
                                <dl class="dl-horizontal">
                                    <dt>最后修改日期：</dt>
                                    <dd>${requestScope.plan.lastaltertime }</dd>
                                    <dt>操作人：</dt>
                                    <dd>${requestScope.plan.pname }</dd>
                                    <dt>操作人编号：</dt>
                                    <dd></dd>
                                    <dt>待处理人：</dt>
                                    <dd>${requestScope.plan.auditor }</dd>
                                </dl>
                            </div>
                        </div>
                        
                        <div class="row">
                        	<div class="col-sm-1"></div>
                        	<div class="col-sm-10">
                        		<pre>${requestScope.plan.context }</pre>
                        	</div>
                        	<div class="col-sm-1"></div>
                        </div>
                        
                        <!-- <div class="row">
                            <div class="col-sm-12">
                                <dl class="dl-horizontal">
                                    <dt>审核进度</dt>
                                    <dd>
                                        <div class="progress progress-striped active m-b-sm">
                                            <div style="width: 30%;" class="progress-bar"></div>
                                        </div>
                                        <small>当前审核进度为<strong>30%</strong></small>
                                    </dd>
                                </dl>
                            </div>
                        </div> -->

                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script>
        $(document).ready(function(){$("#loading-example-btn").click(function(){btn=$(this);simpleLoad(btn,true);simpleLoad(btn,false)})});function simpleLoad(btn,state){if(state){btn.children().addClass("fa-spin");btn.contents().last().replaceWith(" Loading")}else{setTimeout(function(){btn.children().removeClass("fa-spin");btn.contents().last().replaceWith(" Refresh")},2000)}};
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script type="text/javascript">
	function back() {
		history.back(-1)
	}
	</script>
</body>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/project_detail.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>