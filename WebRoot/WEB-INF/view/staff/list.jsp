<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
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
						<th>单价</th>
						<th>分类</th>
						<th>库存</th>
						<th>折扣</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>1</td>
						<td>特步卫衣</td>
						<td>88.8</td>
						<td>服装</td>
						<td>100</td>
						<td>9.9</td>
						<td>
							<a href="">编辑</a>
							&nbsp;&nbsp;
							<a href="">详情</a>
							&nbsp;&nbsp;
							<a href="">删除</a>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>小米4C</td>
						<td>999</td>
						<td>数码</td>
						<td>50</td>
						<td>8.8</td>
						<td>
							<a href="">编辑</a>
							&nbsp;&nbsp;
							<a href="">详情</a>
							&nbsp;&nbsp;
							<a href="">删除</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
