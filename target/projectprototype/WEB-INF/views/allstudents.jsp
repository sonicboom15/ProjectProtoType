<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Students</h2>  
    <table>
        <tr>
            <td>NAME</td><td>Register No</td><td>dob</td><td>rollno</td><td></td>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
            <td>${employee.name}</td>
            <td>${employee.registerno}</td>
            <td>${employee.dob}</td>
            <td><a href="<c:url value='/edit-${employee.rollno}-student' />">${employee.rollno}</a></td>
            <td><a href="<c:url value='/delete-${employee.rollno}-student' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Student</a>
</body>
</html>