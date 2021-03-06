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
    <title>采购分析</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <div class="title">销售分析> 采购分析</div>
     	<div id="analy_top">
	  		<form action="inhousing/inhousingAnalysis.do" method="post">
	  			<table>
	  				<tr>
	  					<td style="width: 125px;text-align: center;font-size: 11pt;">采购日期：</td>
	  					<td style="width: 385px;text-align: left;font-size: 11pt;">
	  						<input type="date" name="date1" value="${date1 }" style="font-family: 微软雅黑;"/> 到 <input type="date" value="${date2 }" name="date2" style="font-family: 微软雅黑;" />
	  					</td>
	  					<td><input type="submit" value="查询" style="font-size: 12pt;background-color: #33AECC;border: 2px solid #33AECC;color: white;border-radius: 3px;"></td>
	  				</tr>
	  			</table>
	  			<input type="hidden" name="pageIndex" value="1" />
	  		</form>
  		</div>
		<div class="form_box">
			<form>
				<table border=1 style="text-align:center">
					<tr>
						<th>采购ID</th>
						<th>商品</th>
						<th>供应商</th>
						<th>仓库</th>
						<th>数量</th>
						<th>采购时间</th>
					</tr>
					<c:forEach var="inhousing" items="${list }">
						<tr>
							<td>${inhousing.inhousing_id }</td>
							<td class="goods_id">${inhousing.goods_id }</td>
							<td class="supplier_id">${inhousing.supplier_id }</td>
							<td class="warehouse_id">${inhousing.warehouse_id }</td>
							<td>${inhousing.goods_counts }</td>
							<td>${inhousing.inhousing_date }</td>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="7" text-align="center">
	   						<a href="inhousing/inhousingAnalysis.do?pageIndex=1">首页</a>
	   						<a href="inhousing/inhousingAnalysis.do?pageIndex=${currentPage-1}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="inhousing/inhousingAnalysis.do?pageIndex=${v.count}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="inhousing/inhousingAnalysis.do?pageIndex=${currentPage+1}">下一页</a>
	   						<a href="inhousing/inhousingAnalysis.do?pageIndex=${pageCount}">尾页</a>
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
  	  			url : "<%=path%>/inhousing/getgoodAndWare.do",
  	  			type : "POST",
  	  			async : false,
  	  			data :
  	  			{
  	  				goods_id : $(this).html(),
  	  				supplier_id : $(this).next().html(),
  	  				warehouse_id : $(this).next().next().html()
  	  			},
  	  			dataType : 'json',
  	  			success : function(data){
	  	  			$(".goods_id").eq(count).html(data.goodsName);
	  	  			$(".supplier_id").eq(count).html(data.supplierName);
	  	  			$(".warehouse_id").eq(count).html(data.warehouseName);
	  	  			count++;
  	  			}
  	  			
  	  		});
  		});
  	});
  </script>
</html>
