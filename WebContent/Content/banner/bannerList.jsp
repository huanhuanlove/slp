<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
                <li class="active">Banner信息查询</li>
            </ul>
            <!-- END 面包屑 -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">查询条件</h3>
                            <ul class="panel-controls">
                                <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-xs-12">
                                    	Banner名称<br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                        <input type="text" class="form-control" id="ex_search" value="${requestScope.search }"/>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="panel-footer">
                            <button class="btn  btn-success" type="button" id="btn_search" onclick="search()">查    询</button>
                            <button class="btn  btn-default" type="button" onclick="Create()" id="btn_create">添    加</button>
                        </div>
                    </div>
                </div>
            </div>


            <!-- 页面Body -->
            <div class="row">
                <div class="col-md-12">

                    <!-- START SIMPLE DATATABLE -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Banner列表</h3>
                            <ul class="panel-controls">
                                <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span></a></li>
                                <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                <li><a href="#" class="panel-remove"><span class="fa fa-times"></span></a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <table class="table datatable_simple">
                                <thead>
                                    <tr>
                                    	<th>序号</th>
                                        <th>编号</th>
                                        <th>名称</th>
                                        <th>链接地址</th>
                                        <th>图片</th>
                                        <th>操作</th>

                                    </tr>
                                </thead>
                                <tbody>

                 				<c:forEach items="${requestScope.bannerList }" var="bannerList" varStatus="state">
	                                    <tr>
	                                    	<td>${state.count }</td>
	                                        <td>${bannerList.id }</td>
	                                        <td>${bannerList.name }</td>
	                                        <td><a href="#">${bannerList.url }</a></td>
	                                       <td><img alt="" src="${pageContext.request.contextPath}/bannerImg/${bannerList.bannerImg }" width="240" height="70"></td>
	                                        <th>
	                                       	 	<a class="btn btn-primary" onclick="update(${bannerList.id})">修改</a>
	                                            <a class="btn btn-primary" onclick="Delete(${bannerList.id})">删除</a>
	                                        </th>
	                                    </tr>

                                   </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        	<div style="margin-left: 50px">
			                      	  每页${requestScope.bannerMap.pageSize }条数据&nbsp;&nbsp;共${requestScope.bannerMap.totalPage }页 ${requestScope.bannerMap.totalData }条数据
			                        <div class="pagination-container">
			                        	<ul class="pagination">
			                        		<!-- 上一页图标 -->
			                        		<li class="PagedList-skipToNext">
			                        			<a href="${pageContext.request.contextPath}/banner/bannerList?EX_search=${requestScope.search }&currentPage=${(requestScope.bannerMap.currentPage-1)>0?requestScope.bannerMap.currentPage-1:1}" rel="up">&lt;&lt;</a>
			                        		</li>
			                        		<!-- 上一页数字 -->
			                        		<c:if test="${(requestScope.bannerMap.currentPage-1)>0}">
			                        			 <li>
			                        		     <a href="${pageContext.request.contextPath}/banner/bannerList?EX_search=${requestScope.search }&currentPage=${requestScope.bannerMap.currentPage-1}">${requestScope.bannerMap.currentPage-1}</a>
			                        		     </li>
			                        		</c:if>
											<!-- 本页数字 -->
			                        		<c:set var="curr" value="${requestScope.bannerMap.currentPage<=requestScope.bannerMap.totalPage?requestScope.bannerMap.currentPage:requestScope.bannerMap.totalPage }"></c:set>
			                        		<li class="active"><a href="${pageContext.request.contextPath}/banner/bannerList?EX_search=${requestScope.search }&currentPage=${curr}">${curr}</a></li>
											<!-- 下一页数字 -->
			                        		<c:if test="${(requestScope.bannerMap.currentPage+1)<=requestScope.bannerMap.totalPage }">
			                        		     <li>
			                        		     <a href="${pageContext.request.contextPath}/banner/bannerList?EX_search=${requestScope.search }&currentPage=${requestScope.bannerMap.currentPage+1}">${requestScope.bannerMap.currentPage+1}</a>
			                        		     </li>
			                        		</c:if>
											<!-- 下一页图标-->
			                        		<li class="PagedList-skipToNext">
			                        			<a href="${pageContext.request.contextPath}/banner/bannerList?EX_search=${requestScope.search }&currentPage=${(requestScope.bannerMap.currentPage+1)>requestScope.bannerMap.totalPage?requestScope.bannerMap.totalPage:(requestScope.bannerMap.currentPage+1)}" rel="next">>></a>
			                        		</li>
			                        		</ul>
			                        </div>
                        </div>
                    </div>
                    <!-- END SIMPLE DATATABLE -->

                </div>
            </div>
            <!-- END 页面Body -->
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


    <div class="modal fade" id="deleteForm">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p>您确认要删除该条信息吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        取消
                    </button>
                    <button type="button" class="btn btn-primary"
                            id="deleteComfirm">
                        确认
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
    </div>


	<jsp:include page="/Content/common_foot.jsp"></jsp:include>
    <script>
        function Create() {
            //设置页面地址  编辑功能地址带id参数
            window.location.href = "${pageContext.request.contextPath}/Content/banner/bannerForm.jsp";
            return false;
        }
        //删除商品
        function Delete(id) {
            $("#deleteForm").modal({
                backdrop: 'static',
                keyboard: false
            });

            $("#deleteComfirm").unbind("click").click(function () {
                //重新加载页面数据
                $("#deleteForm").modal('hide');
                window.location.href = "${pageContext.request.contextPath}/banner/bannerDel?bid="+id;
            })

        }

        //修改商品
        function update(id) {
            //设置页面地址  编辑功能地址带id参数
            window.location.href = "${pageContext.request.contextPath}/banner/bannerUpd?flag=selByID&bid="+ id;
            return false;
        }
        //查询
        function search() {
            //设置页面地址  编辑功能地址带id参数
            var search = $("#ex_search").val();
            window.location.href = "${pageContext.request.contextPath}/banner/bannerList?EX_search="+search+"&currentPage=1"

            return false;
        }
    </script>
    <!-- END 插件-->
    <!-- 模板 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/settings.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/plugins.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Content/js/actions.js"></script>

    <!-- END 模板 -->
    <!-- END 脚本 -->
</body>
</html>



