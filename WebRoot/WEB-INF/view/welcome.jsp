<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	<h2>沃尔玛公司文化</h2>
    	<p>沃尔玛百货有限公司是在山姆·沃尔顿所倡导的原则上建立起来的。 这些原则已体现在同事每天的辛勤工作及待客服务中, 成为沃尔玛独特的企业文化, 使沃尔玛更具竞争力。 沃尔玛百货有限公司是由以下的基本信仰所指导:</p>
    	<h2>四项基本信仰</h2>
    	<h3>服务顾客</h3>
    	<ul>
    		<li>把服务顾客作为我们最重要的工作，“顾客就是老板”。 沃尔玛公司尽其所能使顾客感到在沃尔玛连锁店和山姆会员商店购物是一种亲切、愉快的经历。 “三米微笑原则”是指同事要问候所见到的每一位顾客；“保证满意”的退换政策使顾客能在沃尔玛连锁店和山姆会员商店放心购物;</li>
    		<li>支持我们的员工，这样他们就能为顾客提供最好的服务;</li>
    		<li>回馈当地的社区，与顾客建立联系。</li>
    	</ul>
    	<h3>尊重个人</h3>
    	<ul>
    		<li>尊重每位同事提出的意见,重视和认可每位同事的贡献，经理们被看作“公仆领导”, 通过培训、表扬及建设性的反馈意见帮助新的同事认识、发掘自己的潜能;</li>
    		<li>以聆听员工、分享信息的方式进行沟通，使用“开放式”的管理哲学在开放的气氛中鼓励同事多提问题、 多关心公司;</li>
    		<li>对你的工作负责，保持紧迫感，互相帮助，让大家都做到这一点。</li>
    	</ul>
    	<h3>追求卓越</h3>
    	<ul>
    		<li>大胆创新，尝试新的工作方式，持续提升;</li>
    		<li>为实现远大的理想竖立正面的典范;</li>
    		<li>发挥团队精神，互相帮助，寻求支持。</li>
    	</ul>
    	<h3>诚信行事</h3>
    	<ul>
    		<li>诚实，实话实说，信守诚诺;</li>
    		<li>对员工、供应商及各利益相关方做到公开公正;</li>
    		<li>保持客观，以沃尔玛的利益为一切决策的出发点，一切经营活动均应合法并符合公司政策的要求。</li>
    	</ul>
    </div>
  </body>
</html>
