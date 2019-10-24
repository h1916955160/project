<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/21
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.sql.*" %>
<%
    Date date = new Date();
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
    String time=dateFormat.format(date);
%>

<%
    class DbUtil {

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

        private String dbUrl = bundle.getString("dbUrl");
        private String dbUser = bundle.getString("dbUser");
        private String dbPassword = bundle.getString("dbPassword");
        private String driver = "com.mysql.jdbc.Driver";

        private Connection connection = null;

        public Connection getConnection(){
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            } catch (Exception e) {
                System.out.println("数据库连接失败");
                e.printStackTrace();
            }
            return connection;
        }

        public void closeCon(){
            if(connection != null)
                try {
                    connection.close();
                    System.out.println("数据库已关闭");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
%>

<%
    DbUtil dbUtil=new DbUtil();

    String sql1="SELECT count(*) from garbage";
    String sql2="SELECT count(*) from news";
    String sql3="SELECT count(*) from users";

    Connection connection=dbUtil.getConnection();

    Statement statement=connection.createStatement();
    Statement statement1=connection.createStatement();
    Statement statement2=connection.createStatement();

    ResultSet rs = statement.executeQuery(sql1);
    ResultSet rs1=statement1.executeQuery(sql2);
    ResultSet rs2=statement2.executeQuery(sql3);
    rs.next();
    rs1.next();
    rs2.next();
    int garbagenum = rs.getInt(1);
    int newsnum =rs1.getInt(1);
    int membernum =rs2.getInt(1);
%>



<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-L-admin1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
</head>
<body>
<div class="x-body layui-anim layui-anim-up">
    <%
        boolean isLogin = false;
        String loginName = (String)request.getSession().getAttribute("loginName");
        if(loginName != null && !"".equals(loginName)){
            isLogin = true;
        }
        request.setAttribute("isLogin",isLogin);
        request.setAttribute("loginName",loginName);
    %>
    <blockquote class="layui-elem-quote">欢迎管理员：
        <span class="x-red">${loginName}</span>！登录时间:<%=time%>></blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据统计</legend>
        <div class="layui-field-box">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 90px;">
                            <div carousel-item="">
                                <ul class="layui-row layui-col-space10 layui-this">
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>文章数</h3>
                                            <p>
                                                <cite><%=newsnum%></cite></p>
                                        </a>
                                    </li>
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>会员数</h3>
                                            <p>
                                                <cite><%=membernum%></cite></p>
                                        </a>
                                    </li>

                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>垃圾数</h3>
                                            <p>
                                                <cite><%=garbagenum%></cite></p>
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>

    <fieldset class="layui-elem-field">
        <legend>系统通知</legend>
        <div class="layui-field-box">
            <table class="layui-table" lay-skin="line">
                <tbody>
                <tr>
                    <td >
                        <a class="x-a" href="/" target="_blank">新版L-admin 2.0上线了</a>
                    </td>
                </tr>
                <tr>
                    <td >
                        <a class="x-a" href="/" target="_blank">交流qq:(370946531)</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>


    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>cdnuti(xuebingsi)
                    <td>
                </tr>
                <tr>
                    <th>开发者</th>
                    <td>along(370946531@qq.com)</td></tr>
                </tbody>
            </table>
        </div>
    </fieldset>

</div>

</body>
</html>
