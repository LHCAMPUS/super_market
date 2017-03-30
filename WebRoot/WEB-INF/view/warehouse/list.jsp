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
    <title>仓库信息</title>
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
    <div class="title">仓库管理 > 仓库列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>仓库编号</th>
						<th>仓库名</th>
						<th>仓库地址</th>
						<th>操作</th>
					</tr>
					<c:forEach var="warehouse" items="${list }">
						<tr>
							<td>${warehouse.warehouse_id }</td>
							<td>${warehouse.warehouse_name }</td>
							<td>${warehouse.warehouse_address }</td>
							<td>
								<a href="warehouse/updateWarehouse.do?id=${warehouse.warehouse_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="warehouse/deleteWarehouse.do?id=${warehouse.warehouse_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
  </body>
</html>