<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/8/13
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<c:if test="${not empty message}">
    <div>
        <c:out value="${message}" />
    </div>
</c:if>
<form action="?service=login" method="post">
    <input type="hidden" name="signal" value="login" />
    <table>
        <tr>
            <td><input name="login" type="text" /></td>
        </tr>
        <tr>
            <td><input name="password" type="text" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login" /></td>
        </tr>
    </table>
</form>
<a href="?service=create_client">Create</a>
</body>
</html>