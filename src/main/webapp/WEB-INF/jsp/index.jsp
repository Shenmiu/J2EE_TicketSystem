<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Shenmiu
  Date: 05/03/2018
  Time: 12:46

  Description:  售票网站主页
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>小麦网</title>

    <!-- Normalize -->
    <link href="${pageContext.request.contextPath}/css/normalize.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 模态框的css -->
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet">
    <!-- footer的css -->
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet">

    <style>
        .panel {
            margin-top: 5%;
        }
    </style>

</head>
<body>

<!-- nav begin -->
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <!-- 导航栏头 -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">小麦网</a>
        </div>

        <!-- 导航内容 -->
        <ul class="nav navbar-nav">
            <li id="login-li"><a href="#" data-toggle="modal" data-target="#loginModal">登录</a></li>
            <li id="register-li"><a href="#" data-toggle="modal" data-target="#registerModal">注册</a></li>
        </ul>

        <ul class="nav navbar-nav pull-right">
            <li id="venue-login"><a href="#venueModal" data-toggle="modal">场馆登录</a></li>
            <li id="manager-login"><a href="#managerModal" data-toggle="modal">经理登录</a></li>
        </ul>
    </div>
</nav>
<!-- nav end -->

<div id="plans-container" class="container" style="height: 100%; overflow: scroll">
    <div class="row">
        <h2 class="text-center">近期演出</h2>
    </div>
    <c:forEach items="${comingShows}" var="show">
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div class="panel panel-default">
                    <div class='panel-heading'>
                        <h3 class='panel-title'><c:out value="${show.description}"/></h3>
                    </div>
                    <div class="panel-body">
                        <input type="text" value="<c:out value="${show.venuePlanId}"/>" hidden>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-md-3 control-label">演出地点：</label>
                                <div class="col-md-3">
                                    <p class="form-control-static">
                                        <c:out value="${show.city} ${show.venueName}"/>
                                    </p>
                                </div>
                                <label class="col-md-offset-1 col-md-2 control-label">演出类型：</label>
                                <div class="col-md-3">
                                    <p class="form-control-static">
                                        <c:out value="${show.showType}"/>
                                    </p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">开始时间：</label>
                                <div class="col-md-3">
                                    <p class="form-control-static">
                                        <c:out value="${show.begin}"/>
                                    </p>
                                </div>
                                <label class="col-md-offset-1 col-md-2 control-label">结束时间：</label>
                                <div class="col-md-3">
                                    <p class="form-control-static">
                                        <c:out value="${show.end}"/>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<footer></footer>

<!-- 模态框 -->
<!-- login 模态框 -->
<div class="modal fade" id="loginModal" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- data-dismiss：关闭模态窗口 -->
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-center">会员登录</h4>
            </div>
            <div class="modal-body">
                <form id="login_form">
                    <div class="input-group">
                        <span class="input-group-addon">邮箱</span>
                        <input id="member-mail" type="text" class="form-control" placeholder="请输入邮箱">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">密码</span>
                        <input id="member-password" type="password" class="form-control" placeholder="请输入密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="login_btn" class="btn btn-primary login_btn center-block">登录</button>
            </div>
        </div>
    </div>
</div>
<!-- login 模态框end -->

<!-- register 模态框 -->
<div class="modal fade" id="registerModal" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- data-dismiss：关闭模态窗口 -->
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-center">会员注册</h4>
            </div>
            <div class="modal-body">
                <form id="reg_form">
                    <div class="input-group">
                        <span class="input-group-addon">邮箱</span>
                        <input id="member-register-mail" type="email" class="form-control" placeholder="请输入验证邮箱">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">密码</span>
                        <input id="member-register-password" type="password" class="form-control" placeholder="请输入密码">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">确认密码</span>
                        <input type="password" class="form-control" placeholder="请确认密码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="reg_btn" class="btn btn-primary reg_btn center-block">注册</button>
            </div>
        </div>
    </div>
</div>
<!-- register模态框 end -->

<!-- venue login 模态框 -->
<div class="modal fade" id="venueModal" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- data-dismiss：关闭模态窗口 -->
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-center">场馆登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="venue-login-form">
                    <div class="form-group">
                        <label class="col-md-offset-1 col-md-3 control-label">编号</label>
                        <div class="col-md-7">
                            <input type="text" id="venue-id" class="form-control" placeholder="请输入编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-offset-1 col-md-3 control-label">密码</label>
                        <div class="col-md-7">
                            <input type="password" id="venue-password" class="form-control" placeholder="请输入密码">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="btn-group">
                    <button type="button" id="venue-login-btn" class="btn btn-default">登录</button>
                    <button type="button" id="venue-register-btn" class="btn btn-primary">注册</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- venue login 模态框 end -->

