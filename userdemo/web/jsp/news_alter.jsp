<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <%--<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
    <%--<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
</head>

<body>
<div class="x-body">
    <form class="layui-form"  method="post" action="/NewsAlter">
        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
                <span class="x-red">*</span>新闻编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="id" name="news_id" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
                <span class="x-red">*</span>新闻标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="newsname" name="news_title" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
                <span class="x-red">*</span>新闻作者
            </label>
            <div class="layui-input-inline">
                <input type="text" id="newsauthor" name="news_author" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
                <span class="x-red">*</span>新闻图片
            </label>
            <div class="layui-input-inline">
                <input type="text" id="newspic" name="news_pic" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
                <span class="x-red">*</span>发表时间
            </label>
            <div class="layui-input-inline">
                <input type="text" id="time" name="news_time" required lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label for="newstext" class="layui-form-label">
                新闻内容
            </label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" id="newstext" name="news_text" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="newsname" class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>


</body>

</html>
