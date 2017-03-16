<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改入库信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">入库信息管理 > 入库信息修改</div>
		<div class="form_box">
			<form action="inhousing/updateInhousing.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">姓名:</td>
						<td>
							<input type="text" name="staff_name" class="txt" value="${staff.staff_name }" required placeholder="请输入姓名"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">年龄:</td>
						<td>
							<input type="text" name="staff_age" value="${staff.staff_age }" required  class="txt" placeholder="请输入年龄"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">手机:</td>
						<td>
							<input type="text" name="staff_phone" value="${staff.staff_phone }" required  class="txt" placeholder="请输入手机"/>						
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">职称:</td>
						<td>
							<input type="text" name="staff_title" value="${staff.staff_title }" required   class="txt" placeholder="请输入职称"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">工资:</td>
						<td>
							<input type="text" name="staff_wage" value="${staff.staff_wage }" required  class="txt" placeholder="请输入工资"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">地址:</td>
						<td>
							<input type="text" name="staff_address" value="${staff.staff_address }" required  class="txt" placeholder="请输入地址"/>
						</td>
					<tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					<tr>
				</table>
				<input type="hidden" name="staff_id" value="${staff.staff_id }" />
			</form>
		</div>
	</body>
	
</html>
