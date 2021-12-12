<%--
  Created by IntelliJ IDEA.
  User: yfkey
  Date: 2021/12/4
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>激活页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/registerSuccess.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

<body>
    <div class="w">
        <div class="header">
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.png" alt=""></a>
            </div>
        </div>
        <div class="registerarea">
            <h3>激活状态</h3>
            <div class="reg_form">
                <div>
                    <h3>${msg}</h3>
                    <a href="${url}"><input type="button" value="${gg}" class="btn1"></a>
                    <a href="index.jsp"><input type="button" value="返回主页" class="btn2"></a>
                </div>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</body>
</html>
