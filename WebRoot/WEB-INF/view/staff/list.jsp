<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>员工信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<style>
		table tr{
			height:40px;
			color:#000000;
		}
		table tr:hover{
			background-color:#DCDCDC;
			color:black;
		}
		tr td a:hover{
			color: #1E90FF;
		}
	</style>
    
  </head>
  
  <body>
    <div class="title">商品管理 > 商品列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>手机</th>
						<th>年龄</th>
						<th>职称</th>
						<th>工资</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
					<c:forEach var="staff" items="${list }">
						<tr>
							<td>${staff.staff_id }</td>
							<td>${staff.staff_name }</td>
							<td>${staff.staff_sex }</td>
							<td>${staff.staff_phone }</td>
							<td>${staff.staff_age }</td>
							<td>${staff.staff_title }</td>
							<td>${staff.staff_wage }</td>
							<td>${staff.staff_address }</td>
							<td>
								<a href="">编辑</a>
								&nbsp;&nbsp;
								<a href="">详情</a>
								&nbsp;&nbsp;
								<a href="">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
  </body>
</html>
