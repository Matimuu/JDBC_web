<%--
  Created by IntelliJ IDEA.
  User: omarenrique
  Date: 12.05.2024
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>


<html>
<head>
    <title>Persons Manager Home</title>
</head>
<body>
    <div align="center">
        <h1>Person List</h1>
        <table border="1" cellpadding="5">
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Date of Birth</th>
                <th>Action</th>
            </tr>
<%--            <c:forEach var="person" items="${personList}" varStatus="status">--%>
<%--                <tr>--%>
<%--                    <td>${person.id}</td>--%>
<%--                    <td>${person.name}</td>--%>
<%--                    <td>${person.surname}</td>--%>
<%--                    <td>${person.dateOfBirth}</td>--%>
<%--                </tr>--%>

<%--            </c:forEach>--%>

        </table>
    </div>
</body>
</html>
