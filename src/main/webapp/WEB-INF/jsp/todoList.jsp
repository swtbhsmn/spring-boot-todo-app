<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <%@ include file="common/head.jspf" %>

            <title>Todo List</title>
    </head>

    <body>
        <%@ include file="common/nav.jspf" %>
            <div class="container">
                <div style="margin-top: 20px;">Hi ${username}!</div>
                <div style="margin-top: 5%;">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Username</th>
                                    <th>Description</th>
                                    <th>Target Date</th>
                                    <th>Done</th>
                                    <th class="text-right"></th>
                                    <th class="text-right"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${todos}" var="todo">
                                    <tr>
                                        <td>${todo.id}</td>
                                        <td>${todo.username}</td>
                                        <td>${todo.description}</td>
                                        <td>${todo.targetDate}</td>
                                        <td>${todo.done}</td>
                                        <td class="text-center"><a href="delete-todo?id=${todo.id}">
                                                <i class="fa-solid fa-trash text-danger"></i>
                                            </a></td>
                                        <td class="text-center"><a href="update-todo?id=${todo.id}">
                                                <i class="fa-solid fa-edit text-danger"></i>
                                        </a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <a class="btn btn-success" href="add-todo">
                    Add Todo
                </a>
            </div>

            <%@ include file="common/script.jspf" %>
    </body>

    </html>