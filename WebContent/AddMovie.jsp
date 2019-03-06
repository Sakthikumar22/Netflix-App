<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html >
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
.heading {
	color: gray;
	font-size: 30px;
	font-weight: 100;
	
	
}
</style>
</head>
<body>
<form method="post" action="SaveServlet">
<table>
<tbody>
<h1 class='heading'>Movie Details</h1>
 <tr><td>Id</td>
<td><input type="number"name="id"required></td></tr>
<tr><td>Name</td>
<td><input type="text" name="name" required></td></tr>
<tr><td>Price</td>
<td><input type="number" name="price"required></td></tr>
<tr><td>Director id</td>
<td><select name="directorid">
<c:forEach var= "director" items="${DIRECTOR}">
<option value="${director.id}">${director.name}</option>
</c:forEach>
</select> </td></tr>

<tr><td><button type="submit">add</button></td></tr>
</tbody>
</table>
</form>


</body>
</html>