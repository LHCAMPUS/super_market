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
    <title>管理员信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
  </head>
  
  <body>
    <div class="title">系统设置 > 管理员列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>手机</th>
						<!-- <th>操作</th> -->
					</tr>
					<c:forEach var="user" items="${list }">
						<tr>
							<td>${user.id }</td>
							<td>${user.realname }</td>
							<td>${user.phone }</td>
							<%-- <td>
								<a href="user/updateuser.do?id=${user.id }">编辑</a>
								&nbsp;&nbsp;
								<a href="user/deleteuser.do?id=${user.id }">删除</a>
							</td> --%>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="9" text-align="center">
	   						<a href="user/userList.do?pageIndex=1">首页</a>
	   						<a href="user/userList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="user/userList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="user/userList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="user/userList.do?pageIndex=${pageCount}">尾页</a>
	   					</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
