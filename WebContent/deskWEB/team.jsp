<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta http-equiv="content-language" content="zh-CN">
    <meta http-equiv="Cache-Control" content="no-transform" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>团队_赛利浦</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="by 赛利浦">
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="icon" href="/favicon.png" type="image/png" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="/favicon.ico" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/deskWEB/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/deskWEB/css/style.css">
    <script>var webroot = "/";</script>
</head>
<body>
    <!--head start-->
    <header class="navbar navbar-default navbar-fixed-top" role="navigation">
     	 <jsp:include page="/deskWEB/common_title.jsp"></jsp:include>
    </header>
    <!--end-->

    <section style="background-image:url(images/banner-team.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>团队人员</h2>
                <p>我们致力于打造一个优秀的建站资源共享学习平台</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <!--content start-->
            <section class="content">
                <div class="row team-box text-center">
                
                <c:forEach items="${requestScope.map['teamdata'] }"  var="team">
                    <div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">
                        <figure>
                            <a href="team_member.html" ><img src="${pageContext.request.contextPath}/upload/${team.photo }" alt="${team.name }" width="260" height="260" /><span class="new-pic"></span></a>
                            <figcaption class="pic-hover">
                                <h3><a href="team_member.html" >${team.name }</a></h3>
                                <span></span>
                                <p>${team.position }</p>
                            </figcaption>
                        </figure>
                    </div>
                    </c:forEach>
         
                </div>
                <div class="list-page">
                    <div class="dede_pages">
                        <ul class="pagelist">
                            <li><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=1">首页</a></li> 
                             <li><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${(requestScope.current-1)>0?requestScope.current-1:1}">上一页</a></li>
                           <!-- 上一页 -->
                           <c:if test="${(requestScope.current-1)>0}">
                           		   <li ><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${current-1}">${current-1}</a></li>
                           </c:if>
                           
                           
                            <li class="thisclass"><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${current}">${current}</a></li>
                           <c:if test="${(requestScope.current+1)<=requestScope.map['zy']}">
                            	<li><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${current+1}">${current+1}</a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${(requestScope.current+1)>requestScope.map['zy']?requestScope.map['zy']:(requestScope.current+1)}">下一页</a></li>
                            <li><a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=${requestScope.map['zy'] }">末页</a></li>
                            <li><span class="pageinfo">共 <strong>${requestScope.map['zy'] }</strong>页<strong>${requestScope.map['zt'] }</strong>条</span></li>
                        </ul>
                    </div><!-- /pages -->
                </div>
            </section>
        </div>
    </main>
     <jsp:include page="/deskWEB/common_about.jsp"></jsp:include>
    <!--end-->
    <!--kefu start-->

    <!-- /.modal -->
    <!--jQuery-->
    <script src="${pageContext.request.contextPath }/deskWEB/scripts/jquery.min.js" ></script>
    <script>$(function () { $("#h").addClass("hover"); })</script>
    <script src="${pageContext.request.contextPath }/deskWEB/scripts/bootstrap.min.js" ></script>
    <script>$(function () { $("[data-toggle='tooltip']").tooltip(); })</script>
    <script src="${pageContext.request.contextPath }/deskWEB/scripts/owl.carousel.min.js" ></script>
    <script src="${pageContext.request.contextPath }/deskWEB/scripts/owl.carousel.quote.js"></script>
</body>
</html>