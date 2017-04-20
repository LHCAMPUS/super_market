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
    <title>会员信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
  </head>
  
  <body>
    <div class="title">会员管理 > 会员列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>序号</th>
						<th>会员编号</th>
						<th>会员姓名</th>
						<th>会员卡号</th>
						<th>会员积分</th>
						<th>操作</th>
					</tr>
					<c:forEach var="viper" items="${list }">
						<tr>
							<td>${viper.vip_id }</td>
							<td>${viper.vip_no }</td>
							<td>${viper.vip_name }</td>
							<td>${viper.vip_idCard }</td>
							<td>${viper.vip_integral }</td>
							<td>
								<a href="viper/updateViper.do?id=${viper.vip_id }">修改</a>
								&nbsp;&nbsp;
								<a href="viper/deleteViper.do?id=${viper.vip_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="6" text-align="center">
	   						<a href="viper/viperList.do?pageIndex=1">首页</a>
	   						<a href="viper/viperList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="viper/viperList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="viper/viperList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="viper/viperList.do?pageIndex=${pageCount}">尾页</a>
	   					</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
