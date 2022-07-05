<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/06/2022
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp" %>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Core</div>
                <a class="nav-link" href="<c:url value="/admin/dashboard"></c:url> ">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Dashboard
                </a>


                <div class="sb-sidenav-menu-heading">Addons</div>
                <a class="nav-link" href="<c:url value="/admin/categories"></c:url> ">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    Categories
                </a>
                <a class="nav-link" href="<c:url value="/admin/news"></c:url> ">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    News
                </a>
                <a class="nav-link" href="<c:url value="/admin/users"></c:url> ">
                    <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                    Users
                </a>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            Start Bootstrap
        </div>
    </nav>
</div>
