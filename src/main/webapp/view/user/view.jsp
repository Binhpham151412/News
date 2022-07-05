<%@ page import="model.UsersModel" %>
<%@ page import="model.admin.news.NewsModel" %>
<%@ page import="model.user.ListNewsUserModel" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/07/2022
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/taglib.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Bài viết <%=request.getParameter("id")%></h1><br>
<small>Author <%=((UsersModel)session.getAttribute("userLogin")).getUserName()%></small><br>
</body>
<h3>Title: <%=((ListNewsUserModel)session.getAttribute("news")).getTitle()%></h3><br>
<h5>Description: <%=((ListNewsUserModel)session.getAttribute("news")).getDescription()%></h5><br>

<p>Content: <%=((ListNewsUserModel)session.getAttribute("news")).getContent()%></p>

<a href="<%=request.getContextPath()%>/user/news/list">Back</a>
</html>
