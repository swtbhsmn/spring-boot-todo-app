<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <%@ include file="common/head.jspf" %>
                <title>Add Todo</title>
        </head>

        <body>
            <%@ include file="common/nav.jspf" %>
                <div class="container">
                    <div style="margin-top: 20px;">Hi ${username}!</div>
                    <form:form modelAttribute="todo" method="post">
                        <div class="form-group">
                            <form:label path="description">Description</form:label>
                            <form:input cssClass="form-control" placeholder="Enter Description" path="description" />
                            <form:errors path="description" element="li" cssClass="text-danger" />
                            <form:input type="hidden" path="username" value="${todo.username}" />
                        </div>
                        <div class="form-group">
                            <form:label path="targetDate">Target Date</form:label>
                            <form:input type="date" cssClass="form-control" path="targetDate" />
                        </div>
                        <div class="form-group">
                            <form:label path="done"> Task Done</form:label>

                            <form:select cssClass="form-control" path="done">
                                <form:option value="true">Done</form:option>
                                <form:option value="false">Not Done</form:option>
                            </form:select>
                        </div>
                        <button type="submit" class="btn btn-success">Add Todo</button>
                    </form:form>
                </div>
                <%@ include file="common/script.jspf" %>
        </body>
        </html>