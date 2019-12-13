<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATION USERS</title>

</head>
<body>
<form action="users" method="post" class="form-example">
<ul>
	<div class="form-example">
		<li>
			<label for="name">Nom: </label>
			<input type="text" name="name" id="name" required>
		</li>
	</div>

	<div class="form-example">
		<li>
			<label for="surname">Prénom: </label>
			<input type="text" name="surname" id="surname" required>
		</li>
	</div>
</ul>

<div class="form-example">
	<button type="submit"> Créé </button>
</div>
</form>
</body>
</html>