<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
color:white;
	background-image: url("login.jpg");
	background-color: #ccvvv;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
<table>
<tr>
<td>USERNAME</td>
<td>PASSWORD</td></tr>
<tr>
<td>${username}</td>
<td>${password}</td></tr>
<table>

</body>
</html>