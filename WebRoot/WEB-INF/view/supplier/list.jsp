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
    <title>供应商信息</title>
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
    <div class="title">供应商管理  > 供应商列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>公司名</th>
						<th>负责人</th>
						<th>地址</th>
						<th>电话</th>
						<th>操作</th>
					</tr>
					<c:forEach var="supplier" items="${list }">
						<tr>
							<td>${supplier.supplier_id }</td>
							<td>${supplier.supplier_name }</td>
							<td>${supplier.supplier_person }</td>
							<td>${supplier.supplier_address }</td>
							<td>${supplier.supplier_phone }</td>
							<td>
								<a href="">修改</a>
								&nbsp;&nbsp;
								<a href="">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="4" align="center">
	   						<a href="supplier/supplierList.do?pageIndex=1">首页</a>
	   						<a href="supplier/supplierList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="supplier/supplierList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="supplier/supplierList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="supplier/supplierList.do?pageIndex=${pageCount}">尾页</a>
	   					</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
