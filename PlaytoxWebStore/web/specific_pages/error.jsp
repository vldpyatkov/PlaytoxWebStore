<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/16/13
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<pre>
    <%
        Exception ex = (Exception)request.getAttribute("error");
        ex.printStackTrace(new java.io.PrintWriter(out));
    %>
</pre>

</body>
</html>