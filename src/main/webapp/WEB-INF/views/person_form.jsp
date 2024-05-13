<%--
  Created by IntelliJ IDEA.
  User: omarenrique
  Date: 13.05.2024
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New or Edit Person</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: #ff9900">
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form:form action="save" method="post" modelAttribute="person">
                        <form:hidden path="id" />
                        <fieldset class="form-group">
                            Name:
                            <form:input path="name"/>
                        </fieldset>
                        <fieldset class="form-group">
                            Surname:
                            <form:input path="surname"/>
                        </fieldset>
                        <fieldset class="form-group">
                            Date of Birth:
                            <form:input path="dateOfBirth"/>
                        </fieldset>
                            <input type="submit" value="Save">
                    </form:form>
                </div>
            </div>
        </div>
</body>
</html>
