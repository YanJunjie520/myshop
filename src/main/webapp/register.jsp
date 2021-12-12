<%--
  Created by IntelliJ IDEA.
  User: yfkey
  Date: 2021/12/9
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册页</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/register.css">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

    <script src="JQuery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#username").change(function() {
                $.get("user", "username=" + this.value + "&method=check", function(data) {
                    if(data == 1) {
                        $("#usernameMsg").html("用户名已经存在").css("color","red");
                        $("#registerBtn").attr("disabled", true);
                        $("#registerBtn").css("background-color", "#808080");
                        $("#registerBtn").css("cursor", "default");
                    }
                    else {
                        $("#usernameMsg").html("用户名可用").css("color","green");
                        $("#registerBtn").removeAttr("disabled");
                        $("#registerBtn").css("background-color", "#c81623");
                        $("#registerBtn").css("cursor", "pointer");
                    }
                })
            });
        })
    </script>
</head>

<body>
<div class="w">
    <div class="header">
        <div class="logo">
            <a href="index.jsp"><img src="images/logo.png" alt=""></a>
        </div>
    </div>
    <div class="registerarea">
        <h3>注册新用户
            <div class="login">我有账号，去<a href="login.jsp">登录</a></div>
        </h3>
        <div class="reg_form">
            <form action="user?method=register" method="post">
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
                        <label>确认密码：</label>
                        <input type="password" name="psw" placeholder="Password Again" required="required">
                    </li>
                    <li>
                        <label>邮箱：</label>
                        <input type="email" name="email" placeholder="Email" required="required">
                    </li>
                    <li>
                        <label>性别：</label>
                        <input type="radio" name="sex" id="nan" value="男" required="required"><label for="nan" class="sex">男</label>
                        <input type="radio" name="sex" id="nv" value="女"><label for="nv" class="sex">女</label>
                    </li>
                    <li>
                        <input type="submit" value="完成注册" id="registerBtn" class="btn">
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
