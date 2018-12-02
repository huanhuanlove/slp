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


    <section style="background-image:url(images/banner-service.jpg)" class="banner text-center full_bg">
        <div class="banner-mask">
            <div class="container">
                <h2>打造完美空间</h2>
                <p>更贴心的设计，更放心的质量，更省心的服务</p>
            </div>
        </div>
    </section>

    <main class="main">
        <div id="fuwu1" class="container">
            <!--menu-->
            <div class="ny-menu text-center">
                <ul class="list-inline">
                <c:forEach items="${requestScope.serverdata }" var="server" varStatus="status">
                    <li><a class="btn-title"  href="#fuwu${status.index+1 }">${server.serviceName }</a></li>
                 </c:forEach>
                </ul>
                 
            </div>
            <!--content start-->
            <section class="content">
                <div class="row hbfw">
                    <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
                      <div class="text-center">
	                        <div id="fuwu" class="row">
	                            <div class="col-xs-12 col-sm-5 col-md-5 col-lg-5 col-lg-push-7">
	                                <img alt="" title="" src="${pageContext.request.contextPath}/upload/${requestScope.al[0].serviceImg }">
	                            </div>
	                            <div class="col-xs-12 col-sm-7 col-md-7 col-lg-7 col-lg-pull-5">
	                                <h2>${requestScope.al[0].serviceTitle }</h2>
	                                ${requestScope.al[0].serviceContent }
	                                <p>
	                                    <a  class="btn-center l-m-none" href="#">了解更多</a>
	                                </p>
	                            </div>
	                        </div>
                        </div>
                        <div class="text-center">
                            <div id="fuwu2">
                                <h2 class="b-m-60">${requestScope.al[1].serviceTitle }</h2>
                                <p class="b-m-40">
                                    <img alt="十年专注，勇于创新.jpg" title="十年专注，勇于创新.jpg" src="${pageContext.request.contextPath}/upload/${requestScope.al[1].serviceImg }">
                                </p>
           						  ${requestScope.al[1].serviceContent }
                                <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p>
                            </div>
                        </div>
                        <div class="text-center">
                            <div id="fuwu3">
                                <h2 class="b-m-60">${requestScope.al[2].serviceTitle }</h2>
                                <p>
                                    <img alt="一站式配套服务，全面省心.jpg" title="一站式配套服务，全面省心.jpg" src="${pageContext.request.contextPath}/upload/${requestScope.al[2].serviceImg }" />
                                </p>
                                <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p>
                            </div>
                            <div id="fuwu4">
                                <h2 class="b-m-60">${requestScope.al[3].serviceTitle }</h2>
                                <p class="b-m-40">
                                    <img alt="系统化工程管控，保质保量保时间.jpg" title="系统化工程管控，保质保量保时间.jpg" src="${pageContext.request.contextPath}/upload/${requestScope.al[3].serviceImg }">
                                </p>
                                <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p>
                            </div>
                            <div id="fuwu5">
                                <h2 class="b-m-60">${requestScope.al[4].serviceTitle }</h2>
                                <p class="b-m-40">
                                    <img alt="六步服务流程，响应快速.jpg" title="六步服务流程，响应快速.jpg" src="${pageContext.request.contextPath}/upload/${requestScope.al[4].serviceImg }">
                                </p>
                                <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p>
                            </div>
                            <div id="fuwu6">
                                <h2 class="b-m-60">${requestScope.al[5].serviceTitle }</h2>
                                <p class="b-m-40">
                                    <img alt="超过1000家品牌企业的选择.jpg" title="超过1000家品牌企业的选择.jpg" src="${pageContext.request.contextPath}/upload/${requestScope.al[5].serviceImg }">
                                </p>
                                <p>
                                    <a class="btn-center" href="#">了解更多</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="list_page"></div>
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
    <script type="text/javascript">
    	$(function(){
    		location.href = "#fuwu${requestScope.index}";//跳转到页面中描点所在位置    
    	})
    </script>
</body>
</html>