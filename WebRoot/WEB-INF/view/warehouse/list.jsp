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
  </head>
  
  <body>
    <div class="title">库存管理 > 仓库列表</div>
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
								<a href="warehouse/updateWarehouse.do?id=${warehouse.warehouse_id }">修改</a>
								&nbsp;&nbsp;
								<a href="warehouse/deleteWarehouse.do?id=${warehouse.warehouse_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="4" text-align="center">
	   						<a href="warehouse/warehouseList.do?pageIndex=1">首页</a>
	   						<a href="warehouse/warehouseList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="warehouse/warehouseList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="warehouse/warehouseList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="warehouse/warehouseList.do?pageIndex=${pageCount}">尾页</a>
	   					</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
