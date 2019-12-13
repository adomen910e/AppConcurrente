<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USERS</title>

</head>
<body>
<h1>Bienvenue</h1>
<table>
<tr>
	<td>Prénom</td> <td>Nom</td>
</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.getUser()}</td> <td>${user.getMotDePasse()}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>