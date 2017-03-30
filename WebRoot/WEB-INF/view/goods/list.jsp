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
    <title>员工信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src=""></script>
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
    <div class="title">商品管理 > 商品列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>名称</th>
						<th>进价</th>
						<th>分类</th>
						<th>仓库</th>
						<th>售价</th>
						<th>生产日期</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
					<c:forEach var="goods" items="${list }">
						<tr>
							<td>${goods.goods_id }</td>
							<td>${goods.goods_name }</td>
							<td>${goods.goods_money }</td>
							<td class="category_id">${goods.category_id }</td>
							<td class="warehouse_id">${goods.warehouse_id }</td>
							<td>${goods.goods_saleMoney }</td>
							<td>${goods.goods_date }</td>
							<td>${goods.goods_counts }</td>
							<td>
								<a href="goods/updateGoods.do?id=${goods.goods_id }">修改</a>
								&nbsp;&nbsp;
								<a href="goods/deleteGoods.do?id=${goods.goods_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="4" align="center">
	   						<a href="goods/goodsList.do?pageIndex=1">首页</a>
	   						<a href="goods/goodsList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="goods/goodsList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="goods/goodsList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="goods/goodsList.do?pageIndex=${pageCount}">尾页</a>
	   					</td>
   					</tr>
				</table>
			</form>
		</div>
  </body>
  <script type="text/javascript">
  
  	$(document).ready(function(){
  		var count = 0;
  		$(".category_id").each(function(){
  			$.ajax({
  	  			url : "<%=path%>/goods/getCateAndWare.do",
  	  			type : "POST",
  	  			async : false,
  	  			data :
  	  			{
  	  				category_id : $(this).html(),
  	  				warehouse_id : $(this).next().html()
  	  			},
  	  			dataType : 'json',
  	  			success : function(data){
	  	  			$(".category_id").eq(count).html(data.categoryName);
	  	  			$(".warehouse_id").eq(count).html(data.warehouseName);
	  	  			count++;
  	  			}
  	  			
  	  		});
  		});
  	});
  </script>
</html>
