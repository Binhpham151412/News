<%@ page import="java.util.List" %>
<%@ page import="model.admin.CategoriesModel" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/07/2022
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <lable>Title</lable>
    <input type="text" name="title">
    <lable>Description</lable>
    <input type="text" name="description">
    <lable>Content</lable>
    <input type="text" name="content">
    <lable>Category</lable>
    <select name="categoryId">
        <%
            List<CategoriesModel> list = (List<CategoriesModel>) request.getAttribute("list");
            if (list != null) {
                for (CategoriesModel item : list) {
        %>
        <option value="<%=item.getId()%>"><%=item.getName()%></option>
        <%
                }
            }
        %>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>
