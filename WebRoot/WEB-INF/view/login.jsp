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
	
	<link href="css/login.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
    <div class="login">
    <div class="message">沃尔玛超市管理系统-管理登录</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post">
		<input name="action" value="main" type="hidden">
		<input name="username" placeholder="用户名" required="" type="text">
		<hr class="hr15">
		<input name="password" placeholder="密码" required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit" onclick="window.open('main.do')">
		<hr class="hr20">
		帮助 <a onClick="alert('请联系管理员')">忘记密码</a>
	</form>

</div>
  </body>
</html>
