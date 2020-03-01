<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
							  + request.getServerName() + ":" 
							  + request.getServerPort()
							  + path + "/";	
%>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>添加计划</title>

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    

</head>
<body>
<div class="row">
	<div class="ibox-content">
		<form id="form1"   class="form-horizontal" >
		<div class="form-group">
		       <div class="col-sm-2 control-label">
		       <a href="spservlet?cmd=salplanlist">
		       <button type="button"  class="btn btn-primary"><i class="fa fa-arrow-left"></i>返回</button></a>
		       </div>
		       <div class="col-sm-10"></div>
		       
		   </div>
		   <div class="hr-line-dashed"></div>
		   
		<div class="form-group">
		       <label class="col-sm-2 control-label">计划编号</label>
		       <div class="col-sm-6">
		       <input type="text" name="spno"  class="form-control">
		       <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
		       </div>
		       <div class="col-sm-4"></div>
		   </div>
		   <div class="hr-line-dashed"></div>
		   
		   <!-- <div class="form-group">
		       <label class="col-sm-2 control-label">计划人姓名</label>
		       <div class="col-sm-6">
		       <input type="text" class="form-control">
		       <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
		       </div>
		       <div class="col-sm-4"></div>
		   </div>
		   <div class="hr-line-dashed"></div> -->
		   
		   <div class="form-group">
		       <label class="col-sm-2 control-label">计划月份</label>
		       <div class="col-sm-6">
		       <input id="planmonth"  type="text" name="planmonth"  class="form-control ">
		       <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
		       </div>
		       <div class="col-sm-4"></div>
		   </div>
		   <div class="hr-line-dashed"></div>
		   
		   
		    <div class="form-group">
		       <label class="col-sm-2 control-label">计划内容</label>
		       <div class="col-sm-6">
		       <textarea name="context"  class="form-control" rows="10"></textarea>
		       <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
		       </div>
		       <div class="col-sm-4"></div>
		   </div>
		   <div class="hr-line-dashed"></div>
		   
		   <div class="form-group">
		   		<div class="col-sm-2"></div>
		   		<div class="col-sm-6" >
		   			<button style="margin-right:20px" type="button"  class="btn btn-primary"  onclick="addplan()"><i class="fa fa-check"></i>添加</button>
		   			<button style="margin-right:20px" type="button"  class="btn btn-warning"  onclick="cancel()"><i class="fa fa-times"></i>取消</button></div>
		   		</div>
		   		<div class="col-sm-4"></div>
		   </div>
		   <input type="hidden" name="cmd"  value="addplan">
	   </form>
	</div>
	</div>


	<script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script src="layer/layer.js"></script>
    <script src="laydate/laydate.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <script type="text/javascript">
    	function addplan() {
    		
    		layer.confirm('是否添加该计划？', {
    			  btn: ['确定','取消'] //按钮
    			}, function(){
    				$.ajax({
    					type : "POST",
    					url : "spservlet",
    					data : $("#form1").serialize(),
    					async : true,
    					datatype : "text",
    					success : function (data) {
							if("1"==data){
								layer.msg('添加成功', {icon : 1});
							}else{
								layer.msg('添加失败', {icon : 2});
							}
						},
    					error : function () {
    						layer.msg('添加失败', {icon : 2});
						}
    					
    				})
    			  	
    			}, function(){
    			  layer.confirm('您取消了操作', {
    			    btn: [ '知道了']
    			  });
    			});
		}
    	
    	
    	function cancel(){
    		layer.confirm('是否取消添加？', {
  			  btn: ['确定','取消'] //按钮
  			}, function(){
  				document.location.href="spservlet?cmd=salplanlist"
  			  	
  			}, function(){
  			  layer.confirm('您取消了操作', {
  			    btn: [ '知道了']
  			  });
  			});
    	}
    	
    
    </script>
    <script>
		//执行一个laydate实例
		laydate.render({
		  elem: '#planmonth',//指定元素
		  type: 'month',
		});
		
</script>
    
</body>
</html>