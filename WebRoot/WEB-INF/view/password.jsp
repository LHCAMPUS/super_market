<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
  </head>
  
  <body>
		<div class="title">系统设置 > 密码修改</div>
		<div class="form_box">
			<form action="password.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">原密码:</td>
						<td>
							<input type="text" id="repassword" name="repassword" class="txt" required placeholder="请输入原密码"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">新密码:</td>
						<td>
							<input type="text" id="password1" name="password1"  required  class="txt" placeholder="请输入新密码"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">新密码:</td>
						<td>
							<input type="text" id="password2" name="password2"  required  class="txt" placeholder="请再次输入新密码"/>						
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
	<script type="text/javascript">
   	 	$(document).ready(function(){
   	 		var flag =true;
   	 		var pass = document.getElementById("repassword");
   	 		var pass2 = document.getElementById("password2");
   	 		$("#repassword").blur(function(){
	 			if($("#repassword").val()!=null&&$("#repassword").val()!=""){
	   	 			$.ajax({
		 				url : "<%=path%>/passwordVer.do",
		 				type : "POST",
		 				async : false,
		 				data : 
		 				{
		 					repassword : $("#repassword").val()
		 				},
		 				dataType : 'json',
		 				success : function(data){
		 					 if(data == "1"){
								 flag = false;
		 						 pass.setCustomValidity("原密码不正确");  
		 					 }else{
		 						flag = true;
		 						pass.setCustomValidity("");
		 					 }
		 				} 
		 			});
	 			}
   	 			});
   	 		
   	 		 $(".btn").click(function(){
   	 			if(!flag){
   	 				pass.setCustomValidity("原密码不正确");  
   	 			}else if($("#password1").val()!=$("#password2").val()){
   	 				alert($("#password1").val());
   	 				alert($("#password2").val());
   	 				pass2.setCustomValidity("两次密码不一致");  
   	 			}else{
   	 				pass2.setCustomValidity(""); 
   	 			}
   	 		});   
   	 	});	
   	  </script>
</html>
