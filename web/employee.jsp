<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <link rel="stylesheet" href="static/css/bootstrap-theme.css">
<%--    <link rel="stylesheet" href=static/css/bootstrap-theme.css>--%>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <script type="text/javascript" src="static/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
</head>
<body>
<br>
<div id="queryDiv">
    <label>查询用户:
        <input type="text" id="queryUserByUserName">
    </label>
    <button type="button" class="btn btn-primary btn-sm" onclick="queryUserByUserName()">查询</button>
    <br>
    <button type="button" class="btn btn-primary btn-sm" onclick="openAddWindow()">增加员工</button>
</div>

<table class="table table-hover" id="showTable">
    <tr>
        <th style="width: 170px">id</th>
        <th style="width: 170px">姓名</th>
        <th style="width: 170px">账号</th>
        <th style="width: 170px">密码</th>
        <th style="width: 170px">缴费状况</th>
        <th hidden>状态</th>
        <th colspan="2" style="width: 200px;text-align: center">操作</th>
    </tr>
    <%--用于展示员工信息--%>
    <tbody id="tab"></tbody>
</table>

<%--员工修改form表单--%>
<div style="text-align: center;">
<form action="<%=basePath%>user/updateUserById" method="post" hidden id="updateForm">
    <label hidden>
        id:
        <input type="text" name="id" id="id">
    </label>

    <label>
        姓名:
        <input type="text" name="userName" id="userName">
    </label>
    <br><br>
    <label>
        账号:
        <input type="text" name="userAccount" readonly style="color: red" id="userAccount">
    </label>
    <br><br>
    <label>
        密码:
        <input type="text" name="userPassword" id="userPassword">
    </label>
<%--    <br><br>--%>
<%--    <label>--%>
<%--        职位:--%>
<%--        <input type="text" name="position" id="position">--%>
<%--    </label>--%>
<%--    <br><br>--%>
    <label>
        缴费情况:
        <input type="text" name="state" id="state">
    </label>
    <br><br>
    <input type="hidden" name="method" value="updateUserById">
    <input type="submit" value="提 交">
</form>
</div>

<%--增加员工--%>
<div style="text-align: center;">
    <form action="<%=basePath%>user/addUser" method="post" hidden id="addForm">
        <label>
            姓名:
            <input type="text" name="userName" id="addUserName">
        </label>
        <br><br>
        <label>
            账号:
            <input type="text" name="userAccount" id="addUserAccount">
        </label>
        <br><br>
        <label>
            密码:
            <input type="text" name="userPassword" id="addUserPassword">
        </label>
        <br><br>
        <label>
            缴费情况:
            <input type="text" name="state" id="addSalary">
        </label>
        <br><br>
        <input type="hidden" name="method" value="addUser">
        <input type="submit" value="提 交">
    </form>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        //发送ajax请求
        $.ajax({
            url: "user",
            dataType: "json",
            type: "post",
            data :{
                "method" : "queryAllUser"
            },
            success: function (data) {
                console.log(data)
                var str = "";
                $("#tab").html('');
                if (data.length > 0) {
                    for (var i = 0; i < data.length; i++) {
                        str += "<tr>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].username + "</td>" +
                            "<td>" + data[i].password + "</td>" +
                            "<td>" + data[i].state + "</td>" +
                            // "<td hidden>" + data[i].userState + "</td>" +
                            "<td><button type='button' class='btn btn-primary btn-sm' onclick='update(this)'>\n" +
                            " <span class='glyphicon glyphicon-ok'></span><i class='fa fa-check'></i>&nbsp; 修改</button>\n" +
                            "<button type='button' class='btn btn-danger btn-sm'  onclick='del(" + data[i].id + ")' >\n" +
                            " <span class='glyphicon glyphicon-remove'></span><i class='fa fa-check'></i>&nbsp; 删除</button></td>" +
                            "</tr>"
                    }
                } else {
                    $("#tab").append('<tr><td style="text-align: center" colspan="8">还没有数据，请添加一条</td></tr>');
                }
                $("#tab").append(str);
            }, error: function () {
                alert("服务器错误");
            }
        })
    })

    //删除员工
    function del(id) {
        $.ajax({
            url: "<%=basePath%>user/delUserById",
            dataType: "text",
            type: "post",
            data: {
                "id": id,
                "method" : "delUserById"
            },
            success: function (data) {
                console.log(data);
                if (data === "success") {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert("删除失败");
                    window.location.reload();
                }
            }, error: function () {
                alert("服务器错误");
                window.location.reload();
            }
        })
    }

    //查询员工
    function queryUserByUserName() {
        var userName = $("#queryUserByUserName").val();
        $.ajax({
            url: "<%=basePath%>user/queryUserByUserName",
            dataType: "json",
            type: "post",
            data: {
                "userName": userName,
                "method" : "queryUserByUserName"
            },
            success: function (data) {
                var str = "";
                $("#tab").html('');
                if (data.length > 0) {
                    for (var i = 0; i < data.length; i++) {
                        str += "<tr>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].username + "</td>" +
                            "<td>" + data[i].password + "</td>" +
                            "<td>" + data[i].state + "</td>" +
                            "<td><button type='button' class='btn btn-primary btn-sm' onclick='update(this)'>\n" +
                            " <span class='glyphicon glyphicon-ok'></span><i class='fa fa-check'></i>&nbsp; 修改</button>\n" +
                            "<button type='button' class='btn btn-danger btn-sm'  onclick='del(" + data[i].id + ")' >\n" +
                            " <span class='glyphicon glyphicon-remove'></span><i class='fa fa-check'></i>&nbsp; 删除</button></td>" +
                            "</tr>"
                    }
                } else {
                    $("#tab").append('<tr><td style="text-align: center" colspan="8">还没有数据，请添加一条</td></tr>');
                }
                $("#tab").append(str);
            }, error: function () {
                alert("服务器错误");
            }
        })
    }

    //修改员工信息
    function update(obj) {
        //隐藏查询框和按钮
        $("#queryDiv").hide();
        //隐藏员工展示列表
        $("#showTable").hide();
        //获取当前对象值
        var id = $(obj).parent().parent().find("td").eq(0).text();
        var userName = $(obj).parent().parent().find("td").eq(1).text();
        var userAccount = $(obj).parent().parent().find("td").eq(2).text();
        var userPassword = $(obj).parent().parent().find("td").eq(3).text();
        var position = $(obj).parent().parent().find("td").eq(4).text();
        var salary = $(obj).parent().parent().find("td").eq(5).text();

        //填充值
        $("#id").val(id);
        $("#userName").val(userName);
        $("#userAccount").val(userAccount);
        $("#userPassword").val(userPassword);
        $("#position").val(position);
        $("#salary").val(salary);

        //显示修改员工信息框
        $("#updateForm").show();

    }

    //增加员工窗口
    function openAddWindow() {
        //隐藏查询框和按钮
        $("#queryDiv").hide();
        //隐藏员工展示列表
        $("#showTable").hide();
        //显示添加员工框
        $("#addForm").show();
    }
</script>
</body>
</html>