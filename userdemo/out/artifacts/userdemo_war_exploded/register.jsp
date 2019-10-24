<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/21
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册表单</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div id="wrapper" class="login-page">
    <div id="login_form" class="form">
        <form class="login-form" method="get" action="/CheckServlet">
            <h2>管理注册</h2>
            <input type="text" placeholder="用户名" id="user_name" name="username" />
            <input type="password" placeholder="密码" id="password" name="password" />
            <button id="login">注 册</button>
            <p class="message">已经有了一个账户？ <a href="login.jsp">立刻登录</a></p>
        </form>
    </div>
</div>
</body>
</html>
