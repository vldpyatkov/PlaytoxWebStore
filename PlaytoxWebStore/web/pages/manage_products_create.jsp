<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/15/13
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form action="?service=manage_products&signal=create" method="post" onsubmit="this.submit() && window.close()">
    <table>
        <tbody>
        <tr>
            <td>Title</td>
            <td><input type="text" name="product_title" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="product_price" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><textarea name="product_desc" ></textarea></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="product_quantity"/></td>
        </tr>
        </tbody>
    </table>
    <input type="submit" type="submit" value="Create" />
</form>
</body>
</html>