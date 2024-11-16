<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <%@ include file="common/head.jspf" %>
            <title>login</title>
    </head>

    <body>
        <main style="display: flex;justify-content: center;align-items: center;height: 100vh;flex-direction:column;">
            <div>
                <h1>Welcome to login page!</h1>
            </div>
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">${error}</div>
            </c:if>

            <form method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Username</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                        placeholder="Enter username" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your username with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                        name="password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </main>
        <%@ include file="common/script.jspf" %>
    </body>
    </html>