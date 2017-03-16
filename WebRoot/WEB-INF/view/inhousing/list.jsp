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
    <title>入库信息</title>
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
    <div class="title">入库信息管理 > 入库信息列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>数量</th>
						<th>供应商ID</th>
						<th>仓库ID</th>
						<th>入库时间</th>
						<th>操作</th>
					</tr>
					<c:forEach var="inhousing" items="${list }">
						<tr>
							<td>${inhousing.goods_id }</td>
							<td>${inhousing.goods_name }</td>
							<td>${inhousing.goods_counts }</td>
							<td>${inhousing.supplier_id }</td>
							<td>${inhousing.warehouse_id }</td>
							<td>${inhousing.inhousing_date }</td>
							<td>
								<a href="inhousing/updateInhousing.do?id=${inhousing.inhousing_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="inhousing/deleteInhousing.do?id=${inhousing.inhousing_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
  </body>
</html>
