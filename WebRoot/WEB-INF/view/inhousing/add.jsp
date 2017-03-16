<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加入库信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">入库信息管理 > 入库信息添加</div>
		<div class="form_box">
			<form action="inhousing/addInhousing.do" method="post">
				<table>
					<tr>
						<td align="right" valign="top">商品ID:</td>
						<td>
							<input type="text" name="goods_id" required  class="txt" placeholder="请输入商品ID"/>
						</td>
					<tr>
					<tr>
						<td width="15%" align="right">商品名:</td>
						<td>
							<input type="text" name="goods_name" class="txt" required placeholder="请输入商品名"/>
						</td>
					<tr>
					
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" required  class="txt" placeholder="请输入商品数量"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">供应商ID:</td>
						<td>
							<input type="text" name="supplier_id" required  class="txt" placeholder="请输入供应商ID"/>						
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">仓库ID:</td>
						<td>
							<input type="text" name="warehouse_id" required  class="txt" placeholder="请输入仓库ID"/>
						</td>
					<tr>
					<tr>
						<td align="right" valign="top">入库时间:</td>
						<td>
							<input type="date" name="inhousing_date" required  class="txt" placeholder="请选择入库时间"/>
						</td>
					<tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="添加" class="btn"/>
						</td>
					<tr>
				</table>
			</form>
		</div>
	</body>
</html>
