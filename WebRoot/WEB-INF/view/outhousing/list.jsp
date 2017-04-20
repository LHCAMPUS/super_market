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
    <title>出库信息</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <div class="title">出库信息管理 > 出库信息列表</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>编号</th>
						<th>商品</th>
						<!-- <th>供应商</th>
						<th>仓库</th> -->
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
						<th>销售时间</th>
						<th>操作</th>
					</tr>
					<c:forEach var="outhousing" items="${list }">
						<tr>
							<td>${outhousing.outhousing_id }</td>
							<td class="goods_id">${outhousing.goods_id }</td>
							<td class="goods_price"></td>
							<%-- <td class="supplier_id">${outhousing.supplier_id }</td>
							<td class="warehouse_id">${outhousing.warehouse_id }</td> --%>
							<td>${outhousing.goods_counts }</td>
							<td class="sumprice"></td>
							<td>${outhousing.outhousing_date }</td>
							<td>
								<a href="outhousing/updateOuthousing.do?id=${outhousing.outhousing_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="outhousing/deleteOuthousing.do?id=${outhousing.outhousing_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="7" text-align="center">
	   						<a href="outhousing/outhousingList.do?pageIndex=1">首页</a>
	   						<a href="outhousing/outhousingList.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="outhousing/outhousingList.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="outhousing/outhousingList.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="outhousing/outhousingList.do?pageIndex=${pageCount}">尾页</a>
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
  	  			url : "<%=path%>/outhousing/getgoodAndWare.do",
  	  			type : "POST",
  	  			async : false,
  	  			data :
  	  			{
  	  				goods_id : $(this).html(),
  	  				count :  $(this).next().next().html()
  	  			},
  	  			dataType : 'json',
  	  			success : function(data){
	  	  			$(".goods_id").eq(count).html(data.goodsName);
	  	  			$(".goods_price").eq(count).html(data.goods_price);
	  	  			$(".sumprice").eq(count).html(data.sumprice);
	  	  			count++;
  	  			}
  	  			
  	  		});
  		});
  		
  	});
  </script>
</html>
