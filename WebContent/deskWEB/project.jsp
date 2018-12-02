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
    <title>案例_赛利浦</title>
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

    <section style="background-image:url(images/banner-case.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>案例产品</h2>
                <p>我们提供网站模板，网页模板等建站素材下载</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div class="container">
            <!--menu-->
            <div class="ny-menu text-center">
                <ul class="list-inline">
                
                
           <c:forEach items="${requestScope.proCategorydata }" var="proCategory" varStatus="status">
                   <c:choose >
                   		<c:when test="${proCategory.id==requestScope.cateid }">
                   				<li><a class="btn-title" href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${proCategory.id }&current=1" style="background-color:#df3741;border:1px solid #df3741;color:#fff;text-decoration:none">${proCategory.cateName }</a></li>
                   		</c:when>
                   		<c:otherwise>
                   				 <li><a class="btn-title" href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${proCategory.id }&current=1">${proCategory.cateName }</a></li>
                   		</c:otherwise>
                   </c:choose>
                 
           </c:forEach>


                </ul>
            </div>
            <!--content start-->
            <section class="content">
                <div class="row case-box">
                
                 <c:forEach items="${requestScope.promap['prodata'] }"  var="pro">
                    <div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
                        <figure>
                            <a href="project_details.htm" ><img src="${pageContext.request.contextPath}/upload/${pro.projectImg }" alt="赛利浦-建站资源共享学习平台" width="360" height="258" /></a>
                            <figcaption class="pic-hover">
                                <h3><a href="${pageContext.request.contextPath}/desk/QueryproDetails?bid=${pro.id }&catename=${pro.cateName }"  >${pro.projectName }</a></h3>
                                <ul class="list-inline">
                                    <li>Category /&nbsp;</li>
                                    <li><a href="project.htm" >${pro.cateName }</a></li>
                                </ul>
                                <span class="visible-lg-block visible-md-block"></span>
                            </figcaption>
                        </figure>
                    </div>
                 </c:forEach>


                </div>
                <div class="list-page">
                    <div class="dede_pages">
                        <ul class="pagelist">
                            <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=1">首页</a></li> 
                             <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${(requestScope.current-1)>0?requestScope.current-1:1}">上一页</a></li>
                           <!-- 上一页 -->
                           <c:if test="${(requestScope.current-1)>0}">
                           		   <li ><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${current-1}">${current-1}</a></li>
                           </c:if>
                           
                           
                            <li class="thisclass"><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${current}">${current}</a></li>
                           <c:if test="${(requestScope.current+1)<=requestScope.promap['zy']}">
                            	<li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${current+1}">${current+1}</a></li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${(requestScope.current+1)>requestScope.promap['zy']?requestScope.promap['zy']:(requestScope.current+1)}">下一页</a></li>
                            <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${cateid}&current=${requestScope.promap['zy'] }">末页</a></li>
                            <li><span class="pageinfo">共 <strong>${requestScope.promap['zy'] }</strong>页<strong>${requestScope.promap['zt'] }</strong>条</span></li>

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