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
    <title>销售分析</title>
	<link type="text/css" rel="stylesheet" href="css/comm.css"/>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  
  <body>
    <div class="title">销售分析 >销售商品分析</div>
   	   <div id="analy_top">
	  		<form action="outhousing/outhousingAnalysis.do" method="post">
	  			<table>
	  				<tr>
	  					<td style="width: 125px;text-align: center;font-size: 11pt;">销售日期：</td>
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
						<th>编号</th>
						<th>商品</th>
						<!-- <th>供应商</th>
						<th>仓库</th> -->
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
						<th>销售时间</th>
						<!-- <th>操作</th> -->
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
							<%-- <td>
								<a href="outhousing/updateOuthousing.do?id=${outhousing.outhousing_id }">编辑</a>
								&nbsp;&nbsp;
								<a href="outhousing/deleteOuthousing.do?id=${outhousing.outhousing_id }">删除</a>
							</td> --%>
						</tr>
					</c:forEach>
					<tr>
	   					<td colspan="7" text-align="center">
	   						<a href="outhousing/outhousingAnalysis.do?pageIndex=1&date1=${date1 }&date2=${date2}">首页</a>
	   						<a href="outhousing/outhousingAnalysis.do?pageIndex=${currentPage-1}&date1=${date1 }&date2=${date2}">上一页</a>
	   							<c:forEach begin="1" end="${pageCount}" varStatus="v">
	   								<c:choose>
	   									<c:when test="${v.count==currentPage}">
	   										<span id="sp">${v.count}</span>
	   									</c:when>
	   									<c:otherwise>
	   										<a  id="ap" href="outhousing/outhousingAnalysis.do?pageIndex=${v.count}&date1=${date1 }&date2=${date2}">${v.count}</a>
	   									</c:otherwise>
	   								</c:choose>  							
	   							</c:forEach>
	   						<a href="outhousing/outhousingAnalysis.do?pageIndex=${currentPage+1}&date1=${date1 }&date2=${date2}">下一页</a>
	   						<a href="outhousing/outhousingAnalysis.do?pageIndex=${pageCount}&date1=${date1 }&date2=${date2}">尾页</a>
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
