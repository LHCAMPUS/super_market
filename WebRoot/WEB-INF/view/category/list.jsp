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
  </head>
  
  <body>
    <div class="title">分类管理 > 分类列表</div>
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
								<a href="category/updateCategory.do?id=${category.category_id }">修改</a>
								&nbsp;&nbsp;
								<a href="category/deleteCategory.do?id=${category.category_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" text-align="center">
							<div id="page">
	   						<a href="category/categoryList.do?pageIndex=1">首页</a>
	   						<a href="category/categoryList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="category/categoryList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="category/categoryList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="category/categoryList.do?pageIndex=${pageCount}">尾页</a>
   							</div>
   						</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
