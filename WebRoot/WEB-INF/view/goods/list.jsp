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
						<th>名称</th>
						<th>进价</th>
						<th>售价</th>
						<th>生产日期</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
					<c:forEach var="goods" items="${list }">
						<tr>
							<td>${goods.goods_id }</td>
							<td>${goods.goods_name }</td>
							<td>${goods.goods_money }</td>
							<td>${goods.goods_saleMoney }</td>
							<td>${goods.goods_date }</td>
							<td>${goods.goods_counts }</td>
							<td>
								<a href="goods/updateGoods.do?id=${goods.goods_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="">详情</a>
								&nbsp;&nbsp;
								<a href="goods/deleteGoods.do?id=${goods.goods_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
  </body>
</html>