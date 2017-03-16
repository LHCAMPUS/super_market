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
    <div class="title">会员管理 > 会员列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>会员编号</th>
						<th>会员姓名</th>
						<th>会员卡号</th>
						<th>会员积分</th>
						<th>操作</th>
					</tr>
					<c:forEach var="viper" items="${list }">
						<tr>
							<td>${viper.vip_no }</td>
							<td>${viper.vip_name }</td>
							<td>${viper.vip_idCard }</td>
							<td>${viper.vip_integral }</td>
							<td>
								<a href="viper/updateViper.do?id=${viper.vip_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="viper/deleteViper.do?id=${viper.vip_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
  </body>
</html>
