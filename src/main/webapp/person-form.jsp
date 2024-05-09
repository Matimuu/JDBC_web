<%--
  Created by IntelliJ IDEA.
  User: omarenrique
  Date: 09.05.2024
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="" class="navbar-brand"> Person Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Persons</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${person != null}">
                <form action="insertOrUpdate" method="post">
                <caption>
                <h2>
                <c:if test="${person != null}">
                    Edit Person
                </c:if>
                <c:if test="${person == null}">
                    Add New Person
                </c:if>
                </h2>
                </caption>

                <fieldset class="form-group">
                <label>Person Name</label>
                <input type="text" value="${empty person ? '' : person.name}" class="form-control" name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                <label>Person Surname</label>
                <input type="text" value="${empty person ? '' : person.surname}" class="form-control" name="surname">
                </fieldset>

                <fieldset class="form-group">
                <label>Person date of Birth</label>
                <input type="text" value="${empty person ? '' : person.dateOfBirth}" class="form-control" name="dateOfBirth">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
