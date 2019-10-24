<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/17
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>带摇晃特效的扁平风格登录注册表单界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div id="wrapper" class="login-page">
    <div id="login_form" class="form">
        <form class="login-form" action="/LoginServlet" method="get">
            <h2>管理登录</h2>
            <input type="text" placeholder="用户名" id="user_name" name="loginName" />
            <input type="password" placeholder="密码" id="password" name="loginPass" />
            <button id="login">登　录</button>
            <p class="message">还没有账户? <a href="register.jsp">立刻创建</a></p>
        </form>
    </div>
</div>
</body>
</html>
