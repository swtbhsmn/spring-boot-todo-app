<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="common/head.jspf" %>
        <title>Welcome</title>
</head>

<body>
    <%@ include file="common/nav.jspf" %>

        <div class="container">
            <div style="margin: 20px 0;">Hi ${username}!</div>
        <a href="/todo-list?username=${username}">Manage Todo list</a>
        </div>
    <%@ include file="common/script.jspf" %>
</body>

</html>