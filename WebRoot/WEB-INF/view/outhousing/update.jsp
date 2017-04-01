<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改出库信息</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>

  </head>
  
  <body>
		<div class="title">出库信息管理 > 出库信息修改</div>
		<div class="form_box">
			<form action="staff/updateStaff.do" method="post">
				<table>
					<tr>
						<td width="15%" align="right">编号:</td>
						<td>
							<input type="text" name="outhousing_id" class="txt" value="${outhousing.outhousing_id }" required readonly/>
						</td>
					</tr>
					<tr>
						<td width="15%" align="right">商品ID:</td>
						<td>
							<input type="text" name="goods_id" class="txt" value="${goods.goods_id }" required placeholder="请输入商品ID"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">商品名:</td>
						<td>
							<input type="text" name="goods_name" value="${goods.goods_name }" required  class="txt" placeholder="请输入商品名"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">数量:</td>
						<td>
							<input type="text" name="goods_counts" value="${goods.goods_counts }" required  class="txt" placeholder="请输入商品数量"/>						
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">供应商ID:</td>
						<td>
							<input type="text" name="supplier_id" value="${supplier.supplier_id }" required   class="txt" placeholder="请输入供应商ID"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">仓库ID:</td>
						<td>
							<input type="text" name="warehouse_id" value="${warehouse.warehouse_id }" required  class="txt" placeholder="请输入仓库ID"/>
						</td>
					</tr>
					<tr>
						<td align="right" valign="top">出库时间:</td>
						<td>
							<input type="date" name="outhousing_date" value="${outhousing.outhousing_date }" required  class="txt" placeholder="请选择出库时间"/>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="修改" class="btn"/>
						</td>
					</tr>
				</table>
				<input type="hidden" name="outhousing_id" value="${outhousing.outhousing_id }" />
			</form>
		</div>
	</body>
	
</html>
