<%--
  Created by IntelliJ IDEA.
  User: makros
  Date: 12/15/13
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Products</title>
</head>
<body>
<input type="button" value="Create New Project" onclick="create()" />

<script type="text/javascript">
    function create() {
        window.open("?service=manage_products&signal=create",null,
                "height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
    }
</script>


</body>
</html>