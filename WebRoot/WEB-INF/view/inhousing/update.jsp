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
    <title>修改采购信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">采购列表 > 采购修改</div>
		<div class="form_box">
			<form action="inhousing/updateInhousing.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">编号:</td>
						<td>
							<input type="text" name="inhousing_id" class="txt" value="${inhousing.inhousing_id }" required readonly/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">商品:</td>
						<td>
							<select name="goods_id" id="goods_id">
								<c:forEach var = "goods" items="${goodList }">
									<c:choose>
										<c:when test="${goods.goods_id ==inhousing.goods_id }">
											<option value="${goods.goods_id }" selected="selected">${goods.goods_name } </option>
										</c:when>
										<c:otherwise>
											<option value="${goods.goods_id }">${goods.goods_name } </option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" value="${inhousing.goods_counts }" required  class="txt" placeholder="请输入商品数量"/>						
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">供应商:</td>
						<td>
							<select name="supplier_id" id="supplier_id">
								<c:forEach var = "supplier" items="${supplierList }">
									<c:choose>
										<c:when test="${supplier.supplier_id ==inhousing.supplier_id }">
											<option value="${supplier.supplier_id }" selected="selected">${supplier.supplier_name } </option>
										</c:when>
										<c:otherwise>
											<option value="${supplier.supplier_id }">${supplier.supplier_name } </option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">仓库:</td>
						<td>
							<select name="warehouse_id" id="warehouse_id">
								<c:forEach var = "warehouse" items="${warehouseList }">
									<c:choose>
										<c:when test="${warehouse.warehouse_id ==inhousing.warehouse_id }">
											<option value="${warehouse.warehouse_id }" selected="selected">${warehouse.warehouse_name } </option>
										</c:when>
										<c:otherwise>
											<option value="${warehouse.warehouse_id }">${warehouse.warehouse_name } </option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">入库时间:</td>
						<td>
							<input type="date" name="inhousing_date" value="${inhousing.inhousing_date }" required  class="txt" placeholder="请选择入库时间"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="inhousing_id" value="${inhousing.inhousing_id }" />
			</form>
		</div>
	</body>
	
</html>
