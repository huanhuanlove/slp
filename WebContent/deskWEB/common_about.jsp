<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <!--Action start-->
    ﻿<section class="action text-center">
        <div class="container sx-jianju action-bg">
    			${requestScope.infodata[4].content }
            <p>
                <a href="#"  class="btn-center">访问官网</a><a href="#" class="btn-center">联系方式</a>
            </p>
        </div>
    </section>
    <!--end-->
    <!--footer start-->
    <footer class="text-center">
        <div class="container">
            <div class="row footer">
            <c:forEach items="${requestScope.infodata }" var="info" varStatus="staus">
     			<c:if test="${staus.index<3}">
                <figure class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                    <span class="footer-dh"></span>
                    <h3>${info.name }</h3>
                    ${info.content }
                </figure>
               </c:if>
           </c:forEach>
            </div>
          
            <ul class="footer-nav list-inline menu-kj">
                <li><a href="/desk/QueryIndexData">网站首页</a></li>
                <li><a href="${pageContext.request.contextPath }/deskWEB/intro.jsp">关于我们</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=1">服务中心</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=2">服务优势</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=5">服务流程</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryServiceData?index=6">服务客户</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryProjectData?cateid=2&current=1">成功案例</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryNewData?cateid=1&current=1">公司新闻</a></li>
                <li><a href="${pageContext.request.contextPath }/desk/QueryNewData?cateid=2&current=1">产品动态</a></li>
                <li><a href="${pageContext.request.contextPath }/deskWEB/contact.jsp">联系</a></li>
                <li><a data-toggle="collapse" href="javascript:void(0)" data-target="#links" aria-expanded="false" aria-controls="links">友情链接</a></li>
            </ul>
            <div class="collapse" id="links">
                <div class="well">
                    友情链接：<a href="#" target='_blank'>织码</a>
                </div>
            </div>
        </div>
        <div class="copy">
            <div class="container">
          		${requestScope.infodata[3].content }
            </div>
        </div>
    </footer>
    
     <ul class="kefu">
        <li><a href="#" class="kefu-top" data-toggle="tooltip" data-placement="left" id="top" title="回页面顶部" rel="nofollow">回顶部</a></li>
        <li class="visible-xs-block"><a href="tel://400-8888-616" class="kefu-dh"  data-toggle="tooltip" data-placement="left" title="拔打电话" rel="nofollow">拔打电话</a></li>
        <li><a href="#" class="kefu-gt"  data-toggle="tooltip" data-placement="left" title="在线沟通" rel="nofollow">在线沟通</a></li>
        <li class="hidden-xs" data-toggle="modal" data-target="#weixin"><a href="javascript:void(0)" class="kefu-wx" data-toggle="tooltip" data-placement="left" title="微信平台" rel="nofollow">官方微信平台</a></li>
        <li data-toggle="modal" data-target="#fenxiang"><a href="javascript:void(0)" class="kefu-fx" data-toggle="tooltip" data-placement="left" title="分享给好友" rel="nofollow">分享</a></li>
    </ul>
    <!--end-->
    <!-- weixin modal -->
    <div class="modal fade" id="weixin" tabindex="-1" role="dialog" aria-labelledby="weixin">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title m-none">赛利浦官方微信</h4>
                </div>
                <div class="modal-body p-40 text-center">
                    <img src="${pageContext.request.contextPath }/upload/${requestScope.infodata[6].infoImg }" alt="赛利浦"><p>使用微信扫一扫关注赛利浦</p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.modal -->
    <!-- fenxiang modal -->
    <div class="modal fade" id="fenxiang" tabindex="-1" role="dialog" aria-labelledby="fenxiang">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title m-none">分享给好友</h4>
                </div>
                <div class="modal-body p-40 text-center">
                    <div class="bdsharebuttonbox" data-tag="HBD_FX">
                        <a class="bds_sqq" data-cmd="sqq" href="#"></a>
                        <a class="bds_weixin" data-cmd="weixin" href="#"></a>
                        <a class="bds_qzone" data-cmd="qzone" href="#"></a>
                        <a class="bds_tsina" data-cmd="tsina"></a>
                        <a class="bds_baidu" data-cmd="baidu"></a>
                        <a class="bds_tqq" data-cmd="tqq"></a>
                        <a class="bds_mshare" data-cmd="mshare"></a>
                        <a class="bds_more" data-cmd="more">更多</a>
                        <a class="bds_copy" data-cmd="copy"></a>
                        <a class="bds_count" data-cmd="count"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>