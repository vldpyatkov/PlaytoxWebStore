<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/15/13
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty requestScope.error_message}">
    <h2 style="color: red"><c:out value="${requestScope.error_message}" /></h2>
</c:if>