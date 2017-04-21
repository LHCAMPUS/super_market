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
    <title>库存分析</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
  
    <div class="title">销售分析 > 库存分析</div>
    	<div id="analy_top">
	  		<form action="stock/stockAnalysis.do" method="post">
	  			<table>
	  				<tr>
	  					<td style="width: 125px;text-align: center;font-size: 11pt;">库存数量：</td>
	  					<td style="width: 385px;text-align: left;font-size: 11pt;">
	  						<input type="text" name="count1" value="${count1 }" /> 到 <input type="text" value="${count2 }" name="count2" />
	  					</td>
	  					<td><input type="submit" value="查询" style="font-size: 12pt;background-color: #09f;border: 1px solid #09f;color: white;border-radius: 3px;"></td>
	  				</tr>
	  			</table>
	  			<input type="hidden" name="pageIndex" value="1" />
	  		</form>
  		</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>序号</th>
						<th>商品</th>
						<th>仓库</th>
						<th>数量</th>
					</tr>
					<c:forEach var="stock" items="${list }">
						<tr>
							<td>${stock.stock_id }</td>
							<td class="goods_id">${stock.goods_id }</td>
							<td class="warehouse_id">${stock.warehouse_id }</td>
							<td>${stock.count }</td>
							<%-- <td>
								<a href="viper/updateViper.do?id=${stock.stock_id }">修改</a>
								&nbsp;&nbsp;
								<a href="viper/deleteViper.do?id=${stock.stock_id }">删除</a>
							</td> --%>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="6" text-align="center">
	   						<a href="stock/stockAnalysis.do?pageIndex=1&count1=${count1 }&count2=${count2}">首页</a>
	   						<a href="stock/stockAnalysis.do?pageIndex=${currentPage-1}&count1=${count1 }&count2=${count2}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="stock/stockList.do?pageIndex=${v.count}&count1=${count1 }&count2=${count2}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="stock/stockAnalysis.do?pageIndex=${currentPage+1}&count1=${count1 }&count2=${count2}">下一页</a>
	   						<a href="stock/stockAnalysis.do?pageIndex=${pageCount}&count1=${count1 }&count2=${count2}">尾页</a>
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
