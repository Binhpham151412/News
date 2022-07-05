<%@ page import="model.user.UpdateNewsUserModel" %>
<%@ page import="model.admin.CategoriesModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02/07/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form action="" method="post">
    <%
        UpdateNewsUserModel updateNewsUserModel = (UpdateNewsUserModel) request.getAttribute("news");
    %>
    <lable>Title</lable>
    <input type="text" name="title" value="<%=updateNewsUserModel.getTitle()%>">
    <lable>Description</lable>
    <input type="text" name="description" value="<%=updateNewsUserModel.getDescription()%>">
    <lable>Content</lable>
    <input type="text" name="content" value="<%=updateNewsUserModel.getContent()%>">
    <lable>Category</lable>
    <select name="categoryId" id="<%=updateNewsUserModel.getCategoryId().getId()%>">
        <%
            List<CategoriesModel> list = (List<CategoriesModel>) request.getAttribute("list");
            for (CategoriesModel item : list) {
                if (item.getId() == updateNewsUserModel.getCategoryId().getId()) {
        %>
        <option value="<%=item.getId()%>" selected><%=item.getName()%></option>
        <%
        } else {
        %>
        <option value="<%=item.getId()%>"><%=item.getName()%></option>
        <%
                }
            }

        %>
    </select>
    <input type="submit">
</form>
</html>
