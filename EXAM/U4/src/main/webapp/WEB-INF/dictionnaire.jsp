<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Compteur texte</title>

</head>
<body>
<form action="dictionnaire" method="get" class="form-example">
<div class="form-example">
<label for="localisation">Mot: </label>

<input type="text" name="inputWord" id="inputWord" required>
<button type="submit"> Trouver mots </button>
</div>
</form>
<table>
	<c:if test = "${isEmpty == false}" >
		<c:forEach var="word" items="${TabWord}" >
		<tr>
			<td> ${word} </td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test = "${isEmpty == true}" >
	<tr>Il n'y a pas de mots correspondant</tr>
	</c:if>
</table>
</body>
</html>