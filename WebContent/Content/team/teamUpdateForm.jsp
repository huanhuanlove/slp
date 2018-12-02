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
                <li class="active">成员信息编辑</li>
            </ul>
            <!-- END 面包屑 -->
            <!-- 页面内容 -->
            <div class="page-content-wrap">
                <!-- 插件 -->
                <div class="row">
                    <div class="col-md-12">
						<!-- onsubmit="return checkdata()" -->
                        <form class="form-horizontal" id="myfrom" onsubmit="return checkdata()" method="post" action="${pageContext.request.contextPath}/team/teamUpd_inn"  enctype="multipart/form-data">
                                <input type="hidden" name="bid" value="${requestScope.teamList.id }">
                            	<input type="hidden" name="yimg" value="${requestScope.teamList.photo }"/>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong>成员信息编辑</strong> </h3>
                                    <ul class="panel-controls">
                                        <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                                    </ul>
                                </div>
                                <div class="panel-body">
                                </div>
                                <div class="panel-body form-group-separated">

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">成员名称</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" id="tName" name="tName" value="${requestScope.teamList.name }"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="tName_lable">请输入成员名称！</span>
                                        </div>
                                    </div>

                                     <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">成员岗位</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                                <input type="text" class="form-control" id="tjob" name="tjob" value="${requestScope.teamList.position }"/>
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="tjob_lable">请输成员入岗位！</span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-2 col-xs-12 control-label">成员图片</label>
                                        <div class="col-md-8 col-xs-12">
                                            <div class="input-group">
                                               <a class="btn btn-primary" onclick="searchImage()">浏览图片</a>
                                               <input type="file" class="form-control" value="浏览图片"  none" id="searchImage" name="fileImage" style="display: none;"/>

                                           		  <br/><img src="${pageContext.request.contextPath}/bannerImg/${requestScope.teamList.photo }" id="img0" width="240" height="100" >
                                            </div>
                                            <span class="help-block" style="display: none;color: red" id="searchImage_lable">请选择图片</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer">
                                     <button class="btn btn-primary pull-right" id="submit" >提交</button>
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

            })

        });
      //添加图片
  	  function searchImage(){ $("#searchImage").click(); }
  	  $("#searchImage").change(function(){
  	    var objUrl = getObjectURL(this.files[0]) ;
  	    console.log("objUrl = "+objUrl) ;
  	    if (objUrl){
  	      $("#img0").attr("src", objUrl);
  	      $("#img0").show();
  	    }
  	  }) ;
  	  //建立一個可存取到該file的url
  	  function getObjectURL(file)
  	  {
  	    var url = null ;
  	    if (window.createObjectURL!=undefined)
  	    { // basic
  	      url = window.createObjectURL(file) ;
  	    }
  	    else if (window.URL!=undefined)
  	    {
  	      // mozilla(firefox)
  	      url = window.URL.createObjectURL(file) ;
  	    }
  	    else if (window.webkitURL!=undefined) {
  	      // webkit or chrome
  	      url = window.webkitURL.createObjectURL(file) ;
  	    }
  	    return url ;
  	  }
  	function clearFrom(){
  		$("#tName").val("");
  		$("#tjob").val("");
  		$("#img0").hide();
		$("#tName_lable").hide();
		$("#searchImage_lable").hide();
		$("#tjob_lable").hide();
  	}


  	function checkdata(){
		var name = $("#tName").val();
		if(name==""){
			$("#tName_lable").show();
			$("#searchImage_lable").hide();
			$("#tjob_lable").hide();
			return false;
		}
		var job = $("#tjob").val();
		if(job==""){
			$("#tName_lable").hide();
			$("#searchImage_lable").hide();
			$("#tjob_lable").show();
			return false;
		}


	}
    </script>

</body>
</html>



