<%--
  Created by IntelliJ IDEA.
  User: JiuXian
  Date: 2021/4/11
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<html>

<%--<head>--%>
<%--    <title>登录</title>--%>
<%--&lt;%&ndash;    <script>type=""</script>&ndash;%&gt;--%>

<%--</head>--%>
<%--<body>--%>

<%--    <% pageContext.setAttribute("info","这是Page"); %>--%>
<%--    <form action="login" method="post">--%>
<%--&lt;%&ndash;        method=get 会把获取的数据现在在URL中 &ndash;%&gt;--%>
<%--        用户名:<input type="text" name="username"><br>--%>
<%--        密  码:<input type="password" name="password"><br>--%>
<%--        <input type="submit" value="登录">--%>
<%--&lt;%&ndash;        <input type="submit" onclick="login" value="提交">&ndash;%&gt;--%>
<%--    </form>--%>
<%--    <h5 style="color: darkred">${info}</h5>--%>

<%--    <h1>AJAX请求</h1>--%>

<%--    用户名:<input type="text" id="username"><br>--%>
<%--    密  码:<input type="password" id="password"><br>--%>
<%--    <input type="submit" value="登录" onclick="login()">--%>
<%--    <span id="info" style="color: fuchsia"></span>--%>
<%--    <script type="text/javascript" src="static/jquery.min.js"></script>--%>

<%--    <script>--%>
<%--        function login() {--%>
<%--            var username = $("#username").val();--%>
<%--            var password = $("#password").val();--%>
<%--            // $.ajax({--%>
<%--            //     url : "loginAjax",--%>
<%--            //     type : "get",--%>
<%--            //     dataType : "text",--%>
<%--            //     data : {--%>
<%--            //         "username" : username,--%>
<%--            //         "password" : password--%>
<%--            //     },--%>
<%--            //     success : function (data) {--%>
<%--            //         console.log(data)--%>
<%--            //         if ( data ==="success"){--%>
<%--            //             $("#info").text("登录成功")--%>
<%--            //             location.href = "index.jsp"--%>
<%--            //         }else {--%>
<%--            //             $("#info").text("登录失败")--%>
<%--            //         }--%>
<%--            //     }--%>
<%--            // })--%>

<%--            // $.ajax({--%>
<%--            //     url : "loginAjax",--%>
<%--            //     type : "post",--%>
<%--            //     dataType : "text",--%>
<%--            //     data : {--%>
<%--            //         "username" : username,--%>
<%--            //         "password" : password--%>
<%--            //     },--%>
<%--            //     success : function (data) {--%>
<%--            //         console.log(data)--%>
<%--            //         if ( data ==="success"){--%>
<%--            //             $("#info").text("登录成功")--%>
<%--            //             // location.href = "index.jsp"--%>
<%--            //         }else {--%>
<%--            //             $("#info").text("登录失败")--%>
<%--            //         }--%>
<%--            //     }--%>
<%--            // })--%>
    <%--        $.ajax({--%>
    <%--            url: "user",--%>
    <%--            dataType: "json",--%>
    <%--            type: "post",--%>
    <%--            data: {--%>
    <%--                "method": "queryAllUser"--%>
    <%--            },--%>
    <%--            success: function (data) {--%>
    <%--                console.log(data)--%>
    <%--                var str = "";--%>
    <%--                $("#tab").html('');--%>
    <%--                if (data.length > 0) {--%>
    <%--                    for (var i = 0; i < data.length; i++) {--%>
    <%--                        str += "<tr>" +--%>
    <%--                            "<td>" + data[i].id + "</td>" +--%>
    <%--                            "<td>" + data[i].name + "</td>" +--%>
    <%--                            "<td>" + data[i].username + "</td>" +--%>
    <%--                            "<td>" + data[i].password + "</td>" +--%>
    <%--                            "<td>" + data[i].userstate + "</td>" +--%>
    <%--                            "<td hidden>" + data[i].userState + "</td>" +--%>
    <%--                            "<td><button type='button' class='btn btn-primary btn-sm' onclick='update(this)'>\n" +--%>
    <%--                            " <span class='glyphicon glyphicon-ok'></span><i class='fa fa-check'></i>&nbsp; 修改</button>\n" +--%>
    <%--                            "<button type='button' class='btn btn-danger btn-sm'  onclick='del(" + data[i].id + ")' >\n" +--%>
    <%--                            " <span class='glyphicon glyphicon-remove'></span><i class='fa fa-check'></i>&nbsp; 删除</button></td>" +--%>
    <%--                            "</tr>"--%>
    <%--                    }--%>
    <%--                } else {--%>
    <%--                    $("#tab").append('<tr><td style="text-align: center" colspan="8">还没有数据，请添加一条</td></tr>');--%>
    <%--                }--%>
    <%--                $("#tab").append(str);--%>
    <%--            }, error: function () {--%>
    <%--                alert("服务器错误");--%>
    <%--            }--%>
    <%--        })--%>
    <%--    }--%>

    <%--</script>--%>

<%--</body>--%>
<%--<script>--%>
<%--    function login() {--%>

<%--    }--%>
<%--</script>--%>




<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>static/css/xadmin.css">
    <script type="text/javascript" src="<%=basePath%>static/js/jquery.js"></script>
    <script src="<%=basePath%>static/lib/layui/layui.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/xadmin.js "></script>
</head>
<body class="login-bg">
<div class="login">
    <div class="message">XX系统登录</div>
    <div id="darkbannerwrap"></div>
    <form action="login" method="post">
        <input name="userAccount" placeholder="账 号" type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="userPassword" placeholder="密 码" type="password" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input type="hidden" name="method" value="login">
        <input value="提交" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>
</body>
</html>
