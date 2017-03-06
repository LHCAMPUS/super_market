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
    <title>商品类别信息</title>
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
    <div class="title">商品类别管理 > 商品类别列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>商品类别名称</th>
						<th>商品类别备注</th>
						<th>操作</th>
					</tr>
					<c:forEach var="category" items="${list }">
						<tr>
							<td>${category.category_id }</td>
							<td>${category.category_name }</td>
							<td>${category.category_remark }</td>
							<td>
								<a href="">修改</a>
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
