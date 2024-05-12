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
<head>
    <title>Persons Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Person List</h1>
    <h3><a href="new"> New Person </a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of Birth</th>
            <th>Action</th>
        </tr>
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

    </table>
</div>
</body>
</html>
