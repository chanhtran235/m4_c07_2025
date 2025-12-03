<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/27/2025
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang danh sách</h1>
<a href="/students/add">Add new student</a>
<h2 style="color: red">${mess}</h2>
<table>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Subjects</th>
        <th>Class name</th>
        <th>Detail-RequestParam</th>
        <th>Detail- PathVariable</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>
                <c:forEach var="subject" items="${student.subjects}">
                    <span>${subject} </span>
                </c:forEach>
            </td>
            <td>${student.className}</td>
            <td><a href="/students/detail?id=${student.id}">Detail1</a></td>
            <td><a href="/students/${student.id}/detail">Detail1</a></td>
        </tr>
    </c:forEach>

</table>
<h1>${subjects.size()}</h1>
</body>
</html>
