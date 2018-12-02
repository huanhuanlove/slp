<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="page-sidebar">
            <ul class="x-navigation">
                <li class="xn-logo">
                    <a href="${pageContext.request.contextPath}/Content/index.jsp"></a>
                    <a href="#" class="x-navigation-control"></a>
                </li>
                <li class="xn-profile">
                    <a href="#" class="profile-mini">
                        <img src="${pageContext.request.contextPath}/Content/assets/images/users/avatar.jpg" alt="John Doe" />
                    </a>
                    <div class="profile">
                        <div class="profile-image">
                            <img src="${pageContext.request.contextPath}/Content/assets/images/users/avatar.jpg" alt="John Doe" />
                        </div>
                        <div class="profile-data">
                            <div class="profile-data-name">赛利普</div>
                            <!--<div class="profile-data-title">Web Developer/Designer</div>-->
                        </div>
                    </div>
                </li>
                <li class="active">
                    <a href="#"><span class="fa fa-desktop"></span> <span class="xn-text">控制台</span></a>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-cogs"></span> <span class="xn-text">站点管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/banner/bannerList?currentPage=1"><span class="fa fa-money"></span> Banner管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/adminList?currentPage=1"><span class="fa fa-user"></span>管理员管理</a></li>

                        <li><a href="${pageContext.request.contextPath}/sizeInfo/sizeInfoList?currentPage=1"><span class="fa fa-cogs"></span> 站点信息管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/links/linksList?currentPage=1"><span class="fa fa-anchor"></span> 友情链接管理</a></li>

                    </ul>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-users"></span> <span class="xn-text">团队管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/team/teamList?currentPage=1"><span class="fa fa-users"></span> 团队管理</a></li>
                    </ul>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-globe"></span> <span class="xn-text">服务管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/Server/QueryServerServlet?current=1"><span class="fa fa-globe"></span> 服务管理</a></li>
                    </ul>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">资讯管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/news/newsList?current=1"><span class="fa fa-files-o"></span>资讯管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/news/AddNewsServlet?flag=selCategroy&current=1"><span class="fa fa-th-list"></span> 资讯分类管理</a></li>
                    </ul>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-folder-o"></span> <span class="xn-text">案例管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/project/QuerProjectServlet?current=1"><span class="fa fa-folder-o"></span> 案例管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/project/projectServlet?flag=selCategroy&current=1"><span class="fa fa-th-list"></span> 案例分类管理</a></li>
                    </ul>
                </li>
                <li class="xn-openable">
                    <a href="#"><span class="fa fa-laptop"></span> <span class="xn-text">账户管理</span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/Content/admin/adminUpdateForm.jsp"><span class="fa fa-lock"></span> 修改密码</a></li>
                        <li><a href="${pageContext.request.contextPath}/logOut"><span class="fa fa-sign-out"></span> 退出系统</a></li>
                    </ul>
                </li>
            </ul>
        </div>