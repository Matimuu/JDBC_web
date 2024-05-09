<%--
  Created by IntelliJ IDEA.
  User: omarenrique
  Date: 09.05.2024
  Time: 17:32
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
            <a href="" class="navbar-brand"> Person
                Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Person</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Persons</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Person</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Date Of Birth</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:if test="${empty listPerson}">
                <tr>
                    <td colspan="6">No persons found.</td>
                </tr>
            </c:if>
            <c:forEach var="person" items="${listPerson}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td>${person.dateOfBirth}</td>
                    <td>
                        <a href="edit?id=${person.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=${person.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>
</html>
