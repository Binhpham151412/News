<%@ page import="java.util.List" %>
<%@ page import="model.admin.CategoriesModel" %>
<%@ page import="model.UsersModel" %>
<%@ page import="model.admin.news.NewsModel" %>
<%@ page import="mapper.admin.NewsMapper" %>
<%@ page import="model.admin.news.ListNewsModel" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 27/06/2022
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Tables - SB Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/css/styles.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<%@include file="../../../common/nav-bar.jsp" %>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <%@include file="../../../common/left-bar.jsp" %>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">News</h1>


                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        List News
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Title</th>
                                <th>Name Category</th>
                                <th>User Name</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Title</th>
                                <th>Name Category</th>
                                <th>User Name</th>
                            </tr>
                            </tfoot>

                            <tbody>
                            <%
                                List<ListNewsModel> list = (List<ListNewsModel>) request.getAttribute("list");
                                if (list!=null){
                                    for (ListNewsModel item : list) {
                            %>
                            <tr>
                                <td><%=item.getId()%>
                                </td>
                                <td><%=item.getTitle()%>
                                </td>
                                <td><%=item.getCategoryName()%>
                                </td>
                                <td><%=item.getUserName()%>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>

                            </tbody>
                        </table>

                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                        </div>

                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2022</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/css/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/css/js/datatables-simple-demo.js"></script>
</body>
</html>
