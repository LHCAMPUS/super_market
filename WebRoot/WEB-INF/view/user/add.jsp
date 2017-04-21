<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加管理员信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">系统设置 > 管理员添加</div>
		<div class="form_box">
			<form action="user/addUser.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">姓名:</td>
						<td>
							<input type="text" name="realname" class="txt" required placeholder="请输入姓名"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">手机:</td>
						<td>
							<input type="text" name="phone" class="txt" required placeholder="请输入手机"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">用户名:</td>
						<td>
							<input type="text" id="userName" name="userName" required  class="txt" placeholder="请输入用户名"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">密码:</td>
						<td>
							<input type="text" name="password" required  class="txt" placeholder="请输入密码"/>						
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="添加" class="btn"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
	 <script type="text/javascript">
   	 	$(document).ready(function(){
   	 		 $(".btn").click(function(){
   	 			if($("#userName").val()!=null&&$("#userName").val()!=""){
	   	 			$.ajax({
	   	 				url : "<%=path%>/user/userVal.do",
	   	 				type : "POST",
	   	 				async : false,
	   	 				data : 
	   	 				{
	   	 					userName : $("#userName").val(),
	   	 				},
	   	 				dataType : 'json',
	   	 				success : function(data){
	   	 					 var userName = document.getElementById("userName");
	   	 					 if(data == "1"){
	   	 						userName.setCustomValidity("该用户名已存在");  
	   	 					 }else{
	   	 						userName.setCustomValidity("");
	   	 					 }
	   	 				} 
	   	 			});  
   	 			}
   	 		});   
   	 	});	
   	  </script>
</html>
