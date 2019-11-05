<%@ page import="user.user_reg" %><%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/11/3
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%
    user_reg user =(user_reg) request.getAttribute("user_info");
    session.setAttribute("user",user);
%>
<a href="${pageContext.request.contextPath}/jsp/invitation.jsp">进入论坛界面</a>
</body>
</html>
