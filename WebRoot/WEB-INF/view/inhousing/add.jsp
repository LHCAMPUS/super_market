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
						<td width="15%" align="right" valign="top">商品:</td>
						<td>
							<select name="goods_id" id="goods_id">
								<c:forEach var = "goods" items="${goodList }">
									<option value="${goods.goods_id }">${goods.goods_name } </option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" required  class="txt" placeholder="请输入商品数量"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">供应商:</td>
						<td>
							<select name="supplier_id" id="supplier_id">
								<c:forEach var = "supplier" items="${supplierList }">
									<option value="${supplier.supplier_id }">${supplier.supplier_name } </option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">仓库:</td>
						<td>
							<select name="warehouse_id" id="warehouse_id">
								<c:forEach var = "warehouse" items="${warehouseList }">
									<option value="${warehouse.warehouse_id }">${warehouse.warehouse_name } </option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">采购时间:</td>
						<td>
							<input type="date" name="inhousing_date" required  class="txt" placeholder="请选择入库时间"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="添加" class="btn"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
