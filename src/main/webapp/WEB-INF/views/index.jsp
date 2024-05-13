<%--
  Created by IntelliJ IDEA.
  User: omarenrique
  Date: 12.05.2024
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<head>
    <title>Persons Manager Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #ff9900">
    </nav>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Persons</h3>
            <hr>
            <div class="container text-left">
                <a href="new"> New Person </a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Date of Birth</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="person" items="${personList}" varStatus="status">
                    <tr>
                        <td><c:out value="${status.count}"/></td>
                        <td><c:out value="${person.id}"/></td>
                        <td><c:out value="${person.name}"/></td>
                        <td><c:out value="${person.surname}"/></td>
                        <td><c:out value="${person.dateOfBirth}"/></td>
                        <td>
                            <a href="edit?id=${person.id}">Edit</a>
                            &nbsp;&nbsp;
                            <a href="delete?id=${person.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</header>
</body>
</html>
