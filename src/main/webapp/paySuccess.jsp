<%--
  Created by IntelliJ IDEA.
  User: yfkey
  Date: 2021/12/9
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>支付成功-综合网购首选-正品低价、品质保障、配送及时、轻松购物!
    </title>
    <!-- 网站说明 -->
    <meta name="description"
          content="品优购商城-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!" />
    <!-- 关键字 -->
    <meta name="keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,京东" />

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/paySuccess.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

</head>

<body>
<!-- 快捷导航模块 start -->
<section class="shortcut">
    <div class="w">
        <div class="fl">
            <ul>
                <li>品优购欢迎您！</li>
            </ul>
        </div>
        <div class="fr">
            <ul>
                <c:if test="${empty loginUser}">
                    <li><a href="login.jsp">登录</a></li>
                    <li></li>
                    <li><a href="register.jsp" class="style_red">注册</a></li>
                </c:if>
                <c:if test="${not empty loginUser}">
                    <li><a href="address?method=show">${loginUser.uname}</a></li>
                    <li></li>
                    <li><a href="user?method=logOut">注销</a></li>
                    <li></li>
                    <li><a href="orders?method=show">我的订单</a></li>
                    <c:if test="${loginUser.urole == 1}">
                        <li></li>
                        <li><a href="product?method=manage">商品目录管理</a></li>
                        <li></li>
                        <li><a href="orders?method=statistics">销售统计</a></li>
                        <li></li>
                        <li><a href="journal?method=show">用户浏览记录</a></li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
</section>
<!-- 快捷导航模块 end -->
<!-- header头部模块 start -->
<header class="header w">
    <!-- logo模块 -->
    <div class="logo">
        <h1>
            <a href="index.jsp" title="品优购商城">品优购商城</a>
        </h1>
    </div>
    <!-- 秒杀模块 -->
    <div class="sk">
        <img src="images/sk.png" alt="">
    </div>
    <!-- search搜索模块 -->
    <form action="product?method=search" method="post" class="search">
        <input type="search" name="sear" id="" placeholder="华为手机">
        <input type="submit" value="搜索">
    </form>
    <!-- hotwords热词模块 -->
    <div class="hotwords">
        <a href="#" class="style_red">优惠购首发</a>
        <a href="#">亿元优惠</a>
        <a href="#">9.9元团购</a>
        <a href="#">美满99减30</a>
        <a href="#">办公用品</a>
        <a href="#">电脑</a>
        <a href="#">通信</a>
    </div>
    <!-- shopcar购物车模块 -->
    <div class="shopcar">
        <a href="cart?method=show&uid=${loginUser.uid}">我的购物车</a>
    </div>
</header>
<!-- header头部模块 end -->
<!-- nav导航模块 start -->
<div class="nav">
    <div class="w">
        <div class="sk_list">
            <ul>
                <li><a href="#">品优秒杀</a></li>
                <li><a href="#">即将售罄</a></li>
                <li><a href="#">超值低价</a></li>
            </ul>
        </div>
        <div class="sk_con">
            <ul>
                <li><a href="#">女装</a></li>
                <li><a href="#">女鞋</a></li>
                <li><a href="#">男装</a></li>
                <li><a href="#">男鞋</a></li>
                <li><a href="#">母婴童装</a></li>
                <li><a href="#">食品</a></li>
                <li><a href="#">智能数码</a></li>
                <li><a href="#">运动户外</a></li>
                <li><a href="#">更多分类</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- nav导航模块 end -->
<!-- 购物车提示页主体部分 start -->
<div class="sk_container w">
    <div class="sk_bd clearfix">
        <div>
            <h3 class="top">付款提示</h3>
            <div class="center"><i class="style_green"></i>&nbsp;&nbsp;&nbsp;&nbsp;支付成功</div>
            <div class="bottom">
                <a href="orders?method=show" class="btn1">查看订单</a>
                <a href="index.jsp" class="btn2">继续购物</a>
            </div>
        </div>
    </div>
</div>
<!-- 购物车提示页主体部分 end -->
<!-- footer底部模块 start-->
<footer class="footer">
    <div class="w">
        <div class="mod_service">
            <ul>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>正品保障</h4>
                        <p>正品保障，提供发票</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>极速物流</h4>
                        <p>急速物流，急速送达</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>无忧售后</h4>
                        <p>7天无理由退换货</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>特色服务</h4>
                        <p>私人定制家电套餐</p>
                    </div>
                </li>
                <li>
                    <h5></h5>
                    <div class="service_txt">
                        <h4>帮助中心</h4>
                        <p>您的购物指南</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="mod_help">
            <dl>
                <dt>购物指南</dt>
                <dd>购物流程</dd>
                <dd>会员介绍</dd>
                <dd>生活旅行/团购</dd>
                <dd>常见问题</dd>
                <dd>大家电</dd>
                <dd>联系客服</dd>
            </dl>
            <dl>
                <dt>配送方式</dt>
                <dd>上门自提</dd>
                <dd>211限时达</dd>
                <dd>配送服务查询</dd>
                <dd>配送费收取标准</dd>
                <dd>海外配送</dd>
            </dl>
            <dl>
                <dt>支付方式</dt>
                <dd>货到付款</dd>
                <dd>在线支付</dd>
                <dd>分期付款</dd>
                <dd>邮局汇款</dd>
                <dd>公司转账</dd>
            </dl>
            <dl>
                <dt>售后服务</dt>
                <dd>售后政策</dd>
                <dd>价格保护</dd>
                <dd>退款说明</dd>
                <dd>返修/退换货</dd>
                <dd>取消订单</dd>
            </dl>
            <dl>
                <dt>特色服务</dt>
                <dd>夺宝岛</dd>
                <dd>DIY装机</dd>
                <dd>延保服务</dd>
                <dd>品优购E卡</dd>
                <dd>品优购通信</dd>
            </dl>
            <dl>
                <dt>帮助中心</dt>
                <dd>
                    <img src="images/code.png" alt="">
                    品优购客户端
                </dd>
            </dl>
        </div>
        <div class="mod_copyright">
            <div class="links">
                <a href="#">关于我们</a> | <a>联系我们</a> | <a href="#">联系客服</a> | <a href="#">商家入驻</a> | <a
                    href="#">营销中心</a>
                | <a href="#">手机品优购</a> | <a href="#">友情链接</a> | <a href="#">销售联盟</a> | <a href="#">品优购社区</a> | <a
                    href="#">品优购公益</a> | <a href="#">English Site</a> | <a href="#">Contact
                U</a>
            </div>
            <div class="copyright">
                地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-4000 传真：010-82935100 邮箱: zhanghj+itcast.cn <br>
                京ICP备08001421号京公网安备110108007702
            </div>
        </div>
    </div>
</footer>
<!-- footer底部模块 end-->

</body>
</html>
