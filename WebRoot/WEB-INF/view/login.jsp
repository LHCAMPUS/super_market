<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link href="css/login.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
    <div class="login">
    <div class="message">沃尔玛超市管理系统-管理登录</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="login.do">
		<input name="action" value="main" type="hidden">
		<input name="user" id="user" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input id="passw" name="passw" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit" id="loginBtn" >
		<hr class="hr20">
		帮助 <a onClick="alert('请联系管理员')">忘记密码</a>
	</form>

	</div>
	 <script type="text/javascript">
   	 	$(document).ready(function(){
   	 		 $("#loginBtn").click(function(){
   	 			if($("#user").val()!=null&&$("#user").val()!=""&&$("#passw").val()!=null&&$("#passw").val()!=""){
	   	 			$.ajax({
	   	 				url : "<%=path%>/loginVer.do",
	   	 				type : "POST",
	   	 				async : false,
	   	 				data : 
	   	 				{
	   	 					user : $("#user").val(),
	   	 					passw : $("#passw").val()
	   	 				},
	   	 				dataType : 'json',
	   	 				success : function(data){
	   	 					 var pass = document.getElementById("passw");
	   	 					 if(data.status != "OK"){
	   	 						pass.setCustomValidity(data.comment);  
	   	 					 }else{
	   	 						pass.setCustomValidity("");
	   	 					 }
	   	 				} 
	   	 			});  
   	 			}
   	 		});   
   	 	});	
   	  </script>
  </body>
</html>
