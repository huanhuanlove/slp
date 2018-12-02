<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <div class="container">
            <!--mobile nav start-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!--logo start-->
                <h1 class="logo"><a class="navbar-brand" href="index.htm">赛利浦</a><small class="pull-left visible-lg-block visible-xs-block">建站资源共享学习平台</small></h1>
            </div><!--end-->
            <!--nav start-->
            <nav class="collapse navbar-right navbar-collapse" role="navigation">
                <ul class="nav navbar-nav pull-left" id="nav">
                    <li><a href="${pageContext.request.contextPath }/desk/QueryIndexData">首页</a></li>
                    <li>
                        <a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=1">服务</a>
                        <ul class="list-unstyled">
                       
                        <c:forEach items="${requestScope.serverdata }" var="server" varStatus="status">
                            <li><a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=${status.index+1}">${server.serviceName }</a></li>
                        </c:forEach>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=1&current=1">案例</a>
                        <ul class="list-unstyled">
                         <c:forEach items="${requestScope.proCategorydata }" var="proCategory" varStatus="status">
                            <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=${proCategory.id }&current=1">${proCategory.cateName }</a></li>
                          </c:forEach>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/desk/QueryTeamData?current=1">团队</a>
                        <ul class="list-unstyled"></ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/desk/QueryNewData?cateid=1&current=1">资讯</a>
                        <ul class="list-unstyled">
                         <c:forEach items="${requestScope.newsCategorydata }" var="newsCategory" varStatus="status">
                            <li><a href="${pageContext.request.contextPath }/desk/QueryNewData?cateid=${newsCategory.id }&current=1">${newsCategory.cateName }</a></li>

                          </c:forEach>
                        </ul>
                    </li>
                    <li><a href="${pageContext.request.contextPath }/deskWEB/intro.jsp">简介</a></li>
                    <li><a href="${pageContext.request.contextPath }/deskWEB/contact.jsp">联系</a></li>
                </ul>
                <ul class=" list-unstyled nav-kj pull-right visible-md-block visible-lg-block">
                    <li>
                        <a href="javascript:void(0)" class="fuwu">赛利浦客服</a>
           					${requestScope.infodata[5].content }	
                    </li>
                </ul>
            </nav>
        </div>
        <!--end-->