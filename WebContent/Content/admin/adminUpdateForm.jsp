<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- META SECTION -->
    <title>Atlant - Responsive Bootstrap Admin Template</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <!-- END META SECTION -->
    <!-- CSS INCLUDE -->
    <link rel="stylesheet" type="text/css" id="theme" href="${pageContext.request.contextPath}/Content/css/theme-default.css" />
    <!-- EOF CSS INCLUDE -->
</head>
<body>
    <!-- 页面容器 -->
    <div class="page-container">

        <!-- 页面导航 -->
      	<jsp:include page="/Content/common.jsp"></jsp:include>
        <!-- END 页面导航 -->
        <!-- 页面内容 -->
        <div class="page-content">

            <!-- START X-NAVIGATION VERTICAL -->
            <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                <!-- TOGGLE NAVIGATION -->
                <li class="xn-icon-button">
                    <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                </li>
                <!-- END TOGGLE NAVIGATION -->
                <!-- 查询框 -->
                <!--<li class="xn-search">
                    <form role="form">
                        <input type="text" name="search" placeholder="Search..."/>
                    </form>
                </li>-->
                <!-- END 查询框 -->
                <!-- 登出 -->

                   <li class="xn-icon-button pull-right">
                    <a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span></a>
 </li>
                <!-- END 登出 -->


            </ul>
            <!-- END X-NAVIGATION VERTICAL -->
            <!-- 面包屑 -->
            <ul class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/Content/index.jsp">首页</a></li>
                <li class="active">管理员密码修改</li>
            </ul>
            <!-- END 面包屑 -->
            <!-- 页面内容 -->
            <div class="page-content-wrap">
                <!-- 插件 -->
                <div class="row">
                    <div class="col-md-12">

                        <form class="form-horizontal" id="myfrom" action="${pageContext.request.contextPath}/admin/adminChangeMiMa" onsubmit="return checkdata()">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>修改管理员信息</strong> </h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                <div class="panel-body">
                                </div>
                                <div class="panel-body form-group-separated">

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">管理员名称</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" readonly="readonly" id="adminName" name="adminName" value="${sessionScope.user.adminName }"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="adminName_lable">管理员名称不能为空，并且长度不能小于6位！</span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">原密码</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-unlock-alt"></span></span>
                                                <input type="password" class="form-control" id="ypwd" name="ypwd" />
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="ypwd_lable">原密码输入错误</span>
                                        </div>
                                    </div>
                                    <input type="hidden" name="bid" value="${sessionScope.uname.id }">
									  <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">新密码</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-unlock-alt"></span></span>
                                                <input type="password" class="form-control" id="pwd" name="adminPwd"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="pwd_lable">登陆密码不能为空，并且长度不能小于3位！</span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">确认密码</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-unlock-alt"></span></span>
                                                <input type="password" class="form-control" id="pwd2" />
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="pwd2_lable">两次密码不一致,请重新输入！</span>
                                        </div>
                                    </div>

                                </div>
                                <div class="panel-footer">
                                     <button class="btn btn-primary pull-right" >提交</button>
                                     <a class="btn btn-default" href="javascript:clearFrom()">清空</a>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <!-- END 插件-->
        </div>
        <!-- END 页面内容-->
    </div>
    <!-- END 页面容器 -->
    <!-- MESSAGE BOX-->
    <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
        <div class="mb-container">
            <div class="mb-middle">
                <div class="mb-title"><span class="fa fa-sign-out"></span> 登 <strong>出</strong> ?</div>
                <div class="mb-content">
                    <p>你确定要登出系统吗?</p>
                    <p>点击取消按钮继续工作. 点击确定登出当前用户.</p>
                </div>
                <div class="mb-footer">
                    <div class="pull-right">
                        <a href="${pageContext.request.contextPath}/logOut" class="btn btn-success btn-lg">确定</a>
                        <button class="btn btn-default btn-lg mb-control-close">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END MESSAGE BOX-->
	<jsp:include page="/Content/common_form_foot.jsp"></jsp:include>

    <script>
        $(document).ready(function () {
            $('#summernote').summernote({
                height: 400
            });

            $("#submit").click(function (e) {
                var markupStr = $('#summernote');
                $("#preview").html(markupStr.code(undefined));
                e.preventDefault();
            })
        });
        //校验添加的数据
        function checkdata(){
       		var name = $("#ypwd").val();
       		if(name!="${sessionScope.user.password}"){
       			$("#ypwd_lable").show();
       			return false;
       		}
       		var pwd = $("#pwd").val();
       		if(pwd.length<3||pwd==""){
       			$("#pwd_lable").show();
       			return false;
       		}
       		var pwd2 = $("#pwd2").val();
       		if(pwd!=pwd2){
       			$("#pwd2_lable").show();
       			return false;
       		}

        }
        //清空表单
        function clearFrom(){
        	$("#adminName").val("");
        	$("#pwd").val("");
        	$("#pwd2").val("");
        	$("#adminName_lable").hide();
        	$("#pwd_lable").hide();
        	$("#pwd2_lable").hide();
        }

    </script>
</body>
</html>



