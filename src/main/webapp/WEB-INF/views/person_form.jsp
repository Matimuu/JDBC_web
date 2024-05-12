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
</head>
<body>
<div align="center">
    <h1>New or Edit Person</h1>
    <form:form action="save" method="post" modelAttribute="person">
        <table cellpadding="5">
            <form:hidden path="id" />
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><form:input path="dateOfBirth"/></td>
            </tr>
        </table>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </form:form>
</div>
</body>
</html>
