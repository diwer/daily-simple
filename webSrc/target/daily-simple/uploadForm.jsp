<%--
  Created by IntelliJ IDEA.
  User: ppc
  Date: 2016/3/1
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Please upload a file</h1>
<form method="post" action="./form" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>
</html>
