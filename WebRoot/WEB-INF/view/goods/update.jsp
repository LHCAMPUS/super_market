<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改员工信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">商品管理 > 商品修改</div>
		<div class="form_box">
			<form action="goods/updateGoods.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">名称:</td>
						<td>
							<input type="text" name="goods_name" value="${goods.goods_name }" class="txt" required placeholder="请输入名称"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">单价:</td>
						<td>
							<input type="text" name="goods_money" value="${goods.goods_money }" class="txt" required placeholder="请输入单价"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">售价:</td>
						<td>
							<input type="text" name="goods_saleMoney" value="${goods.goods_saleMoney }" required  class="txt" placeholder="请输入售价"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">日期:</td>
						<td>
							<input type="date" name="goods_date" value="${goods.goods_date }" required  class="txt" placeholder="请输入日期"/>						
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" value="${goods.goods_counts }" required  class="txt" placeholder="请输入数量"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="goods_id" value="${goods.goods_id }" />
			</form>
		</div>
	</body>
	
</html>
