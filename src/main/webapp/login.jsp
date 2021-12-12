<%--
  Created by IntelliJ IDEA.
  User: yfkey
  Date: 2021/12/4
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

<body>
    <div class="w">
        <div class="header">
            <div class="logo">
                <a href="index.jsp"><img src="images/logo.png" alt=""></a>
            </div>
        </div>
        <div class="loginarea">
            <h3>用户登录
                <div class="register">我没有账号，去<a href="register.jsp">注册</a></div>
            </h3>
            <div class="log_form">
                <form action="user?method=login" method="post">
                    <ul>
                        <li>
                            <label>用户名：</label>
                            <input type="text" id="username" name="username" placeholder="Username" required="required">
                            <span id="usernameMsg"></span>
                        </li>
                        <li>
                            <label>密码：</label>
                            <input type="password" name="password" placeholder="Password" required="required">
                        </li>
                        <li>
                            <input type="submit" value="登录" class="btn">
                        </li>
                    </ul>
                    <div>${msg}</div>
                </form>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</body>
</html>
