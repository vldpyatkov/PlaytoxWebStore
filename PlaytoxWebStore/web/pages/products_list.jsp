<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/15/13
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="../include/jquery-2.0.3.min.js"></script>
<head>
    <title>Products List</title>
</head>
<body>
<h1>Products</h1>
<jsp:include page="../include/error_message.jsp" />
<form action="?service=products_list&signal=purchase" method="post">
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Buy</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.products}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td><fmt:formatNumber value="${item.price}" pattern="0.00" /></td>
            <td>${item.quantity}</td>
            <td><c:out value="${item.description}" /></td>
            <td><input quantity="${item.quantity}" type="number" name="${item.id}" onmouseup="checkPositive(this)" value="0"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<input type="submit" value="Continue" />
</form>

<script type="text/javascript">
    function checkPositive(control) {
        $control = jQuery(control);
        if ($control.val() < 0) {
            $control.val(0);
        } else {
            var quantity = $control.attr("quantity");
            if ($control.val() > quantity) {
                $control.val(quantity);
            }
        }
    }
</script>

</body>
</html>