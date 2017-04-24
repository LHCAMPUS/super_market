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
    <title>修改商品信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">商品列表 > 商品修改</div>
		<div class="form_box">
			<form action="goods/updateGoods.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">编号:</td>
						<td>
							<input type="text" name="goods_id" value="${goods.goods_id }" class="txt" required readonly/>
						</td>
					</tr>
					<tr>
						<td width="15%" align="right">名称:</td>
						<td>
							<input type="text" name="goods_name" value="${goods.goods_name }" class="txt" required placeholder="请输入名称"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">分类:</td>
						<td>
							<select name="category_id" id="category_id">
								<c:forEach var = "category" items="${categoryList }">
									<c:choose>
										<c:when test="${category.category_id ==goods.category_id }">
											<option value="${category.category_id }" selected="selected">${category.category_name } </option>
										</c:when>
										<c:otherwise>
											<option value="${category.category_id }">${category.category_name } </option>
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
										<c:when test="${warehouse.warehouse_id ==goods.warehouse_id }">
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
						<td align="right" valign="top">单价:</td>
						<td>
							<input type="text" name="goods_money" value="${goods.goods_money }" class="txt" required placeholder="请输入单价"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">售价:</td>
						<td>
							<input type="text" name="goods_saleMoney" value="${goods.goods_saleMoney }" required  class="txt" placeholder="请输入售价"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">日期:</td>
						<td>
							<input type="date" name="goods_date" value="${goods.goods_date }" required  class="txt" placeholder="请输入日期"/>						
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" value="${goods.goods_counts }" required  class="txt" placeholder="请输入数量"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="goods_id" value="${goods.goods_id }" />
			</form>
		</div>
	</body>
	
</html>
