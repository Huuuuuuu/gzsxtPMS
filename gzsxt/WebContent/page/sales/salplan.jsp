<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gzsxt.domain.Salplan" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
							  + request.getServerName() + ":" 
							  + request.getServerPort()+ path + "/";	
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>绿地中央广场综合物业办公系统 - 基础表格</title>
    <meta name="keywords" content="绿地中央广场综合物业办公系统">
    <meta name="description" content="绿地中央广场综合物业办公系统">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    
    
	<style type="text/css">
	th{
		text-align:center;
		padding: 0px;
	}
	
	</style>
	<script src="./js/vue-2.6.10.js"></script>
	<script src="./js/axios-0.19.0.js"></script>
	<script type="text/javascript">
	
	</script>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>测试修改</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_basic.html#">选项1</a>
                                </li>
                                <li><a href="table_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    
                    <div class="ibox-content" >
                    
                    <button style="float:right; margin-left:30px" class="btn btn-primary" onclick="submitplan()"><i class="fa fa-check"></i>提交</button>
                    <button style="float:right; margin-left:30px" class="btn btn-danger" onclick="delplan()"><i class="fa fa-trash"></i>删除</button>
                    <a href="page/sales/addsplan.jsp">
		              <button style="float:right; margin-left:30px" class="btn btn-success" ><i class="fa fa-file-text-o"></i>添加</button>
		            </a>
		            
		            <form action="spservlet?">
		            <input style="width: 25%;heigth:25px;float:left" name="sltval" type="text" class="form-control" placeholder="输入姓名关键字查找，例如：张三">
		            <button type="submit" class="btn btn-success"><i class="fa fa-search"></i>搜索</button>
		            <input type="hidden" name="cmd" value="sltlike">
		            </form>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                	<th></th>
                                    <th><input type="checkbox" onclick="allchecked(this)"></th>
                                    <th>姓名</th>
                                    <th>月份</th>
                                    <th>状态</th>
                                    <th>最后操作时间</th>
                                    <th>操作人</th>
                                    <th>待处理人</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            	
                            	<c:forEach var="salplan" items="${requestScope.salesPlanList }">
                            	<tr id="${salplan.spno }">
                                	<th></th>
                                    <th><input class="ckbox" type="checkbox"  value="${salplan.spno }" onclick="ckornot(this)" ></th>
                                    <th>${salplan.pname }</th>
                                    <th>${salplan.planmonth }</th>
                                    <c:set var="status" value="${salplan.pstatus }"></c:set>
                                    <c:choose>
                                    <c:when test="${status==0 }">
                                    	<th>已创建</th>
                                    </c:when>
                                    <c:when test="${status==1 }">
                                    	<th>已提交</th>
                                    </c:when>
                                    <c:when test="${status==2 }">
                                    	<th>已审核</th>
                                    </c:when>
                                    <c:when test="${status==3 }">
                                    	<th>已通过</th>
                                    </c:when>
                                    <c:otherwise></c:otherwise>
                                    </c:choose>
                                    <th>${salplan.lastaltertime }</th>
                                    <th>${salplan.pname }</th>
                                    <th>${salplan.auditor }</th>
                                    <th>
                                   		<a href="spservlet?cmd=seeplan&spno=${salplan.spno }">
                                   			<button style="margin-right:20px" type="button" class="btn btn-info" ><i class="fa fa-folder"></i>查看</button></a>
                                   		<a href="spservlet?cmd=getplan&spno=${salplan.spno }">
                                   			<button style="margin-right:20px" type="button" class="btn btn-warning"><i class="fa fa-pencil"></i>修改</button></a>
                                    </th>
                                </tr>
                            	</c:forEach>
                                
                            </tbody>
                        </table>

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
    <script src="layer/layer.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <script type="text/javascript">
    //用于存储已勾选的计划编号
    var spnoArr = []
    
    //勾选或取消
    function ckornot(element){
    	var planbox = $(element) 
    	if(planbox.prop("checked")){
    		spnoArr.push(planbox.val())
    	}else{
    		var i = spnoArr.indexOf(planbox.val())
    		if(i>-1){
    			spnoArr.splice(i,1)
    		}
    	}
    }
    
    //全选
    //attr只能全选或反选一次，使用prop
    function allchecked(element){
    	var allckbox = $(element)
    	if(allckbox.prop("checked")){
    		$(".ckbox").prop('checked',true)
    	}else{
    		$(".ckbox").prop('checked',false)
    	}
    }
    
    //删除
    function delplan() {

		if(spnoArr.length>0){
			var spnoArrStr = spnoArr.toString()
			var len = spnoArr.length
			$.ajax({
				type : "post",
				url	: "spservlet",
				data: {"spnoArrStr":spnoArrStr,"cmd":"delplan"},
				async	: true,
				dataType : "text",
				success: function (result) {
					if(len==result){
						//DOM节点移除
						for(var i=0; i<len; i++){
							$("#"+spnoArr[i]).remove()
						}
						//重置
						spnoArr=[]
						layer.msg('删除成功', {icon : 1});
					}else{
						layer.msg('删除失败', {icon : 2});
					}
				},
				error : function () {
					layer.msg('删除失败', {icon : 2});
				}
			})
		}else{
			layer.msg('请将要删除的计划勾选', {icon : 0});
		}
		
	}
    
    
    //提交
    function submitplan() {
    	if(spnoArr.length>0){
    		layer.confirm(
       			'是否提交计划？', 
       			{btn: ['确定','取消']}, 
       			function(){
       	  			var spnoArrStr = spnoArr.toString()
       	  			var len = spnoArr.length
       	  			$.ajax({
   	    	  			type : "post",
   						url	: "spservlet",
   						data: {"spnoArrStr":spnoArrStr,"cmd":"submitplan"},
   						async	: true,
   						dataType : "text",
   						success: function (result) {
   							if(len==result){
   								layer.msg('提交成功', {icon : 1});
   								setTimeout(function(){
									document.location.reload()
								}, 1000);
   							}else{
   								layer.msg('提交失败', {icon : 2});
   							}
   						},
   						error : function () {
   							layer.msg('提交失败', {icon : 2});
   						}
       	  		  	
       	  			})
       			},
       	  		function(){
       	  		  layer.confirm('您取消了操作', {
       	  		    btn: [ '知道了']
       	  		  })
       	  		})
    		
    	}else{
			layer.msg('请将要提交的计划勾选', {icon : 0});
		}
    	
	}
    
 
    </script> 
    
    
</body>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/table_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->
</html>