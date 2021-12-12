<%--
  Created by IntelliJ IDEA.
  User: yfkey
  Date: 2021/12/5
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>品优购商城-综合网购首选-正品低价、品质保障、配送及时、轻松购物!</title>
    <!-- 网站说明 -->
    <meta name="description"
          content="品优购商城-专业的综合网上购物商城,销售家电、数码通讯、电脑、家居百货、服装服饰、母婴、图书、食品等数万个品牌优质商品.便捷、诚信的服务，为您提供愉悦的网上购物体验!" />
    <!-- 关键字 -->
    <meta name="keywords" content="网上购物,网上商城,手机,笔记本,电脑,MP3,CD,VCD,DV,相机,数码,配件,手表,存储卡,京东" />

    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/index.css">
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
        <a href="cart?method=show&uid=${loginUser.uid}">
            我的购物车
        </a>
    </div>
</header>
<!-- header头部模块 end -->
<!-- nav导航模块 start -->
<div class="nav">
    <div class="w">
        <div class="dropdown">
            <div class="dt">全部商品分类</div>
            <div class="dd">
                <ul>
                    <li><a href="type?method=jump&typename=家用电器">家用电器</a></li>
                    <li><a href="type?method=jump&typename=手机">手机、</a><a href="#">数码、</a><a href="#">通信</a></li>
                    <li><a href="#">电脑、</a><a href="#">办公</a></li>
                    <li><a href="#">家居、</a><a href="#">家具、</a><a href="#">家装、</a><a href="#">厨具</a></li>
                    <li><a href="#">男装、</a><a href="#">女装、</a><a href="#">童装、</a><a href="#">内衣</a></li>
                    <li><a href="#">个护化妆、</a><a href="#">清洁用品、</a><a href="#">宠物</a></li>
                    <li><a href="#">鞋靴、</a><a href="#">箱包、</a><a href="#">珠宝、</a><a href="#">奢侈品</a></li>
                    <li><a href="#">运动户外、</a><a href="#">钟表</a></li>
                    <li><a href="#">汽车、</a><a href="#">汽车用品</a></li>
                    <li><a href="#">母婴、</a><a href="#">玩具乐器</a></li>
                    <li><a href="#">食品、</a><a href="#">酒类、</a><a href="#">生鲜、</a><a href="#">特产</a></li>
                    <li><a href="#">医药保健</a></li>
                    <li><a href="#">图书、</a><a href="#">音像、</a><a href="#">电子书</a></li>
                    <li><a href="#">彩票、</a><a href="#">旅行、</a><a href="#">充值、</a><a href="#">票务</a></li>
                    <li><a href="#">理财、</a><a href="#">众筹、</a><a href="#">白条、</a><a href="#">保险</a></li>
                </ul>
            </div>
        </div>
        <div class="navitems">
            <ul>
                <li><a href="#">服装城</a></li>
                <li><a href="#">美妆馆</a></li>
                <li><a href="#">传智超市</a></li>
                <li><a href="#">全球购</a></li>
                <li><a href="#">闪购</a></li>
                <li><a href="#">团购</a></li>
                <li><a href="#">拍卖</a></li>
                <li><a href="#">有趣</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- nav导航模块 end -->
<!-- index专有 main模块 start  -->
<div class="w">
    <div class="main">
        <div class="focus">
            <ul>
                <li>
                    <img src="upload/focus.png" alt="">
                </li>
            </ul>
        </div>
        <div class="newsflash">
            <div class="news">
                <div class="news_hd">
                    <h5>品优购快报</h5>
                    <a href="#" class="more">更多 &gt;</a>
                </div>
                <div class="news_bd">
                    <ul>
                        <li><a href="#"><strong>[特惠]</strong>备战开学季 全民半价购数码</a></li>
                        <li><a href="#"><strong>[公告]</strong>品优稳占家电网购六成份额</a></li>
                        <li><a href="#"><strong>[特惠]</strong>百元中秋全品类礼券限量领</a></li>
                        <li><a href="#"><strong>[公告]</strong>上品优生鲜 享阳澄湖大闸蟹</a></li>
                        <li><a href="#"><strong>[特惠]</strong>每日享折扣品优品质游</a></li>
                    </ul>
                </div>
            </div>
            <div class="lifeservice">
                <ul>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>话费</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>机票</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>电影票</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>游戏</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>彩票</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>加油卡</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>酒店</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>火车票</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>众筹</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>理财</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>礼品卡</p>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i></i>
                            <p>白条</p>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="bargain">
                <img src="upload/margain.png" alt="">
            </div>
        </div>
    </div>
