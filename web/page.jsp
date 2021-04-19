<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:shiro="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html"
      lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>xx系统</title>
    <link rel="stylesheet" href="<%=basePath%>static/lib/layui/css/layui.css">
    <script type="text/javascript" src="<%=basePath%>static/lib/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">疫情数据后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    张三
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="" target="right">基本资料</a></dd>
                    <dd><a href="" target="right">安全设置</a></dd>
                    <dd><a href="" target="right">更换头像</a></dd>
                    <dd><a href="<%=basePath%>jsp/login.jsp">退出登录</a></dd>
                </dl>
            </li>

        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>employee.jsp" target="right">用户列表</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">缴费</a>
                    <dl class="layui-nav-child">

                        <dd><a href="<%=basePath%>querywater.jsp" target="right">已缴费用户</a></dd>
                        <dd><a href="<%=basePath%>billhistory.jsp" target="right">未缴费用户</a></dd>

                    </dl>
                </li>

<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;">分析系统</a>--%>
<%--                    <dl clas="layui-nav-child">--%>
<%--                        <dd><a href="<%=basePath%>shouye.jsp" target="right">新冠型肺炎分析系统</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>

            </ul>

        </div>

    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <!--        <div style="padding: 15px;">内容主体区域</div>-->
        <iframe scrolling="0" rameborder="0" src="" name="right" width="100%" height="98.5%"></iframe>
    </div>

    <div class="layui-footer" style="text-align: center;height: 50px">
        <!-- 底部固定区域 -->
        <p>author 2021/2/23/xujia</p>
    </div>
</div>
<script th:src="@{layui/layui.js}" type="text/javascript"></script>
<script th:inline="javascript">
    //自动填充模块应该有的内容样式
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>