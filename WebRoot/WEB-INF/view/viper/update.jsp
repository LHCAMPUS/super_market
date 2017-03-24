<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改会员信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">会员管理 > 会员修改</div>
		<div class="form_box">
			<form action="viper/updateViper.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">会员编号:</td>
						<td>
							<input type="text" name="vip_no" class="txt" value="${viper.vip_no }" required readonly/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">会员姓名:</td>
						<td>
							<input type="text" name="vip_name" value="${viper.vip_name }" required  class="txt" placeholder="请输入年龄"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">会员卡号:</td>
						<td>
							<input type="text" name="vip_idCard" value="${viper.vip_idCard }" required  class="txt" placeholder="请输入手机"/>						
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">会员积分:</td>
						<td>
							<input type="text" name="vip_integral" value="${viper.vip_integral }" required   class="txt" placeholder="请输入职称"/>
						</td>
					<tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					<tr>
				</table>
				<input type="hidden" name="vip_id" value="${viper.vip_id }" />
			</form>
		</div>
	</body>
	
</html>