</div>
<!-- index专有 main模块 end  -->
<!-- recom推荐模块 start  -->
<div class="recom w">
    <div class="recom_hd"></div>
    <div class="recom_bd">
        <ul>
            <li>
                <img src="upload/recom1.png" alt="">
            </li>
            <li>
                <img src="upload/recom2.png" alt="">
            </li>
            <li>
                <img src="upload/recom3.png" alt="">
            </li>
            <li>
                <img src="upload/recom4.png" alt="">
            </li>
        </ul>
    </div>
</div>
<!-- recom推荐模块 end  -->
<!-- favorite喜爱模块 start  -->
<div class="favorite w">
    <div class="favorite_hd">
        <h5>猜你喜欢</h5>
        <a href="#">换一批 </a>
    </div>
    <div class="favorite_bd">
        <ul>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav1.png" alt="">
                    </div>
                    <p class="description">
                        阳光美包新款单肩包女<br>
                        包时尚子母包四件套女
                    </p>
                    <span class="price">
                            <i>￥</i>116.00
                        </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav2.png" alt="">
                    </div>
                    <p class="description">
                        爱仕达 30CM炒锅不粘<br>
                        锅NWG8330E电磁炉炒
                    </p>
                    <span class="price">
                            <i>￥</i>99.00
                        </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav3.png" alt="">
                    </div>
                    <p class="description">
                        捷波朗<br>
                        (jabra)BOOSI劲步
                    </p>
                    <span class="price">
                            <i>￥</i>245.00
                        </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav4.png" alt="">
                    </div>
                    <p class="description">
                        欧普<br>
                        JYLZ08面板灯平板灯铝
                    </p>
                    <span class="price">
                            <i>￥</i>238.00
                        </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav5.png" alt="">
                    </div>
                    <p class="description">
                        三星<br>
                        (G5500)移动联
                    </p>
                    <span class="price">
                            <i>￥</i>649.00
                        </span>
                </a>
            </li>
            <li>
                <a href="#">
                    <div class="img">
                        <img src="upload/fav6.png" alt="">
                    </div>
                    <p class="description">
                        韩国所望<br>
                        紧致湿润精华露400ml
                    </p>
                    <span class="price">
                            <i>￥</i>649.00
                        </span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!-- favorite喜爱模块 end  -->
<!-- community社区模块 start  -->
<div class="community w">
    <div class="community_hd">
        <h5>传智播客·有趣区</h5>
    </div>
    <div class="community_bd">
        <div class="book">
            <img src="upload/comm1.png" alt="">
        </div>
        <div class="goods">
            <dl>
                <dt>好东西</dt>
                <dd>
                    <img src="upload/comm2.png" alt="">
                </dd>
                <dd>
                    <img src="upload/comm3.png" alt="">
                </dd>
            </dl>
        </div>
        <div class="brand_street">
            <dl>
                <dt>品牌街</dt>
                <dd>
                    <img src="upload/comm4.png" alt="">
                </dd>
                <dd>
                    <img src="upload/comm5.png" alt="">
                </dd>
                <dd>
                    <img src="upload/comm6.png" alt="">
                </dd>
            </dl>
        </div>
        <div class="brand">
            <img src="upload/comm7.png" alt="">
        </div>
    </div>
