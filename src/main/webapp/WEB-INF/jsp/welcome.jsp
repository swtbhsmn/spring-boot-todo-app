<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="common/head.jspf" %>
        <title>Welcome</title>
</head>

<body>
        <h1>Welcome! ${username}</h1>
        <a href="/todo-list?username=${username}">Manage Todo list</a>
    <%@ include file="common/script.jspf" %>
</body>

</html>