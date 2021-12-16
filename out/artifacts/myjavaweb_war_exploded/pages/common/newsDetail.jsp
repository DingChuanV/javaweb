<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
  </head>
<body>
<!--页面的头部-->
<div id="header">
    <!--页面顶部-->
    <div class="main-top">
        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
        <div class="login-box">
            <label>用户名</label><input type="text" name="uname" /><label>密码</label><input type="text" name="upassword" /><button>登录</button>
        </div>
         <!--导航-->
        <div class="nav">
            <ul class="clearfix">
                <li><a href="#">首页</a></li>
                <li><a href="#">国内</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">娱乐</a></li>
                <li><a href="#">军事</a></li>
            </ul>
        </div>
    </div>
    <!--banner-->
    <div class="main-banner"><img src="<%=request.getContextPath() %>/images/banner.png" /></div>
    <!--搜索横框-->
    <div class="search-box">
        <div class="sl">
            <div class="sr clearfix">
                <span class="left-search clearfix">
                    <label>站内搜索</label><input type="text" name="keyword" value="关键词" /><button class="go-btn"></button>
                </span>
                <span class="right-link">
                    <label>快速链接</label><select><option>-----专题选择-----</option></select><button class="go-btn"></button>
                </span>
            </div>
        </div>    
    </div>
</div>
<!--页面的主体-->
<div id="content" class="main-content clearfix">
	<!--主体的的左边部分-->
    <div class="main-content-left">
        <!--新闻专题分类-->
        <div class="class-box">
            <div class="class-box-header">
                <span class="fr"><a href="#">更多...</a></span>
                <h3>新闻专题</h3>
            </div>
            <div class="class-box-content">
                <ul>
                    <li><a href="#">国内</a></li>
                    <li><a href="#">国际</a></li>
                    <li><a href="#">娱乐</a></li>
                    <li><a href="#">军事</a></li>
                    <li><a href="#">财经</a></li>
                    <li><a href="#">天气</a></li>
                    <li class="clear-bottom-line"><a href="#">科技</a></li>
                </ul>
            </div>
        </div>
        <!--最新新闻-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3>最新新闻</h3></div>
                    <div class="left-box-content">
                        <ul>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--最新评论-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3>最新评论</h3></div>
                    <div class="left-box-content">
                        <ul>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                            <li><a href="#">课工场最靠谱的互联网教育 Java Web从入门到成就！</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主体的右部，包括新闻的列表和评论内容 -->
    <div class="main-content-right">
        <!--各专题的新闻列表-->
        <div class="main-text-box">
            <div class="article-place"><a href="#">新闻中心</a> > <a href="#">国内</a></div>
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                    	<!--新闻的标题-->

                        <%
                            String title = "课工场\"Java Web\"高能充电";
                            String publisher = "小K童鞋";

                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String date = format.format(new Date());
                        %>
						<h1><%=title%></h1>
                        <div class="source-bar">
					
						发布者：<%=publisher%> 分类：新闻信息 更新时间：<%=date%>
                        
                        
                        </div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：</b><%out.print("本课程以真实项目贯穿讲解，内容涉及Java Web环境搭建、JSP基础语法、JavaBean编程、JDBC、Servlet、过滤器与监听器、MVC，理论结合实践，边讲边练，穿插学习方法传授，真正实现Java程序从控制台到B/S结构程序的完美蜕变");%></span>
                            <p><%out.print("各位小伙伴们~又到了一年中，自我充电的黄金期，那么好消息来了，课工场即将开启大型限时活动【0元学习璇女神Java课程】。课程价值399元，开课后即返现金399元，是现金的现哦~<br/>活动流程与返现规则<br/>1、在腾讯课堂中点击购买课程：https://ke.qq.com/course/128564#term_id=100142816 <br/>2、完成付款后请与我们的咨询老师联系：QQ1: 2518311508  QQ2: 2165881978  告知个人返现信息姓名及银行卡卡号<br/>3、根据腾讯课堂规定，返现时间最晚是在课程结束后15个工作日内，请大家注意查收<br/>4、课程开课后与咨询老师联系，提供课工场账号（没有课工场账号的童鞋，快快去注册），即可为你开通免费观看价值500元的回放视频哦~");%> </P>
                        </div>
                        <div class="comment">
                            <dl>
                                <dt class="comment-top">
                                    <span class="fr">2011-09-25 13:33:55</span>
                                    <b>1楼</b> <b>水上漂</b>
                                </dt>
                                <dd class="comment-body">
                                    课工场，棒棒哒！
                                </dd>
                            </dl>
                            <dl>
                                <dt class="comment-top">
                                    <span class="fr">2011-09-25 13:33:55</span>
                                    <b>2楼</b> <b>拉娜</b>
                                </dt>
                               <dd class="comment-body">
                                    kgc,Fighting！
                                </dd>
                            </dl>
                            <dl>
                                <dt class="comment-top">
                                    <span class="fr">2021-09-07 09:30:56</span>
                                    <b>3楼</b> <b>hz7431</b>
                                </dt>
                                <dd class="comment-body">
                                    王铭我是你爸爸！！！
                                </dd>
                            </dl>
                        </div>
                        <div class="comment-form">
                            <div class="comment-form-header">
                                <span>用户：Landodo</span>
                                <h3>发表评论：</h3>
                            </div>
                            <div class="comment-form-content">
                                <textarea class="comment-textarea"></textarea>
                                <button type="submit" class="comment-btn">评论</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--//-->
        
    </div>
</div>
<!--页面底部-->
<div class="main-footer-box">
    24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@kgc.com.cn<br />
    Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
    新闻中心版权所有
</div>
</body>
</html>