<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/8/13
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Client</title>
</head>
<body>
<h1>Create Client</h1>
<form action="?service=create_client" method="post">
    <input type="hidden" name="signal" value="create" />
    <table>
        <tr>
            <td><input name="login" type="text" /></td>
        </tr>
        <tr>
            <td><input name="password" type="text" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create" /></td>
        </tr>
    </table>
</form>
<a href="?service=login">Login</a>
</body>
</html>