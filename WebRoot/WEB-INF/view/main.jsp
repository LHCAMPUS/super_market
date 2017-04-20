<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>主页面</title>
   	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/main.css"/>
	<style type="text/css">
		p a:hover{
			color:#00FFFF;
		}
	</style>
  </head>
  
  <body leftmargin="0" topmargin="0">
		<div id="main">
			<div id="top">
				<p style="float:left;display:block;padding-left:25px;font-size:12pt">沃尔玛超市管理系统</p>
				<p>姶黎，欢迎登录！&nbsp;<a href="exit.do">安全退出</a></p>
			</div>
			<div id="left">
				<ul class="menu_main">
					<li class="menu_first"><a style="padding-left: 10px;">主菜单</a></li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/people.png"></div>&nbsp;&nbsp;档案管理</a>
						<ul>
							<li><a href='staff/staffList.do?pageIndex=1' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;员工列表</a></li>
							<li><a href="supplier/supplierList.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;供应商列表</a></li>
							<li><a href='staff/addStaff.do' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;添加员工</a></li>
							<li><a href="supplier/addSupplier.do" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;添加供应商</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/category.png"></div>&nbsp;&nbsp;分类管理</a>
						<ul>		
							<li><a href='category/categoryList.do?pageIndex=1' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;分类列表</a></li>
							<li><a href='category/addCategory.do' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;分类添加</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/goods.png"></div>&nbsp;&nbsp;商品管理</a>
						<ul>		
							<li><a href='goods/goodsList.do?pageIndex=1&pageSize=2' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;商品列表</a></li>
							<li><a href='goods/addGoods.do' target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;商品添加</a></li>
						</ul>
					</li>
				<!-- 	<li class="menu_first"><a>会员管理</a>
						<ul>
							<li><a href="viper/viperList.do?pageIndex=1" target="right">会员列表</a></li>
							<li><a href="viper/addViper.do" target="right">会员添加</a></li>
						</ul>
					</li> -->
					<li class="menu_first"><a><div id="menu_img"><img src="images/sale.png"></div>&nbsp;&nbsp;销售管理</a>
						<ul>
							<li><a href="outhousing/addOuthousing.do" target="right"?pageIndex=1><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;销售商品添加</a></li>
							<li><a href="outhousing/outhousingList.do?pageIndex=1" target="right"?pageIndex=1><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;销售列表</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/salefenxi.png"></div>&nbsp;&nbsp;销售分析</a>
						<ul>
							<li><a href="stock/stockAnalysis.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;库存分析</a></li>
							<li><a href="outhousing/outhousingAnalysis.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;商品分析</a></li>
							<li><a href="stock/stockList.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;退货分析</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/sale.png"></div>&nbsp;&nbsp;采购管理</a>
						<ul>
							<li><a href="inhousing/inhousingList.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;采购列表</a></li>
							<li><a href="inhousing/addInhousing.do" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;采购添加</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/kucun.png"></div>&nbsp;&nbsp;库存管理</a>
						<ul>
							<li><a href="stock/stockList.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;库存列表</a></li>
							<li><a href="stock/addstock.do" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;库存修改</a></li>
							<li><a href="warehouse/warehouseList.do?pageIndex=1" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;仓库列表</a></li>
							<li><a href="warehouse/addWarehouse.do" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;仓库添加</a></li>
						</ul>
					</li>
					<li class="menu_first"><a><div id="menu_img"><img src="images/setting.png"></div>&nbsp;&nbsp;系统设置</a>
						<ul>
							<li><a href="" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;个人信息</a></li>
							<li><a href="modify_password.html" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;修改密码</a></li>
							<li><a href="add_admin.html" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;新增管理员</a></li>
							<li><a href="" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;管理员列表</a></li>
							<li><a href="" target="right"><div id="menu_img"><img src="images/folder.png"></div>&nbsp;&nbsp;系统退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div id="right">
				<iframe src="welcome.html" name="right" width="100%" height="100%" frameborder="0"></iframe>
			</div>
		</div>
	</body>
	<script>
		$(function(){
			$(".menu_first > a").click(function(){
				var list = $(this).next("ul");
				list.slideToggle("fast");
			});
			
			$(".menu_first > ul > li").hover(
			function(){
				$(this).css('display','block');
				/* $(this).css('background','#C1DEFE'); */
				$(this).children('a').css('color','#33AECC');
			},function(){
				$(this).css('display','block');
				$(this).css('background-color','#F2F2F2');
				$(this).children('a').css('color','black');
			});
			$('.menu_first  li a').click(function(){
				if($(this).attr('href') == '' || $(this).attr('href')==null){
					alert('攻城狮正在东莞相亲,成功后功能将上线!!!');
					return false;
				}
			});
		});
	</script>
</html>
