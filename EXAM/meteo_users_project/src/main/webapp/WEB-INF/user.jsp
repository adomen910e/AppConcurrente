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
<h1>Liste des utilisateurs</h1>
<table>
<tr>
	<td>Prénom</td> <td>Nom</td>
</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.getSurname()}</td> <td>${user.getName()}</td>
		</tr>
	</c:forEach>

</table>
<a href="/meteo_users_project/create-user"> Nouveau </a>

</body>
</html>