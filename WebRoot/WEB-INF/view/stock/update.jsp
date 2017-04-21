<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改库存信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">库存管理 > 库存修改</div>
		<div class="form_box">
			<form action="stock/updateStock.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">仓库:</td>
						<td>
							<input type="text" name="warehouse_name" class="txt" value="${warehouse }" required readonly/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">商品:</td>
						<td>
							<input type="text" name="goods" value="${goods }" required readonly class="txt" />
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="count" value="${stock.count }" required  class="txt" placeholder="请输入数量"/>						
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="stock_id" value="${stock.stock_id }" />
			</form>
		</div>
	</body>
	
</html>
