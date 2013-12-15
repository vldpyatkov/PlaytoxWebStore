<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/4/13
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script type="text/javascript" src="../include/jquery-2.0.3.min.js"></script>
<head>
    <title>Welcome</title>
</head>
<body>

    <table border="2">
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Passwords</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.users}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.login}</td>
                <td>${item.password}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <thead>
        <tr>
            <th>Item</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <a href="?service=products_list">List of Products</a>
            </td>
        </tr>
        </tbody>
    </table>

</body>
</html>