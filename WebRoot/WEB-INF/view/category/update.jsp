<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改商品类别</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">商品类别管理 > 商品类别修改</div>
		<div class="form_box">
			<form action="category/updateCategory.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">编号:</td>
						<td>
							<input type="text" name="category_id" value="${category.category_id }" class="txt" required readonly/>
						</td>
					</tr>
					<tr>
						<td width="15%" align="right">商品类别名称:</td>
						<td>
							<input type="text" name="category_name" value="${category.category_name }" class="txt" required placeholder="请输入名称"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">商品类别备注:</td>
						<td>
							<input type="text" name="category_remark" value="${category.category_remark }" class="txt" required placeholder="请输入单价"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="category_id" value="${category.category_id }" />
			</form>
		</div>
	</body>
	
</html>
