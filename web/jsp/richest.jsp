<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 29 сент. 2019 г.
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>The bank list</title>
    </head>
    <body>
    <p>Richest users: ${users}</p>
    <p>Accounts sum: ${sum}</p>
    <form name="get" action="action" method="POST">
        <input type="submit" name="button" value="get" />
    </form>
    </body>
</html>