<!-- manager login 模态框 -->
<div class="modal fade" id="managerModal" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- data-dismiss：关闭模态窗口 -->
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-center">经理</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="manager-login-form"
                      action="${pageContext.request.contextPath}/manager/login" method="post">
                    <div class="form-group">
                        <label class="col-md-offset-1 col-md-3 control-label">账号</label>
                        <div class="col-md-7">
                            <input id="manager-id" type="text" class="form-control"
                                   placeholder="请输入账号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-offset-1 col-md-3 control-label">密码</label>
                        <div class="col-md-7"><input id="manager-password" type="password" class="form-control"
                                                     placeholder="请输入密码">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="manager-login-btn" class="btn btn-default">登录</button>
            </div>
        </div>
    </div>
</div>
<!-- manager login 模态框 end -->

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>

    //会员登录
    $("#login_btn").on("click", function () {
        let member = {
            mail: $("#member-mail").val(),
            password: $("#member-password").val()
        };

        console.log(JSON.stringify(member));
        $.ajax({
            url: "${pageContext.request.contextPath}/member/login",
            method: "post",
            data: JSON.stringify(member),
            contentType: 'application/json;charset=UTF-8',
            processData: false,
            success: function (data) {
                if (data === true) {
                    //模态框隐藏
                    $("#loginModal").modal("hide");
                    alert("登陆成功");
                    //跳转到近期演出界面
                    $(location).attr("href", "${pageContext.request.contextPath}/member/scanShow")
                }
                else {
                    alert("登陆失败，密码错误或未激活会员资格");
                }
            },
            error: function () {
                alert("登陆失败，会员不存在");
            }
        });
    });

    //会员注册
    $("#reg_btn").on("click", function () {
        let member = {
            mail: $("#member-register-mail").val(),
            password: $("#member-register-password").val()
        };

        console.log(JSON.stringify(member));
        $.ajax({
            url: "${pageContext.request.contextPath}/member/register",
            method: "post",
            data: JSON.stringify(member),
            contentType: 'application/json;charset=UTF-8',
            processData: false,
            success: function (data) {
                if (data === true) {
                    //模态框隐藏
                    $("#registerModal").modal("hide");
                    alert("注册成功，请前往邮箱验证");
                }
                else {
                    alert("注册失败，邮箱已被人注册");
                }
            },
            error: function () {
                alert("注册失败");
            }
        });
    });

    //场馆登录
    $("#venue-login-btn").on("click", function () {
        let venue = {
            id: $("#venue-id").val(),
            password: $("#venue-password").val()
        };

        console.log(JSON.stringify(venue));
        $.ajax({
            url: "${pageContext.request.contextPath}/venue/login",
            method: "post",
            data: JSON.stringify(venue),
            contentType: 'application/json;charset=UTF-8',
            processData: false,
            success: function (data) {
                if (data === true) {
                    //模态框隐藏
                    $("#venueModal").modal("hide");
                    alert("场馆登陆成功");
                    //跳转到场馆信息视图
                    $(location).attr("href", "${pageContext.request.contextPath}/venue/infoView");
                }
                else {
                    alert("场馆登陆失败，场馆未注册、密码错误或场馆正在审批中");
                }
            },
            error: function () {
                alert("场馆登陆失败");
            }
        });
    });

    //场馆注册
    $("#venue-register-btn").on("click", function () {
        $(location).attr("href", "${pageContext.request.contextPath}/venue/registerView");
    });

    //经理登录
    $("#manager-login-btn").on("click", function () {
        let manager = {
            id: $("#manager-id").val(),
            password: $("#manager-password").val()
        };

        console.log(JSON.stringify(manager));
        $.ajax({
            url: "${pageContext.request.contextPath}/manager/login",
            method: "post",
            data: JSON.stringify(manager),
            contentType: 'application/json;charset=UTF-8',
            processData: false,
            success: function (data) {
                if (data === true) {
                    //模态框隐藏
                    $("#managerModal").modal("hide");
                    alert("经理登陆成功");
                    //跳转到经理审批视图
                    $(location).attr("href", "${pageContext.request.contextPath}/manager/audit");
                }
                else {
                    alert("经理登陆失败，密码错误");
                }
            },
            error: function () {
                alert("经理登陆失败");
            }
        });
    });
</script>
</body>
</html>