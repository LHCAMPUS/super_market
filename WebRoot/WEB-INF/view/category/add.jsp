<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加员工信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">商品类别管理 > 商品类别添加</div>
		<div class="form_box">
			<form action="category/addCategory.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">商品类别名称:</td>
						<td>
							<input type="text" name="category_name" class="txt" required placeholder="请输入商品类别名称"/>
						</td>
					</tr>
					<tr>
						<td width="15%" align="right">商品类别备注:</td>
						<td>
							<input type="text" name="category_remark" class="txt" placeholder="请输入商品类别描述（选填）"/>
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
