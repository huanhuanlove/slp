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
    <title>赛利浦设计官网</title>
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
    <!--banner start-->
    <section class="banner">
        <div id="owl-banner" class="owl-carousel owl-theme">
        <c:forEach items="${requestScope.bannerdata }"  var="banner">
            <div class="item" style="background:url(${pageContext.request.contextPath}/upload/${banner.img })">
            	<a href="${banner.url }"  class="center-block">
            		<img src="${pageContext.request.contextPath}/upload/${banner.img }" class="center-block" alt="${banner.name }" />
            	</a>
            </div>
        </c:forEach>
        </div>
    </section>
    <!--end-->
    <!--Service start-->
    <section class="service container sx-jianju text-center">
        <h2 class="h-h2">赛利浦模板平台</h2>
        <p class="m-sm xx">我们致力于打造一个优秀的建站资源共享学习平台</p>
        <div class="row">
         <c:forEach items="${requestScope.infodata2 }" var="info" varStatus="staus">
         <c:if test="${staus.index>0 }">
            <figure class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                <span class="service-kj"></span>
                 <h3><a href="#" >  ${info.name }</a></h3>
                <ul class="list-unstyled">
          				  ${info.content }
                </ul>
            </figure>
            </c:if>
            </c:forEach>
        </div>
        <p class="m-none"><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=2&current=1" class="btn-center" >了解更多</a></p>
    </section>
    <!--end-->
    <!--Client start-->
    <section class="client client-bg sx-jianju full_bg text-center">
        <div class="container">
            <h2 class="h-h2">服务客户，上千家品牌企业首选</h2>
            <p class="m-sm">用行动捍卫客户信任，超过1000家品牌企业的选择</p>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
                    <div class="row">
                    
                 <c:forEach items="${requestScope.linksdata }"  var="links">
                        <figure class="col-xs-6 col-sm-3 col-md-3 col-lg-20">
                            <a href="${links.url }" >
                            	<img src="${pageContext.request.contextPath}/upload/${links.linkImg }" alt="${links.name }">
                            	<figcaption>${links.name }</figcaption>
                            </a>
                        </figure>
                  </c:forEach>
                    </div>
                    <p class="m-none"><a href="#" class="btn-center" >客户名录</a></p>
                </div>
            </div>
        </div>
    </section>
    <!--end-->
    <!--Case start-->
    <section class="case sx-jianju text-center">
        <div class="container">
            <h2 class="h-h2">成功案例，打造完美空间</h2>
            <p class="m-sm">以信誉赢尊重，以品质求发展</p>
            <div class="row case-box">
            <c:forEach items="${requestScope.prodata }"  var="pro">
                <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                    <figure>
                        <a href="project_details.htm" >
                        <img src="${pageContext.request.contextPath}/upload/${pro.projectImg }" alt="${pro.projectName }" width="360" height="258" /></a>
                        <figcaption class="pic-hover">
                            <h3><a href="${pageContext.request.contextPath}/desk/QueryproDetails?bid=${pro.id }&catename=${pro.cateName }" >${pro.projectName }</a></h3>
                            <ul class="list-inline">
                                <li>Category / </li>
                                <li> <a href="project.htm">${pro.cateName }</a></li>
                            </ul>
                            <span class="visible-lg-block visible-md-block"></span>
                        </figcaption>
                    </figure>
                </div>
                </c:forEach>

            </div>
            <p class="m-none"><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=2&current=1" class="btn-center" >更多案例</a></p>
        </div>
    </section>
    <!--end-->
    <!--team start-->
    <section class="team sx-jianju full_bg text-center">
        <div class="container">
            <h2 class="h-h2">赛利浦团队，贴心服务</h2>
            <p class="m-sm">主动服务，超越期待，不怕提要求，就怕没要求</p>
            <div id="owl-team" class="owl-carousel owl-theme">
                <figure class="item">
                    <a href="#" class="shake" ><img class="lazyOwl" src="${pageContext.request.contextPath}/upload/${requestScope.teamdata[0].photo }" alt="Eeala" width="200" height="200" /></a>
                    <figcaption>
                        <h3>
                            <a href="#" >${requestScope.teamdata[0].name }</a>
                        </h3>
                        <p>平面设计师</p>
                        <p class="m-none">
                            <a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=1" class="btn-center" >了解我们</a>
                            <a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=1" class="btn-center" >团队风采</a>
                        </p>
                    </figcaption>
                </figure>
            </div>
        </div>
    </section>
    <!--end-->
    <!--about start-->
     <section class="about sx-jianju container text-center">
        <h2 class="h-h2">赛利浦十年，感恩有您</h2>
        <p class="m-sm">我们致力于打造一个优秀的建站资源共享学习平台</p>
        <div class="row text-left">
            <figure class="col-xs-12 col-sm-12 col-md-5 col-lg-6 text-center">
                <img src="${pageContext.request.contextPath}/upload/${requestScope.infodata2[0].infoImg }" alt="${requestScope.infodata2[0].name }">
            </figure>
            <figure class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-md-offset-1 col-lg-offset-0">
               <h3>${requestScope.infodata2[0].name }</h3>
                ${requestScope.infodata2[0].content }
                <ul class="list-inline">
                    <li><a href="${pageContext.request.contextPath}/deskWEB/intro.jsp" class="btn-center" >阅读全文</a></li>
                    <li><a href="${pageContext.request.contextPath}/deskWEB/intro.jsp" class="btn-center" >资质荣誉</a></li>
                    <li><a href="${pageContext.request.contextPath}/deskWEB/intro.jsp" class="btn-center" >服务流程</a></li>
                    <li><a href="${pageContext.request.contextPath}/deskWEB/intro.jsp" class="btn-center" >服务优势</a></li>
                </ul>
            </figure>
        </div>
    </section>
    <!--end-->
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