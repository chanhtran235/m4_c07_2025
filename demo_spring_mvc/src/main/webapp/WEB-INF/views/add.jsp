<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/28/2025
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/students/add" modelAttribute="student" method="post">
    ID:          <form:input path="id"/><br>
    Name:        <form:input path="name"/>
    Gender:      <form:radiobutton path="gender" value="1"/> Male
                 <form:radiobutton path="gender" value="0"/>Female <br>
    Subejcts :   <form:checkboxes path="subjects" items="${subjects}"/>
    Class nanme : <form:select path="className">
                     <option value="">-------Chon lớp--------</option>
                     <form:option value="C07">C0724</form:option>
                     <form:option value="C08">C0824</form:option>
                     <form:option value="C09">C0924</form:option>
                  </form:select>
    <button> Save</button>
</form:form>
</body>
</html>
