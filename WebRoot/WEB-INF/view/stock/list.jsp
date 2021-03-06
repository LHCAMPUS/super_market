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
    <title>库存信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <div class="title">库存管理 > 库存列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>序号</th>
						<th>商品</th>
						<th>仓库</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
					<c:forEach var="stock" items="${list }">
						<tr>
							<td>${stock.stock_id }</td>
							<td class="goods_id">${stock.goods_id }</td>
							<td class="warehouse_id">${stock.warehouse_id }</td>
							<td>${stock.count }</td>
							<td>
								<a href="stock/updateStock.do?id=${stock.stock_id }">修改</a>
								&nbsp;&nbsp;
								<a href="stock/deleteStock.do?id=${stock.stock_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="6" text-align="center">
	   						<a href="stock/stockList.do?pageIndex=1">首页</a>
	   						<a href="stock/stockList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="stock/stockList.do?pageIndex=${v.count}">${v.count}</a>
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
    <script type="text/javascript">
  	$(document).ready(function(){
  		var count = 0;
  		$(".goods_id").each(function(){
  			$.ajax({
  	  			url : "<%=path%>/stock/getgoodAndWare.do",
  	  			type : "POST",
  	  			async : false,
  	  			data :
  	  			{
  	  				goods_id : $(this).html(),
  	  				warehouse_id : $(this).next().html()
  	  			},
  	  			dataType : 'json',
  	  			success : function(data){
	  	  			$(".goods_id").eq(count).html(data.goodsName);
	  	  			$(".warehouse_id").eq(count).html(data.warehouseName);
	  	  			count++;
  	  			}
  	  			
  	  		});
  		});
  	});
  </script>
</html>
