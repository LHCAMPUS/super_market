<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加仓库信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">仓库管理 > 仓库添加</div>
		<div class="form_box">
			<form action="warehouse/addWarehouse.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right" valign="top">仓库名:</td>
						<td>
							<input type="text" name="warehouse_name" class="txt" required placeholder="请输入仓库名"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">仓库地址:</td>
						<td>
							<input type="text" name="warehouse_address" required  class="txt" placeholder="请输入仓库地址"/>
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