</div>
<!-- community社区模块 end  -->
<!-- floor电梯模块 start  -->
<div class="floor">
    <div class="w jiadian">
        <div class="box_hd">
            <h3>家用电器</h3>
            <div class="tab_list">
                <ul>
                    <li><a href="#" class="style_red">热门</a>|</li>
                    <li><a href="#">大家电</a>|</li>
                    <li><a href="#">生活电器</a>|</li>
                    <li><a href="#">厨房电器</a>|</li>
                    <li><a href="#">个护健康</a>|</li>
                    <li><a href="#">应季电器</a>|</li>
                    <li><a href="#">空气/净水</a>|</li>
                    <li><a href="#">新奇特</a>|</li>
                    <li><a href="#">高端电器</a></li>
                </ul>
            </div>
        </div>
        <div class="box_bd">
            <div class="tab_content">
                <div class="tab_list_item">
                    <div class="col_210">
                        <ul>
                            <li><a href="#">节能补贴</a></li>
                            <li><a href="#">4K电视</a></li>
                            <li><a href="#">空气净化器</a></li>
                            <li><a href="#">IH电饭煲</a></li>
                            <li><a href="#">滚筒洗衣机</a></li>
                            <li><a href="#">电热水器</a></li>
                        </ul>
                        <a href="#"><img src="upload/floor-1-1.png" alt=""></a>
                    </div>
                    <div class="col_329">
                        <a href="#"><img src="upload/floor-bd1-1.png" alt=""></a>
                    </div>
                    <div class="col_221l">
                        <a href="#" class="bb"><img src="upload/floor-1-2.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-1-3.png" alt=""></a>
                    </div>
                    <div class="col_221m">
                        <a href="#"><img src="upload/floor-1-4.png" alt=""></a>
                    </div>
                    <div class="col_219">
                        <a href="#" class="bb"><img src="upload/floor-1-5.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-1-6.png" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="brand">
                <img src="upload/floor-1-brand.png" alt="">
            </div>
        </div>
    </div>
    <div class="w shouji">
        <div class="box_hd">
            <h3>手机通讯</h3>
            <div class="tab_list">
                <ul>
                    <li><a href="#" class="style_red">热门</a>|</li>
                    <li><a href="#">品质优选</a>|</li>
                    <li><a href="#">新机尝鲜</a>|</li>
                    <li><a href="#">高性价比</a>|</li>
                    <li><a href="#">口碑推荐</a>|</li>
                    <li><a href="#">合约机</a>|</li>
                    <li><a href="#">手机卡</a>|</li>
                    <li><a href="#">店铺精选</a>|</li>
                    <li><a href="#">手机配件</a></li>
                </ul>
            </div>
        </div>
        <div class="box_bd">
            <div class="tab_content">
                <div class="tab_list_item">
                    <div class="col_210">
                        <ul>
                            <li><a href="#">手机通讯</a></li>
                            <li><a href="#">依旧换新</a></li>
                            <li><a href="#">双卡双待</a></li>
                            <li><a href="#">自营配件</a></li>
                            <li><a href="#">金属机身</a></li>
                            <li><a href="#">高清屏</a></li>
                        </ul>
                        <a href="#"><img src="upload/floor-2-1.png" alt=""></a>
                    </div>
                    <div class="col_329">
                        <a href="#"><img src="upload/floor-bd2-1.png" alt=""></a>
                    </div>
                    <div class="col_221l">
                        <a href="#" class="bb"><img src="upload/floor-2-2.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-2-3.png" alt=""></a>
                    </div>
                    <div class="col_221m">
                        <a href="#"><img src="upload/floor-2-4.png" alt=""></a>
                    </div>
                    <div class="col_219">
                        <a href="#" class="bb"><img src="upload/floor-2-5.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-2-6.png" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="brand">
                <img src="upload/floor-2-brand.png" alt="">
            </div>
        </div>
    </div>
    <div class="w diannao">
        <div class="box_hd">
            <h3>电脑办公</h3>
            <div class="tab_list">
                <ul>
                    <li><a href="#" class="style_red">热门</a>|</li>
                    <li><a href="#">电脑/平板</a>|</li>
                    <li><a href="#">潮流影音</a>|</li>
                    <li><a href="#">智能/外设</a>|</li>
                    <li><a href="#">DIY硬件</a>|</li>
                    <li><a href="#">电竞游戏</a>|</li>
                    <li><a href="#">办公/网络</a>|</li>
                    <li><a href="#">文具电教</a>|</li>
                    <li><a href="#">精选配件</a></li>
                </ul>
            </div>
        </div>
        <div class="box_bd">
            <div class="tab_content">
                <div class="tab_list_item">
                    <div class="col_210">
                        <ul>
                            <li><a href="#">SSD硬盘</a></li>
                            <li><a href="#">显示器</a></li>
                            <li><a href="#">机械键盘</a></li>
                            <li><a href="#">台式机</a></li>
                            <li><a href="#">组装电脑</a></li>
                            <li><a href="#">配件专区</a></li>
                        </ul>
                        <a href="#"><img src="upload/floor-3-1.png" alt=""></a>
                    </div>
                    <div class="col_329">
                        <a href="#"><img src="upload/floor-bd3-1.png" alt=""></a>
                    </div>
                    <div class="col_221l">
                        <a href="#" class="bb"><img src="upload/floor-3-2.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-3-3.png" alt=""></a>
                    </div>
                    <div class="col_221m">
                        <a href="#"><img src="upload/floor-3-4.png" alt=""></a>
                    </div>
                    <div class="col_219">
                        <a href="#" class="bb"><img src="upload/floor-3-5.png" alt=""></a>
                        <a href="#" class="nbb"><img src="upload/floor-3-6.png" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="brand">
                <img src="upload/floor-3-brand.png" alt="">
            </div>
        </div>
    </div>
</div>
<!-- floor电梯模块 end  -->
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
                    href="#">营销中心</a> | <a href="#">手机品优购</a> | <a href="#">友情链接</a> | <a href="#">销售联盟</a> | <a
                    href="#">品优购社区</a> | <a href="#">品优购公益</a> | <a href="#">English Site</a> | <a href="#">Contact
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
